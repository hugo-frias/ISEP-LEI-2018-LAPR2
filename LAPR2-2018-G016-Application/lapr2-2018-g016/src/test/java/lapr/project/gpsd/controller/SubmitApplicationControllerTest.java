/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.PostalAddress;
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
 * 
 */
public class SubmitApplicationControllerTest {
    
    public SubmitApplicationControllerTest() {
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
     * Test of newApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testNewApplication() throws FileNotFoundException, ParseException {
        System.out.println("newApplication");
        String name = "name";
        String nif = "123456789";
        String phoneNumber = "123456789";
        String email = "h@gmail.com";
        String address = "St";
        String zipCodeAux = "4000-011";
        String locality = "Porto";
        SubmitApplicationController instance = new SubmitApplicationController();
        boolean expResult = true;
        boolean result = instance.newApplication(name, nif, phoneNumber, email, address, zipCodeAux, locality);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAcadQualification method, of class SubmitApplicationController.
     */
    @Test
    public void testAddAcadQualification() throws FileNotFoundException, ParseException {
        String name = "name";
        String nif = "123456789";
        String phoneNumber = "123456789";
        String email = "h@gmail.com";
        String address = "St";
        String zipCodeAux = "4000-011";
        String locality = "Porto";
        System.out.println("addAcadQualification");
        String designation = "test";
        String degree = "test";
        String classification = "12";
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newApplication(name, nif, phoneNumber, email, address, zipCodeAux, locality);
        boolean expResult = true;
        boolean result = instance.addAcadQualification(designation, degree, classification);
        assertEquals(expResult, result);
    }

    /**
     * Test of addProQualification method, of class SubmitApplicationController.
     */
    @Test
    public void testAddProQualification() throws FileNotFoundException, ParseException {
        String name = "name";
        String nif = "123456789";
        String phoneNumber = "123456789";
        String email = "h@gmail.com";
        String address = "St";
        String zipCodeAux = "4000-011";
        String locality = "Porto";
        System.out.println("addAcadQualification");
        System.out.println("getCategories");
        System.out.println("addProQualification");
        String description = "asd";
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newApplication(name, nif, phoneNumber, email, address, zipCodeAux, locality);
        boolean expResult = true;
        boolean result = instance.addProQualification(description);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategories method, of class SubmitApplicationController.
     */
    @Test
    public void testGetCategories() throws FileNotFoundException, ParseException {
        String name = "name";
        String nif = "123456789";
        String phoneNumber = "123456789";
        String email = "h@gmail.com";
        String address = "St";
        String zipCodeAux = "4000-011";
        String locality = "Porto";
        System.out.println("addAcadQualification");
        System.out.println("getCategories");
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newApplication(name, nif, phoneNumber, email, address, zipCodeAux, locality);
        Company comp = GPSD.getInstance().getCompany();
        comp.getCategoriesRegistry().addCategory(new Category("cat1", "test"));
        List<Category> expResult = comp.getCategoriesRegistry().getCategories();
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class SubmitApplicationController.
     */
    @Test
    public void testAddCategory() throws FileNotFoundException, ParseException {
        String name = "name";
        String nif = "123456789";
        String phoneNumber = "123456789";
        String email = "h@gmail.com";
        String address = "St";
        String zipCodeAux = "4000-011";
        String locality = "Porto";
        System.out.println("addCategory");
        Category category = new Category("cat1", "asd");
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newApplication(name, nif, phoneNumber, email, address, zipCodeAux, locality);
        boolean expResult = true;
        boolean result = instance.addCategory(category);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testRegisterApplication() throws FileNotFoundException, ParseException {
        System.out.println("registerApplication");
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.registerApplication();
    }

    /**
     * Test of printApp method, of class SubmitApplicationController.
     */
    @Test
    public void testPrintApp() throws FileNotFoundException, ParseException {
        System.out.println("printApp");
        SubmitApplicationController instance = new SubmitApplicationController();
        String name = "Joaquim Almeida";      
        String email = "joaquimAlmeida@gmail.com";
        String address = "Rua W";
        String zipCode = "4000-300";
        String location = "Porto";
        instance.newApplication(name, "123456789", "123456789", email, address, zipCode, location);
        Application app = new Application(name, 123456789, email, 123456789, new PostalAddress(address, new ZipCode(zipCode), location));
        String expResult = app.toString();
        String result = instance.printApp();
        assertEquals(expResult, result);        
    }
    
}
