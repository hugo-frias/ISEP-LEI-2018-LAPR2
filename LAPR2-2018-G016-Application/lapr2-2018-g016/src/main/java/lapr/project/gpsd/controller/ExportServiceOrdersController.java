/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.FileFormat;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.utils.Date;

/**
 *
 * @author André Novo
 *
 */
public class ExportServiceOrdersController {

    /**
     * Temporary Company variable
     */
    private Company company;

    /**
     * Temporary ServiceProvider variable
     */
    private ServiceProvider serviceProvider;

    /**
     * Temporary service execution orders list
     */
    private List<ServiceOrder> serviceOrders;

    /**
     * Creates a instance of ExportServiceOrdersController
     */
    public ExportServiceOrdersController() {
        company = GPSD.getInstance().getCompany();

    }

    /**
     * Returns the list of service orders inside the given period
     *
     * @param beginning beginning date
     * @param ending ending date
     * @return
     */
    public List<ServiceOrder> getPeriodicServiceOrders(Date beginning, Date ending) {

        serviceOrders = getServiceProviderServiceOrders();
        List<ServiceOrder> serviceOrdersAux = new ArrayList<ServiceOrder>(serviceOrders);
        for (ServiceOrder sO : serviceOrders) {
            if (sO.getIssueDate().difference(ending) > 0 && sO.getIssueDate().difference(beginning) < 0) {
                serviceOrdersAux.remove(sO);
            }
        }
        return serviceOrdersAux;
    }

    /**
     * Returns the service orders for that service provider
     *
     * @return
     */
    private List<ServiceOrder> getServiceProviderServiceOrders() {
        serviceProvider = GPSD.getInstance().getCompany().getServiceProvidersRegistry().getServiceProviderByEmail(GPSD.getInstance().getCurrentSession().getUserEmail());
        List<ServiceOrder> sOAux = new ArrayList<ServiceOrder>(this.company.getServiceOrdersRegistry().getServiceOrdersByServiceProvider(serviceProvider));
        return sOAux;
    }

    /**
     *
     * @param ff
     * @param nameFile
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.NoSuchMethodException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     */
    public void exportFile(FileFormat ff, String nameFile) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ff.exportServiceOrders(serviceOrders, nameFile);
    }

}
