/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Invoice;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceRequestDescription;
import lapr.project.gpsd.model.ServiceRequestDescription.ServiceRequestDescriptionStatus;
import lapr.project.gpsd.model.ServiceProvider;

/**
 *
 * @author Hugo Frias
 *
 */
public class RateServiceController {

    /**
     * Company variable
     */
    private final Company company;
    /**
     * List of service orders
     */
    private List<ServiceOrder> lso = new ArrayList<>();

    private Invoice invoice;

    private Client cli;

    /**
     * Empty Constructor
     */
    public RateServiceController() {
        company = GPSD.getInstance().getCompany();

    }

    /**
     * Shows the Service Description list, depending on the client
     *
     * @param cli cliente using the app
     * @return Service Description list
     */
    public List<ServiceRequestDescription> showServiceList(Client cli) {
        this.cli = cli;
        lso = company.getServiceOrdersRegistry().getServiceOrdersByClient(cli);
        List<ServiceRequestDescription> aux = new ArrayList<>();
        for (ServiceOrder a : lso) {
            if (a.getAffectation().getServiceRequestDescription().getRateStatus().equals(ServiceRequestDescriptionStatus.NOTRATED.getStatus())) {
                aux.add(a.getAffectation().getServiceRequestDescription());
            }
        }
        return aux;
    }

    /**
     * Sets the rating selected by the user on the Service Request Description, and adds it to the Service Provider
     *
     * @param srdAux Service Request Description selected by the client
     * @param rate rate given by the client
     * @return success
     */
    public boolean setRating(ServiceRequestDescription srdAux, Rate rate) {
        for (ServiceOrder a : lso) {
            if (a.getAffectation().getServiceRequestDescription().equals(srdAux)) {
  
                    ServiceProvider spAux = a.getAffectation().getServiceProvider();
                    spAux.getRatesList().add(rate);
                    srdAux.setRate(rate);
                    srdAux.setRateStatus(ServiceRequestDescriptionStatus.RATED.getStatus());
                    return true;

                }
            
        }
        return false;
    }

    public String seeInvoice(ServiceRequestDescription srd) {

        for (ServiceOrder a : lso) {
            if (a.getAffectation().getServiceRequestDescription().equals(srd)) {
                invoice = new Invoice(a.getAffectation().getServiceRequest());
                for (Invoice invoiceAux : cli.getInvoiceList()) {
                    if (!invoiceAux.equals(invoice)) {
                        cli.getInvoiceList().add(invoice);
                    }
                }
                return invoice.toString();
            }

        }
        return null;
    }

}
