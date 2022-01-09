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
public class ZipCodeTest {

    public ZipCodeTest() {
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
     * Test of getZipCode method, of class ZipCode.
     */
    @Test
    public void testGetZipCode() {
        System.out.println("getZipCode");
        ZipCode instance = new ZipCode("4000-300", 41.253, 42.236);
        String expResult = "4000-300";
        String result = instance.getZipCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLongitude method, of class ZipCode.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        ZipCode instance = new ZipCode("4000-300", 41.253, 42.236);
        double expResult = 42.236;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLatitude method, of class ZipCode.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        ZipCode instance = new ZipCode("4000-300", 41.253, 42.236);
        double expResult = 41.253;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setLatitude method, of class ZipCode.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        double latitude = 42.253;
        ZipCode instance = new ZipCode("4000-300", 41.253, 42.236);
        instance.setLatitude(latitude);
    }

    /**
     * Test of setLongitude method, of class ZipCode.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        double longitude = 43.236;
        ZipCode instance = new ZipCode("4000-300", 41.253, 42.236);
        instance.setLongitude(longitude);
    }

    /**
     * Test of toString method, of class ZipCode.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ZipCode instance = new ZipCode("4000-300", 41.253, 42.236);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ZipCode.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        ZipCode instance = new ZipCode("4000-300", 41.253, 42.236);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        ZipCode instance1 = new ZipCode("4000-300", 41.253, 42.236);
        boolean expResult2 = true;
        boolean result2 = instance.equals(instance1);
        assertEquals(expResult2, result2);
        Time time = new Time(13,0);
        boolean expResult3 = false;
        boolean result3 = instance.equals(time);
        assertEquals(expResult3, result3);
        boolean expResult4 = true;
        boolean result4 = instance.equals(instance);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of hashCode method, of class ZipCode.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        ZipCode instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateZipCode method, of class ZipCode.
     */
    @Test
    public void testValidateZipCode() {
        System.out.println("validateZipCode");
        String zipCode = "4000-300";
        ZipCode instance = new ZipCode("4000-300", 41.253, 42.236);
        instance.validateZipCode(zipCode);
    }

    /**
     * Test of getLatitudeByZipCode method, of class ZipCode.
     */
    @Test
    public void testGetLatitudeByZipCode() {
        System.out.println("getLatitudeByZipCode");
        ZipCode instance = new ZipCode("4000-300");
        double expResult = instance.getLatitudeByZipCode();
        double result = instance.getLatitudeByZipCode();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getLongitudeByZipCode method, of class ZipCode.
     */
    @Test
    public void testGetLongitudeByZipCode() {
        System.out.println("getLongitudeByZipCode");
                ZipCode instance = new ZipCode("4000-300");
        double expResult = instance.getLongitudeByZipCode();
        double result = instance.getLongitudeByZipCode();
        assertEquals(expResult, result, 0.0);
    }

}
