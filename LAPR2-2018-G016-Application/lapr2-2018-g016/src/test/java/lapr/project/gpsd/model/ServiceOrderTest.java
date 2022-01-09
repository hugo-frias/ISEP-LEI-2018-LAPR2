/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import lapr.project.utils.Date;
import lapr.project.utils.Date;
import lapr.project.utils.Time;
import lapr.project.utils.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author André Novo
 */
public class ServiceOrderTest {

    public ServiceOrderTest() {
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
     * Test of setDescription method, of class ServiceOrder.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String status = "Test";
        ServiceProvider serviceProvider = new ServiceProvider("Jonas", "Gunner", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        ExpandableService expandableService = new ExpandableService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Expandable", "lapr.project.gpsd.model.ExpandableList"));
        ServiceRequestDescription serviceRequestDescription = new ServiceRequestDescription("tap", expandableService, 60);
        Client client = new Client("Jonas", 985632023, 985256252, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-200"), "Porto"));
        ServiceRequest serviceRequest = new ServiceRequest(client, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        SchedulePreference schedulePreference = new SchedulePreference(new Date(2019, 06, 10), new Time(13, 0), 1);
        Affectation affectation = new Affectation(serviceProvider, serviceRequestDescription, serviceRequest, schedulePreference);
        ServiceOrder instance = new ServiceOrder(affectation);
        instance.setDescription(status);
    }

    /**
     * Test of getAffectation method, of class ServiceOrder.
     */
    @Test
    public void testGetAffectation() {
        System.out.println("getAffectation");
       ServiceProvider serviceProvider = new ServiceProvider("Jonas", "Gunner", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        ExpandableService expandableService = new ExpandableService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Expandable", "lapr.project.gpsd.model.ExpandableList"));
        ServiceRequestDescription serviceRequestDescription = new ServiceRequestDescription("tap", expandableService, 60);
        Client client = new Client("Jonas", 985632023, 985256252, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-200"), "Porto"));
        ServiceRequest serviceRequest = new ServiceRequest(client, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        SchedulePreference schedulePreference = new SchedulePreference(new Date(2019, 06, 10), new Time(13, 0), 1);
        Affectation affectation = new Affectation(serviceProvider, serviceRequestDescription, serviceRequest, schedulePreference);
        ServiceOrder instance = new ServiceOrder(affectation);
        Affectation expResult = instance.getAffectation();
        Affectation result = instance.getAffectation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIssueDate method, of class ServiceOrder.
     */
    @Test
    public void testGetIssueDate() {
        System.out.println("getIssueDate");
        ServiceProvider serviceProvider = new ServiceProvider("Jonas", "Gunner", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        ExpandableService expandableService = new ExpandableService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Expandable", "lapr.project.gpsd.model.ExpandableList"));
        ServiceRequestDescription serviceRequestDescription = new ServiceRequestDescription("tap", expandableService, 60);
        Client client = new Client("Jonas", 985632023, 985256252, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-200"), "Porto"));
        ServiceRequest serviceRequest = new ServiceRequest(client, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        SchedulePreference schedulePreference = new SchedulePreference(new Date(2019, 06, 10), new Time(13, 0), 1);
        Affectation affectation = new Affectation(serviceProvider, serviceRequestDescription, serviceRequest, schedulePreference);
        ServiceOrder instance = new ServiceOrder(affectation);
        Date expResult = instance.getIssueDate();
        Date result = instance.getIssueDate();
        assertEquals(expResult, result);
    }

}
