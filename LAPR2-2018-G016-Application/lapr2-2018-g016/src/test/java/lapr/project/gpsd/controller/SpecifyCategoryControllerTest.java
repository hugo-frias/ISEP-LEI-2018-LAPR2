/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

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
public class SpecifyCategoryControllerTest {
    
    public SpecifyCategoryControllerTest() {
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
     * Test of newCategory method, of class SpecifyCategoryController.
     */
    @Test
    public void testNewCategory() {
        System.out.println("newCategory");
        String cod = "cat1";
        String desc = "description x";
        SpecifyCategoryController instance = new SpecifyCategoryController();
        instance.newCategory(cod, desc);
    }

    /**
     * Test of validatesCategory method, of class SpecifyCategoryController.
     */
    @Test
    public void testValidatesCategory() {
        System.out.println("validatesCategory");
        SpecifyCategoryController instance = new SpecifyCategoryController();
        instance.newCategory("cat2","description x");
        boolean expResult = true;
        boolean result = instance.validatesCategory();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of registCategory method, of class SpecifyCategoryController.
     */
    @Test
    public void testRegistCategory() {
        System.out.println("registCategory");
        SpecifyCategoryController instance = new SpecifyCategoryController();
         instance.newCategory("cat1","description x");
        boolean expResult = true;
        boolean result = instance.registCategory();
        assertEquals(expResult, result);
        
    }
    
}
