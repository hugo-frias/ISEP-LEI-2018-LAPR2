/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.gpsd.model.ServiceRequestDescription;
import helpers.AffectationRules;
import lapr.project.gpsd.model.Affectation;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ServiceRequest.ServiceRequestStatus;
import lapr.project.gpsd.model.ServiceRequestDescription.ServiceRequestDescriptionStatus;

/**
 * Class for FirstCome FirstServed Adapter
 *
 * @author Beatriz Ribeiro
 */
public class ScheduleAlgorithmFCFSAdapter extends TimerTask implements ScheduleAlgorithm {

    List<ServiceRequest> listSubmServReq;
    List<ServiceProvider> listSP;

    public ScheduleAlgorithmFCFSAdapter() {
        this.listSP = GPSD.getInstance().getCompany().getServiceProvidersRegistry().getServiceProviders();
        this.listSubmServReq = GPSD.getInstance().getCompany().getServiceRequestRegistry().getSubmittedServiceRequest();
    }

    /**
     * Returns the first Service Request of the list
     */
    @Override
    public void getServiceRequest() {

        if (!listSubmServReq.isEmpty() && !listSP.isEmpty()) {
            ServiceRequest servReq = listSubmServReq.get(0);
            affectServiceProviderToSubmittedServiceRequest(servReq, listSP);
            int count=0;
            for(ServiceRequestDescription servReqDesc : servReq.getServReqDescList()){
                if(servReqDesc.getServiceStatus().equals(ServiceRequestDescriptionStatus.AFFECTATED.getStatus())){
                    count++;
                }
            }
            if(count==servReq.getServReqDescList().size()){
                servReq.setServiceStatus(ServiceRequestStatus.AFFECTATED.getStatus());      
            }
            listSubmServReq.remove(0);
            listSubmServReq.add(servReq);
        }
        
    }

    @Override
    public void run() {
        this.getServiceRequest();

    }

    private void affectServiceProviderToSubmittedServiceRequest(ServiceRequest servReq, List<ServiceProvider> listSP) {

        List<ServiceProvider> listSPAffected = new ArrayList<ServiceProvider>(listSP);

        int countSch = 0;
        for (ServiceRequestDescription servReqDesc : servReq.getServReqDescList()) {
            if (servReqDesc.getServiceStatus().equals(ServiceRequestDescriptionStatus.SUBMITTED.getStatus())) {
                listSPAffected = AffectationRules.affectByCategory(listSPAffected, servReqDesc);
                if (!listSPAffected.isEmpty()) {
                    do {
                        listSPAffected = AffectationRules.affectBySchedule(listSPAffected, servReq.getSchPrefList().get(countSch));
                        countSch = countSch + 1;
                    } while (listSPAffected.isEmpty() && servReq.getSchPrefList().size() - 1 >= countSch);
                    if (!listSPAffected.isEmpty()) {
                        listSPAffected = AffectationRules.affectByGeographicalArea(listSPAffected, servReq.getPostalAddress());
                        if (listSPAffected.size() >= 1) {
                            listSPAffected = AffectationRules.affectByRate(listSPAffected);
                            if (listSPAffected.size() >= 1) {
                                listSPAffected = AffectationRules.affectByDistance(listSPAffected, servReq.getPostalAddress());
                                if (listSPAffected.size() >= 1) {
                                    listSPAffected = AffectationRules.affectByAlphabeticOrder(listSPAffected);
                                }
                            }
                        }
                    }
                }
                if (!listSPAffected.isEmpty()) {
                    Affectation affectation = new Affectation(listSPAffected.get(0), servReqDesc, servReq, servReq.getSchPrefList().get(countSch-1));
                    GPSD.getInstance().getCompany().getAffectationsRegistry().getAffectationsList().add(affectation);
                    System.out.println(affectation);
                    Company c=GPSD.getInstance().getCompany();
                } else {
                    System.out.println("No affectation");
                    System.out.println(servReq.toString());
                }
            }
        }

    }

}

