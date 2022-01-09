package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.registry.GeographicalsAreasRegistry;

public class GeographicalAreaController {

    private Company company;

    private GeographicalArea ga;

    public GeographicalAreaController()  {
        this.company= GPSD.getInstance().getCompany();
    }

    public GeographicalArea newGeographicalArea(String name, double travelCost, String zipCode, double operatingRadius) throws FileNotFoundException, ParseException {
        GeographicalsAreasRegistry gar = this.company.getGeographicalAreaResgitry();
        ga = gar.newGeographicalArea(name, travelCost, zipCode, operatingRadius);
        return ga;
    }

    public void registerGeographicalArea(GeographicalArea ga) {
        GeographicalsAreasRegistry registry = this.company.getGeographicalAreaResgitry();
        if (registry != null) registry.registerGeographicalArea(ga);
    }
}
