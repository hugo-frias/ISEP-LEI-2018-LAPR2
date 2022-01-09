/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.LabelRate;
import lapr.project.gpsd.model.LabelRate.LabelRateEnum;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.utils.CompanyFinals;

/**
 *
 * @author Beatriz Ribeiro
 */
public class EvaluateServiceProviderController {

    private Company company;

    public EvaluateServiceProviderController() {
        this.company = GPSD.getInstance().getCompany();
    }

    public List<ServiceProvider> showServiceProviders() {
        List<ServiceProvider> serviceProviders = this.company.getServiceProvidersRegistry().getServiceProviders();
        if (!serviceProviders.isEmpty()) {
            return serviceProviders;
        }
        return null;
    }

    public double computeMeanForSP(ServiceProvider serviceProvider) {
        int[] arrayRate = getRateArray(serviceProvider);
        double sum = 0;
        for (int i = 0; i < arrayRate.length; i++) {
            sum = sum + i * arrayRate[i];
        }
        return sum/serviceProvider.getRatesList().size();
    }

    public double computeStandardDeviationForSP(double mean, ServiceProvider serviceProvider) {
        int[] arrayRate = getRateArray(serviceProvider);
        double variance = 0;
        int n =0;
        for (int i = 0; i < arrayRate.length; i++) {
            variance = variance + Math.pow(i - mean, 2) * arrayRate[i];
            
        }
        return Math.sqrt(variance/serviceProvider.getRatesList().size());
    }

    public double computeMeanForAllSP() {
        int[] arrayRate = getRateArrayOfAllSP();
        double sum = 0;
        for (int i = 0; i < arrayRate.length; i++) {
            sum = sum + i * arrayRate[i];
        }
        int nSP=0;
        for(ServiceProvider sp :company.getServiceProvidersRegistry().getServiceProviders()){
            nSP =nSP+sp.getRatesList().size();
        }
        return sum/nSP;
    }

    public double computeStandardDeviationForAllSP(double mean) {
        int[] arrayRate = getRateArrayOfAllSP();
        double variance = 0;
        for (int i = 0; i < arrayRate.length; i++) {
            variance = variance + Math.pow(i - mean, 2) * arrayRate[i];
        }
        int nSP=0;
        for(ServiceProvider sp :company.getServiceProvidersRegistry().getServiceProviders()){
            nSP =nSP+sp.getRatesList().size();
        }
        return Math.sqrt(variance/nSP);
    }

    public int[] computeHistogram(ServiceProvider serviceProvider) {
        return getRateArray(serviceProvider);
    }

    private int[] getRateArray(ServiceProvider serviceProvider) {
        List<Rate> ratesSP = serviceProvider.getRatesList();
        int[] rates = new int[6];
        for (int i = 0; i < rates.length; i++) {
            int count = 0;
            for (Rate rate : ratesSP) {
                if (rate.getRate() == i) {
                    count = count + 1;

                }
            }
            rates[i] = count;
        }
        return rates;
    }

    private int[] getRateArrayOfAllSP() {
        List<Rate> ratesAllSP = new ArrayList<Rate>();
        for (ServiceProvider sp : this.company.getServiceProvidersRegistry().getServiceProviders()) {
            for (Rate rate : sp.getRatesList()) {
                ratesAllSP.add(rate);
            }
        }
        int[] ratesAll = new int[6];
        for (int i = 0; i < ratesAll.length; i++) {
            int count = 0;
            for (Rate rate : ratesAllSP) {
                if (rate.getRate() == i) {
                    count = count + 1;

                }

            }
            ratesAll[i] = count;
        }
        return ratesAll;
    }

    public String computeLabelRate(double standardDeviationAllSP, double meanAllSP, double meanSP, ServiceProvider sp) {
        if (meanSP < meanAllSP - standardDeviationAllSP) {
            return LabelRateEnum.WORST.getStatus();
        } else if (meanAllSP - standardDeviationAllSP < meanSP && meanAllSP + standardDeviationAllSP > meanSP) {
            return LabelRateEnum.REGULAR.getStatus();
        } else if (meanAllSP + standardDeviationAllSP < meanSP) {
            return LabelRateEnum.OUTSTANDING.getStatus();
        }
        return LabelRateEnum.NORATE.getStatus();
    }
}
