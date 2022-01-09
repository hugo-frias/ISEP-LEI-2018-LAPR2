/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

/**
 *
 * @author Beatriz Ribeiro
 */
public class ServiceRequestDescription {

    /**
     * attribute that represents Service description
     */
    private String description;

    /**
     * attribute that represents Service
     */
    private Service service;

    /**
     * attribute that represents service period
     */
    private int period;

    /**
     * attribute that represents service status
     */
    private String serviceStatus;

    /**
     * attribute that represents rate
     */
    private Rate rate;

    /**
     * attribute that represents rate status
     */
    private String rateStatus;

    /**
     * Creates Service Request Description instances
     *
     * @param description - description
     * @param service - choosed servcice
     * @param period - service period
     */
    public ServiceRequestDescription(String description, Service service, int period) {
        if (description == null || description.isEmpty()) {
            throw new NullPointerException();
        }
        if (period < 30) {
            throw new IllegalArgumentException();
        }
        this.description = description;
        this.service = service;
        this.period = period;
        this.serviceStatus = ServiceRequestDescriptionStatus.SUBMITTED.getStatus();
        this.rateStatus= ServiceRequestDescriptionStatus.NOTRATED.getStatus();
    }

    /**
     * Compares two Service Descriptions
     *
     * @param obj other Service Request Desciption
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
        ServiceRequestDescription otherServiceRequestDescription = (ServiceRequestDescription) obj;
        return (this.description.equals(otherServiceRequestDescription.description)
                && this.period == otherServiceRequestDescription.period
                && this.service.equals(otherServiceRequestDescription.service));
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns service
     *
     * @return service
     */
    public Service getService() {
        return service;
    }

    /**
     * return service cost
     *
     * @return
     */
    public double getCost() {
        return this.service.getCostForPeriod(period);
    }

    /**
     * Modiefies Service Status
     *
     * @param status new status
     */
    public void setServiceStatus(String status) {
        this.serviceStatus = status;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    /**
     * Returns service status
     *
     * @return
     */
    public String getServiceStatus() {
        return serviceStatus;
    }

    /**
     * Returns rate
     *
     * @return rate
     */
    public Rate getRate() {
        return rate;
    }

    /**
     * Returns rate status
     *
     * @return rate status
     */
    public String getRateStatus() {
        return rateStatus;
    }

    /**
     * Modiefies rate Status
     *
     * @param rateStatus
     */
    public void setRateStatus(String rateStatus) {
        this.rateStatus = rateStatus;
    }

    /**
     * Enum for Service status
     */
    public enum ServiceRequestDescriptionStatus {
        AFFECTATED("Affectated service"), SUBMITTED("Submitted service"), RATED("Rated Service"), NOTRATED("Service not rated");

        private String status;

        private ServiceRequestDescriptionStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}