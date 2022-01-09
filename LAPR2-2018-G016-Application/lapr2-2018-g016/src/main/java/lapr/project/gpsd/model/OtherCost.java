/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

/**
 *
 * @author Beatriz Ribeiro
 */
public class OtherCost {
    /**
     * attribute that represents name of cost
     */
    private String name;
    
    /**
     * attribute that represents cost
     */
    
    private double value;

    /**
     * Creates intances of OtherCost
     * @param name - other cost name
     * @param value - value of cost
     */
    public OtherCost(String name, double value) {
        this.name = name;
        this.value = value;
    }

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
        OtherCost otherCost = (OtherCost) obj;
        return(this.name.equals(otherCost.name) && this.value == otherCost.value);
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
