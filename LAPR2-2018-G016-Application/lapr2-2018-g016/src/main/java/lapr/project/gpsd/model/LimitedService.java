
package lapr.project.gpsd.model;

/**
 *
 * @author André Novo
 */
public class LimitedService implements Service{
    
    /**
     * attribute that represents Limited Service's id
     */
    private String id;

    /**
     *attribute that represents Limited Service's brief description
     */
    private String briefDesc;

    /**
     attribute that represents Limited Service's complete description
     */
    private String completeDesc;

    /**
     *attribue that represents Limited Service's hourly cost
     */
    private double hourlyCost;
    
    /**
     * attribute that represents Limited Service's category
     */
    private Category category;
    
    /**
     * attribute that represents Limited Service's type 
     */    
    private ServiceType serviceType;
    
    /**
     * Creates Limited Service's instances
     * @param id - Limited Service's id
     * @param briefDesc - Limited Service's brief description
     * @param completeDesc - Limited Service's complete description
     * @param hourlyCost - Limited Service's hourly cost
     * @param category - Limited Service's category
     * @param serviceType - Limited Service's type
     */
    
    public LimitedService(String id, String briefDesc, String completeDesc, double hourlyCost, Category category, ServiceType serviceType) {
        if(id ==null || id.isEmpty() || briefDesc== null || briefDesc.isEmpty() || completeDesc == null || completeDesc.isEmpty()){
            throw new NullPointerException();
        }
        if(hourlyCost <=0){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.briefDesc = briefDesc;
        this.completeDesc = completeDesc;
        this.hourlyCost = hourlyCost;
        this.category=category;
        this.serviceType=serviceType;
    }

    /**
     * Returns Limited Service's id
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns Limited Service's brief description
     * @return the brief description
     */
    public String getBriefDesc() {
        return briefDesc;
    }

    /**
     * Returns Limited Service's complete description
     * @return the complete description
     */
    public String getCompleteDesc() {
        return completeDesc;
    }

    /**
     * Returns Limited Service's hourly cost
     * @return the hourlyCost
     */
    public double getHourlyCost() {
        return hourlyCost;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param briefDesc the briefDesc to set
     */
    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    /**
     * @param completeDesc the completeDesc to set
     */
    public void setCompleteDesc(String completeDesc) {
        this.completeDesc = completeDesc;
    }

    /**
     * @param hourlyCost the hourlyCost to set
     */
    public void setHourlyCost(double hourlyCost) {
        this.hourlyCost = hourlyCost;
    }
    
    /**
     * Returs Limited Sevice's information
     * @return String with Limited Service's information
     */
    
    @Override
    public String toString() {
        return String.format("ID: %s%nBrief Description: %s%nComplete Description: %s%nHourly Cost: %.2f%n Category: %s",id, briefDesc, completeDesc, hourlyCost, category);
    }

    /**
     * Checks if Service has additional attributes or not
     * @return true or false
     */
    @Override
    public boolean hasOtherAttributes() {
        return false;
    }

    /**
     * Returns other attributes
     * @return the other attribute
     */
    @Override
    public int getOtherAttributes() {
        return 0;
    }
    
     /**
     * Compares two objects
     * @param obj is an object
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
        LimitedService otherService = (LimitedService) obj;
        return (otherService.id.equals(this.id) && otherService.briefDesc.equals(this.briefDesc) && otherService.completeDesc.equals(this.completeDesc)
                && otherService.hourlyCost==this.hourlyCost && otherService.category.equals(category));
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void setAdditionalData(int data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Returns service category
     * @return category
     */
    @Override
    public Category getCategory() {
        return this.category;
    }
    
    /**
     * Returns cost for period
     * @return cost for period
     * @param period -service period
     */
    @Override
    public double getCostForPeriod(int period) {
        return this.hourlyCost * (period/60);
    }

    /**
     * Returns service type
     * @return service type
     */
    @Override
    public ServiceType getServiceType() {
        return this.serviceType;
    }
}
