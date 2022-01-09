package lapr.project.serviceprovider.gpsd.ui;

import java.io.IOException;
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
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import lapr.project.serviceprovider.gpsd.controller.GPSD;
import lapr.project.serviceprovider.gpsd.model.ServiceOrder;
import static lapr.project.serviceprovider.gpsd.ui.SortRecordsServiceOrdersUI.UC17_MESSAGE_TITLE;
import lapr.project.serviceprovider.ui.MainApp;
import lapr.project.serviceprovider.utils.Utils;

/**
 * FXML Controller class
 *
 * @author André Novo
 * @author Diogo Ribeiro
 */
public class MenuUI implements Initializable {

    /**
     * Button variable.
     */
    @FXML
    private Button btnImport;

    /**
     * Button variable.
     */
    @FXML
    private Button btnSort;

    /**
     * Button variable.
     */
    @FXML
    private Button btnHistorical;

    /**
     * Initializes the controller.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Updates the importation of the file that contains the service execution
     * orders
     *
     * @param event
     */
    @FXML
    private void importServiceOrders(ActionEvent event) throws IOException {
        changeScene("/fxml/ImportExecutionOrders.fxml");
    }

    /**
     * Shows the service execution orders
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void sortRecordsServiceOrders(ActionEvent event) throws IOException {
        verifyIfThereAreServiceOrders("/fxml/SortRecordsServiceOrders.fxml");
    }

    /**
     * Shows the historical of service execution orders by client
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void seeHistoricalServiceOrdersByClient(ActionEvent event) throws IOException {
        verifyIfThereAreServiceOrders("/fxml/SeeHistoricalServiceOrders.fxml");
    }

    /**
     * Verifies if there are service orders in the company.
     * 
     * @param sceneURL scene url
     * @throws IOException 
     */
    public void verifyIfThereAreServiceOrders(String sceneURL) throws IOException {
        List<ServiceOrder> serviceOrdersList = GPSD.getInstance().getCompany().getServiceExecutionOrdersRegistry().getServiceExecutionOrders();
        if (serviceOrdersList.isEmpty()) {
            askIfUserWantsToImportServiceOrders();
        } else {
            changeScene(sceneURL);
        }
    }
    
        /**
     * Asks the user if he wants to import service orders.
     *
     * @throws IOException
     */
    public void askIfUserWantsToImportServiceOrders() throws IOException {
        Alert alert = Utils.createConfirmationAlert(UC17_MESSAGE_TITLE, "There are no service orders in the system", "Do you want to import service orders?");
        if (alert.showAndWait().get() == ButtonType.YES) {
            changeScene("/fxml/ImportExecutionOrders.fxml");
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
