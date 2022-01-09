package lapr.project.gpsd.model;

import java.util.List;
import model.collections.ZipCodeCollection;

/**
 *
 * @author André Novo
 */
public class ZipCode {

    /**
     * attribute that represents zipCode
     */
    private String zipCode;

    /**
     * attribute that represents zipCode's longitude
     */
    private double longitude;

    /**
     * attribute that represents zipCode's latitude
     */
    private double latitude;

    /**
     * Creates instances of ZipCode
     *
     * @param zipCode - zipCode
     * @param latitude - zipCode's latitude
     * @param longitude - zipCode's longitude
     */
    public ZipCode(String zipCode, double latitude, double longitude) {
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Copy Contructor
     *
     * @param zipCode - other ZipCode
     */
    public ZipCode(ZipCode zipCode) {
        this.zipCode = zipCode.getZipCode();
        this.latitude = zipCode.latitude;
        this.longitude = zipCode.longitude;
    }

    /**
     * Creates zipCode's instances only with one parameter
     *
     * @param zipCode - zipCode
     */
    public ZipCode(String zipCode) {
        validateZipCode(zipCode);
        this.zipCode = zipCode;
        this.latitude=this.getLatitudeByZipCode();
        this.longitude=this.getLongitudeByZipCode();
    }

    /**
     * Returns zipCode
     *
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    /**
     * Modify zipCode's latitude
     *
     * @param latitude - zipCode's latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Modify zipCode's longitude
     *
     * @param longitude - zipCode's longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Returns zipCode information
     *
     * @return String with zipCode's information
     */
    @Override
    public String toString() {
        return String.format("ZipCode: %s%n Latitude: %.2f%nLongitude: %.2f", zipCode, latitude, longitude);
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
        ZipCode otherZipCode = (ZipCode) obj;
        return ((otherZipCode.zipCode.equals(this.zipCode) && otherZipCode.latitude == this.latitude && otherZipCode.longitude == this.longitude));
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Validates the Zip Code
     *
     * @param zipCode zip code
     */
    public final void validateZipCode(String zipCode) {
        
        if (zipCode == null || zipCode.isEmpty()) {
            throw new IllegalArgumentException("The argument cannot be null or empty.");
        }
        String[] aux = zipCode.split("-");
        if (aux.length != 2) {
            throw new IllegalArgumentException();
        }
        if (!zipCode.matches("\\d{4}-\\d{3}") ||(aux[0].contains("[a-Z]")) || aux[1].contains("[a-Z]")) {
            throw new NumberFormatException();
        } else {
            if ((Integer.parseInt(aux[0]) <= 1000 || Integer.parseInt(aux[0]) >= 9999) && (Integer.parseInt(aux[1]) <= 0 || Integer.parseInt(aux[1]) >= 999)) {
                throw new IllegalArgumentException();
            }
        }
    }
    public double getLatitudeByZipCode() {
        //a linah de codigo mudar depois de ter a empresa
        List<ZipCode> zipCodesList = ZipCodeCollection.getInstance().getAllZipCodes();
        for (ZipCode zc : zipCodesList) {
            if (zc.getZipCode().equals(this.getZipCode())) {
                return zc.getLatitude();
            }
        }
        return 0;
    }

    public double getLongitudeByZipCode() {
        List<ZipCode> zipCodesList = ZipCodeCollection.getInstance().getAllZipCodes();
        for (ZipCode zc : zipCodesList) {
            if (zc.getZipCode().equals(this.getZipCode())) {
                return zc.getLongitude();
            }
        }
        return 0;
    }
}
