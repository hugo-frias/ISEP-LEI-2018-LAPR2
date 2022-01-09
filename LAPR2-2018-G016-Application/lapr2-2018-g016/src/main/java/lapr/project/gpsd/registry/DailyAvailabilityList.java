/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.registry;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Availability;
import lapr.project.utils.Date;
import lapr.project.utils.Time;

/**
 *
 * @author Diogo Ribeiro
 */
public class DailyAvailabilityList {
    
        /**
     * list that has all the availabilities of a service provider. 
     */
    private List<Availability> availabilities;

    /**
     * Creates a list of Availabilities.
     */
    public DailyAvailabilityList() {
        availabilities = new ArrayList<>();
    }

    /**
     * Returns a list of Availabilities.
     *
     * @return availabilities
     */
    public List<Availability> getAvailabilities() {
        return availabilities;
    }
    
        /**
     * Creates a new Availability.
     *
     * @param dateBeginning - date of beginning
     * @param hourBeginning - hour of beginning
     * @param dateEnding - date of ending
     * @param hourEnding - hour of ending
     * @return new Availability
     */
    public Availability newAvailabilityPeriod(Date dateBeginning, Time hourBeginning, Date dateEnding, Time hourEnding) {
        return new Availability(dateBeginning,hourBeginning,dateEnding,hourEnding);
    }

    /**
     * Verifies if the Availability already exists
     *
     * @param avail - Availability
     * @return true or false
     */
    public boolean validateAvailabilityPeriod(Availability avail) {
        for (int i = 0; i < availabilities.size(); i++) {
            if (availabilities.get(i).equals(avail)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Adds an Availability to the list.
     * 
     * @param avail
     */
    public void addAvailability(Availability avail) {
        availabilities.add(avail);
    }
}
