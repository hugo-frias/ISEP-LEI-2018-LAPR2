/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Class of Service's types
 *
 * @author Beatriz Ribeiro
 */
public class ServiceType {

    /**
     * atributte that represents Service Type's name
     */
    private String name;

    /**
     * atributte that represents Service Type's class
     */
    private String serviceClass;

    /**
     * Creates Service Types's instances
     *
     * @param name - Service Type's name
     * @param serviceClass - Service Type's class
     */
    public ServiceType(String name, String serviceClass) {
        this.name = name;
        this.serviceClass = serviceClass;
    }

    /**
     * Creates any Service's instances by Reflection
     *
     * @param id - Service's id
     * @param briefDesc - Service's brief description
     * @param completeDesc - Service's complete description
     * @param hourlyCost - Service's hourly cost
     * @param category - Service's category
     * @return Service - created Service
     */
    public Service newService(String id, String briefDesc, String completeDesc, double hourlyCost, Category category) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> oClass = Class.forName(this.serviceClass);
        Class[] argsClasses = new Class[]{String.class, String.class, String.class,
            double.class, Category.class, ServiceType.class};
        Constructor constructor = oClass.getConstructor(argsClasses);
        Object[] argsValues = new Object[]{id, briefDesc, completeDesc, hourlyCost, category,this};
        Service service = (Service) constructor.newInstance(argsValues);
        return service;
    }

    /**
     * Returns information about service type
     * @return String with information
     */
    @Override
    public String toString() {
        return String.format("Tipo Serviço: %s",name);
    }
    
    
}
