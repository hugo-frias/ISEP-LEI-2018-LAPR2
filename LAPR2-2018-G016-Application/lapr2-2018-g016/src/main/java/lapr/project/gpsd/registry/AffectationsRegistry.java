/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.registry;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Affectation;
import lapr.project.gpsd.model.SchedulePreference;
import lapr.project.gpsd.model.SchedulePreference.SchedulePreferenceStatus;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.gpsd.model.ServiceRequest.ServiceRequestStatus;
import lapr.project.gpsd.model.ServiceRequestDescription;
import lapr.project.gpsd.model.ServiceRequestDescription.ServiceRequestDescriptionStatus;

/**
 *
 * @author Beatriz Ribeiro
 */
public class AffectationsRegistry {

    /**
     * list of affectations
     */
    private List<Affectation> affectationsList;

    /**
     * Creates instance od Affectation Registry
     */
    public AffectationsRegistry() {
        this.affectationsList = new ArrayList<Affectation>();
    }

    /**
     * Returns list of affectations
     *
     * @return list of affectations
     */
    public List<Affectation> getAffectationsList() {
        return affectationsList;
    }
    /**
     * Returns list of affectations of one service request
     * @param servReq service request 
     * @return list of service request 
     */
    public List<Affectation> getAffectationsByRequest(ServiceRequest servReq) {
        List<Affectation> affectationsByRequest = new ArrayList<Affectation>();
        for (Affectation affectation : affectationsList) {
            if (affectation.getServiceRequest().equals(servReq)) {
                affectationsByRequest.add(affectation);
            }
        }
        return affectationsByRequest;
    }
    /**
     * Finds affectation select in the list of affectations
     * @param affectationSelec affectation selected in the combo box 
     * @return return affectation in the list
     */
    public Affectation findAffecttation(Affectation affectationSelec) {
        for (Affectation affectation : this.affectationsList) {
            if (affectationSelec.equals(affectation)) {
                return affectation;
            }
        }
        return null;
    }
    /**
     * Returns list of affectations of one service provider
     * @param serviceProvider service provider
     * @return list of affectations
     */
    public List<Affectation> getAffectationsByServiceProvider(ServiceProvider serviceProvider) {
        List<Affectation> affectationsByServiceProvider = new ArrayList<Affectation>();
        for (Affectation affectation : affectationsList) {
            if (affectation.getServiceRequest().equals(serviceProvider)) {
                affectationsByServiceProvider.add(affectation);
            }
        }
        return affectationsByServiceProvider;
    }

}
