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
import javafx.geometry.Insets;
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
import lapr.project.gpsd.controller.RegisterServiceProviderController;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.ApplicationStatus.Status;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.ui.MainApp;
import lapr.project.utils.Utils;
import static lapr.project.utils.Utils.createAlert;

/**
 *
 * @author momog
 */
public class RegisterServiceProviderUI implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TextField txtIDNumber;
    @FXML
    private TextField txtInstitutionalEmail;
    @FXML
    private Button btnImportApplication;
    @FXML
    private TextField txtNif;
    @FXML
    private ChoiceBox<GeographicalArea> cbGeographicalArea;
    @FXML
    private Button btnConfirm;
    @FXML
    private Tab tabConfirmation;
    @FXML
    private Tab tabGeoArea;
    @FXML
    private Tab tabData;
    @FXML
    private TextArea txtServiceProviderData;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnInsertManual;
    @FXML
    private Button btnImportData;
    @FXML
    private TextArea txtApplicationData;
    private final RegisterServiceProviderController rpsController;
    private Application app;
    @FXML
    private Insets x2;
    @FXML
    private Button btnValidateData;
    @FXML
    private Insets x3;
    @FXML
    private TextField txtFullName;
    @FXML
    private Button btnValidateAddress;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtxPostCode;
    @FXML
    private TextField txtLocality;
    @FXML
    private Button btnAddCat;
    @FXML
    private ChoiceBox<Category> cbCategories;
    @FXML
    private Button btnAddGeo;
    @FXML
    private Tab tabAdData;
    @FXML
    private Tab tabPA;
    @FXML
    private Tab tabCat;

    /**
     * Initializes the controller class.
     */
    public RegisterServiceProviderUI() {
        this.rpsController = new RegisterServiceProviderController();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtApplicationData.setDisable(true);
        tabAdData.setDisable(true);
        tabConfirmation.setDisable(true);
        tabGeoArea.setDisable(true);
        tabCat.setDisable(true);
        tabPA.setDisable(true);
        cbCategories.getItems().addAll(rpsController.getCategories());
        cbGeographicalArea.getItems().addAll(rpsController.getGeoAreas());
    }

    @FXML
    private void btnImportApplicationAction(ActionEvent event) {
        int nif = Integer.parseInt(txtNif.getText().trim());
        if (rpsController.getApplicationByNif(nif) != null) {
            app = rpsController.getApplicationByNif(nif);
            txtApplicationData.setText(app.toString());
            txtApplicationData.setDisable(false);
            createAlert(Alert.AlertType.INFORMATION, "Application", "Application found!").show();

        }

    }

    @FXML
    private void btnInsertManualAction(ActionEvent event) {
        createAlert(Alert.AlertType.INFORMATION, "Service Provider", "Insert the required data!").show();
        tabPA.setDisable(false);
        
    }

    @FXML
    private void btnImportDataAction(ActionEvent event) {
        rpsController.newServiceProvider(app);
        app.getAs().setDescription(Status.CECKEDACCEPTED.getStatus());
        tabAdData.setDisable(false);
        createAlert(Alert.AlertType.INFORMATION, "Application", "Application's data imported!").show();

    }

    @FXML
    private void btnValidateAddressAction(ActionEvent event) {
        String fullName = txtFullName.getText().trim();
        String address = txtAddress.getText().trim();
        String postCode = txtxPostCode.getText().trim();
        String locality = txtLocality.getText().trim();
        if(rpsController.newServiceProvider(fullName, address, postCode, locality)){
        tabCat.setDisable(false);
        createAlert(Alert.AlertType.INFORMATION, "Postal Address", "Postal Address data validated!").show();
        }
    }

    @FXML
    private void btnAddCatAction(ActionEvent event) {
        Category cat = cbCategories.getValue();
        if(rpsController.setCategory(cat)){
        tabAdData.setDisable(false);
        createAlert(Alert.AlertType.INFORMATION, "Category", "Category added!").show();
    }
    }

    @FXML
    private void btnValidateDataAction(ActionEvent event) {
        String IDNumber = txtIDNumber.getText().trim();
        String InstitutionalEmail = txtInstitutionalEmail.getText().trim();
        if (rpsController.setAditionalData(IDNumber, InstitutionalEmail)) {
            tabGeoArea.setDisable(false);
            createAlert(Alert.AlertType.INFORMATION, "Aditional Data", "Aditional Data validated!").show();
        }
        
    }

    @FXML
    private void btnConfirmAction(ActionEvent event) throws IOException {
        rpsController.registServiceProvider();
        createAlert(Alert.AlertType.INFORMATION, "Confirm", "Service Provider registered!").show();
        changeScene("/fxml/MenuHRoUI.fxml");
    }

    @FXML
    private void btnCancelAction(ActionEvent event) throws IOException {
        Alert alert = Utils.createConfirmationExitAlert();
        if (alert.showAndWait().get() == ButtonType.YES) {
            changeScene("/fxml/HRoUI.fxml");
        }
    }

    @FXML
    private void btnAddGeoAction(ActionEvent event) {
        GeographicalArea geo = cbGeographicalArea.getValue();
        if (rpsController.setGeographicalArea(geo)) {
            tabConfirmation.setDisable(false);            
            txtServiceProviderData.setText(rpsController.getSp().toString());
            createAlert(Alert.AlertType.INFORMATION, "Geographical Area", "Geographical Area validated!").show();
        }
        
    }
    /**
     * Changes a scene in the same stage
     *
     * @param sceneURL scene url
     * @throws IOException
     */
    public void changeScene(String sceneURL) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneURL));
        Parent root = (Parent) loader.load();
        Stage stage = MainApp.getStage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

}
