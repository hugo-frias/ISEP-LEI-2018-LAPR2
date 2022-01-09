package lapr.project.serviceprovider.gpsd.importers;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.serviceprovider.gpsd.model.Importer;
import lapr.project.serviceprovider.gpsd.model.PostalAddress;
import lapr.project.serviceprovider.gpsd.model.ServiceOrder;
import lapr.project.serviceprovider.gpsd.model.ZipCode;
import lapr.project.serviceprovider.utils.Date;
import lapr.project.serviceprovider.utils.Time;

/**
 *
 * @author Diogo Ribeiro
 */
public class XLSImporterAdapter implements Importer {

    /**
     * Imports a XLS file containing the Service Provider's service execution
     * orders.
     *
     * @param nameFile name of file
     */
    @Override
    public List<ServiceOrder> importFile(String nameFile) {
        List<ServiceOrder> serviceOrdersList = new ArrayList<>();
        try {
            FileInputStream excelFile = new FileInputStream(new File(nameFile));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            iterator.next();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                addServiceOrder(serviceOrdersList,cellIterator);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XLSImporterAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XLSImporterAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serviceOrdersList;
    }

    /**
     * Adds a service order to a list.
     * 
     * @param serviceOrdersList service order's list
     * @param cellIterator
     */
    public void addServiceOrder(List<ServiceOrder> serviceOrdersList, Iterator<Cell> cellIterator) {
        double number = cellIterator.next().getNumericCellValue();
        String clientName = cellIterator.next().getStringCellValue().trim();
        String distance = cellIterator.next().getStringCellValue().trim();
        String cat = cellIterator.next().getStringCellValue();
        String servType = cellIterator.next().getStringCellValue();
        String date = cellIterator.next().getStringCellValue().trim();
        String[] dateAttributes = date.split("-");
        Date date1 = new Date(Integer.parseInt(dateAttributes[2].trim()), Integer.parseInt(dateAttributes[1].trim()), Integer.parseInt(dateAttributes[0].trim()));
        String time = cellIterator.next().getStringCellValue().trim();
        String[] timeAttributes = time.split(":");
        Time time1 = new Time(Integer.parseInt(timeAttributes[0].trim()), Integer.parseInt(timeAttributes[1].trim()));
        PostalAddress postalAddress = new PostalAddress(cellIterator.next().getStringCellValue().trim(), cellIterator.next().getStringCellValue().trim(), new ZipCode(cellIterator.next().getStringCellValue().trim()));
        serviceOrdersList.add(new ServiceOrder((int) number,clientName,Double.parseDouble(distance),cat,servType,date1,time1,postalAddress));
    }
}