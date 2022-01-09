/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.registry;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import lapr.project.autorizacao.FacadeAuthorization;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ServiceProvider;
import static lapr.project.utils.CompanyFinals.SERVICE_PROVIDER_ROLE;
import static lapr.project.utils.Utils.containsLetter;
import static lapr.project.utils.Utils.countDigit;
import static lapr.project.utils.Utils.createAlert;

/**
 *
 * @author Diogo Ribeiro
 */
public class ServiceProvidersRegistry {
    
            /**
     * list that has all Company´s Service Providers.
     */
    private List<ServiceProvider> serviceProviders;

    /**
     * Creates a list of Service Providers.
     */
    public ServiceProvidersRegistry() {
        serviceProviders = new ArrayList<>();
    }

    /**
     * Returns a list of Service Providers.
     *
     * @return serviceProviders
     */
    public List<ServiceProvider> getServiceProviders() {
        return serviceProviders;
    }
    public ServiceProvider newServiceProvider(String fullName, String shortName, List categories, PostalAddress postalAddress){
        return new ServiceProvider(fullName, shortName, categories, postalAddress);
    }
    public ServiceProvider newServiceProvider(String fullName, String shortName, PostalAddress postalAddress){
        return new ServiceProvider(fullName, shortName, postalAddress);
    }
    
    public boolean validateAditionalData(String IDNumber, String InstitutionalEmail) {
        if (IDNumber.equals("") || InstitutionalEmail.equals("")){
            createAlert(Alert.AlertType.ERROR, "Validation", "Dont leave blank boxes!").show();
            return false;
        }        
        if(!InstitutionalEmail.contains("@") || !InstitutionalEmail.contains(".")){
            createAlert(Alert.AlertType.ERROR, "Validation", "Insert a valid email!").show();
            return false;
        }
        if (containsLetter(IDNumber)) {
            createAlert(Alert.AlertType.ERROR, "Validation", "IDNumber only contains numbers!").show();
            return false;
        }
        return true;
    }
    
    public boolean validatePostalAddress(String address, String locality, String postCode){
        if (address.equals("") || locality.equals("")) {
            return false;
        }
        String postCodeAux = postCode;
        if (!postCodeAux.isEmpty()) {
            if (postCodeAux.contains("-")) {
                String[] postCodeParts = postCodeAux.split("-");
                if(!containsLetter(postCodeParts[0]) || !containsLetter(postCodeParts[1])){
                if (countDigit(Integer.parseInt(postCodeParts[0])) == 4 && countDigit(Integer.parseInt(postCodeParts[1])) <=3) {
                        return true;
                    } else {
                    createAlert(Alert.AlertType.ERROR, "Postal Address",
                            "Insert a valid Postal Code! (ex: XXXX-XXX)").show();
                        
                    }
                } else {
                    
                    createAlert(Alert.AlertType.ERROR, "Postal Address",
                                "Postal Code can't have letters!").show();
                }
            } else {
                createAlert(Alert.AlertType.ERROR, "Postal Address",
                        "Separate the 2 sections with a ''-''!").show();
            }
        } else {
            createAlert(Alert.AlertType.ERROR, "Postal Address",
                    "Dont leave blank spaces!").show();
        }
        return false;
    }

    public void setAditionalData(String IDNumber, String InstitutionalEmail, ServiceProvider sp) {
        sp.setIdNumber(Double.parseDouble(IDNumber));
        sp.setInstitutionalMail(InstitutionalEmail);
    }

    public boolean setGeographicalArea(GeographicalArea geoArea, ServiceProvider sp) {
        if(sp.addGeographicalArea(geoArea)){
            return true;
        }
        else{
            createAlert(Alert.AlertType.ERROR, "Geographical Area", "Error adding the geographical area!").show();
            return false;
        }
    }
    public boolean validatesServiceProvider(ServiceProvider sp) {
        if (!serviceProviders.contains(sp)) {
            return true;
        }
        return false;
    }
    public void addServiceProvider(ServiceProvider sp){
        serviceProviders.add(sp);
    }

    public boolean setCategory(Category cat, ServiceProvider sp) {
        if(sp.addCategory(cat)){
            return true;
        }
        else{
            createAlert(Alert.AlertType.ERROR, "Category", "Error adding the Category!").show();
            return false;
        }
    }
    
    /**
     * Returns the Service Provider by Email
     *
     * @param email
     * @return
     */
    public ServiceProvider getServiceProviderByEmail(String email) {
        for (ServiceProvider servpro : serviceProviders) {
            if (servpro != null && servpro.getInstitutionalMail() != null && servpro.getInstitutionalMail().equalsIgnoreCase(email)) {
                return servpro;
            }
        }
        return null;
    }
    public void registerServiceProvider(ServiceProvider sp, String pwd) {
        GPSD app = GPSD.getInstance();
        FacadeAuthorization authorization = app.getCompany().getAuthorization();
        authorization.registerUserWithRole(sp.getShortName(), sp.getInstitutionalMail(), pwd, SERVICE_PROVIDER_ROLE );
        serviceProviders.add(sp);
        

    }
}
