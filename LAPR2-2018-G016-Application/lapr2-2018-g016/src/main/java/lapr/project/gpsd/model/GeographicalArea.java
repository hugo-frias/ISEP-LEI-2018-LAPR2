/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.GPSD.GPSD;

/**
 * Class of Geographical Area
 *
 * @author Beatriz Ribeiro
 */
public class GeographicalArea {

    /**
     * attribute that represents Geographical Area's name
     */
    private String name;

    /**
     * attribute that represents Geographical Area's travel cost
     */
    private double travelCost;

    /**
     * attribute that represents Geographical Area's operating radius
     */
    private double operatingRadius;

    /**
     * attribute that represents Geographical Area's zipCode
     */
    private ZipCode zipCode;
    
    /**
     * list of operates at instances 
     */
    private List<OperatesAt> operatesAt = new ArrayList<OperatesAt>();
    /**
     * Creates Geographical Area's instances
     *
     * @param name
     * @param travelCost
     * @param operatingRadius
     * @param zipCodeString
     */
    public GeographicalArea(String name, double travelCost, double operatingRadius, String zipCodeString)  {
        if((name==null)||name.isEmpty() || zipCodeString ==null||zipCodeString.isEmpty() || operatingRadius==0){
            throw new NullPointerException();
        }
        if(travelCost<=0 || operatingRadius <=0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.travelCost = travelCost;
        this.operatingRadius = operatingRadius;
        this.zipCode = new ZipCode(zipCodeString);
        this.operatesAt=GPSD.getInstance().getCompany().getExternalService().getsOperatesAt(zipCode, operatingRadius);
    }
    /**
     * Creates Geographical Area's instances
     */
    public GeographicalArea() {
        this.name = "no name";
        this.travelCost = 0;
        this.operatingRadius = 0;
        this.zipCode = null;
    }

    /**
     * Returns operates at list
     * @return list
     */
    public List<OperatesAt> getOperatesAt() {
        return operatesAt;
    }

    /**
     * Returns travel cost
     * @return travel 
     */
    public double getTravelCost() {
        return travelCost;
    }
    
    /**
     * Returns geographical area zipCode
     * @return zipCode
     */
    public ZipCode getZipCode() {    
        return zipCode;
    }

    /**
     * Returns Geographical Area's information
     *
     * @return String with Geographical Area's information
     */
    @Override
    public String toString() {
        return String.format("geographical Area: %s%nTravel cost: %.2f%nOperating Radius: %.0f%nZipCode: %s", name, travelCost, operatingRadius, zipCode);
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
        GeographicalArea otherGeographicalArea = (GeographicalArea) obj;
        return (otherGeographicalArea.name.equals(this.name) && otherGeographicalArea.travelCost == this.travelCost
                && otherGeographicalArea.operatingRadius == this.operatingRadius && otherGeographicalArea.zipCode.equals(this.zipCode));
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method to set the data of the geographical area
     * @param name name of the geographical area
     * @param travelCost cost of travel 
     * @param zc zip code
     * @param operatingRadius operating radius
     * @param operatesAtList operatesAt list
     */
    public void setData(String name, double travelCost, ZipCode zc, double operatingRadius, List<OperatesAt> operatesAtList) {
        this.name = name;
        this.travelCost = travelCost;
        this.zipCode = zc;
        this.operatingRadius = operatingRadius;
        this.operatesAt = operatesAtList;

    }


}
