/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

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
 * @author Hugo Frias
 * 
 */
public class PostalAddressTest {
    
    public PostalAddressTest() {
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
     * Test of getAddress method, of class PostalAddress.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAdress");
        PostalAddress instance = new PostalAddress("address", new ZipCode("4000-011"), "location");
        String expResult = "address";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLocation method, of class PostalAddress.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        PostalAddress instance = new PostalAddress("address", new ZipCode("4000-011"), "location");
        String expResult = "location";
        String result = instance.getLocation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getZipCode method, of class PostalAddress.
     */
    @Test
    public void testGetZipCode() {
        System.out.println("getZipCode");
        ZipCode zc = new ZipCode("4000-011");
        PostalAddress instance = new PostalAddress("address", zc, "location");
        ZipCode expResult = zc;
        ZipCode result = instance.getZipCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdress method, of class PostalAddress.
     */
    @Test
    public void testSetAdress() {
        System.out.println("setAdress");
        String address = "newAddress";
        PostalAddress instance = new PostalAddress("address", new ZipCode("4000-011"), "location");
        instance.setAdress(address);        
    }

    /**
     * Test of setLocation method, of class PostalAddress.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "newLocation";
        PostalAddress instance = new PostalAddress("address", new ZipCode("4000-011"), "location");;
        instance.setLocation(location);
    }

    /**
     * Test of setZipCode method, of class PostalAddress.
     */
    @Test
    public void testSetZipCode() {
        System.out.println("setZipCode");
        ZipCode zipCode = new ZipCode("4000-011");
        PostalAddress instance = new PostalAddress("address", new ZipCode("4000-100"), "location");;
        instance.setZipCode(zipCode);
    }

    /**
     * Test of toString method, of class PostalAddress.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PostalAddress instance = new PostalAddress("address", new ZipCode("4000-011"), "location");
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class PostalAddress.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new PostalAddress("address", new ZipCode("4000-011"), "location");
        Time time = new Time(20,30,00);
        PostalAddress instance = new PostalAddress("address", new ZipCode("4000-011"), "location");;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        boolean expResult2 = false;
        boolean result2 = instance.equals(time);
        assertEquals(expResult2, result2);
        PostalAddress pa = null;
        boolean expResult3 = false;
        boolean result3 = instance.equals(pa);
        assertEquals(expResult3, result3);
        boolean expResult4 = true;
        boolean result4 = instance.equals(instance);
        assertEquals(expResult4, result4);       
    }

    /**
     * Test of hashCode method, of class PostalAddress.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        PostalAddress instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
