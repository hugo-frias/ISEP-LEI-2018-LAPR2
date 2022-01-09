/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.utils.Date;
import lapr.project.utils.Time;

/**
 *
 * @author Beatriz Ribeiro
 */
public class MakeServiceRequestController {

    private ServiceRequest serviceRequest;
    private Company company;
    private Client cli;

    public MakeServiceRequestController() {
        this.company = GPSD.getInstance().getCompany();
    }

    public List<PostalAddress> newServiceRequest() {
        List<PostalAddress> postalAddressesList = new ArrayList<PostalAddress>();
        String email = GPSD.getInstance().getCurrentSession().getUserEmail();
        if (email != null ) {
            this.cli = this.company.getClientsRegistry().getClientByEmail(email);
        }
        if (cli != null) {
            postalAddressesList= cli.getPostalAddressList();
            if (postalAddressesList != null) {
                return postalAddressesList;
            }
        }
        return null;
    }

    public void setEndPostal(PostalAddress postalAddress) {
        this.serviceRequest=this.company.getServiceRequestRegistry().newServiceRequest(cli, postalAddress);
    }
    
    public List<Category> getCategories(){
        return this.company.getCategoriesRegistry().getCategories();
    }
    
    public List<Service> getServicesOfCategory(Category cat){
        return this.company.getServicesRegistry().getServicesOfCategory(cat);
    }
    
    public boolean addToServiceRequest(Service serv, String desc, int period){
        return this.serviceRequest.addToServiceRequest(serv, desc, period);
    }
    
    public boolean addSchedule(Date date, Time hour){
        return this.serviceRequest.addSchedule(date, hour);
    }
    
    public void computesCost(){
        this.serviceRequest.computesCost();
    }
    
    public boolean registsServicerequest(){
        return(this.company.getServiceRequestRegistry().registsServiceRequest(serviceRequest));
    }

    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }
    
    
}
