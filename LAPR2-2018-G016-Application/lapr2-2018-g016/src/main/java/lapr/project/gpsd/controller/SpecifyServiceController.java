/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;


import lapr.project.gpsd.GPSD.GPSD;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceType;
/**
 *
 * @author Beatriz Ribeiro
 */
public class SpecifyServiceController {

    /**
     * attribute that represents company
     */
    private Company company;
    
    /**
     * attribute that represents service
     */
    private Service service;
    
    /**
     * Creates instances of SpecifyServiceController
     */
    public SpecifyServiceController() {
        this.company=GPSD.getInstance().getCompany();
    }
    
    /**
     * Returns list of Service Types
     * @return list of ServiceType
     */
    public List<ServiceType> getServiceTypes(){
        return this.company.getServiceTypesRegistry().getServiceTypes();
    }
    
    /**
     * Returns list of categories
     * @return list of categories
     */
    public List<Category> getCategories(){
        return this.company.getCategoriesRegistry().getCategories();
    }
    
    /**
     * Creates new service 
     * @param id - service's id
     * @param briefDesc - service's briefDesc
     * @param completeDesc - service's completeDesc
     * @param cost - service's cost
     * @param category - service's category
     * @param serviceType - service's serviceType
     * @return true or false if service has or not other attributes
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException 
     */
    public boolean newService (String id, String briefDesc, String completeDesc, double cost, Category category, ServiceType serviceType) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        this.service = serviceType.newService(id, briefDesc, completeDesc, cost, category);
        return this.service.hasOtherAttributes();
    }
    
    /**
     * Returns other attributes
     * @return period
     */
    public double getOtherAttributes(){
        return this.service.getOtherAttributes();
    }
    
    /**
     * sets additional data 
     * @param period - the additional data
     */
   public void setAdditionalData(int period){
       service.setAdditionalData(period);
   }
   
   /**
    * Regists the service
    * @return true or false
    */
   public boolean registsService(){
       return this.company.getServicesRegistry().registsService(service);
   }
}
