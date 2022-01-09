
package lapr.project.gpsd.model;

import lapr.project.utils.*;
/**
 *
 * @author André Novo
 * @author Beatriz Ribeiro
 */

public class PostalAddress {
    
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
     * atributte that represents Postal Adress's zipCode
     */
    
    private static String ADRESS_BY_DEFAULT = "No place";
    
    /**
     * atribbutte that represents Postal Address´s location
     */
    
    private static String LOCAL_BY_DEFAULT = "No place";
    
    /**
     * Creates Postal Adress's instances
     * @param address - Postal Adress' adress
     * @param location - Postal Adress's location
     * @param zipCode - Postal Adress's zipCode
     */
    
    public PostalAddress(String address, ZipCode zipCode, String location) {
        Utils.validadeTwoStringFields(address, location);
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
        this.zipCode=new ZipCode(postAdress.zipCode);
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
        return String.format("Adress: %s%n Location: %s%n ZipCode: %s", address, location, zipCode);
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
	* @return
	*/
	
    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
}