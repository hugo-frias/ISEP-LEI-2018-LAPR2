/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

public class OperatesAt {

    private double distance;
    private ZipCode zc;

    public OperatesAt(ZipCode zipC, double distance) {
        this.distance = distance;
        this.zc = zipC;
    }

    /**
     * returns zipCode
     * @return zipCode
     */
    public ZipCode getZc() {
        return zc;
    }

    
    /**
     * Compares two OperatesAt
     * @param obj - other OperatesAt object
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } OperatesAt otherOperatesAt = (OperatesAt) obj;
        return (this.distance==otherOperatesAt.distance && this.zc.equals(otherOperatesAt.zc));
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
