package lapr.project.serviceprovider.gpsd.registry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr.project.serviceprovider.gpsd.model.ServiceOrder;
import static lapr.project.serviceprovider.utils.CompanyFinals.NAME_FILE;

/**
 *
 * @author André Novo
 * @author Diogo Ribeiro
 */
public class ServiceExecutionOrdersRegistry implements Serializable {

    /**
     * list that has all Company's Service Execution Orders
     */
    private List<ServiceOrder> serviceExecutionOrders;

    /**
     * Creates a list of Service Execution Orders
     */
    public ServiceExecutionOrdersRegistry() {
        serviceExecutionOrders = new ArrayList<>();
    }

    /**
     * Returns a list of Service Execution Orders
     *
     * @return serviceExecutionOrders
     */
    public List<ServiceOrder> getServiceExecutionOrders() {
        return serviceExecutionOrders;
    }

    /**
     * @param serviceExecutionOrders service order's list to set
     */
    public void setServiceExecutionOrders(List<ServiceOrder> serviceExecutionOrders) {
        this.serviceExecutionOrders = serviceExecutionOrders;
    }

    /**
     * Adds a Service Orders to the Service Execution Orders's list
     *
     * @param serviceOrder service order
     */
    public void addServiceExecutionOrders(ServiceOrder serviceOrder) {
        serviceExecutionOrders.add(serviceOrder);
    }

    public void addServiceExecutionOrdersList(List<ServiceOrder> serviceOrdersList) {
        serviceExecutionOrders.addAll(serviceOrdersList);
    }

    /**
     * Adds non-repetitive service orders to a list
     *
     * @param serviceOrdersList service order's list
     */
    public void addServiceExecutionOrdersListNonRepetitive(List<ServiceOrder> serviceOrdersList) {
        List<ServiceOrder> list = new ArrayList<>(serviceOrdersList);
        for (int i = 0; i < serviceOrdersList.size(); i++) {
            for (int j = 0; j < this.serviceExecutionOrders.size(); j++) {
                if (serviceOrdersList.get(i).equals(this.serviceExecutionOrders.get(j))) {
                    list.remove(serviceOrdersList.get(i));
                }
            }
        }
        addServiceExecutionOrdersList(list);
    }

    /**
     * Filters a list of Service Execution Orders for the client with that name
     *
     * @param serviceOrders list with service orders
     * @param zipCode client's zipCode
     * @return the filtered list
     */
    public List<ServiceOrder> getServiceExecutionsOrdersByClient(List<ServiceOrder> serviceOrders, String zipCode) {
        List<ServiceOrder> serviceOrdersAux = new ArrayList<>(serviceOrders);
        if (zipCode != null && !zipCode.isEmpty()) {
            for (ServiceOrder sO : serviceOrders) {
                if (sO != null && sO.getClientName() != null && sO.getClientPostalAddress() != null && !sO.getClientPostalAddress().getZipCode().getZipCode().trim().equalsIgnoreCase(zipCode.trim())) {
                    serviceOrdersAux.remove(sO);
                }
            }
        }
        return serviceOrdersAux;
    }

    /**
     * Returns a list of Service Execution Orders for the client with that name
     *
     * @param clientName client's name
     * @return serviceExecutionOrdersAux
     */
    public List<ServiceOrder> getServiceExecutionsOrdersByClient(String clientName) {
        List<ServiceOrder> serviceExecutionOrdersAux = new ArrayList<>();
        if (clientName != null && !clientName.isEmpty()) {
            for (ServiceOrder sO : serviceExecutionOrders) {
                if (sO != null && sO.getClientName() != null && sO.getClientName().equalsIgnoreCase(clientName)) {
                    serviceExecutionOrdersAux.add(sO);
                }
            }
        }
        return serviceExecutionOrdersAux;
    }

    /**
     * Imports the service order instances in the system.
     *
     * @return list with the imported service orders
     */
    public static List<ServiceOrder> importServiceOrders() {
        List<ServiceOrder> serviceOrdersList;
        try {
            FileInputStream fileIn = new FileInputStream(NAME_FILE);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            serviceOrdersList = (List<ServiceOrder>) in.readObject();
            in.close();
            fileIn.close();
            return serviceOrdersList;
        } catch (IOException | ClassNotFoundException i) {

        }
        return null;
    }

    /**
     * Saves the service order istances in a binary file.
     *
     * @param serviceOrdersList service orders's list
     */
    public static void saveServiceOrders(List<ServiceOrder> serviceOrdersList) {
        try {
            FileOutputStream fileOut = new FileOutputStream(NAME_FILE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(serviceOrdersList);
            out.close();
            fileOut.close();
        } catch (IOException ioe) {

        }
    }

    /**
     * Method to verify if there are two clients with same name
     *
     * @param name name of the client
     * @return true if there are and false if there arent
     */
    public boolean thereAreTwoClientsWithSameName(String name) {
        int verifier = 0;
        for (ServiceOrder sO : serviceExecutionOrders) {
            if (sO != null && sO.getClientName().equalsIgnoreCase(name)) {
                verifier++;
            }
        }
        if (verifier > 1) {
            return true;
        }
        return false;
    }
}
