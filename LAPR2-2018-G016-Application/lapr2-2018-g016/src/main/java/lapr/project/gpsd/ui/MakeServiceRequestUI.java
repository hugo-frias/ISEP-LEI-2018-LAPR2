/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.controller.MakeServiceRequestController;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.Service;
import lapr.project.ui.MainApp;
import lapr.project.utils.AlertMessages;
import lapr.project.utils.Date;
import lapr.project.utils.Time;
import lapr.project.utils.Utils;

/**
 * FXML Controller class
 *
 * @author Beatriz Ribeiro
 */
public class MakeServiceRequestUI implements Initializable {

    @FXML
    private Label lblDescServ;
    @FXML
    private TextField txtDescServ;
    @FXML
    private DatePicker dtpDate;
    @FXML
    private TextField txtHour;
    @FXML
    private TextField txtMin;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnNewService;
    @FXML
    private ComboBox<PostalAddress> cmbPostalAddress;
    @FXML
    private ComboBox<Category> cmbCategory;
    @FXML
    private ComboBox<Service> cmbService;
    @FXML
    private Button btnNewPOstalAddress;
    @FXML
    private Label lblHourMin;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblHour;
    @FXML
    private Label lblPeriod;
    @FXML
    private TextField txtPeriod;

    private Stage associatePostalAddressStage;

    private AssociatePostalAddressUI associatePostalAddressUI;

    private MakeServiceRequestController makeServiceRequestController = new MakeServiceRequestController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            associatePostalAddressStage = new Stage();
            associatePostalAddressStage.initModality(Modality.APPLICATION_MODAL);
            associatePostalAddressStage.setTitle("Associate Postal Addres");
            associatePostalAddressStage.setResizable(false);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AssociatePostalAddressScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            associatePostalAddressUI = loader.getController();
            associatePostalAddressUI.associateUI(this);
            associatePostalAddressStage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(MakeServiceRequestUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (PostalAddress postalAddress : makeServiceRequestController.newServiceRequest()) {
            cmbPostalAddress.getItems().add(postalAddress);
        }
    }

    @FXML
    private void onMouseClickedEndPostal(MouseEvent event) {
    }

    @FXML
    private void onActionEndPostal(ActionEvent event) {
        cmbPostalAddress.setDisable(true);
        btnNewPOstalAddress.setDisable(true);
        makeServiceRequestController.setEndPostal(cmbPostalAddress.getValue());
        for (Category cat : makeServiceRequestController.getCategories()) {
            cmbCategory.getItems().add(cat);
        }
    }

    @FXML
    private void addPostalAddress(ActionEvent event) {
        cmbPostalAddress.setDisable(true);
        associatePostalAddressStage.show();
        PostalAddress postAddress = associatePostalAddressUI.getPostalAddress();
        makeServiceRequestController.setEndPostal(postAddress);
        for (Category cat : makeServiceRequestController.getCategories()) {
            cmbCategory.getItems().add(cat);
        }
    }

