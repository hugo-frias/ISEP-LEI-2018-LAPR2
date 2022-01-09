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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.ui.MainApp;

/**
 * FXML Controller class
 *
 * @author Beatriz Ribeiro
 */
public class ServiceProviderUI implements Initializable {

    @FXML
    private Button btnAddAvailability;
    @FXML
    private Button btnServiceOrders;
    @FXML
    private Button btnEndRateOrder;
    @FXML
    private Button btnLogout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addDailyAvailability(ActionEvent event) throws IOException {
        changeScene("/fxml/IndicateAvailability.fxml");
        
    }

    @FXML
    private void seeServiceOrders(ActionEvent event) throws IOException {
        changeScene("/fxml/ExportServiceOrdersScene.fxml");
    }

    @FXML
    private void btnEndRateServiceOrder(ActionEvent event) throws IOException {
        changeScene("/fxml/ReportEndOfService.fxml");
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        GPSD.getInstance().getCurrentSession().doLogout();
        changeScene("/fxml/Menu.fxml");
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

}
