/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import static helpers.InitApp.Init;
import helpers.Loader;
import java.io.FileNotFoundException;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lapr.project.gpsd.algorithm.TaskFactory;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ZipCode;
import lapr.project.utils.Utils;

public class MainApp extends Application {

    private static Stage primary;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            List<ZipCode> readZipCodes = Loader.readZipCodes();
            Init();
            GPSD.getInstance().getCompany();
            TaskFactory.getInstance();
            Company c = GPSD.getInstance().getCompany();
            primary = stage;
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
        } catch (FileNotFoundException e) {
            Utils.createAlert(Alert.AlertType.ERROR, "ERROR", "FILE NOT FOUND").showAndWait();
        }
    }

    /**
     * Returns primary stage
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
