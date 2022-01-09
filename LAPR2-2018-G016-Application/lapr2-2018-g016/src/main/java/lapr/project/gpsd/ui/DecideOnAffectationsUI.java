/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.DecideOnAffectationsController;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.model.Affectation;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.ui.MainApp;
import lapr.project.utils.Utils;

/**
 * FXML Controller class
 *
 * @author Vera Pinto
 */
public class DecideOnAffectationsUI implements Initializable {

    /**
     * ListView variable
     */
    @FXML
    private ListView lstVwAffectations;
    /**
     * ComboBox variable
     */
    @FXML
    private ComboBox<ServiceRequest> cmbServiceRequest;
    /**
     * Button variable
     */
    @FXML
    private Button btnConfirmAll;
    /**
     * Button variable
     */
    @FXML
    private Button btnReject;
    /**
     * DecideOnAffectationsController variable
     */
    private DecideOnAffectationsController decideController = new DecideOnAffectationsController();
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpRequests();
        lstVwAffectations.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    /**
     * Method to show the correct button
     *
     * @param event onClick event
     */
    @FXML
    private void chooseAffectation(MouseEvent event) {
        btnReject.setDisable(false);
        btnConfirmAll.setDisable(true);
    }

    /**
     * Method to confirm all affectations
     *
     * @param event
     */
    @FXML
    private void confirmAll(ActionEvent event) throws IOException {
        for (Affectation affectation : GPSD.getInstance().getCompany().getAffectationsRegistry().getAffectationsByRequest(cmbServiceRequest.getValue())) {
            decideController.newOrder(affectation);
        }
        Utils.createAlert(Alert.AlertType.INFORMATION, "INFORMATION", "Scehdule accepted!").showAndWait();
        changeScene("/fxml/ClientMenu.fxml");
    }

    /**
     * Method to reject the affectations
     *
     * @param event
     */
    @FXML
    private void reject(ActionEvent event) throws IOException {
        Affectation affec = (Affectation) lstVwAffectations.getSelectionModel().getSelectedItem();
        if (affec.getSchedulePreference().getOrder() == affec.getServiceRequest().getSchPrefList().size()) {
            Utils.createAlert(Alert.AlertType.WARNING, "WARNING", "You don't have more schedules for this service request! If you proceed the service request will be deleted!").showAndWait();
            changeScene("/fxml/DecideOnAffectations.fxml");
        } else {
            decideController.rejectAffectation((Affectation) lstVwAffectations.getSelectionModel().getSelectedItem());
            Utils.createAlert(Alert.AlertType.INFORMATION, "INFORMATION", "Schedule rejected!");
            changeScene("/fxml/ClientMenu.fxml");
        }
    }

    /**
     * Method to set up the requests in the combo box
     */
    private void setUpRequests() {
        String email = GPSD.getInstance().getCurrentSession().getUserEmail();
        Client client = GPSD.getInstance().getCompany().getClientsRegistry().getClientByEmail(email);
        for (ServiceRequest servReq : decideController.getServiceRequests(client)) {
            cmbServiceRequest.getItems().add(servReq);
        }
    }

    /**
     * Method to add affectations to the ListView
     *
     * @param event
     */
    @FXML
    private void showAffectations(ActionEvent event) {
        ServiceRequest servRequest = cmbServiceRequest.getValue();
        lstVwAffectations.getItems().addAll(GPSD.getInstance().getCompany().getAffectationsRegistry().getAffectationsByRequest(servRequest));
    }

    /**
     * Loads any scene
     *
     * @throws IOException
     */
    private void changeScene(String strURL) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(strURL));
        Parent root = loader.load();
        Stage stage = MainApp.getStage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

 @FXML
    private void cancel(ActionEvent event) throws IOException {
        changeScene("/fxml/ClientMenu.fxml");
    }
}
