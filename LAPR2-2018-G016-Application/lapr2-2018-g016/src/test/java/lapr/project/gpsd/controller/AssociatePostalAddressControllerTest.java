/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ZipCode;
import lapr.project.gpsd.registry.ClientsRegistry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

/**
 *
 * @author André Novo
 */
public class AssociatePostalAddressControllerTest {
    
    public AssociatePostalAddressControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of newPostalAdress method, of class AssociatePostalAddressController.
     */
    @Test
    public void testNewPostalAdress() {
        
        ZipCode zc = new ZipCode("4000-011");
        PostalAddress pa = new PostalAddress("Street X", zc, "Location Y");
        Client cli = new Client("Jose", 123456789, 123456789, "j@mail.pt", pa);
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "teste");
        GPSD.getInstance().doLogin("j@mail.pt", "teste");
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "psw");
        System.out.println("newPostalAdress");
        AssociatePostalAddressController instance = new AssociatePostalAddressController();
        instance.newPostalAdress();
    }

    /**
     * Test of newPostalAddress method, of class AssociatePostalAddressController.
     */
    @Test
    public void testNewPostalAddress() {
        ZipCode zc = new ZipCode("4000-011");
        PostalAddress pa = new PostalAddress("Street X", zc, "Location Y");
        Client cli = new Client("Jose", 123456789, 123456789, "j@mail.pt", pa);
        GPSD g = GPSD.getInstance();
        Company c = g.getCompany();
        ClientsRegistry cr = c.getClientsRegistry();
        cr.registerClient(cli, "teste");
        
        //GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "teste");
        GPSD.getInstance().doLogin("j@mail.pt", "teste");
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "psw");
        System.out.println("newPostalAddress");
        String address = "Rua daqui do Lado";
        String zipCode = "4000-007";
        String location = "Alvite";
        AssociatePostalAddressController instance = new AssociatePostalAddressController();
        instance.newPostalAdress();
        instance.newPostalAddress(address, zipCode, location);
    }
    
}
