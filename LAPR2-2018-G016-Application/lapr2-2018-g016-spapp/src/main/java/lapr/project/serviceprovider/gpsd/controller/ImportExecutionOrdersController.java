package lapr.project.serviceprovider.gpsd.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import lapr.project.serviceprovider.gpsd.model.Company;
import lapr.project.serviceprovider.gpsd.model.FileFormat;
import lapr.project.serviceprovider.gpsd.model.ServiceOrder;

/**
 *
 * @author Diogo Ribeiro
 */
public class ImportExecutionOrdersController {

    /**
     * attribute that represents company
     */
    private final Company company;

    /**
     * Creates instances of ImportExecutionOrdersController
     */
    public ImportExecutionOrdersController() {
        this.company = GPSD.getInstance().getCompany();
    }

    /**
     * Returns the company
     * @return company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Returns list of File Formats
     *
     * @return list of FileFormat
     */
    public List<FileFormat> getFileFormats() {
        return this.company.getFileFormatsRegistry().getFileFormats();
    }

    /**
     * Imports the service execution orders
     *
     * @param nameFile name of file
     * @param fileFormat file format
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public void importServiceOrders(String nameFile, FileFormat fileFormat) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<ServiceOrder> serviceOrdersList = fileFormat.importServiceOrders(nameFile);
        company.getServiceExecutionOrdersRegistry().addServiceExecutionOrdersListNonRepetitive(serviceOrdersList);
    }
}
