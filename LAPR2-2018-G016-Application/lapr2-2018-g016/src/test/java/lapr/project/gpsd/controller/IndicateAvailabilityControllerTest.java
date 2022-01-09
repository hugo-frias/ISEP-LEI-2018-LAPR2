/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ZipCode;
import lapr.project.utils.Date;
import lapr.project.utils.Time;
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
public class IndicateAvailabilityControllerTest {
    
    public IndicateAvailabilityControllerTest() {
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
     * Test of indicateNewAvailability method, of class IndicateAvailabilityController.
     */
    @Test
    public void testIndicateNewAvailability() {
        String address = "Rua Joaquim Almeida nº2";
        String zipCode = "4000-007";
        String location = "Porto";
        ZipCode zp = new ZipCode(zipCode);
        PostalAddress pa = new PostalAddress(address, zp, location);
        ServiceProvider sp = GPSD.getInstance().getCompany().getServiceProvidersRegistry().newServiceProvider("Jose", "X", pa);
        GPSD.getInstance().getCompany().getServiceProvidersRegistry().setAditionalData("11111", "m@mail.pt", sp);
        GPSD.getInstance().getCompany().getServiceProvidersRegistry().registerServiceProvider(sp, "teste");
        GPSD.getInstance().doLogin("m@mail.pt", "teste");
        System.out.println("indicateNewAvailability");
        IndicateAvailabilityController instance = new IndicateAvailabilityController();
        instance.indicateNewAvailability();
    }

    /**
     * Test of newAvailabilityPeriod method, of class IndicateAvailabilityController.
     */
    @Test
    public void testNewAvailabilityPeriod() {
        ZipCode zp = new ZipCode("4000-011");
        PostalAddress pa = new PostalAddress("Rua Joaquim Almeida nº2", zp, "Porto");
        ServiceProvider sp = GPSD.getInstance().getCompany().getServiceProvidersRegistry().newServiceProvider("Jose", "X", pa);
        GPSD.getInstance().getCompany().getServiceProvidersRegistry().setAditionalData("11111", "m@mail.pt", sp);
        GPSD.getInstance().getCompany().getServiceProvidersRegistry().registerServiceProvider(sp, "teste");
        GPSD.getInstance().doLogin("m@mail.pt", "teste");
        System.out.println("newAvailabilityPeriod");
        Date dateBeginning = new Date(2019,12,3);
        Time hourBeginning = new Time(16,30);
        Date dateEnding = new Date(2019,12,19);
        Time hourEnding = new Time(21,0);
        IndicateAvailabilityController instance = new IndicateAvailabilityController();
        instance.indicateNewAvailability();
        boolean expResult = true;
        boolean result = instance.newAvailabilityPeriod(dateBeginning, hourBeginning, dateEnding, hourEnding);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAvailabilityPatterns method, of class IndicateAvailabilityController.
     */
    @Test
    public void testAddAvailabilityPatterns() {
        ZipCode zp = new ZipCode("4000-011");
        PostalAddress pa = new PostalAddress("Rua Joaquim Almeida nº2", zp, "Porto");
        ServiceProvider sp = GPSD.getInstance().getCompany().getServiceProvidersRegistry().newServiceProvider("Jose", "X", pa);
        GPSD.getInstance().getCompany().getServiceProvidersRegistry().setAditionalData("11111", "m@mail.pt", sp);
        GPSD.getInstance().getCompany().getServiceProvidersRegistry().registerServiceProvider(sp, "teste");
        GPSD.getInstance().doLogin("m@mail.pt", "teste");
        System.out.println("newAvailabilityPeriod");
        Date dateBeginning = new Date(2019,12,3);
        Time hourBeginning = new Time(16,30);
        Date dateEnding = new Date(2019,12,19);
        Time hourEnding = new Time(21,0);
        IndicateAvailabilityController instance = new IndicateAvailabilityController();
        instance.indicateNewAvailability();
        instance.newAvailabilityPeriod(dateBeginning, hourBeginning, dateEnding, hourEnding);
        System.out.println("addAvailabilityPatterns");
        List<String> availabilityPatterns = new ArrayList<>();
        availabilityPatterns.add("Monday");
        instance.addAvailabilityPatterns(availabilityPatterns);
    }

    /**
     * Test of registerAvailabilityPeriod method, of class IndicateAvailabilityController.
     */
    @Test
    public void testRegisterAvailabilityPeriod() {
         ZipCode zp = new ZipCode("4000-011");
        PostalAddress pa = new PostalAddress("Rua Joaquim Almeida nº2", zp, "Porto");
        ServiceProvider sp = GPSD.getInstance().getCompany().getServiceProvidersRegistry().newServiceProvider("Jose", "X", pa);
        GPSD.getInstance().getCompany().getServiceProvidersRegistry().setAditionalData("11111", "m@mail.pt", sp);
        GPSD.getInstance().getCompany().getServiceProvidersRegistry().registerServiceProvider(sp, "teste");
        GPSD.getInstance().doLogin("m@mail.pt", "teste");
        System.out.println("newAvailabilityPeriod");
        Date dateBeginning = new Date(2019,12,3);
        Time hourBeginning = new Time(16,30);
        Date dateEnding = new Date(2019,12,19);
        Time hourEnding = new Time(21,0);
        IndicateAvailabilityController instance = new IndicateAvailabilityController();
        instance.indicateNewAvailability();
        instance.newAvailabilityPeriod(dateBeginning, hourBeginning, dateEnding, hourEnding);
        System.out.println("registerAvailabilityPeriod");

        instance.registerAvailabilityPeriod();
    }
    
}
