/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;
import lapr.project.utils.Time;
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
 * @author André Novo
 */
public class GeographicalAreaTest {

    public GeographicalAreaTest() {
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
     * Test of getOperatesAt method, of class GeographicalArea.
     */
    @Test
    public void testGetOperatesAt() {
        System.out.println("getOperatesAt");
        GeographicalArea instance = new GeographicalArea("Port", 100, 25, "4000-300");
        List<OperatesAt> expResult = instance.getOperatesAt();
        List<OperatesAt> result = instance.getOperatesAt();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTravelCost method, of class GeographicalArea.
     */
    @Test
    public void testGetTravelCost() {
        System.out.println("getTravelCost");
        GeographicalArea instance = new GeographicalArea("Port", 100, 25, "4000-300");
        double expResult = 100;
        double result = instance.getTravelCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class GeographicalArea.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GeographicalArea instance = new GeographicalArea("Port", 100, 25, "4000-300");
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class GeographicalArea.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        GeographicalArea instance = new GeographicalArea("Port", 100, 25, "4000-300");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        Time time = new Time(20, 30, 00);
        boolean expResult2 = false;
        boolean result2 = instance.equals(time);
        assertEquals(expResult2, result2);
        GeographicalArea instance1 = new GeographicalArea("Port", 100, 25, "4000-300");
        boolean expResult3 = true;
        boolean result3 = instance.equals(instance1);
        assertEquals(expResult3, result3);
        boolean expResult4 = true;
        boolean result4 = instance.equals(instance);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of hashCode method, of class GeographicalArea.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        GeographicalArea instance = new GeographicalArea();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class GeographicalArea.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        String name = "ISEP";
        double travelCost = 100;
        ZipCode zc = new ZipCode("4000-300");
        double operatingRadius = 25;
        GeographicalArea instance = new GeographicalArea("Port", 100, 25, "4000-300");
        List<OperatesAt> operatesAtList = null;
        instance.setData(name, travelCost, zc, operatingRadius, operatesAtList);
    }

}
