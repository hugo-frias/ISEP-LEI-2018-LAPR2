
package lapr.project.gpsd.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.controller.RateServiceController;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.ServiceRequestDescription;
import lapr.project.ui.MainApp;
import lapr.project.utils.Utils;

/**
 *
 * @author Hugo Frias
 * 
 */

public class RateServiceUI implements Initializable {
    /**
     * ChoiceBox variable
     */
    @FXML
    private ChoiceBox<String> cbRating;
    /**
     * Button variable
     */
    @FXML
    private Button btnDone;
    /**
     * TextArea variable
     */
    @FXML
    private TextArea txtInvoice;
    
    @FXML
    private ComboBox<ServiceRequestDescription> cmbServReqDesc;
    /**
     * client using the app
     */
    public Client cli;
    /**
     * 
     */
    private final RateServiceController rsController;
    /**
     * ServiceRequestDescription list variable
     */
    private List<ServiceRequestDescription> dl = new ArrayList<>();
    /**
     * Empty constructor
     */
    public RateServiceUI(){
        rsController = new RateServiceController();
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbRating.getItems().addAll("0","1","2","3","4","5");
        String email = GPSD.getInstance().getCurrentSession().getUserEmail();
        for(ServiceRequestDescription srd : rsController.showServiceList(GPSD.getInstance().getCompany().getClientsRegistry().getClientByEmail(email))){
           cmbServReqDesc.getItems().add(srd);
        }
        cbRating.setDisable(true);
        
        //dl = rsController.showServiceList(cli);
       
    }    
    /**
     * Adds a rating to a service description and service provider
     * @param event 
     */
    @FXML
    private void btnDoneAction(ActionEvent event) throws IOException {
        ServiceRequestDescription srdAux = cmbServReqDesc.getValue();
        Rate rate = new Rate();
        rate.setRate(Integer.parseInt(cbRating.getValue()));
        if(rsController.setRating(srdAux,rate)){
            Utils.createAlert(Alert.AlertType.INFORMATION, "Rating Service", "Service Rated!").showAndWait();
            changeScene("/fxml/ClientMenu.fxml");
        }else{
            Utils.createAlert(Alert.AlertType.ERROR, "Rating Service", "This service is already rated!").showAndWait();
            
        }
        
    }

    @FXML
    private void invoiceOnAction(ActionEvent event) {
        if (rsController.seeInvoice(cmbServReqDesc.getValue())!= null){
            txtInvoice.setText(rsController.seeInvoice(cmbServReqDesc.getValue()));
            cbRating.setDisable(false);
        }  else{
            Utils.createAlert(Alert.AlertType.ERROR, "Invoice ", "Error loading the invoice!");
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
