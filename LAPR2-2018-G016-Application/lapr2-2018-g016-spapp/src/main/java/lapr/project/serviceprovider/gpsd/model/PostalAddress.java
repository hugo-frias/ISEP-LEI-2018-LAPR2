package lapr.project.serviceprovider.gpsd.model;

import java.io.Serializable;

/**
 *
 * @author André Novo
 * @author Diogo Ribeiro
 */
public class PostalAddress implements Serializable {

    /**
     * attribute that represents Postal Adress's adress
     */
    private String address;

    /**
     * attribute that represents Postal Adress's adress
     */
    private String location;

    /**
     * attribute that represents Postal Adress's location
     */
    private ZipCode zipCode;

    /**
     * attribute that represents Postal Adress's adress by default
     */
    
    private static String ADRESS_BY_DEFAULT = "No place";

    /**
     * atribbutte that represents Postal Address´s location by default
     */
    private static String LOCAL_BY_DEFAULT = "No place";
    
    /**
     *  Creates Postal Adress's instances
     * @param address
     * @param zipCode
     * @param location 
     */
    
    public PostalAddress(String address, String location, ZipCode zipCode) {
        validatePostalAddress(address,location);
        this.address=address;
        this.location=location;
        this.zipCode=zipCode;
    }
    
 /**
  * Copy Contructor
  * @param postAdress - other Postal Adress 
  */
    public PostalAddress(PostalAddress postAdress){
        this.address=postAdress.address;
        this.location=postAdress.location;
        this.zipCode= postAdress.zipCode;
    }
    
    /**
     * Returns Postal Adress's adress
     * @return the local
     */
    public String getAddress() {
        return address;
    }

    /**
     * Postal Adress's location
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Postal Adress's zip Code
     * @return the zipCode
     */
    public ZipCode getZipCode() {
        return zipCode;
    }

    /**
     * 
     * @param address the local to set
     */
    public void setAdress(String address) {
        this.address = address;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }
    
    /**
     * Returns Postal Adress's information
     * @return String with Postal Adress's information 
     */
    
    @Override
    public String toString() {
        return String.format("Adress: %s%nLocation: %s%n %s", address, location, zipCode);
    }

    /**
     * Compares two objects
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
        PostalAddress otherPostalAdress = (PostalAddress) obj;
        return (otherPostalAdress.address.equals(this.address) && otherPostalAdress.location.equals(this.location) && otherPostalAdress.zipCode.equals(this.zipCode));
    }
    
    /**
     * Validates a Postal Address
     * 
     * @param address Postal Address´s address
     * @param location Postal Address´s location
     */
    
    public final void validatePostalAddress(String address, String location) {
        if(address == null || location == null || address.isEmpty() || location.isEmpty()) {
            throw new IllegalArgumentException("None of the arguments (adress or location) cannot be null or empty.");
        }
    }
}
