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
public class ClientUI implements Initializable {

    @FXML
    private Button btnMakeServReq;
    @FXML
    private Button btnAfectations;
    @FXML
    private Button btnRateService;
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
    private void makeServiceRequest(ActionEvent event) throws IOException {
        changeScene("/fxml/MakeServiceRequest.fxml");
    }

    @FXML
    private void seeAfectations(ActionEvent event) throws IOException {
        changeScene("/fxml/DecideOnAffectations.fxml");
    }

    @FXML
    private void rateService(ActionEvent event) throws IOException {
        changeScene("/fxml/RatingService.fxml");
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
    private void logout(ActionEvent event) throws IOException {
        GPSD.getInstance().getCurrentSession().doLogout();
        changeScene("/fxml/Menu.fxml");
    }
}
