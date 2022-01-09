package lapr.project.serviceprovider.gpsd.model;

import java.io.Serializable;
import lapr.project.serviceprovider.utils.Date;
import lapr.project.serviceprovider.utils.Time;
import lapr.project.serviceprovider.utils.Utils;

/**
 *
 * @author Diogo Ribeiro
 */
public class ServiceOrder implements Serializable {

    /**
     * attribute that represents service order's number
     */
    private int number;

    /**
     * attribute that represents client's name
     */
    private String clientName;

    /**
     * attribute that represents the distance from SP facilities to client's
     * home
     */
    private double distance;

    /**
     * attribute that represents service category
     */
    private String serviceCategory;

    /**
     * attribute that represents service start date
     */
    private Date dateService;

    /**
     * attribute that represents service start time
     */
    private Time timeService;

    /**
     * attribute that represents type of service
     */
    private String serviceType;

    /**
     * attribute that represents client's postal address
     */
    private PostalAddress clientPostalAddress;

    /**
     * Creates a new Service Order
     *
     * @param number service order's number
     * @param clientName client's name
     * @param distance distance from SP facilities to client's home
     * @param serviceCategory service category
     * @param dateService service start date
     * @param timeService service start time
     * @param serviceType type of service
     * @param clientAddress client's postal address
     */
    public ServiceOrder(int number, String clientName, double distance, String serviceCategory, String serviceType, Date dateService, Time timeService, PostalAddress clientAddress) {
        validateField(number,clientName,distance,serviceCategory,serviceType);
        this.number = number;
        this.clientName = clientName;
        this.distance = distance;
        this.serviceCategory = serviceCategory;
        this.dateService = dateService;
        this.timeService = timeService;
        this.serviceType = serviceType;
        this.clientPostalAddress = clientAddress;
    }

    /**
     * Returns the service order's number
     *
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns client's name
     *
     * @return client's name
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Returns distance from SP facilities to client's home
     *
     * @return distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Returns service category
     *
     * @return service category
     */
    public String getServiceCategory() {
        return serviceCategory;
    }

    /**
     * Returns service start date
     *
     * @return service start date
     */
    public Date getDateService() {
        return dateService;
    }

    /**
     * Returns service start time
     *
     * @return service start time
     */
    public Time getTimeService() {
        return timeService;
    }

    /**
     * Returns type of service
     *
     * @return type of service
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Returns client's postal address
     *
     * @return client's postal address
     */
    public PostalAddress getClientPostalAddress() {
        return clientPostalAddress;
    }

    /**
     * @param number service order's number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @param clientName client's name to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @param distance distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @param serviceCategory service category to set
     */
    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    /**
     * @param dateService service start date to set
     */
    public void setDateService(Date dateService) {
        this.dateService = dateService;
    }

    /**
     * @param timeService service start time to set
     */
    public void setTimeService(Time timeService) {
        this.timeService = timeService;
    }

    /**
     * @param serviceType type of service to set
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * @param clientAddress client's postal address to set
     */
    public void setClientPostalAddress(PostalAddress clientAddress) {
        this.clientPostalAddress = clientAddress;
    }
    
    public static void validateField(int number, String clientName, double distance, String serviceCategory, String serviceType) {
        String number1 = Integer.toString(number);
        String distance1 = Double.toString(distance);
        if (Utils.containsLetter(number1)|| number1.isEmpty() || clientName == null || clientName.isEmpty() || Utils.containsLetter(distance1)|| distance1.isEmpty() || serviceCategory == null || serviceCategory.isEmpty() || serviceType == null || serviceType.isEmpty()) {
            throw new IllegalArgumentException("Argumment is invalid.");
        }
    }

    /**
     * Returns the Service Order information
     *
     * @return string containing the service order information
     */
    @Override
    public String toString() {
        return String.format("Number: %s%n Client's name: %s%n Distance: %.2f%n Service category: %s%n Type of service: %s%n Service start date: %s%n Service start time: %s%n  %s", this.number, this.clientName, this.distance, this.serviceCategory, this.serviceType, this.dateService, this.timeService, this.clientPostalAddress);
    }

    /**
     * Compares two objects
     *
     * @param obj another object
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
        ServiceOrder otherServiceOrder = (ServiceOrder) obj;
        return (otherServiceOrder.number == this.number && otherServiceOrder.clientName.equals(this.clientName) && otherServiceOrder.distance == this.distance && otherServiceOrder.serviceCategory.equals(this.serviceCategory) && otherServiceOrder.serviceType.equals(this.serviceType) && otherServiceOrder.dateService.equals(this.dateService) && otherServiceOrder.timeService.equals(this.timeService) && otherServiceOrder.clientPostalAddress.equals(this.clientPostalAddress));
    }
    
}
