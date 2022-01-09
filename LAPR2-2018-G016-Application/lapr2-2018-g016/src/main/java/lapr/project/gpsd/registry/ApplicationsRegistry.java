/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.registry;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.PostalAddress;

/**
 *
 * @author momog
 */
public class ApplicationsRegistry {
    private List<Application> applications;
    
    public ApplicationsRegistry(){
        applications = new ArrayList<>();
    }

    public List<Application> getApplications() {
        return applications;
    }

    public Application newApplication(String name, int nif, int phoneNumber, String email, PostalAddress addr1){
        return new Application(name, nif, email, phoneNumber, addr1);
    }
    public boolean validatesApplication(Application app) {
        if (!applications.contains(app)) {
            return true;
        }
        return false;
    }
    
    public void addApplication(Application app){
        applications.add(app);
    }
    public Application getApplicationByNif(int nif){
        for (Application a : applications){
            if(a.getNif() == nif){
                return a;
            }
        }
        return null;
    }
}
