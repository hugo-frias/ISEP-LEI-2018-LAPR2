/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

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
public class OtherCostTest {

    public OtherCostTest() {
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
     * Test of equals method, of class OtherCost.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        OtherCost instance = new OtherCost("Okapi", 250);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        OtherCost instance1 = new OtherCost("Okapi", 250);
        boolean expResult1 = true;
        boolean result1 = instance.equals(instance1);
        assertEquals(expResult1, result1);
        Time time = new Time(20, 30, 00);
        boolean expResult2 = false;
        boolean result2 = instance.equals(time);
        assertEquals(expResult2, result2);
        boolean expResult3 = true;
        boolean result3 = instance.equals(instance);
        assertEquals(expResult3, result3);

    }

    /**
     * Test of hashCode method, of class OtherCost.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        OtherCost instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
