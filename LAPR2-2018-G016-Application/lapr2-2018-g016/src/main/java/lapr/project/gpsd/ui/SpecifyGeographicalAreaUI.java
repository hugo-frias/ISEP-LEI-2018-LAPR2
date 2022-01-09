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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.GeographicalAreaController;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.registry.GeographicalsAreasRegistry;
import lapr.project.ui.MainApp;
import lapr.project.utils.Utils;

/**
 * FXML Controller class
 *
 * @author Vera Pinto
 */
public class SpecifyGeographicalAreaUI implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtZipCode;
    @FXML
    private TextField txtOperatingRadius;
    @FXML
    private TextField txtCostOfTravel;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;

    private GeographicalAreaController controller = new GeographicalAreaController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void confirm(ActionEvent event) throws FileNotFoundException, ParseException, IOException {
        String nameString = txtName.getText();
        String zipCodeString = txtZipCode.getText();
        String operatingRadiusString = txtOperatingRadius.getText();
        String costOfTravel = txtCostOfTravel.getText();
        double travelCost = Double.parseDouble(costOfTravel);
        double operatingRadius = Double.parseDouble(operatingRadiusString);
        try {
            if (nameString.equalsIgnoreCase("") || zipCodeString.equalsIgnoreCase("") || operatingRadiusString.equalsIgnoreCase("") || costOfTravel.equalsIgnoreCase("")) {
                throw new NullPointerException("All data need to be introduced");
            } else {
                GeographicalArea ga = controller.newGeographicalArea(nameString, travelCost, zipCodeString, operatingRadius);
                GeographicalsAreasRegistry geographicalsAreasRegistry = new GeographicalsAreasRegistry();
                List<GeographicalArea> gar = geographicalsAreasRegistry.getGeographicalAreas();
                controller.registerGeographicalArea(ga);
                Utils.createAlert(Alert.AlertType.INFORMATION, "INFORMATION", "Área geográfica registada").showAndWait();
                changeScene("/fxml/AdministrativeUI.fxml");
            }
        } catch (NullPointerException e) {
            Utils.createAlert(Alert.AlertType.ERROR, "ERROR", "Please don't leave the fields in white").showAndWait();
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
        changeScene("/fxml/AdministrativeUI.fxml");
    }

}
