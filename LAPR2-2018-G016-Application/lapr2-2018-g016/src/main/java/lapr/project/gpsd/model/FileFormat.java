/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import lapr.project.utils.Utils;

/**
 *
 * @author Diogo Ribeiro
 */
public class FileFormat {

    /**
     * atributte that represents File Format's name
     */
    private String name;

    /**
     * atributte that represents Exporter's class
     */
    private String exporterClass;

    /**
     * Creates File Format's instances
     *
     * @param name - File Format's name
     * @param exporterClass - Exporter's class
     */
    public FileFormat(String name, String exporterClass) {
        Utils.validadeTwoStringFields(name, exporterClass);
        this.name = name;
        this.exporterClass = exporterClass;
    }

    /**
     * Returns information about service type
     *
     * @return String with information
     */
    @Override
    public String toString() {
        return String.format("File format type: %s", name);
    }

    /**
     * Creates any Importer's instances by Reflection
     *
     * @param serviceOrders
     * @param nameFile - name of file
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.NoSuchMethodException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     */
    public void exportServiceOrders(List<ServiceOrder> serviceOrders, String nameFile) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> oClass = Class.forName(this.exporterClass);
        Object obj = oClass.newInstance();
        Method exportFile = oClass.getDeclaredMethod("exportFile", List.class,String.class);
        try{
        exportFile.invoke(obj, serviceOrders, nameFile);
        }catch(Exception e){
            System.out.println(e.getCause());
        }
    }

}
