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
public class Rate {
    /**
     * attribute that represents service rate
     */
    private int rate;
    
   
    /**
     * Creates rate with value by default
     */
    public Rate() {
        this.rate=Integer.parseInt(RateEnum.RATE_3.getStatus());
    }

    /**
     * Creates rate instances
     * @param rate - rate service
     */
    public Rate(int rate) {
        this.rate = rate;
    }

    
    /**
     * Modifies rate
     * @param rate - new rate value
     */
    public void setRate(int rate) {
        this.rate = rate;
    }
    
    /**
     * Return rate
     * @return rate
     */
    
    public double getRate() {
        return rate;
    }
    
    /**
     * Enum for schedule status
     */
    public enum RateEnum{
        RATE_0("0"),RATE_1("1"),RATE_2("2"),RATE_3("3"),RATE_4("4"),RATE_5("5");
        
        private String label;

        private RateEnum(String label) {
            this.label = label;
        }

        public String getStatus() {
            return label;
        }
        
    }
}
