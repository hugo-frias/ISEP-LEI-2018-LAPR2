/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exporter.adapters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;
import javafx.scene.control.Alert;
import lapr.project.gpsd.model.Exporter;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.utils.Utils;

/**
 *
 * @author André Novo
 */
public class CSVExporterAdapter implements Exporter {

    /**
     * Method to export service execution orders in CSV format
     *
     * @param serviceOrders the list with all service orders to export
     * @param nameFile the name of file that will be created
     */
    @Override
    public void exportFile(List<ServiceOrder> serviceOrders, String nameFile) {
        try {
            Formatter out = new Formatter(new File(nameFile + ".csv"));
            StringBuilder sb = new StringBuilder();
            int count = 0;
            sb.append("Number ; ClientsName ; Distance ; ServiceCategory ; ServiceType ; Date ; Time ; ClientAddress ; Location ; ClientsZipCode").append("\n");
            for (ServiceOrder sO : serviceOrders) {
                if (sO != null && sO.toString() != null && !sO.toString().isEmpty()) {
                    sb.append(count - 1);
                    sb.append(sO.getAffectation().getServiceRequest().getClient().getName()).append(";");
                    sb.append(String.format("%.2f", Utils.getDistance(sO.getAffectation().getServiceRequest().getPostalAddress().getZipCode().getLatitude(), sO.getAffectation().getServiceRequest().getPostalAddress().getZipCode().getLongitude(), sO.getAffectation().getServiceRequest().getPostalAddress().getZipCode().getLatitude(), sO.getAffectation().getServiceRequest().getPostalAddress().getZipCode().getLongitude()))).append(";");
                    sb.append(sO.getAffectation().getServiceRequestDescription().getService().getCategory().getDescription()).append(";");
                    sb.append(sO.getAffectation().getServiceRequestDescription().getService().getServiceType().toString()).append(";");
                    sb.append(sO.getIssueDate().toString()).append(";");
                    sb.append(sO.getAffectation().getSchedulePreference().toString()).append(";");
                    sb.append(sO.getAffectation().getServiceRequest().getPostalAddress().getAddress()).append(";");
                    sb.append(sO.getAffectation().getServiceRequest().getPostalAddress().getLocation()).append(";");
                    sb.append(sO.getAffectation().getServiceRequest().getPostalAddress().getZipCode().toString()).append("\n");
                }
            }

            out.format("%s", sb.toString());
            out.close();
        } catch (FileNotFoundException ex) {
            Utils.createAlert(Alert.AlertType.ERROR, "Unfortunately, the file could not be exported.", nameFile).showAndWait();
        }
    }

}
