/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.util.List;
import lapr.project.gpsd.model.Affectation;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;

/**
 *
 * @author Vera Pinto
 */
public class ReportEndOfServiceController {
     private Company company;
        public ReportEndOfServiceController() {
        this.company = GPSD.getInstance().getCompany();
    }
    
    public List<Affectation> getAffectationsByServiceProvider(ServiceProvider serviceProvider){
        return company.getAffectationsRegistry().getAffectationsByServiceProvider(serviceProvider);
    }

    public void changeToFinished(ServiceOrder serviceOrder) {
        serviceOrder.setStatus(ServiceOrder.ServiceOrderStatus.WITHOUTPROBLEMS.getStatus());
    }

    public void addIssue(ServiceOrder serviceOrder, String problem, String strategy) {
        serviceOrder.getTroubleShooting().setProblem(problem);
        serviceOrder.getTroubleShooting().setStrategy(strategy);
        serviceOrder.setStatus(ServiceOrder.ServiceOrderStatus.WITHPROBLEMS.getStatus());
                
    }

    public List<ServiceOrder> getServiceOrders(ServiceProvider servProvider) {
      return GPSD.getInstance().getCompany().getServiceOrdersRegistry().getServiceOrders();
    }
    
}
