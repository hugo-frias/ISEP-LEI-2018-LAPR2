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
 * @author Hugo Frias
 * 
 */
public class RateTest {
    
    public RateTest() {
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
     * Test of setRate method, of class Rate.
     */
    @Test
    public void testSetRate() {
        System.out.println("setRate");
        int rate = 4;
        Rate instance = new Rate();
        instance.setRate(rate);
    }

    /**
     * Test of getRate method, of class Rate.
     */
    @Test
    public void testGetRate() {
        System.out.println("getRate");
        Rate instance = new Rate();
        double expResult = 3.0;
        double result = instance.getRate();
        assertEquals(expResult, result, 0.0);
    }
    
}
