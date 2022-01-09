package lapr.project.serviceprovider.gpsd.ui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import lapr.project.serviceprovider.gpsd.controller.SortRecordsServiceOrdersController;
import lapr.project.serviceprovider.gpsd.model.ServiceOrder;
import lapr.project.serviceprovider.ui.MainApp;
import lapr.project.serviceprovider.utils.SortParameters;
import lapr.project.serviceprovider.utils.Utils;

/**
 *
 * @author Diogo Ribeiro
 */
public class SortRecordsServiceOrdersUI implements Initializable {

    /**
     * TabPane variable.
     */
    @FXML
    private TabPane tabPane;
    /**
     * Tab variable.
     */
    @FXML
    private Tab tab1;

    /**
     * Tab variable.
     */
    @FXML
    private Tab tab2;

    /**
     * Tab variable.
     */
    @FXML
    private Tab tab3;

    /**
     * Button variable.
     */
    @FXML
    private Button btnSort;

    /**
     * ListView variable.
     */
    @FXML
    private ListView txtList;

    /**
     * Button variable.
     */
    @FXML
    private Button btnCancel;

    /**
     * ComboBox variable.
     */
    @FXML
    private ComboBox cmbSort;

    /**
     * Button variable.
     */
    @FXML
    private Button btnSort1;

    /**
     * ListView variable.
     */
    @FXML
    private ListView txtSortedList;

    /**
     * Button variable.
     */
    @FXML
    private Button btnFinish;

    /**
     * SortRecordsServiceOrdersController instance.
     */
    private final SortRecordsServiceOrdersController srsoController;

    /**
     * Constant that stores a message.
     */
    public static final String ERROR_MESSAGE_HEADER = "Data Error";

    /**
     * Constant that stores a message.
     */
    public static final String UC17_MESSAGE_TITLE = "Sort service orders";

    /**
     * Empty constructor.
     */
    public SortRecordsServiceOrdersUI() {
        srsoController = new SortRecordsServiceOrdersController();
    }

    /**
     * Initializes the controller.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showServiceOrdersList();
        } catch (IOException ex) {
            Logger.getLogger(SortRecordsServiceOrdersUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        tab2.setDisable(true);
        tab3.setDisable(true);
        setupComboBoxSortParameters();
    }

    /**
     * Asks the user if he wants to sort his service execution orders.
     *
     * @param event
     */
    @FXML
    private void chooseSortParameters(ActionEvent event) throws IOException {
        Alert alert = Utils.createConfirmationAlert(UC17_MESSAGE_TITLE, "Choosing a sort parameter", "Do you want to choose a parameter to sort the list?");
        if (alert.showAndWait().get() == ButtonType.YES) {
            tabPane.getSelectionModel().selectNext();
            tab2.setDisable(false);
            tab1.setDisable(true);
        } else {
            exit();
        }
    }

    /**
     * Shows service provider's execution orders list.
     */
    private void showServiceOrdersList() throws IOException {
        List<ServiceOrder> serviceOrdersList = srsoController.getServiceOrders();
        ObservableList<ServiceOrder> oServiceOrdersList = FXCollections.observableArrayList(serviceOrdersList);
        txtList.setItems(oServiceOrdersList);

    }

    /**
     * Adds sort parameters to the combobox
     */
    private void setupComboBoxSortParameters() {
        for (int i = 0; i < SortParameters.NUMBER_SORT_PARAMETERS; i++) {
            String attribute = SortParameters.sortParametersDesignation(i);
            cmbSort.getItems().add(attribute);
        }
    }

    /**
     * Sorts the service order's list acoording to a certain parameter
     */
    @FXML
    private void sortServiceOrders() {
        try {
            if (cmbSort.getValue() == null) {
                throw new IllegalArgumentException();
            }
            String parameter = (String) cmbSort.getValue();
            tabPane.getSelectionModel().selectNext();
            tab3.setDisable(false);
            tab2.setDisable(true);
            List<ServiceOrder> sortedList = srsoController.sortServiceOrders(parameter);
            showSortedServiceOrdersList(sortedList);
        } catch (IllegalArgumentException iae) {
            Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "The parameter is invalid.").show();
        }
    }

    /**
     * Shows service provider's execution orders list.
     */
    private void showSortedServiceOrdersList(List<ServiceOrder> sortedServiceOrdersList) {
        ObservableList<ServiceOrder> oSortedServiceOrdersList = FXCollections.observableArrayList(sortedServiceOrdersList);
        txtSortedList.setItems(oSortedServiceOrdersList);
    }

    /**
     * Shows a confirmation exit alert.
     *
     * @throws IOException
     */
    @FXML
    private void exit() throws IOException {
        Alert alert = Utils.createConfirmationAlert(UC17_MESSAGE_TITLE, "New sort", "Do you want to sort the original list according to another parameter");
        if (alert.showAndWait().get() == ButtonType.YES) {
            tabPane.getSelectionModel().selectPrevious();
            tab2.setDisable(false);
            tab3.setDisable(true);
        } else {
            if (alert.showAndWait().get() == ButtonType.NO) {
                changeScene("/fxml/Menu.fxml");
            }
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
