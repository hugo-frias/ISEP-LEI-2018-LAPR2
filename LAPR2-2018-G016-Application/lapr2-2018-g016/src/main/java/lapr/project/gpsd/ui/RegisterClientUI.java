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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.RegisterClientController;
import lapr.project.ui.MainApp;
import lapr.project.utils.AlertMessages;
import lapr.project.utils.Utils;

/**
 *
 * @author Diogo Ribeiro
 */
public class RegisterClientUI implements Initializable {

    /**
     * TabPane variable.
     */
    @FXML
    private TabPane tabPane;

    /**
     * Tab variable.
     */
    @FXML
    private Tab tabPersonal;

    /**
     * Tab variable.
     */
    @FXML
    private Tab tabPostal;

    /**
     * Button variable.
     */
    @FXML
    private Button btnSave;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtName;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtNIF;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtPhone;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtEmail;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtPassword;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtAddress;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtZipCode;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtLocation;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtAddress1;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtZipCode1;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtLocation1;

    /**
     * Button variable.
     */
    @FXML
    private Button btnSave1;

    /**
     * Button variable.
     */
    @FXML
    private Button btnCancel;

    /**
     * RegisterClientController instance.
     */
    private final RegisterClientController rcController;

    /**
     * Constant that stores a message.
     */
    public static final String ERROR_MESSAGE_HEADER = "Data Error";

    /**
     * Constant that stores a message.
     */
    public static final String UC1_MESSAGE_TITLE = "Register as client";

    /**
     * Empty constructor.
     */
    public RegisterClientUI() throws FileNotFoundException, ParseException {
        rcController = new RegisterClientController();
    }

    /**
     * Initializes the controller.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabPostal.setDisable(true);
    }

    /**
     * Creates a new client
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void createNewClient(ActionEvent event) throws IOException, FileNotFoundException, ParseException {
        try {
            if(txtName.getText().isEmpty() || txtNIF.getText().isEmpty() || txtPhone.getText().isEmpty() ||txtEmail.getText().isEmpty() || txtPassword.getText().isEmpty() ||txtAddress.getText().isEmpty() || txtZipCode.getText().isEmpty() || txtLocation.getText().isEmpty()){
            throw new NullPointerException();
        }
            boolean cliTrue = rcController.newClient(txtName.getText().trim(), Integer.parseInt(txtNIF.getText().trim()), Integer.parseInt(txtPhone.getText().trim()), txtEmail.getText().trim(), txtPassword.getText().trim(), txtAddress.getText().trim(), txtZipCode.getText().trim(), txtLocation.getText().trim());
            if (!cliTrue) {
                Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "Data related to nif and/or email is duplicated.").show();
            } else {
                Alert alert = Utils.createConfirmationAlert(UC1_MESSAGE_TITLE, "Add a postal address", "Do you want to add another postal address?");
                if (alert.showAndWait().get() == ButtonType.YES) {
                    tabPane.getSelectionModel().selectNext();
                    tabPostal.setDisable(false);
                    tabPersonal.setDisable(true);
                } else {
                    showData();
                }
            }
        } catch (NumberFormatException nfe) {
            Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "Data related to nif and/or phone contact are incorrect.").show();
        } catch (IllegalArgumentException iae) {
            Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "Some data is not valid.").show();
        } catch(NullPointerException e){
            Utils.createAlert(Alert.AlertType.ERROR, AlertMessages.ERROR_MESSAGE, "Please complete the fields!").showAndWait();
        }
    }

    /**
     * Adds postal address to client.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void addPostalAddress(ActionEvent event) throws IOException, FileNotFoundException, ParseException {
        try {
            boolean address = rcController.addPostalAddress(txtAddress1.getText().trim(), txtZipCode1.getText().trim(), txtLocation.getText().trim());
            if (!address) {
                Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "You already have this postal address associated.").show();
            } else {
                Alert alert = Utils.createConfirmationAlert(UC1_MESSAGE_TITLE, "Add a postal address", "Do you want to add another postal address?");
                if (alert.showAndWait().get() == ButtonType.NO) {
                    showData();
                }
            }
        } catch (NumberFormatException nfe) {
            Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "The format of the zip code is incorrect.").show();
        } catch (IllegalArgumentException iae) {
            Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "Some data is not valid.").show();
        }
    }

    /**
     * Shows the data introduced by the user.
     *
     * @throws IOException
     */
    private void showData() throws IOException, FileNotFoundException, ParseException {
        Alert alert = Utils.createConfirmationAlert(UC1_MESSAGE_TITLE, "Client's data:\n" + rcController.getClientString() + "\nClient´s postal address list:\n" + Utils.printList(rcController.getClient().getPostalAddressList()), "Do you confirm this data?");
        if (alert.showAndWait().get() == ButtonType.YES) {
            rcController.registerClient();
            Alert alert1 = Utils.createInformationSuccessfulOperationAlert(UC1_MESSAGE_TITLE, "client's data recorded with success!");
            if (alert1.showAndWait().get() == ButtonType.YES) {
                changeScene("/fxml/Menu.fxml");
            }
        } else {
            changeScene("/fxml/RegisterClient.fxml");
        }
    }

    /**
     * Cancels the use case.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void cancel(ActionEvent event) throws IOException {
        Alert alert = Utils.createConfirmationExitAlert();
        if (alert.showAndWait().get() == ButtonType.YES) {
            changeScene("/fxml/Menu.fxml");
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
