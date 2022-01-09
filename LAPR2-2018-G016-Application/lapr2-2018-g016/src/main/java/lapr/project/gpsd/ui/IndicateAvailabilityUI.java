/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.IndicateAvailabilityController;
import lapr.project.ui.MainApp;
import lapr.project.utils.Date;
import lapr.project.utils.Time;
import lapr.project.utils.Utils;

/**
 *
 * @author Diogo Ribeiro
 */
public class IndicateAvailabilityUI implements Initializable {
    
        /**
     * TabPane variable.
     */
    @FXML
    private TabPane tabPane;

    /**
     * Tab variable.
     */
    @FXML
    private Tab tab;

    /**
     * Tab variable.
     */
    @FXML
    private Tab tab1;

    /**
     * DatePicker variable.
     */
    @FXML
    private DatePicker dpBeginning;

    /**
     * DatePicker variable.
     */
    @FXML
    private DatePicker dpEnding;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtHourBeginning;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtMinuteBeginning;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtHourEnding;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtMinuteEnding;

    /**
     * Button variable.
     */
    @FXML
    private Button btnSave;

    /**
     * RadioButton variable.
     */
    @FXML
    private RadioButton rbtnMonday;

    /**
     * RadioButton variable.
     */
    @FXML
    private RadioButton rbtnTuesday;

    /**
     * RadioButton variable.
     */
    @FXML
    private RadioButton rbtnWednesday;

    /**
     * RadioButton variable.
     */
    @FXML
    private RadioButton rbtnThursday;

    /**
     * RadioButton variable.
     */
    @FXML
    private RadioButton rbtnFriday;

    /**
     * RadioButton variable.
     */
    @FXML
    private RadioButton rbtnSaturday;

    /**
     * Button variable.
     */
    @FXML
    private Button btnSave1;

    /**
     * IndicateAvailabilityController instance.
     */
    private final IndicateAvailabilityController iaController;

    /**
     * Constant that stores a message.
     */
    public static final String ERROR_MESSAGE_HEADER = "Data Error";

    /**
     * Constant that stores a message.
     */
    public static final String UC9_MESSAGE_TITLE = "Indicate Availability";
    @FXML
    private Button btnCancel;

    /**
     * Empty constructor.
     */
    public IndicateAvailabilityUI() {
        iaController = new IndicateAvailabilityController();
    }

    /**
     * Initializes the controller.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tab1.setDisable(true);
    }

    /**
     * Creates a new availability
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void createNewAvailability(ActionEvent event) throws IOException {
        try {
            LocalDate local1 = dpBeginning.getValue();
            LocalDate local2 = dpEnding.getValue();
            Date dateBeginning = new Date(local1.getYear(), local1.getMonthValue(), local1.getDayOfMonth());
            Date dateEnding = new Date(local2.getYear(), local2.getMonthValue(), local2.getDayOfMonth());
            Time timeBeginning = new Time(Integer.parseInt(txtHourBeginning.getText().trim()), Integer.parseInt(txtMinuteBeginning.getText().trim()));
            Time timeEnding = new Time(Integer.parseInt(txtHourEnding.getText().trim()), Integer.parseInt(txtMinuteEnding.getText().trim()));
            if(!validateDate(dateBeginning, dateEnding)){
                throw new IllegalArgumentException();
            }
            iaController.indicateNewAvailability();
            boolean avail = iaController.newAvailabilityPeriod(dateBeginning, timeBeginning, dateEnding, timeEnding);
            if (!avail) {
                Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "The availability alreary exists!").show();
            } else {
                askAboutPatterns();
            }
        } catch (NumberFormatException nfe) {
            Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "Data related to the hour is incorrect. Introduce only numbers.").show();
        } catch (IllegalArgumentException iae) {
            Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "Some data is not valid.").show();
        }
    }

    /**
     * Asks to the user if the wants to add patterns to the choosen availability
     * period.
     *
     * @throws IOException
     */
    private void askAboutPatterns() throws IOException {
        Alert alert = Utils.createConfirmationAlert(UC9_MESSAGE_TITLE, "Adding a pattern", "Do you want to add a pattern to the choosen period?");
        if (alert.showAndWait().get() == ButtonType.YES) {
            tabPane.getSelectionModel().selectNext();
            tab1.setDisable(false);
            tab.setDisable(true);
        } else {
            showData();
        }
    }

    /**
     * Adds patterns to the availability.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void addPatterns(ActionEvent event) throws IOException {
        ArrayList<String> patternsList = new ArrayList<>();
        if (rbtnMonday.isSelected()) {
            patternsList.add(rbtnMonday.getText());
        }
        if (rbtnTuesday.isSelected()) {
            patternsList.add(rbtnTuesday.getText());
        }
        if (rbtnWednesday.isSelected()) {
            patternsList.add(rbtnWednesday.getText());
        }
        if (rbtnThursday.isSelected()) {
            patternsList.add(rbtnThursday.getText());
        }
        if (rbtnFriday.isSelected()) {
            patternsList.add(rbtnFriday.getText());
        }
        if (rbtnSaturday.isSelected()) {
            patternsList.add(rbtnSaturday.getText());
        }
        iaController.addAvailabilityPatterns(patternsList);
        showData();
    }

    /**
     * Shows the data introduced by the user.
     * @throws IOException 
     */
    private void showData() throws IOException {
        Alert alert;
        if (iaController.getAvailability().getPatternsList().isEmpty()) {
            alert = Utils.createConfirmationAlert(UC9_MESSAGE_TITLE, "Availabiloty's data:\n" + iaController.getAvailabilityString() + "\nThere is no patterns associated", "Do you confirm this data?");
        } else {
            alert = Utils.createConfirmationAlert(UC9_MESSAGE_TITLE, "Availability's data:\n" + iaController.getAvailabilityString() + "\nYou will work all:\n" + Utils.printList(iaController.getAvailability().getPatternsList()), "Do you confirm this data?");
        }
        if (alert.showAndWait().get() == ButtonType.YES) {
            iaController.registerAvailabilityPeriod();
            Alert alert1 = Utils.createInformationSuccessfulOperationAlert(UC9_MESSAGE_TITLE, "client's data recorded with success!");
            if (alert1.showAndWait().get() == ButtonType.FINISH) {
                changeScene("/fxml/ServiceProviderMenu.fxml");
            }
        } else {
            changeScene("/fxml/IndicateAvailability.fxml");
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
            changeScene("/fxml/ServiceProviderMenu.fxml");
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
     /**
     * Validates Availability´s dates.
     * @param dBeginning availability's date of beginning
     * @param dEnding availability's date of ending
     * @return true or false
     */
    public boolean validateDate(Date dBeginning, Date dEnding) {
        if (dBeginning.weekDay().equals(Date.WeekDay.SUNDAY.toString()) || !dBeginning.isGreater(Date.actualDate())) {
            return false;
        }
        return (!dEnding.weekDay().equals(Date.WeekDay.SUNDAY.toString()) || dBeginning.isGreater(dEnding));
    }
}
