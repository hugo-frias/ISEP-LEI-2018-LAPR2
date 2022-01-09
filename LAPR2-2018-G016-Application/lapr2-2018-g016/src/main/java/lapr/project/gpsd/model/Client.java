package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.utils.Utils;

/**
 * Class that represents a Client
 *
 * @author André Novo
 * @author Beatriz Ribeiro
 */
public class Client {

    /**
     * attribute that represents Client's name
     */
    private String name;

    /**
     * attribute that represents Client's nif
     */
    private int nif;

    /**
     * attribute that represents Client's email
     */
    private String email;

    /**
     * attribute that represents Client's phone number
     */
    private int phone;

    /**
     * attribute that represents all Client's Postal Adresses
     */
    private List<PostalAddress> postalAddressList;
    
    /**
     * attribute that represents all Client's invoices
     */
    
    private List<Invoice> invoiceList;

    /**
     * Creates a new Client
     *
     * @param name - Client's name
     * @param nif - Client's nif
     * @param email - Client's email
     * @param phone - Client's phone number
     * @param postalAddress - Client's postal address
     */
    public Client(String name, int nif, int phone, String email, PostalAddress postalAddress) {
		Utils.validadeTwoStringFields(name, email);
        Utils.validateNifORPhone(nif);
		Utils.validateNifORPhone(phone);
        this.name = name;
        this.nif = nif;
        this.email = email;
        this.phone = phone;
        this.postalAddressList = new ArrayList<PostalAddress>();
        this.postalAddressList.add(postalAddress);
        this.invoiceList = new ArrayList<Invoice>();
    }

    /**
     * Copy contructor
     *
     * @param client - other Client
     */
	 
    public Client(Client client) {
        this.name = client.name;
        this.nif = client.nif;
        this.email = client.email;
        this.phone = client.phone;
    }

    /**
     * Returns Client's name
     *
     * @return the name - client's name
     */
	 
    public String getName() {
        return name;
    }

    /**
     * Returns Client's nif
     *
     * @return the nif
     */
	 
    public double getNif() {
        return nif;
    }

    /**
     * Returns Client's mail
     *
     * @return the email
     */
	 
    public String getEmail() {
        return email;
    }

    /**
     * Returns Client's phone number
     *
     * @return the phone
     */
	 
    public double getPhone() {
        return phone;
    }

    /**
     * Returns Client´s postal address list
     * @return Client's invoice list
     */
    public List<PostalAddress> getPostalAddressList() {
        return postalAddressList;
    }
    
    /**
     * Returns Client's invoice list
     * @return Client's invoice list
     */
    
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * Returns Client's information
     *
     * @return Client's information
     */
    @Override
    public String toString() {
        return String.format("Name: %s%nNIF: %d%nEmail: %s%nPhone Number: %d", name, nif, email, phone);
    }

    /**
     * Compares two objects
     *
     * @param obj - another object
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Client otherClient = (Client) obj;
        return (otherClient.name.equals(this.name) && otherClient.nif == nif && otherClient.email.equals(email) && otherClient.phone == phone);

    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    

    /**
     * Creates a new Postal Address
     *
     * @param address Postal Address´s address
     * @param zipCode Postal Address´s zip code
     * @param location Postal Address´s location
     * @return new Postal Address
     */
    public static PostalAddress newAddress(String address, ZipCode zipCode, String location) {
        return new PostalAddress(address, zipCode, location);
    }

    /**
     * Validates a postal address
     * @param postalAddress postal address
     * @return true or false
     */
    public boolean validatePostalAddress(PostalAddress postalAddress) {
        return postalAddress != null && !postalAddressList.contains(postalAddress);
    }
    
    /**
     * Adds a postal address
     * @param postalAddress postal address
     */
	 
    public void addPostalAddress(PostalAddress postalAddress) {
        postalAddressList.add(postalAddress);
    }

}