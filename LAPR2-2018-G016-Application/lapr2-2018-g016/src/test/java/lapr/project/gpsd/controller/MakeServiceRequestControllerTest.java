/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.LimitedService;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceType;
import lapr.project.gpsd.model.ZipCode;
import lapr.project.utils.Date;
import lapr.project.utils.Time;
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
public class MakeServiceRequestControllerTest {

    public MakeServiceRequestControllerTest() {
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
     * Test of newServiceRequest method, of class MakeServiceRequestController.
     */
    @Test
    public void testNewServiceRequest() throws FileNotFoundException, ParseException {
        System.out.println("newServiceRequest");
        MakeServiceRequestController instance = new MakeServiceRequestController();
        ZipCode zc = new ZipCode("4000-011");
        PostalAddress pa = new PostalAddress("Street X", zc, "Location Y");
        Client cli = new Client("Jose", 123456789, 123456789, "g@mail.pt", pa);
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "teste");
        GPSD.getInstance().doLogin("g@mail.pt", "teste");
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "psw");
        List<PostalAddress> expResult = new ArrayList<PostalAddress>();
        expResult.add(pa);
        List<PostalAddress> result = instance.newServiceRequest();
        assertEquals(expResult, result);

    }

    /**
     * Test of addToServiceRequest method, of class
     * MakeServiceRequestController.
     */
    @Test
    public void testAddToServiceRequest() {
        MakeServiceRequestController instance = new MakeServiceRequestController();
        ZipCode zc = new ZipCode("4000-011");
        PostalAddress pa = new PostalAddress("Street X", zc, "Location Y");
        Client cli = new Client("Jose", 123456789, 123456789, "g@mail.pt", pa);
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "teste");
        GPSD.getInstance().doLogin("g@mail.pt", "teste");
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "psw");
        List<PostalAddress> listPA = instance.newServiceRequest();
        instance.setEndPostal(pa);
        System.out.println("addToServiceRequest");
        Category category = new Category("cat3", "xxx");
        ServiceType serviceType = new ServiceType("Limited", "lapr.project.gpsd.model.LimitedService");
        Service serv = new LimitedService("serv1", "teste", "test", 2, category, serviceType);
        String desc = "xxx";
        int period = 120;
        boolean expResult = true;
        boolean result = instance.addToServiceRequest(serv, desc, period);
        assertEquals(expResult, result);

    }

    /**
     * Test of addSchedule method, of class MakeServiceRequestController.
     */
    @Test
    public void testAddSchedule() {
        MakeServiceRequestController instance = new MakeServiceRequestController();
        ZipCode zc = new ZipCode("4000-011");
        PostalAddress pa = new PostalAddress("Street X", zc, "Location Y");
        Client cli = new Client("Jose", 123456789, 123456789, "g@mail.pt", pa);
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "teste");
        GPSD.getInstance().doLogin("g@mail.pt", "teste");
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "psw");
        List<PostalAddress> listPA = instance.newServiceRequest();
        instance.setEndPostal(pa);
        System.out.println("addSchedule");
        Date date = new Date(2019, 10, 1);
        Time hour = new Time(23, 00, 00);
        boolean expResult = true;
        boolean result = instance.addSchedule(date, hour);
        assertEquals(expResult, result);
         boolean result2 = instance.addSchedule(date, hour);
         boolean expResult2=false;
         assertEquals(expResult, result);
        
    }

    /**
     * Test of computesCost method, of class MakeServiceRequestController.
     *
     *
     */
    @Test
    public void testComputesCost() {
        MakeServiceRequestController instance = new MakeServiceRequestController();
        ZipCode zc = new ZipCode("4000-011");
        PostalAddress pa = new PostalAddress("Street X", zc, "Location Y");
        Client cli = new Client("Jose", 123456789, 123456789, "g@mail.pt", pa);
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "teste");
        GPSD.getInstance().doLogin("g@mail.pt", "teste");
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "psw");
        List<PostalAddress> listPA = instance.newServiceRequest();
        instance.setEndPostal(pa);
        GeographicalArea ga = new GeographicalArea("Porto", 2, 7000, "4000-007");
        GPSD.getInstance().getCompany().getGeographicalAreaResgitry().registerGeographicalArea(ga);
        System.out.println("computesCost");
        Category category = new Category("cat3", "xxx");
        ServiceType serviceType = new ServiceType("Limited", "lapr.project.gpsd.model.LimitedService");
        Service serv = new LimitedService("serv1", "teste", "test", 60, category, serviceType);
        String desc = "xxx";
        int period = 120;
        instance.addToServiceRequest(serv, desc, period);
       
        instance.computesCost();
        
    }

    /**
     * Test of registsServicerequest method, of class
     * MakeServiceRequestController.
     *
     *
     */
    @Test
    public void testRegistsServicerequest() {
        System.out.println("registsServicerequest");
        MakeServiceRequestController instance = new MakeServiceRequestController();
        ZipCode zc = new ZipCode("4000-011");
        PostalAddress pa = new PostalAddress("Street X", zc, "Location Y");
        Client cli = new Client("Jose", 123456789, 123456789, "g@mail.pt", pa);
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "teste");
        GPSD.getInstance().doLogin("g@mail.pt", "teste");
        GPSD.getInstance().getCompany().getClientsRegistry().registerClient(cli, "psw");
        List<PostalAddress> listPA = instance.newServiceRequest();
        instance.setEndPostal(pa);
        boolean expResult = true;
        boolean result = instance.registsServicerequest();
        assertEquals(expResult, result);
        boolean expResult2 = false;
        boolean result2 = instance.registsServicerequest();
    }

   

}
