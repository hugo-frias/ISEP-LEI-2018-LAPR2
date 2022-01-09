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
 * @author Beatriz Ribeiro
 */
public class AcademicQualificationTest {
    
    public AcademicQualificationTest() {
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
     * Test of getDesignation method, of class AcademicQualification.
     */
    @Test
    public void testGetDesignation() {
        System.out.println("getDesignation");
        AcademicQualification instance = new AcademicQualification("XXX", "ZZZ", 12);
        String expResult = "XXX";
        String result = instance.getDesignation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDesignation method, of class AcademicQualification.
     */
    @Test
    public void testSetDesignation() {
        System.out.println("setDesignation");
         AcademicQualification instance = new AcademicQualification("XXX", "ZZZ", 12);
        String designation = "ccc";
        instance.setDesignation(designation);
        assertEquals("Match", "ccc",instance.getDesignation() );
    }

    /**
     * Test of getDegree method, of class AcademicQualification.
     */
    @Test
    public void testGetDegree() {
        System.out.println("getDegree");
        AcademicQualification instance = new AcademicQualification("XXX", "ZZZ", 12);
        String expResult = "ZZZ";
        String result = instance.getDegree();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDegree method, of class AcademicQualification.
     */
    @Test
    public void testSetDegree() {
        System.out.println("setDegree");
        String degree = "ggg";
         AcademicQualification instance = new AcademicQualification("XXX", "ZZZ", 12);
        instance.setDegree(degree);
        assertEquals("Match","ggg", instance.getDegree());
    }

    /**
     * Test of getClassification method, of class AcademicQualification.
     */
    @Test
    public void testGetClassification() {
        System.out.println("getClassification");
         AcademicQualification instance = new AcademicQualification("XXX", "ZZZ", 12.0);
        Double expResult = 12.0;
        Double result = instance.getClassification();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setClassification method, of class AcademicQualification.
     */
    @Test
    public void testSetClassification() {
        System.out.println("setClassification");
        double classification = 15;
        AcademicQualification instance = new AcademicQualification("XXX", "ZZZ", 12);
        instance.setClassification(classification);
        assertEquals(15,instance.getClassification(),0.0);
   
    }

    /**
     * Test of toString method, of class AcademicQualification.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
         AcademicQualification instance = new AcademicQualification("XXX", "ZZZ", 12);
        String expResult ="Academic Qualification:\n" + "designation=" + instance.getDesignation() + ", degree=" + instance.getDegree() + ", classification=" + instance.getClassification();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class AcademicQualification.
    
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
         AcademicQualification instance = new AcademicQualification("XXX", "ZZZ", 12);
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    

    /**
     * Test of equals method, of class AcademicQualification.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new AcademicQualification("XXX", "ZZZ", 12);
        AcademicQualification instance = new AcademicQualification("XXX", "ZZZ", 12);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        ZipCode zp = null;
        try {
            zp = new ZipCode("4000-007");
        } catch (Exception e){
            e.printStackTrace();
        }
        boolean expResult2 = false;
        boolean result2= instance.equals(zp);
        assertEquals(expResult2, result2);
        AcademicQualification a2 = new AcademicQualification("LLL", "ZZZ", 12);
        boolean expResult3=false;
        boolean result3= instance.equals(a2);
        assertEquals(expResult3, result3);
        Object x = null;
        boolean expResult4 = false;
        boolean result4= instance.equals(x);
        assertEquals(expResult4, result4);
    }
    
}
