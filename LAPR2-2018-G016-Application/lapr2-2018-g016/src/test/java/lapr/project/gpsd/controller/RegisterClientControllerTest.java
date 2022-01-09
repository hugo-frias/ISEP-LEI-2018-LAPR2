/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.Client;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diogo Ribeiro
 */
public class RegisterClientControllerTest {
    
    public RegisterClientControllerTest() {
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
     * Test of newClient method, of class RegisterClientController.
     */
    @Test
    public void testNewClient() {
        System.out.println("newClient");
        String name = "Joaquim Almeida";
        int nif = 123456788;
        int phone = 919586593;
        String email = "joaquimAlmeida@gmail.com";
        String pwd = "teste";
        String address = "Rua W";
        String zipCode = "4000-007";
        String location = "Porto";
        RegisterClientController instance = new RegisterClientController();
        boolean expResult = true;
        boolean result = instance.newClient(name, nif, phone, email, pwd, address, zipCode, location);
        assertEquals(expResult, result);
    }

    /**
     * Test of addPostalAddress method, of class RegisterClientController.
     */
    @Test
    public void testAddPostalAddress() {
        System.out.println("addPostalAddress");
        String name = "Afonso Henriques";
        int nif = 123456789;
        int phone = 919586593;
        String email = "afonsoheriques@mail.com";
        String pwd = "teste";
        String address = "Rua M nº2";
        String zipCode = "4000-013";
        String location = "Porto";
        RegisterClientController instance = new RegisterClientController();
        instance.newClient(name, nif, phone, email, pwd, address, zipCode, location);
        boolean expResult = true;
        boolean result = instance.addPostalAddress(address, "4000-011", location);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerClient method, of class RegisterClientController.
     */
    @Test
    public void testRegisterClient() throws Exception {
        String name = "Joao Almeida";
        int nif = 123456789;
        int phone = 919586593;
        String email = "joaoAlmeida@gmail.com";
        String pwd = "teste";
        String address = "Rua Z nº2";
        String zipCode = "4000-011";
        String location = "Porto";
        RegisterClientController instance = new RegisterClientController();
        instance.newClient(name, nif, phone, email, pwd, address, zipCode, location);
        System.out.println("registerClient");
        instance.registerClient();
    }    

    
}
