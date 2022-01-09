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
 * @author Diogo Ribeiro
 */
public class RegisterClientController {

    /**
     * variable that represents the company.
     */
    private final Company company;
    
    /**
     * variable that represents the client.
     */
    private Client cli;
    
    /**
     * variable that represents the client´s password.
     */
    private String pwd;

    /**
     * Empty constructor.
     */
    public RegisterClientController()  {
        company = GPSD.getInstance().getCompany();
    }

    /**
     * Creates a new client.
     * 
     * @param name client´s name
     * @param nif client´s nif
     * @param phone client´s phone contact
     * @param email client´s email
     * @param pwd client´s password
     * @param address client´s address
     * @param zipCode client´s zip code
     * @param location client´s location
     * @return true or false
     */
    public boolean newClient(String name, int nif, int phone, String email, String pwd, String address, String zipCode, String location) {
        this.pwd = pwd;
        ZipCode zipCode1 = new ZipCode(zipCode);
        PostalAddress address1 = Client.newAddress(address, zipCode1, location);
        cli = company.getClientsRegistry().newClient(name, nif, phone, email, address1);
        return company.getClientsRegistry().validateClient(cli, pwd);
    }

    /**
     * Adds a new postal address associated to client.
     * @param address client´s address
     * @param zipCode client´s zip code
     * @param location client´s location
     * @return true or false
     */
    public boolean addPostalAddress(String address, String zipCode, String location) {
        ZipCode zipCode1 = new ZipCode(zipCode);
        PostalAddress address1 = Client.newAddress(address, zipCode1, location);
        if(cli.validatePostalAddress(address1)){
            cli.addPostalAddress(address1);
            return true;
        }
        return false;  
    }
    
    /**
     * Registers a client.
     */
    public void registerClient(){
        company.getClientsRegistry().registerClient(cli, pwd);
    }
    
    /**
     * Returns the client text.
     * @return client text
     */
    public String getClientString()
    {
        return cli.toString();
    }
    
    /**
     * Returns the client instance.
     * @return client instance
     */
    public Client getClient() {
        return cli;
    }

}
