/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.registry;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Service;

/**
 * Class of Services Registry
 *
 * @author Beatriz Ribeiro
 */
public class ServicesRegistry {

    /**
     * list that has all Company's Services
     */
    private List<Service> services;

    /**
     * Creates a list of Services
     */
    public ServicesRegistry() {
        services = new ArrayList<Service>();
    }

    /**
     * Returns a list of Services
     *
     * @return services
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * Returns list of services of category
     *
     * @param cat - category
     * @return list of categories
     */
    public List<Service> getServicesOfCategory(Category cat) {
        List<Service> servOfCat = new ArrayList<Service>();
        for (Service serv : this.services) {
            if (serv.getCategory().equals(cat)) {
                servOfCat.add(serv);
            }
        }
        if (servOfCat != null) {
            return servOfCat;
        } else {
            return null;
        }
    }

    /**
     * Regists service
     *
     * @param service - service
     * @return true or false
     */
    public boolean registsService(Service service) {
        if (validatesService(service)) {
            return addService(service);
        }
        return false;
    }

    /**
     * Validates the service
     *
     * @param service - service
     * @return true or false
     */
    private boolean validatesService(Service service) {
        if (services.contains(service)) {
            return false;
        }
        return true;
    }

    /**
     * Adds service to list
     *
     * @param service - service
     * @return true or false
     */
    private boolean addService(Service service) {
        return services.add(service);
    }

}
