package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.registry.DailyAvailabilityList;

/**
 * Class of Service Provider
 *
 * @author André Novo
 */
public class ServiceProvider {

    /**
     * attribute that represents Service Provider's idNumber
     */
    private double idNumber;

    /**
     * attribute that represents ServiceProvider's complete name
     */
    private String completeName;

    /**
     * attribute that represents ServiceProvider's short name
     */
    private String shortName;

    /**
     * attribute that represents ServiceProvider's institucional mail
     */
    private String institutionalMail;

    /**
     * attribute that represents ServiceProvider's postal address
     */
    private PostalAddress postalAddress;

    /**
     * attribute that represents ServiceProvider's availability list
     */
    private final DailyAvailabilityList availabilityList;
    
    /**
     * attribute that represents Service Provider's categories list
     */
    private List<Category> categoriesList;
    
    /**
     * attribute that represents Service Provider's geographicalAreas list
     */
    private List<GeographicalArea> geographicalAreasList;
    
    /**
     * attribute that represents Service Provider's rates list
     */
    private List<Rate> ratesList;
    
    /**
     * attriute that represents Service Provide's label rate
     */
    private LabelRate labelRate;

    /**
     * Creates Service Porvider's instances
     *
     * @param idNumber - Service Provider's idNumber
     * @param completeName - Service Provider's complete name
     * @param shortName - Service Provider's short name
     * @param institutionalMail - Service Provider's institucional mail
     * @param postalAddress - Service Provider's postal address
     * @param categoriesList- Service Provider's categories list
     */
    public ServiceProvider(double idNumber, String completeName, String shortName, String institutionalMail, PostalAddress postalAddress, List<Category> categoriesList) {
        if (idNumber <= 0) {
            throw new IllegalArgumentException();
        }
        if (completeName == null || completeName.isEmpty() || shortName == null || shortName.isEmpty() || institutionalMail == null || institutionalMail.isEmpty()) {
            throw new NullPointerException();
        }
        this.idNumber = idNumber;
        this.completeName = completeName;
        this.shortName = shortName;
        this.institutionalMail = institutionalMail;
        this.postalAddress = postalAddress;
        this.availabilityList = new DailyAvailabilityList();
        this.categoriesList = categoriesList;
        this.geographicalAreasList = new ArrayList<GeographicalArea>();
        this.ratesList= new ArrayList<Rate>();
        ratesList.add(new Rate());
        this.labelRate= new LabelRate();
    }
    
    public ServiceProvider(String completeName, String shortName, PostalAddress postalAddress) {
        if (completeName == null || completeName.isEmpty() || shortName == null || shortName.isEmpty()) {
            throw new NullPointerException();
        }
        this.idNumber = 0;
        this.completeName = completeName;
        this.shortName = shortName;
        this.institutionalMail = "";
        this.postalAddress = postalAddress;
        this.availabilityList = new DailyAvailabilityList();
        this.categoriesList = new ArrayList<>();
        this.geographicalAreasList = new ArrayList<>();
        this.ratesList=new ArrayList<Rate>();
        this.labelRate= new LabelRate();
        ratesList.add(new Rate());
    }
    public ServiceProvider(String completeName, String shortName, List<Category> categoriesList, PostalAddress postalAddress) {
        if (completeName == null || completeName.isEmpty() || shortName == null || shortName.isEmpty()) {
            throw new NullPointerException();
        }
        this.idNumber = 0;
        this.completeName = completeName;
        this.shortName = shortName;
        this.institutionalMail = "";
        this.postalAddress = postalAddress;
        this.availabilityList = new DailyAvailabilityList();
        this.categoriesList = categoriesList;
        this.geographicalAreasList = new ArrayList<GeographicalArea>();
        this.ratesList=new ArrayList<Rate>();
        this.labelRate= new LabelRate();
        ratesList.add(new Rate());
    }
    /**
     * Retuns Service Provider's id number.
     * @return id number
     */
    public double getIdNumber() {
        return idNumber;
    }

    /**
     * Returns Service Provider's complete name.
     * @return complete name
     */
    public String getCompleteName() {
        return completeName;
    }

    /**
     * Returns Service Provider's short name.
     * @return short name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Returns Service Provider's institutional mail.
     * @return institucional mail
     */
    public String getInstitutionalMail() {
        return institutionalMail;
    }

    /**
     * Returns Service Provider's postal address.
     * @return postal address
     */
    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    /**
     * Returns Service Provider's availability´s list
     * @return availability's list
     */
    public DailyAvailabilityList getAvailabilityList() {
        return availabilityList;
    }

    /**
     * Returns Service Provider's label rate
     * @return label rate
     */
    public LabelRate getLabelRate() {
        return labelRate;
    }

    /**
     * Returns Service Provider's rates list
     * @return rates list
     */
    public List<Rate> getRatesList() {
        return ratesList;
    }

    /**
     * @param idNumber the id number to set
     */
    public void setIdNumber(double idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @param completeName the complete name to set
     */
    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    /**
     * @param shortName the short name to set
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * @param institutionalMail the institucional mail to set
     */
    public void setInstitutionalMail(String institutionalMail) {
        this.institutionalMail = institutionalMail;
    }

    /**
     * @param postalAddress the postal address to set
     */
    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * Returns categories list of service provider
     * @return list of categories
     */
    public List<Category> getCategoriesList() {
        return categoriesList;
    }

    /**
     * Returns geographical areas list of service provider
     * @return list of geographical areas
     */
    public List<GeographicalArea> getGeographicalAreasList() {
        return geographicalAreasList;
    }
    
    public boolean addGeographicalArea(GeographicalArea geoArea){
       return this.geographicalAreasList.add(geoArea);
    }
    public boolean addCategory(Category cat) {
        return this.categoriesList.add(cat);
    }
    
    /**
     * Returns Service Provier's information
     *
     * @return String with Service Provier's information
     */
    @Override
    public String toString() {
        return String.format("Name: %s%nShortName: %s%nID Number: %.0f%nInstitucional Mail:%s%n PostalAddress: %s", completeName, shortName, idNumber, institutionalMail, postalAddress);
    }

    /**
     * Compares two objects
     *
     * @param obj - another object
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
        ServiceProvider otherServiceProvider = (ServiceProvider) obj;
        return (otherServiceProvider.idNumber == this.idNumber && otherServiceProvider.completeName.equals(this.completeName)
                && otherServiceProvider.shortName.equals(this.shortName) && otherServiceProvider.institutionalMail.equals(this.institutionalMail) && otherServiceProvider.postalAddress.equals(this.postalAddress));
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
