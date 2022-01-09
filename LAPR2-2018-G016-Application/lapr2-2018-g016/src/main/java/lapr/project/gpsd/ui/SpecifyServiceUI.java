/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.SpecifyServiceController;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.ServiceType;
import lapr.project.ui.MainApp;
import lapr.project.utils.AlertMessages;
import lapr.project.utils.CompanyFinals;
import lapr.project.utils.Utils;

/**
 * FXML Controller class
 *
 * @author Beatriz Ribeiro
 */
public class SpecifyServiceUI implements Initializable {

    @FXML
    private Button btnAddService;
    @FXML
    private ComboBox<ServiceType> cmbServiceType;
    @FXML
    private Label lblServiceType;
    @FXML
    private Label lblCategory;
    @FXML
    private ComboBox<Category> cmbCategory;
    @FXML
    private Label lblService;
    @FXML
    private Label lblId;
    @FXML
    private Label lblBriefDesc;
    @FXML
    private Label lblCompleteDesc;
    @FXML
    private Label lblHourlyCost;
    @FXML
    private Label lblPeriod;
    @FXML
    private TextField txtBriefDesc;
    @FXML
    private TextField txtCompleteDesc;
    @FXML
    private TextField txtHorulyCost;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtPeriod;

    private SpecifyServiceController specifyServiceController = new SpecifyServiceController();
    @FXML
    private Button btnAddData;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupComboBoxServiceTypes();
        setupCategories();
    }

    /**
     * adds Service
     *
     * @param event - OnClick event
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    @FXML
    private void addService(ActionEvent event) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
        try {
            if (txtId.getText().isEmpty() || txtBriefDesc.getText().isEmpty() || txtCompleteDesc.getText().isEmpty() || txtHorulyCost.getText().isEmpty() || cmbCategory.getValue() == null || cmbServiceType.getValue() == null) {
                throw new NullPointerException();
            }
            
            boolean hasAttrbs = specifyServiceController.newService(txtId.getText().trim(), txtBriefDesc.getText().trim(), txtCompleteDesc.getText().trim(), Double.parseDouble(txtHorulyCost.getText().trim()), cmbCategory.getValue(), cmbServiceType.getValue());
            if (hasAttrbs) {
                createAlert(Alert.AlertType.INFORMATION, "INFORMATION", "Please insert the service's period!").showAndWait();
                disableForPeriod();
                txtPeriod.setVisible(true);
                lblPeriod.setVisible(true);
                btnAddData.setVisible(true);
                btnAddService.setVisible(false);
            } else {
                createAlert(Alert.AlertType.CONFIRMATION, "CONFIRMATION", "Do you confirm the service?").showAndWait();
                boolean regists = specifyServiceController.registsService();
                if (regists) {
                    createAlert(Alert.AlertType.INFORMATION, "INFORMATION", "Serviço registado!").showAndWait();
                    changeScene("/fxml/AdministrativeUI.fxml");
                }
            }

        } catch (NullPointerException e) {
            Utils.createAlert(Alert.AlertType.ERROR, AlertMessages.ERROR_MESSAGE, "Please complete the fields").showAndWait();
        }
    }

    @FXML
    private void addNewData(ActionEvent event) throws IOException {
        double attrbs = specifyServiceController.getOtherAttributes(); //Desnecessário???
        try{
        if(Utils.validateServicePeriod(Integer.parseInt(txtPeriod.getText().trim()))){
            throw new IllegalArgumentException();
            
        }
        specifyServiceController.setAdditionalData(Integer.parseInt(txtPeriod.getText().trim()));
        createAlert(Alert.AlertType.CONFIRMATION, "CONFIRMATION", "Do you confirm the service?").showAndWait();
        boolean regists = specifyServiceController.registsService();
        if (regists) {
            createAlert(Alert.AlertType.INFORMATION, "INFORMATION", "Serviço registado!").showAndWait();
            changeScene("/fxml/AdministrativeUI.fxml");
        }
        }catch(IllegalArgumentException e){
            Utils.createAlert(Alert.AlertType.ERROR, "ERROR", "Period shoud be 30 or more than 30 minutes. Also should be a multiple of 30!").showAndWait();
        }
    }

    /**
     * select service type
     *
     * @param event OnClick event
     */
    @FXML
    private void chooseServiceType(ActionEvent event) {
        cmbServiceType.setDisable(true);
        cmbCategory.setDisable(false);

    }

    /**
     * select category
     *
     * @param event OnClickEvent
     */
    @FXML
    private void chooseCategory(ActionEvent event) {
        cmbCategory.setDisable(true);
        txtId.setDisable(false);
        txtBriefDesc.setDisable(false);
        txtCompleteDesc.setDisable(false);
        txtHorulyCost.setDisable(false);
    }

    /**
     * Adds Service Types to the combobox
     */
    private void setupComboBoxServiceTypes() {
        List<ServiceType> serviceTypes = specifyServiceController.getServiceTypes();
        for (ServiceType serviceType : serviceTypes) {
            cmbServiceType.getItems().add(serviceType);
        }
    }

    /**
     * Adds Categories to the combobox
     */
    private void setupCategories() {
        List<Category> categories = specifyServiceController.getCategories();
        for (Category category : categories) {
            cmbCategory.getItems().add(category);
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

    private void disableForPeriod() {
        txtId.setDisable(true);
        txtBriefDesc.setDisable(true);
        txtCompleteDesc.setDisable(true);
        txtHorulyCost.setDisable(true);
    }
    
    

}
