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
public class OperatesAtTest {

    public OperatesAtTest() {
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
     * Test of getZc method, of class OperatesAt.
     */
    @Test
    public void testGetZc() {
        System.out.println("getZc");
        OperatesAt instance = new OperatesAt(new ZipCode("4000-300"), 5);
        ZipCode expResult = new ZipCode("4000-300");
        ZipCode result = instance.getZc();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class OperatesAt.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        OperatesAt instance = new OperatesAt(new ZipCode("4000-300"), 5);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        OperatesAt instance1 = new OperatesAt(new ZipCode("4000-300"), 5);
        boolean expResult2 = true;
        boolean result2 = instance.equals(instance1);
        assertEquals(expResult2, result2);
        Time time = new Time(20,30,00);
        boolean expResult3 = false;
        boolean result3 = instance.equals(time);
        assertEquals(expResult3, result3);
        boolean expResult4 = true;
        boolean result4 = instance.equals(instance);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of hashCode method, of class OperatesAt.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        OperatesAt instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
