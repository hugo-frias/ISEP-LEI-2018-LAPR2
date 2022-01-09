/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import lapr.project.utils.Date;
import lapr.project.utils.Time;

/**
 *
 * @author Beatriz Ribeiro
 */
public class SchedulePreference {
    /**
     * schedule date
     */
    private Date date;
    
    /**
     * schedule hour
     */
    private Time hour;

    /**
     * order of schedule
     */
    private int order;
    
     /**
     * attribute that represents schedule status
     */
    
    private String scheduleStatus;
    
    /**
     * Cretaes Schedule Preference instances 
     * @param date - schedule date
     * @param hour - schedule hour
     */
    public SchedulePreference(Date date, Time hour, int order) {
        if(!validateDate(date) || !validateTime(hour)){
            throw new IllegalArgumentException();
        }
        this.date = date;
        this.hour = hour;
        this.order=order;
        this.scheduleStatus= SchedulePreferenceStatus.SUBMITTED.getStatus();
    }

    /**
     * Returns date 
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Returns hour
     * @return 
     */
    public Time getHour() {
        return hour;
    }

    /**
     * Returns schedule order
     * @return order
     */
    public int getOrder() {
        return order;
    }

    
    /**
     * Modiefies Schedule Status
     * @param status new status
     */
    public void setScheduleStatus(String status) {
        this.scheduleStatus = status;
    }

    /**
     * Returns schedule status
     * @return
     */
    public String getScheduleStatus() {
        return scheduleStatus;
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
        SchedulePreference otherSchePref = (SchedulePreference) obj;
        return (this.date.equals(otherSchePref.date) || this.hour.equals(otherSchePref.hour));
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
   
     /**
     * Enum for schedule status
     */
    public enum SchedulePreferenceStatus{
        AFFECTATED("Affectated schedule"),REJECTED("Rejected schedule"),SUBMITTED("Submitted schedule");
        
        private String status;

        private SchedulePreferenceStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
    
    public final boolean validateDate(Date dBeginning) {
       return (!dBeginning.weekDay().equals(Date.WeekDay.SUNDAY.toString()));
    }
    
     public final boolean validateTime(Time hBeginning) {
        if (hBeginning.getHours() > 23 || hBeginning.getHours() < 6 ) {
            return false;
        }
        return !(hBeginning.getMinutes() > 59 || hBeginning.getMinutes() < 0 );
    }
}
