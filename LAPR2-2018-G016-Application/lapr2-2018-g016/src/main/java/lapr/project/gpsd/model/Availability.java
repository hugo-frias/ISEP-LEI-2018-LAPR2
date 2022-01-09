/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.utils.Date;
import lapr.project.utils.Time;

/**
 *
 * @author Diogo Ribeiro
 */
public class Availability {
    
     /**
     * attribute that represents the Availability's date of beginning.
     */
    private Date dateBeginning;

    /**
     * attribute that represents the Availability's hour of beginning.
     */
    private Time hourBeginning;

    /**
     * attribute that represents the Availability's date of ending.
     */
    private Date dateEnding;

    /**
     * attribute that represents the Availability's hour of ending.
     */
    private Time hourEnding;

    /**
     * attribute that represents the Availability's patterns list.
     */
    private List<String> patternsList;

    /**
     * Creates Availability instances.
     *
     * @param dateBeginning availability's date of beginning
     * @param hourBeginning availability's hour of beginning
     * @param dateEnding availability's date of ending
     * @param hourEnding availability's hour of ending
     */
    public Availability(Date dateBeginning, Time hourBeginning, Date dateEnding, Time hourEnding) {
        if (!validateDate(dateBeginning, dateEnding)|| !validateTime(hourBeginning, hourEnding)) {
            throw new IllegalArgumentException();
        }
        this.dateBeginning = dateBeginning;
        this.hourBeginning = hourBeginning;
        this.dateEnding = dateEnding;
        this.hourEnding = hourEnding;
        patternsList = new ArrayList<>();
    }

    /**
     * Empty constructor.
     */
    public Availability() {
        this.dateBeginning = new Date();
        this.hourBeginning = new Time();
        this.dateEnding = new Date();
        this.hourEnding = new Time();
        patternsList = new ArrayList<>();
    }

    /**
     * Returns Availability's date of beginning.
     *
     * @return date of beginning
     */
    public Date getDateBeginning() {
        return dateBeginning;
    }

    /**
     * Returns Availability's hour of beginning.
     *
     * @return hour of beginning
     */
    public Time getHourBeginning() {
        return hourBeginning;
    }

    /**
     * Returns Availability's date of ending.
     *
     * @return date of ending
     */
    public Date getDateEnding() {
        return dateEnding;
    }

    /**
     * Returns Availability's hour of ending.
     *
     * @return hour of ending
     */
    public Time getHourEnding() {
        return hourEnding;
    }

    /**
     * Returns Availability's patterns list.
     *
     * @return patterns list
     */
    public List<String> getPatternsList() {
        return patternsList;
    }

    /**
     * @param dateBeginning the date of beginning to set
     */
    public void setDateBeginning(Date dateBeginning) {
        this.dateBeginning = dateBeginning;
    }

    /**
     * @param hourBeginning the hour of beginning to set
     */
    public void setHourBeginning(Time hourBeginning) {
        this.hourBeginning = hourBeginning;
    }

    /**
     * @param dateEnding the date of ending to set
     */
    public void setDateEnding(Date dateEnding) {
        this.dateEnding = dateEnding;
    }

    /**
     * @param hourEnding the hour of ending to set
     */
    public void setHourEnding(Time hourEnding) {
        this.hourEnding = hourEnding;
    }

    /**
     * @param patternsList the patterns's list to set
     */
    public void setPatternsList(List<String> patternsList) {
        this.patternsList = patternsList;
    }

    /**
     * Returns Availability's information.
     *
     * @return String with Availability's information
     */
    @Override
    public String toString() {
        return String.format("Date of beginning: %s%nHour of beginning: %s%nDate of ending: %s%nHour of ending: %s", dateBeginning, hourBeginning, dateEnding, hourEnding);
    }

    /**
     * Compares two availabilities
     * @param obj other object
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
        Availability otherAva= (Availability) obj;
        return (this.dateBeginning.equals(otherAva.dateBeginning) && this.dateEnding.equals(otherAva.dateEnding)
                && this.hourBeginning.equals(otherAva.hourBeginning) && this.hourEnding.equals(otherAva.hourEnding));
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * Adds a pattern to Availability.
     * @param pattern 
     */
    public void addPattern(String pattern) {
        patternsList.add(pattern);
    }

    /**
     * Validates Availability´s dates.
     * @param dBeginning availability's date of beginning
     * @param dEnding availability's date of ending
     * @return true or false
     */
    public boolean validateDate(Date dBeginning, Date dEnding) {
        if (dBeginning.weekDay().equals(Date.WeekDay.SUNDAY.toString()) || dEnding.weekDay().equals(Date.WeekDay.SUNDAY.toString())) {
            return false;
        }
        return true;
    }

    /**
     * Validates Availability's hours.
     * @param hBeginning availability's hour of beginning
     * @param hEnding availability's hour of ending
     * @return true or false
     */
    public final boolean validateTime(Time hBeginning, Time hEnding) {
        if (hBeginning.getHours() > 23 || hBeginning.getHours() < 6 || hEnding.getHours() > 23 || hEnding.getHours() < 6) {
            return false;
        }
        return !(hBeginning.getMinutes() > 59 || hBeginning.getMinutes() < 0 || hEnding.getMinutes() > 59 || hEnding.getMinutes() < 0);
    }
    
}
