/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.EvaluateServiceProviderController;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.model.LabelRate;
import lapr.project.gpsd.model.LabelRate.LabelRateEnum;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.Rate.RateEnum;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.ui.MainApp;
import lapr.project.utils.Utils;

/**
 * FXML Controller class
 *
 * @author Beatriz Ribeiro
 */
public class EvaluateServiceProviderUI implements Initializable {

    @FXML
    private Button btnLblRate;
    @FXML
    private Button btnDone;
    @FXML
    private BarChart<?, ?> chtServiceProvider;
    @FXML
    private ComboBox<ServiceProvider> cmbChooseSP;

    @FXML
    private ComboBox<String> cbmLabel;

    private EvaluateServiceProviderController evaluateSPController = new EvaluateServiceProviderController();
    @FXML
    private TextField txtMeanSP;
    @FXML
    private TextField txtMeanAllSP;
    @FXML
    private TextField txtStdDevSP;
    @FXML
    private TextField txtStdDevAllSP;
    @FXML
    private TextField txtDeviation;
    
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (ServiceProvider serviceProvider : GPSD.getInstance().getCompany().getServiceProvidersRegistry().getServiceProviders()) {
            cmbChooseSP.getItems().add(serviceProvider);
        }
        cbmLabel.setDisable(true);
    }

    @FXML
    private void changeLabelRate(ActionEvent event) {
        cbmLabel.setDisable(false);
        cbmLabel.getItems().add(LabelRateEnum.OUTSTANDING.getStatus());
        cbmLabel.getItems().add(LabelRateEnum.REGULAR.getStatus());
        cbmLabel.getItems().add(LabelRateEnum.WORST.getStatus());

    }

    @FXML
    private void done(ActionEvent event) throws IOException {
        ServiceProvider sp = cmbChooseSP.getValue();
        sp.getLabelRate().setLabelRate(cbmLabel.getValue());
        sp.getLabelRate().setMean(Double.parseDouble(txtMeanSP.getText()));
        sp.getLabelRate().setMean(Double.parseDouble(txtStdDevSP.getText()));
        Utils.createAlert(Alert.AlertType.INFORMATION, "INFORMATION", "Service Provider evaluated!").showAndWait();
        changeScene("/fxml/HROMenu.fxml");
    }

    @FXML
    private void chooseSP(ActionEvent event) {

        ServiceProvider sp = cmbChooseSP.getValue();
        XYChart.Series series1 = new XYChart.Series<>();

        int[] arrayRate = evaluateSPController.computeHistogram(sp);
        chtServiceProvider.getData().clear();

        series1.getData().add(new XYChart.Data("0", arrayRate[0]));
        series1.getData().add(new XYChart.Data("1", arrayRate[1]));
        series1.getData().add(new XYChart.Data("2", arrayRate[2]));
        series1.getData().add(new XYChart.Data("3", arrayRate[3]));
        series1.getData().add(new XYChart.Data("4", arrayRate[4]));
        series1.getData().add(new XYChart.Data("5", arrayRate[5]));

        chtServiceProvider.getData().addAll(series1);
        double meanSP = evaluateSPController.computeMeanForSP(sp);
        txtMeanSP.setText("" + meanSP);
        double meanAllSP = evaluateSPController.computeMeanForAllSP();
        txtMeanAllSP.setText("" + meanAllSP);
        double stdDevSP = evaluateSPController.computeStandardDeviationForSP(meanSP, sp);
        txtStdDevSP.setText("" + stdDevSP);
        double stdDevAllSP = evaluateSPController.computeStandardDeviationForAllSP(meanAllSP);
        txtStdDevAllSP.setText("" + evaluateSPController.computeStandardDeviationForAllSP(meanSP));
        txtDeviation.setText("" + Math.abs(meanSP - meanAllSP));
        cbmLabel.setPromptText(evaluateSPController.computeLabelRate(stdDevAllSP, meanAllSP, meanSP, sp));
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
