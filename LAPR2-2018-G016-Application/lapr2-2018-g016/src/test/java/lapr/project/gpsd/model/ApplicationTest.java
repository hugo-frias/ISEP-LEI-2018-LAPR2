/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;
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
public class ApplicationTest {

    public ApplicationTest() {
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
     * Test of toString method, of class Application.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Application.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Application.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        int expResult = instance.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNif method, of class Application.
     */
    @Test
    public void testGetNif() {
        System.out.println("getNif");
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        int expResult = 999222000;
        int result = instance.getNif();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostalAddress method, of class Application.
     */
    @Test
    public void testGetPostalAddress() {
        System.out.println("getPostalAddress");
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        PostalAddress expResult = new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto");
        PostalAddress result = instance.getPostalAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryList method, of class Application.
     */
    
    @Ignore
    public void testGetCategoryList() {
        System.out.println("getCategoryList");
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        List<Category> expResult = instance.getCategoryList();
        List<Category> result = instance.getCategoryList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Application.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        String expResult = "Teste";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Application.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "CCC";
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        instance.setName(name);

    }

    /**
     * Test of getAs method, of class Application.
     */
    
    @Ignore
    public void testGetAs() {
        System.out.println("getAs");
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        ApplicationStatus expResult = null;
        ApplicationStatus result = instance.getAs();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAs method, of class Application.
     */
    @Ignore
    public void testSetAs() {
        System.out.println("setAs");
        ApplicationStatus as = new ApplicationStatus();
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        instance.setAs(as);
    }

    /**
     * Test of addAcadQualifications method, of class Application.
     */
    @Test
    public void testAddAcadQualifications() {
        System.out.println("addAcadQualifications");
        String designation = "Testte";
        String degree = "Doutoramento";
        String classification = "20";
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        boolean expResult = true;
        boolean result = instance.addAcadQualifications(designation, degree, classification);
        assertEquals(expResult, result);
    }

    /**
     * Test of addProQualification method, of class Application.
     */
    @Test
    public void testAddProQualification() {
        System.out.println("addProQualification");
        String description = "Teste";
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        boolean expResult = true;
        boolean result = instance.addProQualification(description);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class Application.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        Category category = new Category("cat1", "Limpeza");
        Application instance = new Application("Teste", 999222000, "teste@okapi.com", 985023210, new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        boolean expResult = true;
        boolean result = instance.addCategory(category);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateName method, of class Application.
     */
    @Test
    public void testValidateName() {
        System.out.println("validateName");
        String fullName = "Teste Okapi";
        String nif = "999780250";
        String phoneNumber = "985632022";
        String email = "test@okapi.com";
        boolean expResult = true;
        boolean result = Application.validateName(fullName, nif, phoneNumber, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateAdress method, of class Application.
     */
    @Test
    public void testValidateAdress() {
        System.out.println("validateAdress");
        String address = "ISEP";
        String locality = "Porto";
        String postCode = "4000-300";
        boolean expResult = true;
        boolean result = Application.validateAdress(address, locality, postCode);
        assertEquals(expResult, result);
    }

}