    @FXML
    private void registRequest(ActionEvent event) throws IOException {

        Date date = new Date(dtpDate.getValue().getYear(), dtpDate.getValue().getMonthValue(), dtpDate.getValue().getDayOfMonth());
        try {

            Time hour = new Time(Integer.parseInt(txtHour.getText()), Integer.parseInt(txtMin.getText()));
            if (!validateDate(date) || !validateTime(hour)) {
                throw new IllegalArgumentException();
            }
            boolean add = makeServiceRequestController.addSchedule(date, hour);
            if (add) {
                Alert confirmAlert = Utils.createConfirmationAlert(AlertMessages.CONFIRMATION_MESSAGE, "QUESTION", "Do you want to add more schedules to your request?");
                confirmAlert.showAndWait();
                if (confirmAlert.getResult() == ButtonType.YES) {
                    txtHour.setText("");
                    txtMin.setText("");
                } else {
                    makeServiceRequestController.computesCost();
                    Utils.createAlert(Alert.AlertType.CONFIRMATION, AlertMessages.CONFIRMATION_MESSAGE, "Do you confirm?").showAndWait();
                    boolean regist = makeServiceRequestController.registsServicerequest();
                    if (regist) {
                        Utils.createAlert(Alert.AlertType.INFORMATION, AlertMessages.INFORMATION_MESSAGE, "Service request has been saved!\n").showAndWait();
                        changeScene("/fxml/ClientMenu.fxml");
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            Utils.createAlert(Alert.AlertType.ERROR, "ERROR", "Invalide date or hour").showAndWait();
        }
    }

    @FXML
    private void addService(ActionEvent event) {
        try {
            int period;
            if (cmbService.getValue().hasOtherAttributes()) {
                period = cmbService.getValue().getOtherAttributes();
            } else {
                if (Utils.validateServicePeriod(Integer.parseInt(txtPeriod.getText().trim()))) {
                    throw new IllegalArgumentException();

                }
                period = Integer.parseInt(txtPeriod.getText());
            }
            boolean add = makeServiceRequestController.addToServiceRequest(cmbService.getValue(), txtDescServ.getText(), period);
            if (add) {
                Alert confirmAlert = Utils.createConfirmationAlert(AlertMessages.CONFIRMATION_MESSAGE, "CONFIRMATION", "Do you want to add more services?");
                confirmAlert.showAndWait();
                if (confirmAlert.getResult() == ButtonType.YES) {
                    resetServiceDesc();
                } else {
                    enableServices();
                }
            }
        } catch (IllegalArgumentException e) {
            Utils.createAlert(Alert.AlertType.ERROR, "ERROR", "Period shoud be 30 or more than 30 minutes. Also should be a multiple of 30!").showAndWait();
        }
    }

    @FXML
    private void onActionCategory(ActionEvent event) {
        cmbCategory.setDisable(true);
        cmbService.getItems().clear();
        for (Service serv : makeServiceRequestController.getServicesOfCategory(cmbCategory.getValue())) {
            cmbService.getItems().add(serv);
        }
    }

    @FXML
    private void onActionService(ActionEvent event) {
        if (cmbService.getValue() == null) {
            return;
        }
        cmbService.setDisable(true);
        Service serve = cmbService.getValue();
        if (!serve.hasOtherAttributes()) {
            lblPeriod.setVisible(true);
            txtPeriod.setVisible(true);
        }

    }

    private void resetServiceDesc() {
        cmbCategory.getItems().clear();
        for (Category cat : makeServiceRequestController.getCategories()) {
            cmbCategory.getItems().add(cat);
        }
        cmbPostalAddress.setDisable(true);
        cmbCategory.setDisable(false);
        cmbService.setDisable(false);
        txtDescServ.setText(" ");
        lblPeriod.setVisible(false);
        txtPeriod.setText("");
        txtPeriod.setVisible(false);
    }

    private void enableServices() {
        cmbPostalAddress.setDisable(true);
        cmbCategory.setDisable(true);
        cmbService.setDisable(true);
        txtDescServ.setDisable(true);
        txtPeriod.setDisable(true);
        btnNewService.setDisable(true);
        lblDate.setVisible(true);
        dtpDate.setVisible(true);
        lblHour.setVisible(true);
        txtHour.setVisible(true);
        lblHourMin.setVisible(true);
        txtMin.setVisible(true);
        btnNext.setVisible(true);
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

    /**
     * Validates Availability´s dates.
     *
     * @param dBeginning availability's date of beginning
     * @param dEnding availability's date of ending
     * @return true or false
     */
    public boolean validateDate(Date dBeginning) {
        if (dBeginning.weekDay().equals(Date.WeekDay.SUNDAY.toString()) || !dBeginning.isGreater(Date.actualDate())) {
            return false;
        }
        return true;
    }

    /**
     * Validates Availability's hours.
     *
     * @param hBeginning availability's hour of beginning
     * @param hEnding availability's hour of ending
     * @return true or false
     */
    public final boolean validateTime(Time hBeginning) {
        if (hBeginning.getHours() > 23 || hBeginning.getHours() < 6) {
            return false;
        }
        return !(hBeginning.getMinutes() > 59 || hBeginning.getMinutes() < 0);
    }
}
