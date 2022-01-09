
package lapr.project.gpsd.model;

/**
 * Service's Interface
 * @author André Novo
 */

public interface Service {
    
    /**
     * Checks if Service has additional attributes or not
     * @return true or false
     */
    boolean hasOtherAttributes();
    
    /**
     * Returns other attributes
     * @return the other attribute
     */
    int getOtherAttributes(); 
    
    /**
     * SetsAdditionalData
     * @param data - new data
     */
    void setAdditionalData(int data);
    
    /**
     * Returns category service
     * @return category
     */
    Category getCategory();
    
    /**
     * Returns cost for period
     * @param period - service period
     * @return cost for period
     */
    double getCostForPeriod( int period);
    
    /**
     * Returns service type id
     * @return service type
     */
    ServiceType getServiceType();
}
