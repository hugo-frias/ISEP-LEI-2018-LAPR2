/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;
import lapr.project.utils.Date;
import lapr.project.utils.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author André Novo
 */
public class AvailabilityTest {

    public AvailabilityTest() {
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
     * Test of getDateBeginning method, of class Availability.
     */
    @Test
    public void testGetDateBeginning() {
        System.out.println("getDateBeginning");
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        Date expResult = new Date(2019, 06, 12);
        Date result = instance.getDateBeginning();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHourBeginning method, of class Availability.
     */
    @Test
    public void testGetHourBeginning() {
        System.out.println("getHourBeginning");
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        Time expResult = new Time(13, 0);
        Time result = instance.getHourBeginning();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateEnding method, of class Availability.
     */
    @Test
    public void testGetDateEnding() {
        System.out.println("getDateEnding");
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        Date expResult = new Date(2019, 06, 13);
        Date result = instance.getDateEnding();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHourEnding method, of class Availability.
     */
    @Test
    public void testGetHourEnding() {
        System.out.println("getHourEnding");
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        Time expResult = new Time(14, 0);
        Time result = instance.getHourEnding();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPatternsList method, of class Availability.
     */
    @Ignore
    public void testGetPatternsList() {
        System.out.println("getPatternsList");
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        List<String> expResult = null;
        List<String> result = instance.getPatternsList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateBeginning method, of class Availability.
     */
    @Test
    public void testSetDateBeginning() {
        System.out.println("setDateBeginning");
        Date dateBeginning = new Date(2019, 07, 12);
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        instance.setDateBeginning(dateBeginning);
    }

    /**
     * Test of setHourBeginning method, of class Availability.
     */
    @Test
    public void testSetHourBeginning() {
        System.out.println("setHourBeginning");
        Time hourBeginning = new Time(14, 0);
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        instance.setHourBeginning(hourBeginning);
    }

    /**
     * Test of setDateEnding method, of class Availability.
     */
    @Test
    public void testSetDateEnding() {
        System.out.println("setDateEnding");
        Date dateEnding = new Date(2019, 07, 13);
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        instance.setDateEnding(dateEnding);
    }

    /**
     * Test of setHourEnding method, of class Availability.
     */
    @Test
    public void testSetHourEnding() {
        System.out.println("setHourEnding");
        Time hourEnding = new Time(15, 0);
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        instance.setHourEnding(hourEnding);
    }

    /**
     * Test of setPatternsList method, of class Availability.
     */
    @Ignore
    public void testSetPatternsList() {
        System.out.println("setPatternsList");
        List<String> patternsList = null;
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        instance.setPatternsList(patternsList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Availability.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Availability.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Availability instance = new Availability(new Date(2019, 06, 12), new Time(13, 0), new Date(2019, 06, 13), new Time(14, 0));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Availability.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        Availability instance = new Availability(new Date(2019,06,12), new Time(13, 0), new Date(2019,06,13), new Time(14, 0));
        int expResult = instance.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of addPattern method, of class Availability.
     */
    @Test
    public void testAddPattern() {
        System.out.println("addPattern");
        String pattern = "Random";
                Availability instance = new Availability(new Date(2019,06,12), new Time(13, 0), new Date(2019,06,13), new Time(14, 0));
        instance.addPattern(pattern);
    }

    /**
     * Test of validateDate method, of class Availability.
     */
    @Test
    public void testValidateDate() {
        System.out.println("validateDate");
        Date dBeginning = new Date(2019,06,12);
        Date dEnding = new Date(2019,06,13);
                Availability instance = new Availability(new Date(2019,06,12), new Time(13, 0), new Date(2019,06,13), new Time(14, 0));
        boolean expResult = true;
        boolean result = instance.validateDate(dBeginning, dEnding);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateTime method, of class Availability.
     */
    @Test
    public void testValidateTime() {
        System.out.println("validateTime");
        Time hBeginning = new Time(13, 0);
        Time hEnding = new Time(14, 0);
        Availability instance = new Availability(new Date(2019,06,12), new Time(13, 0), new Date(2019,06,13), new Time(14, 0));
        boolean expResult = true;
        boolean result = instance.validateTime(hBeginning, hEnding);
        assertEquals(expResult, result);
    }

}
