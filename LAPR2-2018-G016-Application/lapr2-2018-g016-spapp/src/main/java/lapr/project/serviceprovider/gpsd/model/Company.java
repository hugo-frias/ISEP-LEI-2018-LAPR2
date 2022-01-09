package lapr.project.serviceprovider.gpsd.model;

import lapr.project.serviceprovider.gpsd.registry.FileFormatsRegistry;
import lapr.project.serviceprovider.gpsd.registry.ServiceExecutionOrdersRegistry;

/**
 * Company class
 *
 * @author André Novo
 * @author Diogo Ribeiro
 */

public class Company {
    
      /**
     * attribute that represents Company's name
     */
    private final String name;

    /**
     * attribute that represents Company's nif
     */
    private final String nif;
    
    /**
     * attribute that represents Service Execution Orders registry
     */
    private final ServiceExecutionOrdersRegistry serviceExecutionOrdersRegistry;
  
    
    /**
     * attribute that represents File Formats registry
     */
    private final FileFormatsRegistry fileFormatsRegistry;
    
    /**
     * Creates Company's instances
     *
     * @param name - Company's name
     * @param nif - Company's nif
     */
    
    public Company(String name, String nif) {
        this.name = name;
        this.nif = nif;
        serviceExecutionOrdersRegistry = new ServiceExecutionOrdersRegistry();
        fileFormatsRegistry = new FileFormatsRegistry();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @return the serviceExecutionOrdersRegistry
     */
    public ServiceExecutionOrdersRegistry getServiceExecutionOrdersRegistry() {
        return serviceExecutionOrdersRegistry;
    }
    
    /**
     * @return the serviceExecutionOrdersRegistry
     */
    public FileFormatsRegistry getFileFormatsRegistry() {
        return fileFormatsRegistry;
    }
}
