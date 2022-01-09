/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.algorithm;

import com.sun.javafx.scene.traversal.Algorithm;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.IllegalAccessException;
import java.lang.reflect.InvocationTargetException;
import lapr.project.gpsd.GPSD.GPSD;
import lapr.project.gpsd.model.Company;

/**
 *
 * @author Beatriz Ribeiro
 */
public class TaskFactory {

    private static TaskFactory _instance = null;

    private TaskFactory() {
        this.createAlgorithm();
    }

    public static TaskFactory getInstance() {
        if (_instance == null) {
            _instance = new TaskFactory();
        }

        return _instance;
    }

    public void createAlgorithm() {
        Properties props = new Properties();
        // Lê as propriedades e valores definidas 
        try {
            InputStream in = new FileInputStream("config.properties");
            props.load(in);
            in.close();

            Class<?> oClass = Class.forName(props.getProperty("Company.ScheduleAlgorithm.Class"));
            Class[] argsClasses = new Class[]{};
            Constructor constructor = oClass.getConstructor(argsClasses);
            Object[] argsValues = new Object[]{};
            ScheduleAlgorithm algorithm = (ScheduleAlgorithm) constructor.newInstance(argsValues);
            Timer timer = new Timer();
           Company company= GPSD.getInstance().getCompany();
            int x = Integer.parseInt(props.getProperty("Company.ScheduleAlgorithm.Delay"));
            timer.schedule((TimerTask) algorithm, Integer.parseInt(props.getProperty("Company.ScheduleAlgorithm.Delay")), Integer.parseInt(props.getProperty("Company.ScheduleAlgorithm.Period")));
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }

    }
}
