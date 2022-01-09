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
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.SubmitApplicationController;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.Category;
import lapr.project.ui.MainApp;
import lapr.project.utils.Utils;
import static lapr.project.utils.Utils.createAlert;

/**
 *
 * @author momog
 */
public class SubmitApplicationUI {

    @FXML
    private TextField txtFullName;
    @FXML
    private TextField txtNif;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPostCode;
    @FXML
    private TextField txtLocality;
    @FXML
    private TextField txtDesignation;
    @FXML
    private TextField txtDegree;
    @FXML
    private TextField txtClassification;
    @FXML
    private TextField txtDescription;
    @FXML
    private Button btnAddProQuali;
    @FXML
    private Button btnAddAcadQuali;
    @FXML
    private Button btnVData;
    @FXML
    private Tab tabData;
    @FXML
    private Tab tabAQ;
    @FXML
    private Tab tabPQ;
    @FXML
    private Tab tabCategory;
    @FXML
    private Button btnAddCat;
    @FXML
    private Tab tabApplication;
    @FXML
    private TextArea txtApplication;
    @FXML
    private Button btnConfirm;
    @FXML
    private Font x1;
    @FXML
    private ChoiceBox<Category> cbCategory;
    @FXML
    private Button btnDone;
    @FXML
    private Button btnChangeData;
    private List<Category> lc;

    private final SubmitApplicationController apController;

    public SubmitApplicationUI() throws FileNotFoundException, ParseException {
        apController = new SubmitApplicationController();
    }

    public void initialize(URL url, ResourceBundle rb) {
        tabAQ.setDisable(true);
        tabPQ.setDisable(true);
        tabCategory.setDisable(true);
        tabApplication.setDisable(true);

    }

    @FXML
    private void btnVDataAction(ActionEvent event) {
        String fullName = txtFullName.getText().trim();
        String nif = txtNif.getText().trim();
        String phoneNumber = txtPhoneNumber.getText().trim();
        String email = txtEmail.getText().trim();
        String address = txtAddress.getText().trim();
        String postCode = txtPostCode.getText().trim();
        String locality = txtLocality.getText().trim();
        if (apController.newApplication(fullName, nif, phoneNumber, email, address, postCode, locality) == true) {
            createAlert(Alert.AlertType.INFORMATION, "Validation",
                    "Data saved!").showAndWait();
            tabData.setDisable(true);
            tabAQ.setDisable(false);
        }
    }

    @FXML
    private void btnAddAcadQualiAction(ActionEvent event) {
        String designation = txtDesignation.getText().trim();
        String degree = txtDegree.getText().trim();
        String classification = txtClassification.getText().trim();
        if (apController.addAcadQualification(designation, degree, classification)) {
            createAlert(Alert.AlertType.INFORMATION, "Validation",
                    "Data saved!").showAndWait();
            tabPQ.setDisable(false);
        }
    }

    @FXML
    private void btnAddProQualiAction(ActionEvent event) {
        String description = txtDescription.getText().trim();
        if (apController.addProQualification(description)) {
            createAlert(Alert.AlertType.INFORMATION, "Validation",
                    "Data saved!").showAndWait();
            tabCategory.setDisable(false);
        }
        cbCategory.getItems().clear();
        for (Category cat : apController.getCategories()) {
            cbCategory.getItems().add(cat);
        }
    }

    @FXML
    private void btnAddCatAction(ActionEvent event) {
        Category aux = cbCategory.getValue();
        if (apController.addCategory(aux)) {
            createAlert(Alert.AlertType.INFORMATION, "Validation",
                    "Data saved!").showAndWait();
        }
    }

    @FXML
    private void btnDoneAction(ActionEvent event) {
        tabAQ.setDisable(true);
        tabPQ.setDisable(true);
        tabCategory.setDisable(true);
        tabApplication.setDisable(false);
        txtApplication.setText(apController.printApp());
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) throws IOException {
        apController.registerApplication();
        createAlert(Alert.AlertType.INFORMATION, "Registry",
                "Application Registered!").showAndWait();
        changeScene("/fxml/Menu.fxml");
    }

    @FXML
    private void btnChangeDataAction(ActionEvent event) throws IOException {
        Alert alert = Utils.createConfirmationExitAlert();
        if (alert.showAndWait().get() == ButtonType.YES) {
            changeScene("/fxml/Menu.fxml");
        }
    }

    public void changeScene(String sceneURL) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneURL));
        Parent root = (Parent) loader.load();
        Stage stage = MainApp.getStage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
