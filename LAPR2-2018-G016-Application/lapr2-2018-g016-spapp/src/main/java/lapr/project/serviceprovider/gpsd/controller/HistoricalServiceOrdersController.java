package lapr.project.serviceprovider.gpsd.controller;

import java.util.List;
import lapr.project.serviceprovider.gpsd.model.Company;
import lapr.project.serviceprovider.gpsd.model.ServiceOrder;
import lapr.project.serviceprovider.utils.Utils;

/**
 *
 * @author André Novo
 *
 */
public class HistoricalServiceOrdersController {

    /**
     * attribute that represents company
     */
    private Company company;

    /**
     * attribute that represents a temporary list of service orders
     */
    private List<ServiceOrder> serviceOrders;

    /**
     * Creates instances of HistoricalServiceOrdersController
     */
    public HistoricalServiceOrdersController() {
        company = GPSD.getInstance().getCompany();
    }

    /**
     * Filters the list of service execution orders for that client
     *
     * @param zipCode client's zipCode
     * @return the filtered list
     */
    
    public List<ServiceOrder> filterServiceExecutionOrdersListByZipCode(String zipCode) {
        return GPSD.getInstance().getCompany().getServiceExecutionOrdersRegistry().getServiceExecutionsOrdersByClient(serviceOrders, zipCode);
    }

    /**
     * Returns the list of service execution orders for that client
     *
     * @param name client's name
     * @return the list with all service orders for a client with that name
     */
    public List<ServiceOrder> getServiceExecutionOrdersListByClient(String name) {
        serviceOrders = GPSD.getInstance().getCompany().getServiceExecutionOrdersRegistry().getServiceExecutionsOrdersByClient(name);
        return serviceOrders;
    }
    
    /**
     * Method to verify if there are two clients with the same name
     *
     * @param name name of the client
     * @return true if there are and false if there arent
     */
    public boolean verifyName(String name) {
        return GPSD.getInstance().getCompany().getServiceExecutionOrdersRegistry().thereAreTwoClientsWithSameName(name);
    }

}
