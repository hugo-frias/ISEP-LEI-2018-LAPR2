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
public class FixedServiceTest {

    public FixedServiceTest() {
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
     * Test of getId method, of class FixedService.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        String expResult = "serv1";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBriefDesc method, of class FixedService.
     */
    @Test
    public void testGetBriefDesc() {
        System.out.println("getBriefDesc");
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        String expResult = "Clean";
        String result = instance.getBriefDesc();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCompleteDesc method, of class FixedService.
     */
    @Test
    public void testGetCompleteDesc() {
        System.out.println("getCompleteDesc");
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        String expResult = "Clean all house";
        String result = instance.getCompleteDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHourlyCost method, of class FixedService.
     */
    @Test
    public void testGetHourlyCost() {
        System.out.println("getHourlyCost");
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        double expResult = 15;
        double result = instance.getHourlyCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setId method, of class FixedService.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "serv2";
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        instance.setId(id);
    }

    /**
     * Test of setPreGivenPeriod method, of class FixedService.
     */
    @Test
    public void testSetPreGivenPeriod() {
        System.out.println("setPreGivenPeriod");
        int preGivenPeriod = 50;
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        instance.setPreGivenPeriod(preGivenPeriod);
    }

    /**
     * Test of setBriefDesc method, of class FixedService.
     */
    @Test
    public void testSetBriefDesc() {
        System.out.println("setBriefDesc");
        String briefDesc = "Clean it";
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        instance.setBriefDesc(briefDesc);
    }

    /**
     * Test of setCompleteDesc method, of class FixedService.
     */
    @Test
    public void testSetCompleteDesc() {
        System.out.println("setCompleteDesc");
        String completeDesc = "Clean all house and garden";
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        instance.setCompleteDesc(completeDesc);
    }

    /**
     * Test of setHourlyCost method, of class FixedService.
     */
    @Test
    public void testSetHourlyCost() {
        System.out.println("setHourlyCost");
        double hourlyCost = 20;
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        instance.setHourlyCost(hourlyCost);
    }

    /**
     * Test of toString method, of class FixedService.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasOtherAttributes method, of class FixedService.
     */
    @Test
    public void testHasOtherAttributes() {
        System.out.println("hasOtherAttributes");
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        boolean expResult = true;
        boolean result = instance.hasOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOtherAttributes method, of class FixedService.
     */
    @Test
    public void testGetOtherAttributes() {
        System.out.println("getOtherAttributes");
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        int expResult = instance.getOtherAttributes();
        int result = instance.getOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class FixedService.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        FixedService instance1 = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        boolean expResult2 = true;
        boolean result2 = instance.equals(instance1);
        assertEquals(expResult2, result2);
        Time time = new Time(20, 30, 00);
        boolean expResult3 = false;
        boolean result3 = instance.equals(time);
        assertEquals(expResult3, result3);
        boolean expResult4 = true;
        boolean result4 = instance.equals(instance);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of hashCode method, of class FixedService.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        FixedService instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdditionalData method, of class FixedService.
     */
    @Test
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        int data = 1;
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        instance.setAdditionalData(data);
    }

    /**
     * Test of getCategory method, of class FixedService.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        Category expResult = instance.getCategory();
        Category result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCostForPeriod method, of class FixedService.
     */
    
    @Test
    public void testGetCostForPeriod() {
        System.out.println("getCostForPeriod");
        int period = 60;
       FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 15, new Category("cat1", "Clean"), new ServiceType("Fixed", "lapr.project.gpsd.model.FixedService"));
        double expResult = 15;
        double result = instance.getCostForPeriod(period);
        assertEquals(expResult, result, 0.0);
    }

}
