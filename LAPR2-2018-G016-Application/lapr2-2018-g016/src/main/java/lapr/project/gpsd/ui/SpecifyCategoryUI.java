package lapr.project.gpsd.ui;


import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.SpecifyCategoryController;
import lapr.project.ui.MainApp;
import lapr.project.utils.Utils;

/**
 *
 * @author André Novo
 * 
 */
public class SpecifyCategoryUI implements Initializable {

    /**
     * Label variable
     */
    private Label label;

    /**
     * TextField variable
     */
    @FXML
    private TextField txtCategoryID;

    /**
     * TextField variable
     */
    @FXML
    private TextField txtCategoryName;

    /**
     * Button variable
     */
    @FXML
    private Button btnCancel;

    /**
     * Button variable
     */
    @FXML
    private Button btnCreate;

    /**
     * SpecifyCategoryController variable
     */
    private SpecifyCategoryController spController = new SpecifyCategoryController();

    /**
     * Initialize (default) method
     *
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * Method to return to the main (menu) app
     *
     * @param event
     */
    @FXML
    private void cancel(ActionEvent event) {
        if (Utils.createAlert(Alert.AlertType.CONFIRMATION, "Do you really want to go back?", "").showAndWait().get() == ButtonType.CANCEL) {
            event.consume();
        }
    }

    /**
     * Creates category
     *
     * @param event OnClick event
     */
    @FXML
    private void createCategory(ActionEvent event) throws IOException {
        try {
            if (txtCategoryID.getText().equals("") || txtCategoryName.getText().equals("")) {
                throw new NullPointerException();
            }
            spController.newCategory(txtCategoryID.getText().trim(), txtCategoryName.getText().trim());

            boolean validate = spController.validatesCategory();
            if (validate) {
                if (Utils.createAlert(Alert.AlertType.CONFIRMATION, "CONFIRMATION", "Do you really want to create this category?" + "\n" + spController.getCategoryString()).showAndWait().get() == ButtonType.OK) {
                    boolean regist = spController.registCategory();
                    if (regist) {
                        Utils.createAlert(Alert.AlertType.CONFIRMATION, "CONFIRMATION", "Category registed").showAndWait();
                        changeScene("/fxml/AdministrativeUI.fxml");
                    }
                } else {
                    Utils.createAlert(Alert.AlertType.CONFIRMATION, "CONFIRMATION", "Please introduce the new data").showAndWait();
                    txtCategoryName.setText("");
                    txtCategoryID.setText("");
                }
            } else {
                Utils.createAlert(Alert.AlertType.WARNING, "WARNING", "The category already exixts").showAndWait();
                txtCategoryName.setText("");
                txtCategoryID.setText("");
            }
        } catch (NullPointerException e) {
            Utils.createAlert(Alert.AlertType.ERROR, "ERROR", "Please complete the missing fields!").showAndWait();
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
}
