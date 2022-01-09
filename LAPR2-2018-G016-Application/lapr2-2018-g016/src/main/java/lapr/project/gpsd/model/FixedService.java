package lapr.project.gpsd.model;

/**
 *
 * @author André Novo
 */
public class FixedService implements Service{

    /**
     * attribute that represents Fixed Service's id
     */
    private String id;

    /**
     *attribute that represents Fixed Service's brief description
     */
    private String briefDesc;

    /**
     attribute that represents Fixed Service's complete description
     */
    private String completeDesc;

    /**
     *attribute that represents Fixed Service's hourly cost
     */
    private double hourlyCost;
    
    /**
     * attribute that represents Fixed Service's period
     */
    
    private int preGivenPeriod;
    
    /**
     * attribute that represents Limited Service's category
     */
    private Category category;
    
    /**
     * attribute that represents Limited Service's type 
     */    
    private ServiceType serviceType;
    
    /**
     * Creates Fixed Service's instances
     * @param id - Fixed Service's id
     * @param briefDesc - Fixed Service's brief description
     * @param completeDesc - Fixed Service's complete description
     * @param hourlyCost - Fixed Service's hourly cost
     * @param category - Fixed Service's category
     * @param serviceType - Fixed Service's type
     */
    
    public FixedService(String id, String briefDesc, String completeDesc, double hourlyCost, Category category, ServiceType serviceType) {
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
     * Returns Fixed Service's id
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns Fixed Service's brief description
     * @return the brief description
     */
    public String getBriefDesc() {
        return briefDesc;
    }

    /**
     * Returns Fixed Service's complete description
     * @return the complete description
     */
    public String getCompleteDesc() {
        return completeDesc;
    }

    /**
     * Returns Fixed Service's hourly cost
     * @return the hourlyCost
     */
    public double getHourlyCost() {
        return hourlyCost;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
     
/**
     * Modifies Fixed Service's id 
     * @param preGivenPeriod - new Service's period
     */
    public void setPreGivenPeriod(int preGivenPeriod) {
        if(preGivenPeriod <=0){
            throw new IllegalArgumentException();
        }
        this.preGivenPeriod = preGivenPeriod;
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
     * Returs Fixed Sevice's information
     * @return String with Expandable Service's information
     */
    
    @Override
    public String toString() {
        return String.format("ID: %s%nBrief Description: %s%nComplete Description: %s%nHourly Cost: %.2f%nPeriod: %d%nCategory: %s",id, briefDesc, completeDesc, hourlyCost, preGivenPeriod, category);
    }
    
    /**
     * Checks if Service has additional attributes or not
     * @return true or false
     */
    @Override
    public boolean hasOtherAttributes() {
        return true;
    }

    /**
     * Returns other attributes
     * @return the other attribute
     */
    @Override
    public int getOtherAttributes() {
        return preGivenPeriod;
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
        FixedService otherService = (FixedService) obj;
        return (otherService.id.equals(this.id) && otherService.briefDesc.equals(this.briefDesc) && otherService.completeDesc.equals(this.completeDesc)
                && otherService.hourlyCost==this.hourlyCost && otherService.preGivenPeriod==this.preGivenPeriod && otherService.category.equals(category));
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void setAdditionalData(int data) {
        preGivenPeriod = data;
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
