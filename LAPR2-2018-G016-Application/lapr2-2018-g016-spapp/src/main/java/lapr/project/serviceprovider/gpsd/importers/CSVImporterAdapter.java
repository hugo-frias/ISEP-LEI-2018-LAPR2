package lapr.project.serviceprovider.gpsd.importers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
public class CSVImporterAdapter implements Importer {
    
    /**
     * Imports a CSV file containing the Service Provider's service execution orders.
     * 
     * @param nameFile name of file
     * @return Service Provider's service orders's list
     */
    @Override
    public List<ServiceOrder> importFile(String nameFile) {
        List<ServiceOrder> serviceOrdersList = new ArrayList<>();
        try {
            Scanner fInput = new Scanner(new File(nameFile));
            fInput.nextLine();
            while (fInput.hasNext()) {
                String line = fInput.nextLine();
                if ((line.trim()).length() > 0) {
                    addServiceOrder(line,serviceOrdersList);
                }
            }
            fInput.close();
        } catch (FileNotFoundException fnfe) {
        }
        return serviceOrdersList;
    }
    
    /**
     * Adds a service order to a list.
     * 
     * @param line line containing the service order's attributes
     * @param serviceOrdersList service order's list
     */
    public void addServiceOrder(String line, List<ServiceOrder> serviceOrdersList) {
        String[] attributes = line.split(";");
        String[] dateAttributes = attributes[5].split("-");
        Date date = new Date(Integer.parseInt(dateAttributes[2].trim()),Integer.parseInt(dateAttributes[1].trim()),Integer.parseInt(dateAttributes[0].trim()));
        String[] timeAttributes = attributes[6].split(":");
        Time time = new Time(Integer.parseInt(timeAttributes[0].trim()),Integer.parseInt(timeAttributes[1].trim()));
        PostalAddress postalAddress = new PostalAddress(attributes[7].trim(),attributes[8].trim(), new ZipCode(attributes[9].trim()));
        serviceOrdersList.add(new ServiceOrder(Integer.parseInt(attributes[0].trim()), attributes[1].trim(), Double.parseDouble(attributes[2].trim()), attributes[3].trim(), attributes[4].trim(),date,time,postalAddress));
    }
}
