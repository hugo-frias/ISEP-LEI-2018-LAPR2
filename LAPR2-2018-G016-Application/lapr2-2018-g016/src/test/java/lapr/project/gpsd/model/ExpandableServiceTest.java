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
import org.junit.Ignore;

/**
 *
 * @author André Novo
 */
public class ExpandableServiceTest {

    public ExpandableServiceTest() {
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
     * Test of getId method, of class ExpandableService.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        String expResult = "serv1";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBriefDesc method, of class ExpandableService.
     */
    @Test
    public void testGetBriefDesc() {
        System.out.println("getBriefDesc");
        ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        String expResult = "Clean";
        String result = instance.getBriefDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompleteDesc method, of class ExpandableService.
     */
    @Test
    public void testGetCompleteDesc() {
        System.out.println("getCompleteDesc");
        ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        String expResult = "Clean all house";
        String result = instance.getCompleteDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHourlyCost method, of class ExpandableService.
     */
    @Test
    public void testGetHourlyCost() {
        System.out.println("getHourlyCost");
        ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        double expResult = 25;
        double result = instance.getHourlyCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setId method, of class ExpandableService.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "serv2";
        ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        instance.setId(id);
    }

    /**
     * Test of setBriefDesc method, of class ExpandableService.
     */
    @Test
    public void testSetBriefDesc() {
        System.out.println("setBriefDesc");
        String briefDesc = "Clean it";
        ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        instance.setBriefDesc(briefDesc);
    }

    /**
     * Test of setCompleteDesc method, of class ExpandableService.
     */
    @Test
    public void testSetCompleteDesc() {
        System.out.println("setCompleteDesc");
        String completeDesc = "Clean all house and garden";
                ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        instance.setCompleteDesc(completeDesc);
    }

    /**
     * Test of setHourlyCost method, of class ExpandableService.
     */
    @Test
    public void testSetHourlyCost() {
        System.out.println("setHourlyCost");
        double hourlyCost = 30;
                ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        instance.setHourlyCost(hourlyCost);
    }

    /**
     * Test of toString method, of class ExpandableService.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
                ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasOtherAttributes method, of class ExpandableService.
     */
    @Test
    public void testHasOtherAttributes() {
        System.out.println("hasOtherAttributes");
                ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        boolean expResult = false;
        boolean result = instance.hasOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOtherAttributes method, of class ExpandableService.
     */
    @Test
    public void testGetOtherAttributes() {
        System.out.println("getOtherAttributes");
        ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        int expResult = instance.getOtherAttributes();
        int result = instance.getOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ExpandableService.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
                ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class ExpandableService.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        ExpandableService instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdditionalData method, of class ExpandableService.
     */
    @Test
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        int data = 5;
        FixedService instance = new FixedService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        instance.setAdditionalData(data);
    }

    /**
     * Test of getCategory method, of class ExpandableService.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
                ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        Category expResult = new Category("cat1", "Limpeza");
        Category result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCostForPeriod method, of class ExpandableService.
     */
    @Test
    public void testGetCostForPeriod() {
        System.out.println("getCostForPeriod");
        int period = 60;
                ExpandableService instance = new ExpandableService("serv1", "Clean", "Clean all house", 25, new Category("cat1", "Limpeza"), new ServiceType("ExpandableService", "lapr.project.gpsd.model.ExpandableService"));
        double expResult = 25;
        double result = instance.getCostForPeriod(period);
        assertEquals(expResult, result, 0.0);
    }

}
