/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.ServiceType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Beatriz Ribeiro
 */
public class SpecifyServiceControllerTest {
    
    public SpecifyServiceControllerTest() {
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
     * Test of newService method, of class SpecifyServiceController.
     */
    @Test
    public void testNewService() throws Exception {
        System.out.println("newService");
        String id = "serv1";
        String briefDesc = "brief1";
        String completeDesc = "complete1";
        double cost = 2.0;
        Category category = new Category("cat3","xxx");
        ServiceType serviceType = new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService");
        SpecifyServiceController instance = new SpecifyServiceController();
        boolean expResult = true;
        boolean result = instance.newService(id, briefDesc, completeDesc, cost, category, serviceType);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of registsService method, of class SpecifyServiceController.
     */
    @Test
    public void testRegistsService() throws Exception{
        System.out.println("registsService");
        String id = "serv2";
        String briefDesc = "brief1";
        String completeDesc = "complete1";
        double cost = 2.0;
        Category category = new Category("cat3","xxx");
        ServiceType serviceType = new ServiceType("Limited", "lapr.project.gpsd.model.LimitedService");
        SpecifyServiceController instance = new SpecifyServiceController();
        instance.newService(id, briefDesc, completeDesc, cost, category, serviceType);
        boolean expResult = true;
        boolean result = instance.registsService();
        assertEquals(expResult, result);
        
    }
    
}
