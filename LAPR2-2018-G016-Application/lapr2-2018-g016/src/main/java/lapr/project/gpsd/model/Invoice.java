/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.Objects;

/**
 *
 * @author Hugo Frias
 */
public class Invoice {
    /**
     * ServiceOrder variable
     */
    private ServiceRequest serviceRequest;
    
    /**
     * Constructor
     * @param serviceOrder
     * @param invoiceLines 
     */
    public Invoice(ServiceRequest servReq) {
        this.serviceRequest = servReq;
    }
    /**
     * returns the service order
     * @return service order
     */
    public ServiceRequest getServiceRequest() {    
        return serviceRequest;
    }

    /**
     * sets the service order
     * @param serviceOrder new service order
     */
    public void setServiceRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    /**
     * prints the invoice
     * @return String with invoice's data
     */
    @Override
    public String toString() {
        return "Invoice{" + "service request=" + serviceRequest+'}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.serviceRequest);
        return hash;
    }
    
    /**
     * method to compare 2 invoices
     * @param obj other invoice
     * @return if its equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Invoice other = (Invoice) obj;
        if (!Objects.equals(this.serviceRequest, other.serviceRequest)) {
            return false;
        }
        return true;
    }
    
}
