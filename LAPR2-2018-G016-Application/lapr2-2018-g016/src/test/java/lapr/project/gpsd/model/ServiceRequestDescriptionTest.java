/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import lapr.project.gpsd.model.ServiceRequestDescription.ServiceRequestDescriptionStatus;
import lapr.project.utils.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Hugo Frias
 * 
 */
public class ServiceRequestDescriptionTest {
    
    public ServiceRequestDescriptionTest() {
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
     * Test of equals method, of class ServiceRequestDescription.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new ServiceRequestDescription("description", new 
            LimitedService("1", "briefdesc", "completedesc", 60, new Category("cat1", "description"), 
                    new ServiceType("LimitedService", "lapr.project.gpsd.model.LimitedService")), 120);
        Time time = new Time(20,30,00);
        ServiceRequestDescription instance = new ServiceRequestDescription("description", new 
            LimitedService("1", "briefdesc", "completedesc", 60, new Category("cat1", "description"), 
                    new ServiceType("LimitedService", "lapr.project.gpsd.model.LimitedService")), 120);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        boolean expResult2 = false;
        boolean result2 = instance.equals(time);
        assertEquals(expResult2, result2);
        ServiceRequestDescription srd = null;
        boolean expResult3 = false;
        boolean result3 = instance.equals(srd);
        assertEquals(expResult3, result3);
        boolean expResult4 = true;
        boolean result4 = instance.equals(instance);
        assertEquals(expResult4, result4);        
    }

    /**
     * Test of hashCode method, of class ServiceRequestDescription.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        ServiceRequestDescription instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getService method, of class ServiceRequestDescription.
     */
    @Test
    public void testGetService() {
        System.out.println("getService");
        ServiceRequestDescription instance = new ServiceRequestDescription("description", new 
            LimitedService("1", "briefdesc", "completedesc", 60, new Category("cat1", "description"), 
                    new ServiceType("LimitedService", "lapr.project.gpsd.model.LimitedService")), 120);
        Service expResult = instance.getService();
        Service result = instance.getService();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCost method, of class ServiceRequestDescription.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        ServiceRequestDescription instance = new ServiceRequestDescription("description", new LimitedService("1", "briefdesc", "completedesc", 60, new Category("cat1", "description"), 
                    new ServiceType("LimitedService", "lapr.project.gpsd.model.LimitedService")), 120);
        double expResult = 120.0;
        double result = instance.getCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setServiceStatus method, of class ServiceRequestDescription.
     */
    @Test
    public void testSetServiceStatus() {
        System.out.println("setServiceStatus");
        String status = "newStatus";
        ServiceRequestDescription instance = new ServiceRequestDescription("description", new 
            LimitedService("1", "briefdesc", "completedesc", 60, new Category("cat1", "description"), 
                    new ServiceType("LimitedService", "lapr.project.gpsd.model.LimitedService")), 120);
        instance.setServiceStatus(status);
    }

    /**
     * Test of getServiceStatus method, of class ServiceRequestDescription.
     */
    @Test
    public void testGetServiceStatus() {
        System.out.println("getServiceStatus");
        ServiceRequestDescription instance = new ServiceRequestDescription("description", new 
            LimitedService("1", "briefdesc", "completedesc", 60, new Category("cat1", "description"), 
                    new ServiceType("LimitedService", "lapr.project.gpsd.model.LimitedService")), 120);
        String expResult = ServiceRequestDescriptionStatus.SUBMITTED.getStatus();
        String result = instance.getServiceStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRate method, of class ServiceRequestDescription.
     */
    @Test
    public void testGetRate() {
        System.out.println("getRate");
        ServiceRequestDescription instance = new ServiceRequestDescription("description", new 
            LimitedService("1", "briefdesc", "completedesc", 60, new Category("cat1", "description"), 
                    new ServiceType("LimitedService", "lapr.project.gpsd.model.LimitedService")), 120);
        Rate expResult = null;
        Rate result = instance.getRate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRate method, of class ServiceRequestDescription.
     */
    @Test
    public void testSetRate() {
        System.out.println("setRate");
        Rate rate = new Rate();
        rate.setRate(5);
        ServiceRequestDescription instance = new ServiceRequestDescription("description", new LimitedService("1", "briefdesc", "completedesc", 60, new Category("cat1", "description"), 
                    new ServiceType("LimitedService", "lapr.project.gpsd.model.LimitedService")), 120);
        instance.setRate(rate);
    }
    
}
