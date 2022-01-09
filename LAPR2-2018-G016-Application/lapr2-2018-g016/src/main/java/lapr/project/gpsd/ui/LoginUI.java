/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.AuthenticationController;
import lapr.project.utils.CompanyFinals;
import lapr.project.ui.MainApp;
import lapr.project.utils.Utils;

/**
 * FXML Controller class
 *
 * @author Beatriz Ribeiro
 */
public class LoginUI implements Initializable {

    @FXML
    private Label lblEmail;
    @FXML
    private TextField txtEmail;
    @FXML
    private Label lblPassword;
    @FXML
    private Button btnLogin;
    @FXML 
    private PasswordField pswField;

    /**
     * attribute that represents MenuUI
     */
    private MenuUI menuUI;

    /**
     * attribute that represents administrative stage
     */
    private Stage stageAdministrative;

    /**
     * attribute that represents AdministrativeUI
     */
    private AdministrativeUI administrativeUI;

    /**
     * attribute that represents HRO stage
     */
    private Stage stageHRO;

    /**
     * attribute that represents HRoUI;
     */
    private HRoUI hroUI;

    /**
     * Initializes the controller class.
     */
    Parent root = null;
    @FXML
    private Button btnCancel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    /**
     * Does the login
     *
     * @param event OnClick event
     */
    @FXML
    private void login(ActionEvent event) throws FileNotFoundException, ParseException {
        int totalAttempts =3;
        try {
            String email = txtEmail.getText();
            String psw = pswField.getText();

            if (email.isEmpty() || psw.isEmpty()) {
                throw new NullPointerException();
            }

            AuthenticationController authenticationController = new AuthenticationController();
            if (!authenticationController.doLogin(email, psw)) {
                Utils.createAlert(Alert.AlertType.INFORMATION, "INFORMATION", "User doesn't exist. Please insert email and password again.").showAndWait();
                txtEmail.setText("");
                pswField.setText("");
                totalAttempts--;
            } else if(totalAttempts!=0){
                if (authenticationController.getGpsd().getCurrentSession().isLoggedInWithRole(CompanyFinals.ADMINISTRATIVE_ROLE)) {
                   //totalAttempts=3;
                    changeScene("/fxml/AdministrativeUI.fxml");
                } else if (authenticationController.getGpsd().getCurrentSession().isLoggedInWithRole(CompanyFinals.HRO_ROLE)) {
                    totalAttempts=3;
                    changeScene("/fxml/HROMenu.fxml");
                } else if (authenticationController.getGpsd().getCurrentSession().isLoggedInWithRole(CompanyFinals.CLIENT_ROLE)) {
                    totalAttempts=3;
                    changeScene("/fxml/ClientMenu.fxml");
                } else if (authenticationController.getGpsd().getCurrentSession().isLoggedInWithRole(CompanyFinals.SERVICE_PROVIDER_ROLE)){
                    totalAttempts=3;
                    changeScene("/fxml/ServiceProviderMenu.fxml");
                }
            }
        } catch (NullPointerException e) {
            Utils.createAlert(Alert.AlertType.WARNING, "WARNING", "Ups! Some fields are missing. Please complete them!").showAndWait();
        } catch (IOException e) {
            Utils.createAlert(Alert.AlertType.ERROR, "ERROR", "Error loading scene. Please check file path.").showAndWait();
        }
    }

    /**
     * Associates UI's
     *
     * @param menuUI - MenuUI
     */
    public void associateUI(MenuUI menuUI) {
        this.menuUI = menuUI;
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
        changeScene("/fxml/Menu.fxml");
    }

}
