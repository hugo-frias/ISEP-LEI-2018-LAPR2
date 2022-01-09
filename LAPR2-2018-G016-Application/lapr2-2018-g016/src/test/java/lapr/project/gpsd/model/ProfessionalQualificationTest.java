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
public class ProfessionalQualificationTest {
    
    public ProfessionalQualificationTest() {
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
     * Test of getDescription method, of class ProfessionalQualification.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ProfessionalQualification instance = new ProfessionalQualification("description");
        String expResult = "description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class ProfessionalQualification.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "newDesc";
        ProfessionalQualification instance = new ProfessionalQualification("description");;
        instance.setDescription(description);
    }

    /**
     * Test of equals method, of class ProfessionalQualification.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new ProfessionalQualification("description");
        ProfessionalQualification instance = new ProfessionalQualification("description");
        Time time = new Time(20,30,00);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        boolean expResult1 = false;
        boolean result1 = instance.equals(time);
        assertEquals(expResult1, result1);
        ProfessionalQualification pq = null;
        boolean expResult2 = false;
        boolean result2 = instance.equals(pq);
        assertEquals(expResult2, result2);
        boolean expResult4 = true;
        boolean result4 = instance.equals(instance);
        assertEquals(expResult4, result4);        
    }

    /**
     * Test of hashCode method, of class ProfessionalQualification.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        ProfessionalQualification instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ProfessionalQualification.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ProfessionalQualification instance = new ProfessionalQualification("description");;
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
