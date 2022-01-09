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
import javafx.stage.Modality;
import javafx.stage.Stage;
import lapr.project.ui.MainApp;

/**
 * FXML Controller class
 *
 * @author Beatriz Ribeiro
 */
public class MenuUI implements Initializable {

    @FXML
    private Button btnRegistCliente;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnSubApplication;

    /**
     * attribute that represents login stage
     */
    private Stage stageLogin;

    /**
     * attribute that represents LoginUI
     */
    private LoginUI loginUI;

    Parent root = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         * try{ stageLogin = new Stage();
         * stageLogin.initModality(Modality.APPLICATION_MODAL);
         *
         * stageLogin.setTsitle("Login"); stageLogin.setResizable(false);
         *
         * FXMLLoader loader1 = new
         * FXMLLoader(getClass().getResource("/fxml/Login.fxml")); Parent root1
         * = loader1.load();
         *
         * Scene scene1 = new Scene(root1);
         *
         * loginUI = loader1.getController(); loginUI.associateUI(this);
         *
         * stageLogin.setScene(scene1);
         *
         *
         *
         * }catch (IOException e){
         *
         * }*
         */
    }

    @FXML
    private void registClient(ActionEvent event) throws IOException {
        changeScene("/fxml/RegisterClient.fxml");
        
    }

    /**
     * Opens the Login scene
     * @param event OnClick event
     */
    @FXML
    private void login(ActionEvent event) throws IOException {
        changeScene("/fxml/Login.fxml");
    }

    @FXML
    private void submitApplication(ActionEvent event) throws IOException {
        changeScene("/fxml/SubmitApplication.fxml");
    }

    /**
     * Loads any scene
     *
     * @throws IOException
     */
    private void changeScene(String strURL) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(strURL));
        Parent root = loader.load();
        Stage stage = MainApp.getStage();
        Scene scene = new Scene (root);
        stage.setScene(scene);
    }
}
