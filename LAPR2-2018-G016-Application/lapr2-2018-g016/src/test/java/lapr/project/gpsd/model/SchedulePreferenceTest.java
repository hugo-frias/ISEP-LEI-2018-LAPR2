/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import lapr.project.utils.Date;
import lapr.project.utils.Date;
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
public class SchedulePreferenceTest {

    public SchedulePreferenceTest() {
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
     * Test of getDate method, of class SchedulePreference.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        SchedulePreference instance = new SchedulePreference(new Date(2019, 6, 13), new Time(13, 0), 1);
        Date expResult = new Date(2019, 6, 13);
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHour method, of class SchedulePreference.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        SchedulePreference instance = new SchedulePreference(new Date(2019, 6, 13), new Time(13, 0), 1);
        Time expResult = new Time(13, 0);
        Time result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of setScheduleStatus method, of class SchedulePreference.
     */
    @Test
    public void testSetScheuleStatus() {
        System.out.println("setScheuleStatus");
        String status = "Afetado";
        SchedulePreference instance = new SchedulePreference(new Date(2019, 6, 13), new Time(13, 0), 1);
        instance.setScheduleStatus(status);
    }

    /**
     * Test of getScheduleStatus method, of class SchedulePreference.
     */
    @Test
    public void testGetScheduleStatus() {
        System.out.println("getScheduleStatus");
        SchedulePreference instance = new SchedulePreference(new Date(2019, 6, 13), new Time(13, 0), 1);
        String status = "Afetado";
        instance.setScheduleStatus(status);
        String expResult = "Afetado";
        String result = instance.getScheduleStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class SchedulePreference.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        SchedulePreference instance = new SchedulePreference(new Date(2019, 6, 13), new Time(13, 0), 1);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        boolean expResult2 = true;
        boolean result2 = instance.equals(instance);
        assertEquals(expResult2, result2);
        SchedulePreference instance1 = new SchedulePreference(new Date(2019, 6, 13), new Time(13, 0), 1);
        boolean expResult3 = true;
        boolean result3 = instance.equals(instance1);
        assertEquals(expResult3, result3);
        Time time = new Time(20, 30, 00);
        boolean expResult4 = false;
        boolean result4 = instance.equals(time);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of hashCode method, of class SchedulePreference.
     */
    @Ignore
    public void testHashCode() {
        System.out.println("hashCode");
        SchedulePreference instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
