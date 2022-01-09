/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import lapr.project.utils.Date;

/**
 *
 * @author Vera Pinto
 */
public class ServiceOrder {
    private Affectation affectation;
    private int count =0;
    private int number;
    private Date issueDate;
    private String status;
    private TroubleShooting troubleShooting;
    
    /**
     * Creates a service order
     * @param affectation affectation
     */
     public ServiceOrder(Affectation affectation){
        this.affectation= affectation;
        this.issueDate= Date.actualDate();
        this.troubleShooting = new TroubleShooting();
        this.status=ServiceOrderStatus.NOTRATED.getStatus();
        this.number= count+1;
    }

    /**
     * Modifies status of service order
     * @param description 
     */
    public void setDescription(String status) {
        this.status = status;
    }
    
    /**
     * Returns the Affectation instance
     * @return 
     */
    
    public Affectation getAffectation () {
        return affectation;
    }
    
    /**
     * Returns issue date
     * @return issue date
     */
    
    public Date getIssueDate() {
        return issueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TroubleShooting getTroubleShooting() {
        return troubleShooting;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Service Order:%n%s", this.affectation); 
    }
 
    
    
    
    /**
     * Enum for schedule status
     */
    public enum ServiceOrderStatus{
        NOTRATED("ServiceOrder not rated yet"),WITHOUTPROBLEMS("Service Order completed without problems"),WITHPROBLEMS("Service Order completed with problems");
        
        private String status;

        private ServiceOrderStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
        
    }
}