/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

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
public class ServiceTypeTest {
    
    public ServiceTypeTest() {
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
     * Test of newService method, of class ServiceType.
     */
    @Test
    public void testNewService() throws Exception {
        System.out.println("newService");
        String id = "serv1";
        String briefDesc = "cleaning";
        String completeDesc = "cleaning room";
        double hourlyCost = 3.0;
        Category category = new Category("cat1", "house work");
        ServiceType instance = new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService");
        Service expResult = new FixedService("serv1", "cleaning", "cleaning room", 3.0, category, instance);
        Service result = instance.newService(id, briefDesc, completeDesc, hourlyCost, category);
        assertEquals(expResult, result);
        
    }
    
}
