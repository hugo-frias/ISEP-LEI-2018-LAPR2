/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.registry;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Affectation;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;

/**
 *
 * @author Vera Pinto
 */
public class ServiceOrdersRegistry {
     
    /**
     * list of service orders
     */
    private List<ServiceOrder> serviceOrders;
   

    /**
     * Create instances of service orders registry 
     */
    public ServiceOrdersRegistry() {
        this.serviceOrders= new ArrayList<ServiceOrder>();
    }
    
    /**
     * Creates a new Service Order
     * @param affectation - affectation
     * @return affectation
     */
    public ServiceOrder newServiceOrder(Affectation affectation){
       return new ServiceOrder(affectation);     
    }

    /**
     * Returns list of service orders
     * @return list of service orders
     */
    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }
    
    /**
     * Returns list of service orders by client
     * @param cli the client instance
     * @return list of service orders by client
     */
    
    public List<ServiceOrder> getServiceOrdersByClient(Client cli) {
        List<ServiceOrder> lstAux = new ArrayList<>();
        for(ServiceOrder sO : serviceOrders) {
            if(sO!= null && cli != null && sO.getAffectation().getServiceRequest().getClient().equals(cli)) {
                lstAux.add(sO);
            }
        }
        return lstAux;
        
    }
    
    public List<ServiceOrder> getServiceOrdersByServiceProvider(ServiceProvider servProvider){
        List<ServiceOrder> servOrdSP = new ArrayList<ServiceOrder>();
        for (ServiceOrder sO : this.getServiceOrders()) {
            if (sO != null && sO.getAffectation().getServiceProvider() != null && sO.getAffectation().getServiceProvider().equals(servProvider)) {
                servOrdSP.add(sO);
            }
        }
        return servOrdSP;
    }
    
}
