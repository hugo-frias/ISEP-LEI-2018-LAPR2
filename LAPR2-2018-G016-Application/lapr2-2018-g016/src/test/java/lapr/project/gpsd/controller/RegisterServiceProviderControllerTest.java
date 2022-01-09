/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ZipCode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hugo Frias
 */
public class RegisterServiceProviderControllerTest {
    
    public RegisterServiceProviderControllerTest() {
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
     * Test of getApplicationByNif method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetApplicationByNif() {
        System.out.println("getApplicationByNif");
        String name = "Joaquim Almeida";
        int nif = 123456789;        
        String email = "joaquimAlmeida@gmail.com";
        int phone = 123456789;
        String address = "Rua W";
        String zipCode = "4000-007";
        String location = "Porto";
        Application app = new Application(name, nif, email, phone, new PostalAddress(address, new ZipCode(zipCode), location));
        int nifAux = 123456789;
        GPSD.getInstance().getCompany().getApplicationsRegistry().addApplication(app);
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        Application expResult = app;
        Application result = instance.getApplicationByNif(nifAux);
        assertEquals(expResult, result);
    }

    /**
     * Test of newServiceProvider method, of class RegisterServiceProviderController.
     */
    @Test
    public void testNewServiceProvider_Application() {
        System.out.println("newServiceProvider");
        String name = "Joaquim Almeida";
        int nif = 123456789;        
        String email = "joaquimAlmeida@gmail.com";
        int phone = 123456789;
        String address = "Rua W";
        String zipCode = "4000-007";
        String location = "Porto";
        Application app = new Application(name, nif, email, phone, new PostalAddress(address, new ZipCode(zipCode), location));
        app.addCategory(new Category("cat1","asd"));
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        instance.newServiceProvider(app);
    }

    /**
     * Test of newServiceProvider method, of class RegisterServiceProviderController.
     */
    @Test
    public void testNewServiceProvider_4args() {
        System.out.println("newServiceProvider");
        String fullName = "Hugo";
        String address = "St";
        String postCode = "4000-011";
        String locality = "Porto";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        boolean expResult = true;
        boolean result = instance.newServiceProvider(fullName, address, postCode, locality);
        assertEquals(expResult, result);
    }

    /**
     * Test of getShortName method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetShortName() {
        System.out.println("getShortName");
        String fullName = "Hugo Filipe Frias";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        String expResult = "Hugo Frias";
        String result = instance.getShortName(fullName);
        assertEquals(expResult, result);
    }

    /**
     * Test of setAditionalData method, of class RegisterServiceProviderController.
     */
    @Test
    public void testSetAditionalData() {
        String name = "Joaquim Almeida";
        String address = "Rua W";
        String zipCode = "4000-007";
        String location = "Porto";
        System.out.println("setAditionalData");
        String IDNumber = "123456789";
        String InstitutionalEmail = "h@gmail.com";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        instance.newServiceProvider(name, address, zipCode, location);
        boolean expResult = true;
        boolean result = instance.setAditionalData(IDNumber, InstitutionalEmail);
        assertEquals(expResult, result);
    }

    /**
     * Test of setGeographicalArea method, of class RegisterServiceProviderController.
     */
    @Test
    public void testSetGeographicalArea() {
        String name = "Joaquim Almeida";
        String address = "Rua W";
        String zipCode = "4000-007";
        String location = "Porto";
        
        System.out.println("setGeographicalArea");
        GeographicalArea geoArea = new GeographicalArea("name", 10, 1000, "4000-011");
        
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        instance.newServiceProvider(name, address, zipCode, location);
        
        boolean expResult = true;
        boolean result = instance.setGeographicalArea(geoArea);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSp method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetSp() {
        System.out.println("getSp");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        ServiceProvider expResult = instance.getSp();
        ServiceProvider result = instance.getSp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRandomPassword method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetRandomPassword() {
        System.out.println("getRandomPassword");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        String expResult = "teste";
        String result = instance.getRandomPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of registServiceProvider method, of class RegisterServiceProviderController.
     */
    @Test
    public void testRegistServiceProvider() {
        String fullName = "Hugo";
        String address = "St";
        String postCode = "4000-011";
        String locality = "Porto";
        String IDNumber = "123456789";
        String InstitutionalEmail = "h@gmail.com";
        System.out.println("registServiceProvider");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        instance.newServiceProvider(fullName, address, postCode, locality);
        instance.setAditionalData(IDNumber, InstitutionalEmail);
        instance.registServiceProvider();
    }

    /**
     * Test of setCategory method, of class RegisterServiceProviderController.
     */
    @Test
    public void testSetCategory() {
        String fullName = "Hugo";
        String address = "St";
        String postCode = "4000-011";
        String locality = "Porto";
        System.out.println("setCategory");
        Category cat = new Category("cat1", "teste");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        instance.newServiceProvider(fullName, address, postCode, locality);
        boolean expResult = true;
        boolean result = instance.setCategory(cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategories method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetCategories() {
        String fullName = "Hugo";
        String address = "St";
        String postCode = "4000-011";
        String locality = "Porto";
        Category cat = new Category("cat1", "teste");
        System.out.println("getCategories");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        instance.newServiceProvider(fullName, address, postCode, locality);
        instance.setCategory(cat);
        List<Category> expResult = new ArrayList<Category>();
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeoAreas method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetGeoAreas() {
        System.out.println("getGeoAreas");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        Company comp = GPSD.getInstance().getCompany();
        List<GeographicalArea> expResult = comp.getGeographicalAreaResgitry().getGeographicalAreas();
        List<GeographicalArea> result = instance.getGeoAreas();
        assertEquals(expResult, result);
    }
    
}
