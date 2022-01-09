package lapr.project.serviceprovider.gpsd.model;

import java.util.List;

/**
 *
 * @author Diogo Ribeiro
 */
public interface Importer {
    
    /**
     * Imports a file containing the Service Provider's service execution orders.
     * 
     * @param nameFile name of the file
     * @return list of service orders
     */
    List<ServiceOrder> importFile(String nameFile);
}
