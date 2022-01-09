/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Affectation;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.LimitedService;
import lapr.project.gpsd.model.Rate;
import lapr.project.gpsd.model.ServiceRequestDescription;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.SchedulePreference;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.gpsd.model.ServiceType;
import lapr.project.gpsd.model.ZipCode;
import lapr.project.utils.Date;
import lapr.project.utils.Time;

/**
 *
 * @author Hugo Frias
 */
public class RateServiceControllerTest {
    
    public RateServiceControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException, ParseException {
        

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of showServiceList method, of class RateServiceController.
     * @throws java.io.FileNotFoundException
     * @throws java.text.ParseException
     */
    @Test
    public void testShowServiceList() throws FileNotFoundException, ParseException {
        System.out.println("showServiceList");
        Client cli = new Client("Zé", 123456789, 123456789, "email@gmail.com", new PostalAddress("St", new ZipCode("4000-300"), "Location"));
        RateServiceController instance = new RateServiceController();
        List<ServiceRequestDescription> expResult = new ArrayList<ServiceRequestDescription>();
        List<ServiceRequestDescription> result = instance.showServiceList(cli);
        assertEquals(expResult, result);
        
    } 

    
    
    
}
