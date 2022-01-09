/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.util.List;
import javafx.scene.control.Alert;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ZipCode;
import lapr.project.gpsd.registry.ServiceProvidersRegistry;
import static lapr.project.utils.Utils.createAlert;

/**
 *
 * @author momog
 */
public class RegisterServiceProviderController {
    private final Company company;
    private ServiceProvider sp;
    private ServiceProvidersRegistry spr;
    
    public RegisterServiceProviderController() {
        company = GPSD.getInstance().getCompany();
        spr = company.getServiceProvidersRegistry();
        
    }

    public Application getApplicationByNif(int nif) {
        if(company.getApplicationsRegistry().getApplicationByNif(nif) != null ){
            return company.getApplicationsRegistry().getApplicationByNif(nif);
        }else{
            createAlert(Alert.AlertType.ERROR, "Application", "There is no Application with that NIF! Insert the data manually or try with another NIF!").show();
            
        }
        return null;
    }
    public void newServiceProvider(Application app){           
            String fullName = app.getName();
            String NameAux = app.getName();
            String shortName = getShortName(fullName);
            List<Category> categories = app.getCategoryList();
            PostalAddress postalAddress = app.getPostalAddress();             
            sp = spr.newServiceProvider(fullName, shortName, categories, postalAddress);
            
    }
    public boolean newServiceProvider(String fullName, String address, String postCode, String locality) {
        if (spr.validatePostalAddress(address, locality, postCode)){
            PostalAddress pa = new PostalAddress(address, new ZipCode(postCode), locality);
            String shortName = getShortName(fullName);
            sp = spr.newServiceProvider(fullName, shortName, pa);
            return true;
        }
        return false;
        
    }
    
    public String getShortName( String fullName) {
        String[] shortNameAux = fullName.split(" ");
        if(shortNameAux.length>2){
            return shortNameAux[0]+" "+shortNameAux[shortNameAux.length-1];
        } else{
            return fullName;
        }
    }

    public boolean setAditionalData(String IDNumber, String InstitutionalEmail) {
        if(spr.validateAditionalData(IDNumber, InstitutionalEmail)){
            spr.setAditionalData(IDNumber, InstitutionalEmail,sp);
            return true;
        }
        return false;
    }
    public boolean setGeographicalArea(GeographicalArea geoArea){
        if(spr.setGeographicalArea(geoArea,sp)){
            return true;
        }
        return false;
    }

    public ServiceProvider getSp() {
        return sp;
    }
    
    public String getRandomPassword(){
        return "teste";
    }
       

    public void registServiceProvider() {
        if(spr.validatesServiceProvider(sp)){
            spr.registerServiceProvider(sp, getRandomPassword());
        }
    }

    public boolean setCategory(Category cat) {
        if(spr.setCategory(cat,sp)){
            return true;
        }
        return false;        
    }
    public List<Category> getCategories(){
        return company.getCategoriesRegistry().getCategories();
    }
    public List<GeographicalArea> getGeoAreas(){
        return company.getGeographicalAreaResgitry().getGeographicalAreas();
    }

    
    
    
}
