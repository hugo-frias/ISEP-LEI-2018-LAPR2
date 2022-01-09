/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Affectation;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.SchedulePreference;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.gpsd.model.ServiceRequestDescription;

/**
 *
 * @author Vera Pinto
 */
public class DecideOnAffectationsController {

    private Company company;

    public DecideOnAffectationsController() {
        this.company = GPSD.getInstance().getCompany();
    }

    public List<ServiceRequest> getServiceRequests(Client client) {
        return company.getServiceRequestRegistry().getAffectedServiceRequestByCient(client);
    }

    public List<Affectation> getAffectationsByServiceRequest(ServiceRequest serviceRequest) {
        return company.getAffectationsRegistry().getAffectationsByRequest(serviceRequest);
    }

    public void newOrder(Affectation affectation) {

        ServiceOrder serviceOrder = company.getServiceOrdersRegistry().newServiceOrder(affectation);
        this.company.getServiceOrdersRegistry().getServiceOrders().add(serviceOrder);

    }

    public void rejectAffectation(Affectation affectation) {
        Affectation affec = GPSD.getInstance().getCompany().getAffectationsRegistry().findAffecttation(affectation);
        affec.getServiceRequest().setServiceStatus(ServiceRequest.ServiceRequestStatus.SUBMITTED.getStatus());
        affec.getSchedulePreference().setScheduleStatus(SchedulePreference.SchedulePreferenceStatus.REJECTED.getStatus());
        affec.getServiceRequestDescription().setServiceStatus(ServiceRequestDescription.ServiceRequestDescriptionStatus.SUBMITTED.getStatus());
        GPSD.getInstance().getCompany().getAffectationsRegistry().getAffectationsList().remove(affec);
    }
}
