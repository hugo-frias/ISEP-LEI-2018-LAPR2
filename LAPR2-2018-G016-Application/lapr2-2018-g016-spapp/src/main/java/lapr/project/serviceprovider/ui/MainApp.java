package lapr.project.serviceprovider.ui;

import java.io.File;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lapr.project.serviceprovider.gpsd.controller.GPSD;
import lapr.project.serviceprovider.gpsd.model.ServiceOrder;
import lapr.project.serviceprovider.gpsd.registry.ServiceExecutionOrdersRegistry;
import static lapr.project.serviceprovider.utils.CompanyFinals.NAME_FILE;

public class MainApp extends Application {

    private static Stage primary;

    @Override
    public void start(Stage stage) throws Exception {

        File serOrders = new File(NAME_FILE);
        if (serOrders.exists() && !serOrders.isDirectory()) {
            List<ServiceOrder> serviceOrdersList = ServiceExecutionOrdersRegistry.importServiceOrders();
            GPSD.getInstance().getCompany().getServiceExecutionOrdersRegistry().addServiceExecutionOrdersListNonRepetitive(serviceOrdersList);
        }
        primary = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("SPapp");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("SPApp");
                alert.setHeaderText("Action confirmation.");
                alert.setContentText("Do you really want to close the app?");

                if (alert.showAndWait().get() == ButtonType.CANCEL) {
                    event.consume();
                }
            }
        });
    }

    /**
     * Returns primary stage
     *
     * @return priamry stage
     */
    public static Stage getStage() {
        return primary;
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
