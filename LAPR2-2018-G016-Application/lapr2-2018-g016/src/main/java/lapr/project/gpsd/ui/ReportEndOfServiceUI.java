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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.controller.ReportEndOfServiceController;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceOrder.ServiceOrderStatus;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.ui.MainApp;
import lapr.project.utils.Utils;

/**
 * FXML Controller class
 *
 * @author Vera Pinto
 */
public class ReportEndOfServiceUI implements Initializable {

    @FXML
    private ComboBox cmbServiceOrders;
    @FXML
    private Button btnFinished;
    @FXML
    private Button btnAddIssue;
    @FXML
    private TextField txtProblem;
    @FXML
    private TextField txtStrategy;
    private ReportEndOfServiceController reportController = new ReportEndOfServiceController();
    @FXML
    private Button btnCancel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpServiceOrders();
    }    

    @FXML
    private void writeIssue(MouseEvent event) {
        btnAddIssue.setDisable(false);
        btnFinished.setDisable(true);
    }

    @FXML
    private void changeToFinished(ActionEvent event) {
      reportController.changeToFinished((ServiceOrder) cmbServiceOrders.getSelectionModel().getSelectedItem());
        Utils.createAlert(Alert.AlertType.INFORMATION, "INFORMATION", "Service Order has been finished!").showAndWait();
    }

    @FXML
    private void addIssue(ActionEvent event) {
        reportController.addIssue((ServiceOrder) cmbServiceOrders.getSelectionModel().getSelectedItem(),txtProblem.getText(), txtStrategy.getText());        
        Utils.createAlert(Alert.AlertType.INFORMATION, "INFORMATION", "Your issue has been reported!").showAndWait();
    }
    
    private void setUpServiceOrders(){
        String email = GPSD.getInstance().getCurrentSession().getUserEmail();
        ServiceProvider servProvider = GPSD.getInstance().getCompany().getServiceProvidersRegistry().getServiceProviderByEmail(email);
        for(ServiceOrder servOrder : reportController.getServiceOrders(servProvider)){
            if(servOrder.getStatus().equals(ServiceOrderStatus.NOTRATED.getStatus())){
                cmbServiceOrders.getItems().add(servOrder);
            }
            
        }
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
        changeScene("/fxml/ServiceProviderMenu.fxml");
    }
}
