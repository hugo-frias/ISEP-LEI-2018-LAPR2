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
 * @author André Novo
 */
public class LabelRateTest {

    public LabelRateTest() {
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
     * Test of getLabelRate method, of class LabelRate.
     */
    @Test
    public void testGetLabelRate() {
        System.out.println("getLabelRate");
        LabelRate instance = new LabelRate("XXX", 4.0, 0.02);
        String expResult = "XXX";
        String result = instance.getLabelRate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStandardDeviation method, of class LabelRate.
     */
    @Test
    public void testGetStandardDeviation() {
        System.out.println("getStandardDeviation");
        LabelRate instance = new LabelRate("XXX", 4.0, 0.02);
        double expResult = 0.02;
        double result = instance.getStandardDeviation();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getMean method, of class LabelRate.
     */
    @Test
    public void testGetMean() {
        System.out.println("getMean");
        LabelRate instance = new LabelRate("XXX", 4.0, 0.02);
        double expResult = 4.0;
        double result = instance.getMean();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setMean method, of class LabelRate.
     */
    @Test
    public void testSetMean() {
        System.out.println("setMean");
        double mean = 2.0;
        LabelRate instance = new LabelRate("XXX", 4.0, 0.02);
        instance.setMean(mean);
    }

    /**
     * Test of setLabelRate method, of class LabelRate.
     */
    @Test
    public void testSetLabelRate() {
        System.out.println("setLabelRate");
        String labelRate = "XXS";
        LabelRate instance = new LabelRate("XXX", 4.0, 0.02);
        instance.setLabelRate(labelRate);
    }

    /**
     * Test of setStandardDeviation method, of class LabelRate.
     */
    @Test
    public void testSetStandardDeviation() {
        System.out.println("setStandardDeviation");
        double standardDeviation = 0.01;
        LabelRate instance = new LabelRate("XXX", 4.0, 0.02);
        instance.setStandardDeviation(standardDeviation);
    }

}
