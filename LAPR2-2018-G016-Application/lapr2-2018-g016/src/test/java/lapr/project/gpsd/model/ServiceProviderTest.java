/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.LabelRate.LabelRateEnum;
import lapr.project.gpsd.registry.DailyAvailabilityList;
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
public class ServiceProviderTest {
    
    public ServiceProviderTest() {
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
     * Test of getIdNumber method, of class ServiceProvider.
     */
    @Test
    public void testGetIdNumber() {
        System.out.println("getIdNumber");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com", new 
        PostalAddress("address", new ZipCode("4000-100"), "location"), new ArrayList());
        double expResult = 1;
        double result = instance.getIdNumber();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCompleteName method, of class ServiceProvider.
     */
    @Test
    public void testGetCompleteName() {
        System.out.println("getCompleteName");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com", new 
        PostalAddress("address", new ZipCode("4000-100"), "location"), new ArrayList());;
        String expResult = "CompleteName";
        String result = instance.getCompleteName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShortName method, of class ServiceProvider.
     */
    @Test
    public void testGetShortName() {
        System.out.println("getShortName");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com", new 
        PostalAddress("address", new ZipCode("4000-100"), "location"), new ArrayList());;
        String expResult = "ShortName";
        String result = instance.getShortName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInstitutionalMail method, of class ServiceProvider.
     */
    @Test
    public void testGetInstitutionalMail() {
        System.out.println("getInstitutionalMail");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com", new 
        PostalAddress("address", new ZipCode("4000-100"), "location"), new ArrayList());
        String expResult = "h@gmail.com";
        String result = instance.getInstitutionalMail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostalAddress method, of class ServiceProvider.
     */
    @Test
    public void testGetPostalAddress() {
        System.out.println("getPostalAddress");
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        PostalAddress expResult = pa;
        PostalAddress result = instance.getPostalAddress();
        assertEquals(expResult, result);
    }


    /**
     * Test of getLabelRate method, of class ServiceProvider.
     */
    @Test
    public void testGetLabelRate() {
        System.out.println("getLabelRate");
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        LabelRate expResult = instance.getLabelRate();
        LabelRate result = instance.getLabelRate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRatesList method, of class ServiceProvider.
     */
    @Test
    public void testGetRatesList() {
        System.out.println("getRatesList");
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        List<Rate> expResult = new ArrayList<Rate>();
        Rate rate = instance.getRatesList().get(0);
        expResult.add(rate);
        List<Rate> result = instance.getRatesList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdNumber method, of class ServiceProvider.
     */
    @Test
    public void testSetIdNumber() {
        System.out.println("setIdNumber");
        double idNumber = 1;
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        instance.setIdNumber(idNumber);
    }

    /**
     * Test of setCompleteName method, of class ServiceProvider.
     */
    @Test
    public void testSetCompleteName() {
        System.out.println("setCompleteName");
        String completeName = "newName";
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        instance.setCompleteName(completeName);
    }

    /**
     * Test of setShortName method, of class ServiceProvider.
     */
    @Test
    public void testSetShortName() {
        System.out.println("setShortName");
        String shortName = "newSName";
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        instance.setShortName(shortName);
    }

    /**
     * Test of setInstitutionalMail method, of class ServiceProvider.
     */
    @Test
    public void testSetInstitutionalMail() {
        System.out.println("setInstitutionalMail");
        String institutionalMail = "new@mail.com";
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        instance.setInstitutionalMail(institutionalMail);
    }

    /**
     * Test of setPostalAddress method, of class ServiceProvider.
     */
    @Test
    public void testSetPostalAddress() {
        System.out.println("setPostalAddress");
        PostalAddress postalAddress = new PostalAddress("newAddress",new ZipCode("4000-100"), "location");
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        instance.setPostalAddress(postalAddress);
    }

    /**
     * Test of getCategoriesList method, of class ServiceProvider.
     */
    @Test
    public void testGetCategoriesList() {
        System.out.println("getCategoriesList");
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        List<Category> expResult = new ArrayList<Category>();
        List<Category> result = instance.getCategoriesList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeographicalAreasList method, of class ServiceProvider.
     */
    @Test
    public void testGetGeographicalAreasList() {
        System.out.println("getGeographicalAreasList");
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        List<GeographicalArea> expResult = new ArrayList<GeographicalArea>();
        List<GeographicalArea> result = instance.getGeographicalAreasList();
        assertEquals(expResult, result);
    }

    /**
     * Test of addGeographicalArea method, of class ServiceProvider.
     */
    @Test
    public void testAddGeographicalArea() {
        System.out.println("addGeographicalArea");
        GeographicalArea geoArea = new GeographicalArea("name", 10,1000, "4000-011");
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        boolean expResult = true;
        boolean result = instance.addGeographicalArea(geoArea);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class ServiceProvider.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        Category cat = new Category("cat1", "description");
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        boolean expResult = true;
        boolean result = instance.addCategory(cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ServiceProvider.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PostalAddress pa = new PostalAddress("address", new ZipCode("4000-100"), "location");
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com",pa, new ArrayList());
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ServiceProvider.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com", new 
        PostalAddress("address", new ZipCode("4000-100"), "location"), new ArrayList());
        ServiceProvider instance = new ServiceProvider(1, "CompleteName", "ShortName", "h@gmail.com", new 
        PostalAddress("address", new ZipCode("4000-100"), "location"), new ArrayList());
        Time time = new Time(20,30,00);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        boolean expResult2 = false;
        boolean result2 = instance.equals(time);
        assertEquals(expResult2, result2);
        ServiceProvider sp = null;
        boolean expResult3 = false;
        boolean result3 = instance.equals(sp);
        assertEquals(expResult3, result3);
        boolean expResult4 = true;
        boolean result4 = instance.equals(instance);
        assertEquals(expResult4, result4);       
        
    }

    /**
     * Test of hashCode method, of class ServiceProvider.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        ServiceProvider instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}
