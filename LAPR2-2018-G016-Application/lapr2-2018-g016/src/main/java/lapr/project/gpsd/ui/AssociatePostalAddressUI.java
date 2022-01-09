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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.AssociatePostalAddressController;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.ui.MainApp;
import lapr.project.utils.Utils;

public class AssociatePostalAddressUI implements Initializable {

    /**
     * TextField variable
     */
    @FXML
    private TextField txtAddress;

    /**
     * TextField variable
     */
    @FXML
    private TextField txtZipCode;

    /**
     * TextField variable
     */
    @FXML
    private TextField txtLocation;

    /**
     * Button variable
     */
    @FXML
    private Button btnCancel;

    /**
     * Button variable
     */
    @FXML
    private Button btnAdd;

    /**
     * AssociatePostalAddressController variable
     */
	 
    private AssociatePostalAddressController apaController;
    
	/*
	* MakeServiceRequestUI variable
	*/
	
    private MakeServiceRequestUI makeServiceRequestUI;
    
	/*
	* Temporary PostalAddress variable
	*/
	
    private PostalAddress postalAddress;

    /**
     * Empty constructor
     */
    public AssociatePostalAddressUI() throws FileNotFoundException, ParseException {
        apaController = new AssociatePostalAddressController();
    }

    /**
     * Initialize (default) method
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        apaController.newPostalAdress();
    }

    /**
     * Method to cancel the UC
     *
     * @param event
     */
    @FXML
    private void cancel(ActionEvent event) throws IOException {
        if (Utils.createAlert(Alert.AlertType.CONFIRMATION, "Do you really want to go back?", "").showAndWait().get() == ButtonType.OK) {
            changeScene("/fxml/ClientMenu.fxml");
        } else {
            event.consume();
        }
    }

    /**
     * Method to add the new postal address to the client instance
     *
     * @param event
     */
    @FXML
    private void add(ActionEvent event) {
        if (Utils.createAlert(Alert.AlertType.CONFIRMATION, "Do you really want to add this new postal address", "").showAndWait().get() == ButtonType.OK) {
            apaController.newPostalAddress(txtAddress.getText().trim(), txtZipCode.getText().trim(), txtLocation.getText().trim());
            postalAddress= apaController.getPostalAddress();
            ((Node) event.getSource()).getScene().getWindow().hide();
        } else {
            event.consume();
        }
    }
    
    /*
	* Makes the connection with the UC6
	*/
	
    public void associateUI(MakeServiceRequestUI makeServiceRequestUI){
        this.makeServiceRequestUI= makeServiceRequestUI;
    }
	
	/*
	* Returns the temporary PostalAddress variable
	*/
	
    public PostalAddress getPostalAddress(){
        return this.postalAddress;
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