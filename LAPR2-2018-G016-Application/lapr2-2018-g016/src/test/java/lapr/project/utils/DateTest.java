/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.time.Month;
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
public class DateTest {
    
    public DateTest() {
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
     * Test of getYear method, of class Date.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Date instance = new Date(2019,4,5);
        int expResult = 2019;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class Date.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Date instance = new Date(2019,6,12);
        int expResult = 6;
        int result = instance.getMonth();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getDay method, of class Date.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Date instance = new Date(2019,12,3);
        int expResult = 3;
        int result = instance.getDay();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDate method, of class Date.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        int year = 2019;
        int month = 3;
        int day = 21;
        Date instance = new Date();
        int expResult=21;
        instance.setDate(year, month, day);
        assertEquals(expResult, day);
    }

    /**
     * Test of toString method, of class Date.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Date instance = new Date();
        String expResult =instance.weekDay()+", "+ instance.getDay()+" of January of "+ instance.getYear();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toYearMonthDayString method, of class Date.
     */
    @Test
    public void testToYearMonthDayString() {
        System.out.println("toYearMonthDayString");
        Date instance = new Date(1,1,1);
        String expResult = "0001/01/01";
        String result = instance.toYearMonthDayString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class Date.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object anotherObject = new Date(2019,7,8);
        Time time = new Time(20,30,00);
        Date instance = new Date(2019,7,8);
        boolean expResult = true;
        boolean result = instance.equals(anotherObject);
        assertEquals(expResult, result);
        boolean expResult2= false;
        boolean result2= instance.equals(time);
        assertEquals(expResult2, result2);
        Date date = null;
        boolean expResult3=false;
        boolean result3=instance.equals(date);
        assertEquals(expResult3, result3);
        boolean expResult4= true;
        boolean result4=instance.equals(instance);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of hashCode method, of class Date.
     
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Date instance = new Date();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    **/

    /**
     * Test of compareTo method, of class Date.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Date otherDate = new Date(2019,7,8);
        Date otherDate2= new Date(2019,4,21);
        Date otherDate3= new Date(2019,3,7);
        Date instance = new Date(2019,4,21);
        int expResult = -1;
        int result = instance.compareTo(otherDate);
        assertEquals(expResult, result);
        int expResult2=0;
        int result2= instance.compareTo(otherDate2);
        assertEquals(expResult2,result2);
        int expResult3=1;
        int result3= instance.compareTo(otherDate3);
        assertEquals(expResult3,result3);
    }

    /**
     * Test of weekDay method, of class Date.
     */
    @Test
    public void testWeekDay() {
        System.out.println("weekDay");
        Date instance = new Date(2019,6,12);
        String expResult = "Wednesday";
        String result = instance.weekDay();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isGreater method, of class Date.
     */
    @Test
    public void testIsGreater() {
        System.out.println("isGreater");
        Date anotherDate = new Date(2019,3,4);
        Date anotherDate2= new Date(2019,2,3);
        Date instance = new Date(2019,3,2);
        boolean expResult = false;
        boolean result = instance.isGreater(anotherDate);
        assertEquals(expResult, result);
        boolean expResult2=true;
        boolean result2=instance.isGreater(anotherDate2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of difference method, of class Date.
     */
    @Test
    public void testDifference_Date() {
        System.out.println("difference");
        Date anotherDate = new Date(2019,7,7);
        Date instance = new Date(2019,7,5);
        int expResult = 2;
        int result = instance.difference(anotherDate);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of difference method, of class Date.
     */
    @Test
    public void testDifference_3args() {
        System.out.println("difference");
        int year = 2019;
        int month = 3;
        int day = 4;
        Date instance = new Date(2019,3,7);
        int expResult = 3;
        int result = instance.difference(year, month, day);
        assertEquals(expResult, result);
    }

    /**
     * Test of leapYear method, of class Date.
     */
    @Test
    public void testLeapYear() {
        System.out.println("leapYear");
        int year = 2018;
        boolean expResult = false;
        int year2= 2020;
        boolean result = Date.leapYear(year);
        boolean result2= Date.leapYear(year2);
        boolean expResult2=true;
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of nextDay method, of class Date.
     */
    @Test
    public void testNextDay() {
        System.out.println("nextDay");
        Date instance = new Date(2019,6,7);
        Date expResult = new Date(2019,6,8);
        Date result = instance.nextDay();
        assertEquals(expResult, result);
        
    }
}
