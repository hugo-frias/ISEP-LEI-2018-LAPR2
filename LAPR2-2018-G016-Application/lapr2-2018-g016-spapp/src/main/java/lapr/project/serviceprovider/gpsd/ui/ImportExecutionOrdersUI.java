package lapr.project.serviceprovider.gpsd.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.serviceprovider.gpsd.controller.ImportExecutionOrdersController;
import lapr.project.serviceprovider.gpsd.model.FileFormat;
import lapr.project.serviceprovider.gpsd.registry.ServiceExecutionOrdersRegistry;
import lapr.project.serviceprovider.ui.MainApp;
import lapr.project.serviceprovider.utils.Utils;

/**
 *
 * @author Diogo Ribeiro
 */
public class ImportExecutionOrdersUI implements Initializable {

    /**
     * Button variable.
     */
    @FXML
    private Button btnImport;

    /**
     * TextField variable.
     */
    @FXML
    private TextField txtNameFile;

    /**
     * Button variable.
     */
    @FXML
    private Button btnCancel;

    /**
     * ComboBox variable.
     */
    @FXML
    private ComboBox cmbFileFormat;

    /**
     * ImportExecutionOrdersController instance.
     */
    private final ImportExecutionOrdersController ieoController;

    /**
     * Constant that stores a message.
     */
    public static final String ERROR_MESSAGE_HEADER = "Data Error";

    /**
     * Constant that stores a message.
     */
    public static final String UC16_MESSAGE_TITLE = "Import execution orders";

    /**
     * Empty constructor.
     */
    public ImportExecutionOrdersUI() {
        ieoController = new ImportExecutionOrdersController();
    }

    /**
     * Initializes the controller.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupComboBoxFileFormats();
    }

    /**
     * Imports the file that contains the service execution orders
     *
     * @param event
     */
    @FXML
    private void importServiceOrders(ActionEvent event) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        try {
            if (txtNameFile.getText() == null || txtNameFile.getText().isEmpty() || cmbFileFormat.getValue() == null) {
                throw new IllegalArgumentException();
            }
            FileFormat fileFormat = (FileFormat) cmbFileFormat.getValue();
            String fileFormat1 = fileFormat.getName();
            String nameFile = txtNameFile.getText() + "." + fileFormat1;
            File f = new File(nameFile);
            if (!f.exists() || f.isDirectory()) {
                throw new FileNotFoundException();
            }
            ieoController.importServiceOrders(nameFile, fileFormat);
            exit();
        } catch (IllegalArgumentException iae) {
            Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "Some data is invalid.").show();
        } catch (FileNotFoundException fnfe) {
            Utils.createAlert(Alert.AlertType.ERROR, ERROR_MESSAGE_HEADER, "The file doesn't exist.").show();
        }
    }

    /**
     * Adds File Formats to the combobox
     */
    private void setupComboBoxFileFormats() {
        List<FileFormat> fileFormats = ieoController.getFileFormats();
        fileFormats.forEach((fileFormat) -> {
            cmbFileFormat.getItems().add(fileFormat);
        });
    }

    /**
     * Shows an information successful operation alert
     *
     * @throws IOException
     */
    private void exit() throws IOException {
        Alert alert = Utils.createInformationSuccessfulOperationAlert(UC16_MESSAGE_TITLE, "Service execution orders imported with success!");
        if (alert.showAndWait().get() == ButtonType.FINISH) {
            ServiceExecutionOrdersRegistry.saveServiceOrders(ieoController.getCompany().getServiceExecutionOrdersRegistry().getServiceExecutionOrders());
            changeScene("/fxml/Menu.fxml");
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
