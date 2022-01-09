/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.util.List;
import lapr.project.gpsd.model.Availability;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.utils.Date;
import lapr.project.utils.Time;

/**
 *
 * @author Diogo Ribeiro
 */
public class IndicateAvailabilityController {
    
          /**
     * variable that represents the company.
     */
    private Company company;
    
    /**
     * variable that represents the service provider.
     */
    private ServiceProvider servpro;
    
    private Availability avail;

    /**
     * Empty constructor.
     */
    public IndicateAvailabilityController() {
        company = GPSD.getInstance().getCompany();
    }
    
    /**
     * Initializes the service provider.
     */
    public void indicateNewAvailability() {
        String email = GPSD.getInstance().getCurrentSession().getUserEmail();
        this.servpro = company.getServiceProvidersRegistry().getServiceProviderByEmail(email);
    }

    /**
     * Creates a new availability.
     * 
     * @param dateBeginning - date of beginning
     * @param hourBeginning - hour of beginning
     * @param dateEnding - date of ending
     * @param hourEnding - hour of ending
     * @return true or false
     */
    public boolean newAvailabilityPeriod(Date dateBeginning, Time hourBeginning, Date dateEnding, Time hourEnding) {
        avail = servpro.getAvailabilityList().newAvailabilityPeriod(dateBeginning,hourBeginning,dateEnding,hourEnding);
        return servpro.getAvailabilityList().validateAvailabilityPeriod(avail);
    }

    /**
     * Adds a new postal address associated to client.
     * @param availabilityPatterns list of availability patterns
     */
    public void addAvailabilityPatterns(List<String> availabilityPatterns) {
        avail.setPatternsList(availabilityPatterns);
    }
    
    /**
     * Adds an availability to service provider.
     */
    public void registerAvailabilityPeriod() {
        servpro.getAvailabilityList().addAvailability(avail);
    }
    
    /**
     * Returns the availability's information.
     * @return availability text
     */
    public String getAvailabilityString()
    {
        return avail.toString();
    }
    
    /**
     * Returns the availability's instance.
     * @return availability instance
     */
    public Availability getAvailability() {
        return avail;
    }
}
