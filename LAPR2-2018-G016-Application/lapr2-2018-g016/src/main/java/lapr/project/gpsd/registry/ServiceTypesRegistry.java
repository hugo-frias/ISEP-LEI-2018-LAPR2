/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.registry;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import lapr.project.gpsd.model.ServiceType;
import java.util.List;
import java.util.Properties;
import lapr.project.utils.CompanyFinals;

/**
 *
 * @author Beatriz Ribeiro
 */
public class ServiceTypesRegistry {

    /**
     * list that has all Company's Service's Types
     */
    private List<ServiceType> serviceTypes;

    /**
     * Creates a list of Service's Types
     */
    public ServiceTypesRegistry() {
        serviceTypes = createSupportedServiceTypes(getProperties());
    }

    /**
     * Returns a list of service types
     *
     * @return service types
     */
    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    /**
     * Creates supported ServiceTypes
     *
     * @param props file of properties
     * @return list of supported service types
     */
    public List<ServiceType> createSupportedServiceTypes(Properties props) {

        List<ServiceType> serviceTypesList = new ArrayList<ServiceType>();
        String qntTypes = props.getProperty("Company.QuantityOfSupportedServiceTypes");
        int qnt = Integer.parseInt(qntTypes);
        for (int i = 1; i <= qnt; i++) {
            String desc = props.getProperty(
                    "Company.ServiceType." + i + ".Name").trim();
            String serviceClass = props.getProperty(
                    "Company.ServiceType." + i + ".Class").trim();
            ServiceType serviceType = new ServiceType(desc, serviceClass);
            serviceTypesList.add(serviceType);
        }
        return serviceTypesList;
    }

    private Properties getProperties() {
        Properties props = new Properties();
        // Lê as propriedades e valores definidas 
        try {
            InputStream in = new FileInputStream(CompanyFinals.FILE_PARAM);
            props.load(in);
            in.close();
        } catch (Exception ex) {

        }
        return props;
    }
}
