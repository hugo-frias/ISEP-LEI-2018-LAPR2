package lapr.project.gpsd.registry;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.autorizacao.FacadeAuthorization;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.PostalAddress;
import static lapr.project.utils.CompanyFinals.CLIENT_ROLE;

/**
 * Class of Clients Registry
 *
 * @author Beatriz Ribeiro
 */
public class ClientsRegistry {

    /**
     * list that has all Company's Clients
     */
    private List<Client> clients;

    /**
     * Creates a list of Clients
     */
    public ClientsRegistry() {
        clients = new ArrayList<Client>();
    }

    /**
     * Returns a list of Clients
     *
     * @return clients
     */
    public List<Client> getClients() {
        return clients;
    }
    /**
     * Creates a new Client.
     * 
     * @param name - Client´s name
     * @param nif - Clent´s nif
     * @param phone - Client´s phone
     * @param email - Client´s email
     * @param postalAddress - Client´s postal address
     * @return new Client
     */
    public Client newClient(String name, int nif, int phone, String email, PostalAddress postalAddress) {
        return new Client(name,nif,phone,email,postalAddress);
    }
    
    /**
     * Validates the Client´s password and verifies if the Client already exists
     * 
     * @param cli - Client
     * @param pwd - Client´s password
     * @return true or false
     */
    public boolean validateClient(Client cli, String pwd) {
        if (pwd == null || pwd.isEmpty()) {
            return false;
        }
        for (int i = 0; i < clients.size(); i++) {
            if (cli.getEmail().equals(clients.get(i).getEmail())) {
                return false;
            }
            if (cli.getNif() == clients.get(i).getNif()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns the Client by Email
     * @param email
     * @return 
     */
    
    public Client getClientByEmail (String email) {
        for(Client cli : clients) {
            if(cli != null && cli.getEmail() != null && cli.getEmail().equalsIgnoreCase(email)) {
                return cli;
            }
        }
        return null;
    }
    
        /**
     * Registers a new Client
     * 
     * @param cli client
     * @param pwd client´s password
     */
    public void registerClient(Client cli, String pwd){
        GPSD app = GPSD.getInstance();
        FacadeAuthorization authorization = app.getCompany().getAuthorization();
        authorization.registerUserWithRole(cli.getName(), cli.getEmail(), pwd, CLIENT_ROLE);
        addClient(cli);

    }
    
    /**
     * Adds a Client to the list.
     * 
     * @param cli 
     */
    public void addClient(Client cli) {
        clients.add(cli);
    }
}
