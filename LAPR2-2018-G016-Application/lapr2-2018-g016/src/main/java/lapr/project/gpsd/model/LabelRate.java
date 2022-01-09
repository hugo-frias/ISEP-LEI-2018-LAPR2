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
public class LabelRate {
    /**
     * attribute that represents Service Provider mean rate
     */
    private double mean;
    
    /**
     * private double standard deviation
     */
    private double standardDeviation;
    
    /**
     * attribute that represents Service Provider label rate
     */
    private String labelRate;
    
    /**
     * attribute that represents mean and deviation by default
     */
    private static final double MEAN_DEVIATION_BY_DEFAULT=0.0;
    
    /**
     * Creates Service Provider label instance
     * @param labelRate
     * @param mean
     * @param standardDeviation 
     */
    
    public LabelRate(String labelRate, Double mean, Double standardDeviation) {
        this.labelRate = labelRate;
        this.mean = mean;
        this.standardDeviation = standardDeviation;
    }
    
    /**
     * Creates Service Provider label rate by default
     */
    public LabelRate() {
        this.labelRate=LabelRateEnum.NORATE.getStatus();
        this.mean = MEAN_DEVIATION_BY_DEFAULT;
        this.standardDeviation= MEAN_DEVIATION_BY_DEFAULT;
    }
    
    
    /**
     * Return label rate
     * @return label rate
     */
    public String getLabelRate() {
        return labelRate;
    }

    /**
     * Returns standard deviation
     * @return standard deviation
     */
    public double getStandardDeviation() {
        return standardDeviation;
    }
    
    /**
     * Returns mean 
     * @return mean
     */
    public double getMean() {
        return mean;
    }

    /**
     * Modifies mean
     * @param mean new mean
     */
    public void setMean(double mean) {
        this.mean = mean;
    }

    /**
     * Modifies labe rate
     * @param labelRate new label rate
     */
    public void setLabelRate(String labelRate) {
        this.labelRate = labelRate;
    }

    /**
     * Modifies standardDeviation
     * @param standardDeviation new standard deviation
     */
    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }
    
    /**
     * Enum for schedule status
     */
    public enum LabelRateEnum{
        NORATE("No label rate available"),WORST("Worst Providers"),REGULAR("Regular Providers"),OUTSTANDING("Outstanding Providers");
        
        private String label;

        private LabelRateEnum(String label) {
            this.label = label;
        }

        public String getStatus() {
            return label;
        }
        
    }
}
