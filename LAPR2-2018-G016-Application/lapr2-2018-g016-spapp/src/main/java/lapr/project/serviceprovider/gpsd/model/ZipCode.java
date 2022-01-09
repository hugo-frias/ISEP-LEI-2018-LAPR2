package lapr.project.serviceprovider.gpsd.model;

import java.io.Serializable;

/**
 *
 * @author André Novo
 * @author Diogo Ribeiro
 */

public class ZipCode implements Serializable {
    
    /**
     * attribute that represents zipCode
     */
    private String zipCode;

    /**
     * Creates zipCode's instances only with one parameter
     *
     * @param zipCode - zipCode
     */
    public ZipCode(String zipCode) {
        validateZipCode(zipCode);
        this.zipCode = zipCode;
    }

    /**
     * Returns zipCode
     *
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
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
        if ((aux[0].contains("[a-Z]")) || aux[1].contains("[a-Z]")) {
            throw new NumberFormatException();
        } else {
            if ((Integer.parseInt(aux[0]) <= 1000 || Integer.parseInt(aux[0]) >= 9999) && (Integer.parseInt(aux[0]) <= 100 || Integer.parseInt(aux[1]) >= 999)) {
                throw new IllegalArgumentException();
            }
        }
    }
    
    /**
     * Returns zipCode information
     *
     * @return String with zipCode's information
     */
    @Override
    public String toString() {
        return String.format("ZipCode: %s%n", zipCode);
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
        return (otherZipCode.zipCode.equals(this.zipCode));
    }
    
}
