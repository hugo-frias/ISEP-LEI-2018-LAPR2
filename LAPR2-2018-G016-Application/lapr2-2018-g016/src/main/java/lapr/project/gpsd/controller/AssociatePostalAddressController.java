/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.io.FileNotFoundException;
import java.text.ParseException;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ZipCode;

/**
 *
 * @author Andr� Novo
 */
public class AssociatePostalAddressController {
    
    /**
     * Company variable
     */
    
    private Company company;
    
    /*
	* Client variable
	*/
    
    private Client cli;
	
	/**
     * PostalAddress variable
     */
	 
    private PostalAddress postalAddress;
    
    /**
     * Empty constructor
     */
    
    public AssociatePostalAddressController() {
        company = GPSD.getInstance().getCompany();
    }
    
    /**
     * Starting the UC
     */
    
    public void newPostalAdress() {
        Client c=company.getClientsRegistry().getClientByEmail(GPSD.getInstance().getCurrentSession().getUserEmail());
        if (c!=null){
            cli=c;
        }
    }
    
    /**
     * Creates a new Postal Address
     */
    
    public void newPostalAddress(String address, String zipCode, String location) {
        this.postalAddress= new PostalAddress(address, new ZipCode(zipCode), location);
        cli.addPostalAddress(postalAddress);
    }

    /**
     * Returns the temporary PostalAddress instance
     * @return the temporary PostalAddress instance
     */
    public PostalAddress getPostalAddress() {
        return postalAddress;
    }
    
}