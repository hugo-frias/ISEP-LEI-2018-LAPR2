/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.registry;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ServiceRequest.ServiceRequestStatus;
import lapr.project.gpsd.model.ServiceRequest;

/**
 *
 * @author Beatriz Ribeiro
 */
public class ServiceRequestRegistry {

    private final List<ServiceRequest> serviceRequestList;

    private int number = 0;

    /**
     * Creates ServiceRequestRRegistry instances
     */
    public ServiceRequestRegistry() {
        this.serviceRequestList = new ArrayList<ServiceRequest>();
    }

    /**
     * Creates a new Service Request
     *
     * @param cli - Client
     * @param postalAddress - postal Address of Client
     * @return Service Request
     */
    public ServiceRequest newServiceRequest(Client cli, PostalAddress postalAddress) {
        return new ServiceRequest(cli, postalAddress);
    }

    /**
     * Returns service Request list
     *
     * @return list of service request
     */
    public List<ServiceRequest> getServiceRequestList() {
        return serviceRequestList;
    }

    public List<ServiceRequest> getSubmittedServiceRequest() {
        List<ServiceRequest> listSubServReq = new ArrayList<ServiceRequest>();
        for (ServiceRequest servReq : this.serviceRequestList) {
            if (servReq.getServiceStatus().equals(ServiceRequestStatus.SUBMITTED.getStatus())) {
                listSubServReq.add(servReq);
            }
        }
        return listSubServReq;
    }

    public List<ServiceRequest> getAffectedServiceRequestByCient(Client client) {
        List<ServiceRequest> listAffSubReq = new ArrayList<ServiceRequest>();
        try{
        for (ServiceRequest servReq : this.serviceRequestList) {
            if (servReq.getServiceStatus().equals(ServiceRequestStatus.AFFECTATED.getStatus()) && servReq.getClient().equals(client)) {
                listAffSubReq.add(servReq);
            }
        }
        }catch(Exception e){
            System.out.println(e.getCause());
        }
        return listAffSubReq;
    }

    public boolean registsServiceRequest(ServiceRequest servReq) {
        if (validatesServiceRequest(servReq)) {
            servReq.setNumber(generatesRequestNumber());
            addServiceRequest(servReq);
            return true;
        }
        return false;
    }

    private boolean validatesServiceRequest(ServiceRequest servReq) {
        if (!this.serviceRequestList.contains(servReq)) {
            return true;
        }
        return false;
    }

    private int generatesRequestNumber() {
        number = number + 1;
        return number;
    }

    private void addServiceRequest(ServiceRequest servReq) {
        this.serviceRequestList.add(servReq);
    }
}
