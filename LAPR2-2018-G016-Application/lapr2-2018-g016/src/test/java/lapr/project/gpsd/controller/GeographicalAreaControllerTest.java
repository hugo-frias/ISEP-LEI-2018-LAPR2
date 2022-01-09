/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.GeographicalArea;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vera Pinto
 */
public class GeographicalAreaControllerTest {
    
    public GeographicalAreaControllerTest() {
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
     * Test of newGeographicalArea method, of class GeographicalAreaController.
     */
    @Test
    public void testNewGeographicalArea() throws Exception {
        System.out.println("newGeographicalArea");
        String name = "AreaX";
        double travelCost = 2.0;
        String zipCode = "4000-007";
        double operatingRadius = 7000.0;
        GeographicalAreaController instance = new GeographicalAreaController();
        GeographicalArea result = instance.newGeographicalArea(name, travelCost, zipCode, operatingRadius);
        GeographicalArea expResult = new GeographicalArea(name, travelCost, operatingRadius, zipCode);
        GeographicalArea expResult2 = new GeographicalArea("AreaY", travelCost, operatingRadius, zipCode);
        GeographicalArea expResult3=null;
        assertEquals(expResult, result);
        assertNotEquals(expResult2,result);
        assertNotEquals(expResult3, result);
    }

    /**
     * Test of registerGeographicalArea method, of class GeographicalAreaController.
     */
    @Test
    public void testRegisterGeographicalArea() {
        System.out.println("registerGeographicalArea");
        GeographicalArea ga = new GeographicalArea("AreaY", 2.0, 7000, "4000-011");
        GeographicalAreaController instance = new GeographicalAreaController();
        
        instance.registerGeographicalArea(ga);
        
    }
    
}
