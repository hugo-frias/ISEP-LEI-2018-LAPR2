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
public class ClientTest {

    public ClientTest() {
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
     * Test of getName method, of class Client.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        String expResult = "Test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNif method, of class Client.
     */
    @Test
    public void testGetNif() {
        System.out.println("getNif");
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        double expResult = 985023652;
        double result = instance.getNif();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getEmail method, of class Client.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        String expResult = "test@okapi.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhone method, of class Client.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        double expResult = 952362033;
        double result = instance.getPhone();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPostalAddressList method, of class Client.
     */
    @Test
    public void testGetPostalAddressList() {
        System.out.println("getPostalAddressList");
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        List<PostalAddress> result = instance.getPostalAddressList();
        
        assertFalse(result.isEmpty());
    }

    /**
     * Test of setName method, of class Client.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        instance.setName(name);
    }

    /**
     * Test of setNif method, of class Client.
     */
    @Test
    public void testSetNif() {
        System.out.println("setNif");
        int nif = 985023653;
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        instance.setNif(nif);
    }

    /**
     * Test of setEmail method, of class Client.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "test@okapi.net";
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        instance.setEmail(email);
    }

    /**
     * Test of setPhone method, of class Client.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        int phone = 952362034;
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        instance.setPhone(phone);
    }

    /**
     * Test of toString method, of class Client.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Client.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Client.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        Client instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newAddress method, of class Client.
     */
    @Test
    public void testNewAddress() {
        System.out.println("newAddress");
        String address = "ISEP";
        ZipCode zipCode = new ZipCode("4000-300");
        String location = "Porto";
        PostalAddress expResult = new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto");
        PostalAddress result = Client.newAddress(address, zipCode, location);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePostalAddress method, of class Client.
     */
    @Test
    public void testValidatePostalAddress() {
        System.out.println("validatePostalAddress");
        PostalAddress postalAddress = new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto");
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        
        //valida se o código postal ainda não existe na ficha de cliente
        boolean result = instance.validatePostalAddress(postalAddress);
        assertFalse(result);
        
        boolean resultToInsert = instance.validatePostalAddress(new PostalAddress("FAP", new ZipCode("4000-241"), "Porto"));
        assertTrue(resultToInsert);
    }

    /**
     * Test of addPostalAddress method, of class Client.
     */
    @Test
    public void testAddPostalAddress() {
        System.out.println("addPostalAddress");
        PostalAddress postalAddress = new PostalAddress("ISEP", new ZipCode("4100-300"), "Porto");
        Client instance = new Client("Test", 985023652, 952362033, "test@okapi.com", new PostalAddress("ISEP", new ZipCode("4000-300"), "Porto"));
        instance.addPostalAddress(postalAddress);
    }

}
