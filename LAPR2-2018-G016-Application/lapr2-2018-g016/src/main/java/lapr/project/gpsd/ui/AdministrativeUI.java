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
import javafx.stage.Stage;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.ui.MainApp;

/**
 * FXML Controller class
 *
 * @author Beatriz Ribeiro
 */
public class AdministrativeUI implements Initializable {

    @FXML
    private Button btnSpecCat;
    @FXML
    private Button btnSpecServ;
    @FXML
    private Button btnSpecGeoArea;

    /**
     * attribute that represents LoginUI
     */
    private LoginUI loginUI;
    @FXML
    private Button btnLogout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Doesn't have nothing to initialize
    }

    /**
     * Specifies the category
     *
     * @param event - OnClick event
     * @throws IOException
     */
    @FXML
    private void specifyCategory(ActionEvent event) throws IOException {
        changeScene("/fxml/SpecifyCategoryScene.fxml");
    }

    @FXML
    private void specifyService(ActionEvent event) throws IOException, FileNotFoundException, ParseException {
        if (GPSD.getInstance().getCompany().getCategoriesRegistry().getCategories().isEmpty()) {
            Alert alert = createAlert(Alert.AlertType.ERROR, "ERROR", "There are no registry of categories. Please create one");
            alert.showAndWait();
            changeScene("/fxml/SpecifyCategoryScene.fxml");
        } else {
            changeScene("/fxml/SpecifyService.fxml");
        }
    }

    @FXML
    private void specifyGeoArea(ActionEvent event) throws IOException {
        changeScene("/fxml/SpecifyGeographicalArea.fxml");
    }

    /**
     * Associates UI's
     *
     * @param loginUI - LoginUI
     */
    public void associateUI(LoginUI loginUI) {
        this.loginUI = loginUI;
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
     * Creates alert
     *
     * @param tipoAlerta - alert type
     * @param header - alert header
     * @param message - alert message
     * @return alert
     */
    private Alert createAlert(Alert.AlertType alertType, String header, String message) {
        Alert alert = new Alert(alertType);

        alert.setTitle("AGPSD");
        alert.setHeaderText(header);
        alert.setContentText(message);

        return alert;
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        GPSD.getInstance().getCurrentSession().doLogout();
        changeScene("/fxml/Menu.fxml");
    }
}
