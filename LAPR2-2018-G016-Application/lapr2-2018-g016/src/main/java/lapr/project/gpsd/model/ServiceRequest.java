/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.utils.Date;
import lapr.project.utils.Time;

/**
 *
 * @author Beatriz Ribeiro
 */
public class ServiceRequest {

    /**
     * service request number
     */
    private int number;

    /**
     * service request date
     */
    private Date date;

    /**
     * total cost of service request
     */
    private double total;

    /**
     * client that makes the request
     */
    private Client client;

    /**
     * client's postal address;
     */
    private PostalAddress postalAddress;

    /**
     * List of services request descriptions
     */
    private List<ServiceRequestDescription> servReqDescList;

    /**
     * cost of request
     */
    private OtherCost otherCost;

    /**
     * client's Schedule Preferences
     */
    private List<SchedulePreference> schPrefList;
    
     /**
     * attribute that represents service request status
     */
    private String serviceRequestStatus;

    
    private int count =0;

    /**
     * Creates a service request
     *
     * @param client - Client that makes the request
     * @param postalAddress - client's postl address
     */
    public ServiceRequest(Client client, PostalAddress postalAddress) {
        this.date = new Date(Date.actualDate());
        this.client = client;
        this.postalAddress = postalAddress;
        this.servReqDescList = new ArrayList<ServiceRequestDescription>();
        this.schPrefList = new ArrayList<SchedulePreference>();
        this.serviceRequestStatus=ServiceRequestStatus.SUBMITTED.getStatus();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Número: %d%n Date: %s Cost: %.2f", this.number, this.date, this.total);
    }

    
    /**
     * Compares two service requests
     *
     * @param obj - other service request
     * @return true or false
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
        ServiceRequest otherServReq = (ServiceRequest) obj;
        return (this.client.equals(otherServReq.client) && this.date.equals(otherServReq.date) && this.number == otherServReq.number
                && this.otherCost.equals(otherServReq.otherCost) && this.postalAddress.equals(otherServReq.postalAddress) && this.total == otherServReq.total);
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns Client
     * @return client
     */
    public Client getClient() {
        return client;
    }

    
   /**
     * Modiefies Service Request Status
     * @param status new status
     */
    public void setServiceStatus(String status) {
        this.serviceRequestStatus = status;
    }

    /**
     * Returns service request status
     * @return status
     */
    public String getServiceStatus() {
        return serviceRequestStatus;
    }

    /**
     * Returns Service Request Descriptions List
     * @return list of service request descriptions
     */
    public List<ServiceRequestDescription> getServReqDescList() {
        return servReqDescList;
    }

    /**
     * Returns Client's schedule preferences List
     * @return list of service request descriptions
     */
    public List<SchedulePreference> getSchPrefList() {
        return schPrefList;
    }

    /**
     * Returns Client's postal address
     * @return postal address
     */
    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    
    
    public boolean addToServiceRequest(Service serv, String desc, int period) {
        ServiceRequestDescription servReqDesc = new ServiceRequestDescription(desc, serv, period);
        boolean validates = validatesServReqDesc(servReqDesc);
        if(validates){
            this.addToServiceRequest(servReqDesc);
            return true;
        }
        return false;
    }

    private boolean validatesServReqDesc(ServiceRequestDescription servReqDesc) {
        if (!this.servReqDescList.contains(servReqDesc)) {
            return true;
        }
        return false;
    }

    private void addToServiceRequest(ServiceRequestDescription servReqDesc) {
        this.servReqDescList.add(servReqDesc);

    }
    
    public boolean addSchedule(Date date, Time time){
        int order = countSchedules();
        SchedulePreference schPref = new SchedulePreference(date, time, order);
        if(validatesSchedule(schPref)){
            addSchedule(schPref);
            return true;
        } 
        return false;
    }
    
    private int countSchedules(){
        count =count+1;
        return count;
    }
    
    private boolean validatesSchedule(SchedulePreference schPref){
        if(!this.schPrefList.contains(schPref)){
            return true;
        }
        return false;
    }
    
    private void addSchedule(SchedulePreference schPref){
        this.schPrefList.add(schPref);
    }
    
    /**
     *calcula custo de pedido
     */
    public void computesCost() {
        for(ServiceRequestDescription servReqDesc : this.servReqDescList){
            if(servReqDesc!=null){
            total= total + servReqDesc.getCost();
            }
        }
        GeographicalArea geographicalArea= GPSD.getInstance().getCompany().getGeographicalAreaResgitry().getAreaGeograficaMaisPerto(this.postalAddress.getZipCode());
        double travelCost= geographicalArea.getTravelCost();
        otherCost= new OtherCost("deslocação", travelCost);
        total=total +travelCost;
    }
    
    /**
     * Enum for Service status
     */
    public enum ServiceRequestStatus{
        AFFECTATED("Affectated service request"),SUBMITTED("Submitted service request");
        
        private String status;

        private ServiceRequestStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}
