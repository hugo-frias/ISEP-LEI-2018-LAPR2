package lapr.project.serviceprovider.gpsd.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.serviceprovider.gpsd.controller.GPSD;
import lapr.project.serviceprovider.gpsd.controller.HistoricalServiceOrdersController;
import lapr.project.serviceprovider.gpsd.model.ServiceOrder;
import lapr.project.serviceprovider.ui.MainApp;
import lapr.project.serviceprovider.utils.Utils;

/**
 * FXML Controller class
 *
 * @author André Novo
 */
public class HistoricalServiceOrdersUI implements Initializable {

    /**
     * Button variable
     */
    @FXML
    private Button btnSearch;

    /**
     * AssociatePostalAddressController controller
     */
    private HistoricalServiceOrdersController hSOController;

    /**
     * ListView variable
     */
    @FXML
    private ListView lstServiceOrders;

    /**
     * TextFIeld variable
     */
    @FXML
    private TextField txtName;

    /**
     * Button variable
     */
    @FXML
    private Button btnReturn;
    @FXML

    /**
     * TextField variable
     */
    private TextField txtPostal;

    /**
     * Creates instances of HistoricalServiceOrdersUI
     * @throws java.io.FileNotFoundException
     * @throws java.text.ParseException
     */
    public HistoricalServiceOrdersUI() throws FileNotFoundException, ParseException {
        hSOController = new HistoricalServiceOrdersController();
    }

    /**
     * Initializes the FXML Controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtPostal.setDisable(true);
        if (GPSD.getInstance().getCompany().getServiceExecutionOrdersRegistry().getServiceExecutionOrders() != null) {
            ObservableList<ServiceOrder> oServiceOrdersList = FXCollections.observableArrayList(GPSD.getInstance().getCompany().getServiceExecutionOrdersRegistry().getServiceExecutionOrders());
            if (oServiceOrdersList != null) {
                lstServiceOrders.setItems(oServiceOrdersList);
            }
        }

    }

    /**
     * Method that will search and show service orders by Client
     *
     * @param event mouse left click
     */
    @FXML
    private void search(ActionEvent event) {
        if (txtPostal.getText().isEmpty()) {
            if (!txtName.getText().isEmpty()) {
                if (hSOController.getServiceExecutionOrdersListByClient(txtName.getText().trim()) != null) {
                    ObservableList<ServiceOrder> oSortedServiceOrdersList = FXCollections.observableArrayList(hSOController.getServiceExecutionOrdersListByClient(txtName.getText().trim()));
                    if (oSortedServiceOrdersList != null && !oSortedServiceOrdersList.isEmpty()) {
                        if (!hSOController.verifyName(txtName.getText().trim())) {
                            lstServiceOrders.setItems(oSortedServiceOrdersList);
                        } else {
                            Utils.createAlert(Alert.AlertType.ERROR, "There are two clients with the same name.", "Please introduce the ZipCode and press Search button again.").showAndWait();
                            txtPostal.setDisable(false);
                        }
                    } else {
                        Utils.createAlert(Alert.AlertType.ERROR, "There is no service orders for that client", "").showAndWait();
                    }

                } else {
                    Utils.createAlert(Alert.AlertType.ERROR, "Name field can't be empty.", "").showAndWait();
                    event.consume();
                }
            }
        } else {
            ObservableList<ServiceOrder> oSortedServiceOrdersList = FXCollections.observableArrayList(hSOController.filterServiceExecutionOrdersListByZipCode(txtPostal.getText().trim()));
            if (oSortedServiceOrdersList != null && !oSortedServiceOrdersList.isEmpty()) {
                lstServiceOrders.setItems(oSortedServiceOrdersList);
            } else {
                Utils.createAlert(Alert.AlertType.ERROR, "Invalid zipCode", "").showAndWait();
            }
        }
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        if (Utils.createConfirmationExitAlert().showAndWait().get() == ButtonType.YES) {
            changeScene("/fxml/Menu.fxml");
        } else {
            event.consume();
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
