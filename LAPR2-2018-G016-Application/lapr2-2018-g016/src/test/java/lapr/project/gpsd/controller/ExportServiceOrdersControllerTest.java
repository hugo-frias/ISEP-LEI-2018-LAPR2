/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.FileFormat;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.utils.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author André Novo
 */
public class ExportServiceOrdersControllerTest {
    
    public ExportServiceOrdersControllerTest() {
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
     * Test of getPeriodicServiceOrders method, of class ExportServiceOrdersController.
     */
    @Test
    public void testGetPeriodicServiceOrders() {
         RegisterServiceProviderController rsoc = new RegisterServiceProviderController();
         rsoc.newServiceProvider("Joaquina Dos Santos", "Rua Z", "4470-526", "Porto");
        rsoc.setAditionalData("10003", "jaquina@hotmail.com");
        rsoc.registServiceProvider();
        
        System.out.println("getPeriodicServiceOrders");
        Date beginning = new Date (2000, 02, 19);
        Date ending = new Date (2000, 10, 21);
        GPSD.getInstance().doLogin("jaquina@hotmail.com", "teste");
        ExportServiceOrdersController instance = new ExportServiceOrdersController();
        List<ServiceOrder> expResult = new ArrayList<ServiceOrder>();
        List<ServiceOrder> result = instance.getPeriodicServiceOrders(beginning, ending);
        assertEquals(expResult, result);
        GPSD.getInstance().doLogout();
    }

    /**
     * Test of exportFile method, of class ExportServiceOrdersController.
     * @throws java.lang.Exception
     */
    
    @Test
    public void testExportFile() throws Exception {
        System.out.println("exportFile");
        FileFormat ff = new FileFormat("csv", "exporter.adapters.CSVExporterAdapter");
        String nameFile = "testing";
        ExportServiceOrdersController instance = new ExportServiceOrdersController();
        instance.exportFile(ff, nameFile);
    }
    
}
