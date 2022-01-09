/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

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
public class TimeTest {
    
    public TimeTest() {
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
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        Time instance = new Time(20,30,00);
        int expResult = 20;
        int result = instance.getHours();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        Time instance = new Time(20,40,8);
        int expResult = 40;
        int result = instance.getMinutes();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getSeconds method, of class Time.
     */
    @Test
    public void testGetSeconds() {
        System.out.println("getSeconds");
        Time instance = new Time(18,45,06);
        int expResult = 6;
        int result = instance.getSeconds();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHours method, of class Time.
     */
    @Test
    public void testSetHours() {
        System.out.println("setHours");
        int hours = 2;
        Time instance = new Time(20,8,9);
        instance.setHours(hours);
        assertEquals(instance.getHours(), hours);
    }

    /**
     * Test of setMinutes method, of class Time.
     */
    @Test
    public void testSetMinutes() {
        System.out.println("setMinutes");
        int minutes = 30;
        Time instance = new Time(20,40,12);
        instance.setMinutes(minutes);
        assertEquals(instance.getMinutes(), minutes);
    }

    /**
     * Test of setSeconds method, of class Time.
     */
    @Test
    public void testSetSeconds() {
        System.out.println("setSeconds");
        int seconds = 10;
        Time instance = new Time(12,5,40);
        instance.setSeconds(seconds);
        assertEquals(instance.getSeconds(),seconds);
    }

    /**
     * Test of setTime method, of class Time.
     */
    @Test
    public void testSetTime_3args() {
        System.out.println("setTime");
        int hours = 12;
        int minutes = 6;
        int seconds = 30;
        Time instance = new Time(20,7,30);
        instance.setTime(hours, minutes, seconds);
        assertEquals(new Time(12,6,30),instance);
    }

    /**
     * Test of setTime method, of class Time.
     */
    @Test
    public void testSetTime_int() {
        System.out.println("setTime");
        int hours = 7;
        Time instance = new Time(8);
        instance.setTime(hours);
        assertEquals(new Time(7,0,0),instance);
    }

    /**
     * Test of setTime method, of class Time.
     */
    @Test
    public void testSetTime_int_int() {
        System.out.println("setTime");
        int hours = 19;
        int minutes = 20;
        Time instance = new Time(12,40);
        instance.setTime(hours, minutes);
        assertEquals(new Time(19,20,00),instance);
    }

    /**
     * Test of toString method, of class Time.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Time instance = new Time(13,40,00);
        String expResult = "01:40:00 PM";
        String result = instance.toString();
        assertEquals(expResult, result);  
    }

    /**
     * Test of toStringHHMMSS method, of class Time.
     */
    @Test
    public void testToStringHHMMSS() {
        System.out.println("toStringHHMMSS");
        Time instance = new Time();
        String expResult = "00:00:00";
        String result = instance.toStringHHMMSS();
        assertEquals(expResult, result);      
    }

    /**
     * Test of equals method, of class Time.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object anotherObject = new Time(20,30,40);
        Time instance = new Time(20,30,40);
        Time anotherObject2=new Time(8,9,9);
        Date anotherObject3= new Date(2017,6,7);
        Date anotherObject4= null;
        boolean expResult = true;
        boolean result = instance.equals(anotherObject);
        assertEquals(expResult, result);
        boolean expResult2=false;
        boolean result2=instance.equals(anotherObject2);
        assertEquals(expResult2,result2);
        boolean expResult3=false;
        boolean result3=instance.equals(anotherObject3);
        assertEquals(expResult3, result3);
        boolean expResult4=false;
        boolean result4=instance.equals(anotherObject4);
        assertEquals(expResult4,result4);
    }

    /**
     * Test of hashCode method, of class Time.
     
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Time instance = new Time();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }**/

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Time anotherTime = new Time(8,9,9);
        Time instance = new Time(9,9,9);
        int expResult = 1;
        int result = instance.compareTo(anotherTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of tick method, of class Time.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        Time instance = new Time(12,8,9);
        instance.tick();
        Time expResult= new Time(12,8,10);
        assertEquals(expResult, instance);
    }

    /**
     * Test of isGreater method, of class Time.
     */
    @Test
    public void testIsGreater_Time() {
        System.out.println("isGreater");
        Time anotherTime = new Time(4,0,0);
        Time instance = new Time(20,9,9);
        boolean expResult = true;
        boolean result = instance.isGreater(anotherTime);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isGreater method, of class Time.
     */
    @Test
    public void testIsGreater_3args() {
        System.out.println("isGreater");
        int hours = 20;
        int minutes = 30;
        int seconds = 0;
        Time instance = new Time(8,40,0);
        boolean expResult = false;
        boolean result = instance.isGreater(hours, minutes, seconds);
        assertEquals(expResult, result);
    }

    /**
     * Test of differenceInSeconds method, of class Time.
     */
    @Test
    public void testDifferenceInSeconds() {
        System.out.println("differenceInSeconds");
        Time anotherTime = new Time(8,9,8);
        Time instance = new Time(8,9,10);
        int expResult = 2;
        int result = instance.differenceInSeconds(anotherTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of differenceInTime method, of class Time.
     */
    @Test
    public void testDifferenceInTime() {
        System.out.println("differenceInTime");
        Time anotherTime = new Time(9,9,9);
        Time instance = new Time(9,9,7);
        Time expResult = new Time(0,0,2);
        Time result = instance.differenceInTime(anotherTime);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of actualTime method, of class Time.
    
    @Test
    public void testActualTime() {
        System.out.println("actualTime");
        Time expResult = null;
        Time result = Time.actualTime();
        assertEquals(expResult, result);
    }
        **/
    
    
}
