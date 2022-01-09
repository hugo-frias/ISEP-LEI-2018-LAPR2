/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exporter.adapters;

import java.io.FileNotFoundException;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.control.Alert;
import lapr.project.gpsd.model.Exporter;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.utils.Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author André Novo
 */
public class XLSExporterAdapter implements Exporter {

    /**
     * String's array that will contain the headers of columns
     */
    private static String[] columns = {"Number", "ClientsName", "Distance", "ServiceCategory", "ServiceType", "Date", "Time", "ClientAddress", "Location", "ClientZipCode"};

    /**
     * Method to export service execution orders in XLS format
     *
     * @param serviceOrders
     */
    @Override
    public void exportFile(List<ServiceOrder> serviceOrders, String nameFile) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("ServiceExecutionOrders");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.ORANGE.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowNum = 1;

        for (ServiceOrder sO : serviceOrders) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rowNum - 1);
            row.createCell(1).setCellValue(sO.getAffectation().getServiceRequest().getClient().getName());
            row.createCell(2).setCellValue(String.format("%.2f", Utils.getDistance(sO.getAffectation().getServiceRequest().getPostalAddress().getZipCode().getLatitude(), sO.getAffectation().getServiceRequest().getPostalAddress().getZipCode().getLongitude(), sO.getAffectation().getServiceRequest().getPostalAddress().getZipCode().getLatitude(), sO.getAffectation().getServiceRequest().getPostalAddress().getZipCode().getLongitude())));
            row.createCell(3).setCellValue(sO.getAffectation().getServiceRequestDescription().getService().getCategory().getDescription());
            row.createCell(4).setCellValue(sO.getAffectation().getServiceRequestDescription().getService().getServiceType().toString());
            row.createCell(5).setCellValue(sO.getIssueDate().toString());
            row.createCell(6).setCellValue(sO.getAffectation().getSchedulePreference().toString());
            row.createCell(7).setCellValue(sO.getAffectation().getServiceRequest().getPostalAddress().getAddress());
            row.createCell(8).setCellValue(sO.getAffectation().getServiceRequest().getPostalAddress().getLocation());
            row.createCell(9).setCellValue(sO.getAffectation().getServiceRequest().getPostalAddress().getZipCode().toString());
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(nameFile + ".xls");
            workbook.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Utils.createAlert(Alert.AlertType.ERROR, "Unfortunately, the file could not be exported.", nameFile);
        } catch (IOException ex) {
            Utils.createAlert(Alert.AlertType.ERROR, "Unfortunately, the file could not be exported.", nameFile);
        }

    }

}
