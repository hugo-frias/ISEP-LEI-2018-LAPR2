/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import lapr.project.gpsd.model.ServiceRequestDescription.ServiceRequestDescriptionStatus;

/**
 *
 * @author Beatriz Ribeiro
 */
public class Affectation {
    /**
     * attribute that represents service provider
     */
    private ServiceProvider serviceProvider;
    
    /**
     * attribute that represents ServiceRequestDescription
     */
    private ServiceRequestDescription serviceRequestDescription;
    
    /**
     * attribute that represents number of service request;
     */
    private ServiceRequest serviceRequest;

    /**
     * attribute that represents service request schedule preference;
     */
    private SchedulePreference schedulePreference;
    
    /**
     * Creates affectation 
     * @param serviceProvider - affected service provider
     * @param serviceRequestDescription - service request description
     * @param serviceRequest  - service request 
     * @param schedulePreference - service schedule preference
     */
    public Affectation(ServiceProvider serviceProvider, ServiceRequestDescription serviceRequestDescription, ServiceRequest serviceRequest,SchedulePreference schedulePreference) {
        this.serviceProvider = serviceProvider;
        this.serviceRequestDescription = serviceRequestDescription;
        this.serviceRequestDescription.setServiceStatus(ServiceRequestDescriptionStatus.AFFECTATED.getStatus());
        this.serviceRequest = serviceRequest;
        this.schedulePreference=schedulePreference;
        this.schedulePreference.setScheduleStatus(SchedulePreference.SchedulePreferenceStatus.AFFECTATED.getStatus());
    }

    /**
     * Returns service request
     * @return service request
     */
    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    /**
     * Returns schedule prefernce
     * @return schedule preference
     */
    public SchedulePreference getSchedulePreference() {
        return schedulePreference;
    }

    /**
     * Return get service requests description
     * @return service request description
     */
    public ServiceRequestDescription getServiceRequestDescription() {
        return serviceRequestDescription;
    }
    
    
    
     /**
     * Returns service provider
     * @return service provider
     */
    
    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }
    
    
/**
 * Returns information about affectation
 * @return string with information about Affectation
 */
    @Override
    public String toString() {
        return String.format("Affectation:%nServiceProvider: %s%nServiceRequest: %s%nClient: %s%nSchedulePreference: %s %s", this.serviceProvider,this.serviceRequest,this.serviceRequest.getClient(),this.schedulePreference.getDate(),this.schedulePreference.getHour());
    }
    
    
    
}
