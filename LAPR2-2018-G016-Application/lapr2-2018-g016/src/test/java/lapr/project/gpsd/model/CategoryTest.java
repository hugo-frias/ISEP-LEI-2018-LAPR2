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
public class CategoryTest {
    
    public CategoryTest() {
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
     * Test of getId method, of class Category.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Category instance = new Category("cat1", "Limpeza");
        String expResult = "cat1";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Category.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Category instance = new Category("cat1", "Limpeza");
        String expResult = "Limpeza";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Category.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Category instance = new Category("cat1", "Limpeza");
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Category.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Category instance = new Category("cat1", "Limpeza");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of hashCode method, of class Category.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        Category instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
