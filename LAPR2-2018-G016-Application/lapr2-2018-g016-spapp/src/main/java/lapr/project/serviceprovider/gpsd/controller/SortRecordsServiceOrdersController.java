package lapr.project.serviceprovider.gpsd.controller;

import java.util.List;
import lapr.project.serviceprovider.gpsd.model.Company;
import lapr.project.serviceprovider.gpsd.model.ServiceOrder;
import lapr.project.serviceprovider.gpsd.model.SortServiceOrders;

/**
 *
 * @author Diogo Ribeiro
 */
public class SortRecordsServiceOrdersController {

    /**
     * attribute that represents company
     */
    private final Company company;

    /**
     * Creates instances of SortRecordsServiceOrdersController
     */
    public SortRecordsServiceOrdersController() {
        this.company = GPSD.getInstance().getCompany();
    }

    /**
     * Retuns the Company's service orders list
     * @return service orders list
     */
    public List<ServiceOrder> getServiceOrders() {
        return this.company.getServiceExecutionOrdersRegistry().getServiceExecutionOrders();
    }

    /**
     * Returns a list of sorted service provider's execution orders
     *
     * @param parameter sort parameter
     * @return
     */
    public List<ServiceOrder> sortServiceOrders(String parameter) {
        return SortServiceOrders.sortServiceOrders(parameter);
    }
}
