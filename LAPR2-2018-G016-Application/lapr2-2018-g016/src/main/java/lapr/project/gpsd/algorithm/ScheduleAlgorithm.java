/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.algorithm;

import java.util.List;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceRequest;

/**
 *
 * @author Beatriz Ribeiro
 */
public interface ScheduleAlgorithm {
    /**
     * Returns the service request according to the schedule algorithm
     */
    void getServiceRequest();
   
}
