/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.ExportServiceOrdersController;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.model.FileFormat;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.ui.MainApp;
import lapr.project.utils.Date;
import lapr.project.utils.Utils;

/**
 *
 * @author André Novo
 *
 */
public class ExportServiceOrdersUI implements Initializable {

    /**
     * ComboBox variable
     */
    @FXML
    private ComboBox cmbFFormat;

    /**
     * Button variable
     */
    @FXML
    private Button btnCancel;

    /**
     * Button variable
     */
    @FXML
    private Button btnExport;

    /**
     * ExportServiceOrdersController instance
     */
    private ExportServiceOrdersController eSOController;

    /**
     * DatePicker variable
     */
    @FXML
    private DatePicker dpBeginning;

    /**
     * DatePicker variable
     */
    @FXML
    private DatePicker dpEnding;

    /**
     * TextField variable
     */
    @FXML
    private TextField txtNameFile;
    @FXML
    private TextArea txtAreaOrders;
    @FXML
    private Button btnSeeOrders;

    /**
     * Initialize Method
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eSOController = new ExportServiceOrdersController();
        setUpComboBox();
    }

    /**
     * cancel the UC
     *
     * @param event
     */
    @FXML
    private void cancel(ActionEvent event) throws IOException {
        if (Utils.createAlert(Alert.AlertType.CONFIRMATION, "Do you really want to go back?", "").showAndWait().get() == ButtonType.OK) {
            changeScene("/fxml/ServiceProviderMenu.fxml");
        } else {
            event.consume();
        }
    }

    /**
     * Method to export file
     *
     * @param event
     * @throws FileNotFoundException
     */
    @FXML
    private void export(ActionEvent event) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
        Date dateBeginning = new Date(dpBeginning.getValue().getYear(), dpBeginning.getValue().getMonthValue(), dpBeginning.getValue().getDayOfMonth());
        Date dateEnding = new Date(dpEnding.getValue().getYear(), dpEnding.getValue().getMonthValue(), dpEnding.getValue().getDayOfMonth());
        List<ServiceOrder> sOList = eSOController.getPeriodicServiceOrders(dateBeginning, dateEnding);
        if (sOList != null && !txtNameFile.getText().isEmpty()) {
            eSOController.exportFile((FileFormat) cmbFFormat.getValue(), txtNameFile.getText());
            Utils.createAlert(Alert.AlertType.INFORMATION, "INFORMATION", "Service Orders Exported").showAndWait();
            changeScene("/fxml/ServiceProviderMenu.fxml");
        } else {
            Utils.createAlert(Alert.AlertType.ERROR, "No service orders were found in given period.", "Or nameFile is empty.").showAndWait();
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
     * Method to setUp the comboBox
     */
    
    private void setUpComboBox() {
        for (FileFormat ff : GPSD.getInstance().getCompany().getFileFormatsRegistry().getFileFormats()) {
            if (ff != null && !ff.toString().isEmpty()) {
                cmbFFormat.getItems().add(ff);
            }
        }
    }

    @FXML
    private void seeOrders(ActionEvent event) {
        Date dateBeginning = new Date(dpBeginning.getValue().getYear(), dpBeginning.getValue().getMonthValue(), dpBeginning.getValue().getDayOfMonth());
        Date dateEnding = new Date(dpEnding.getValue().getYear(), dpEnding.getValue().getMonthValue(), dpEnding.getValue().getDayOfMonth());
        List<ServiceOrder> sOList = eSOController.getPeriodicServiceOrders(dateBeginning, dateEnding);
        if (sOList != null && !txtNameFile.getText().isEmpty()) {
            for(ServiceOrder so : sOList){
                txtAreaOrders.setText(so.toString());
            }
        } else {
            Utils.createAlert(Alert.AlertType.ERROR, "No service orders were found in given period.", "Or nameFile is empty.").showAndWait();
        }
    }
}
