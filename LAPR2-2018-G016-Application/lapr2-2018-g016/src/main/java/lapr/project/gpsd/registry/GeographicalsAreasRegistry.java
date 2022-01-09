/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.registry;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import lapr.project.gpsd.model.GeographicalArea;
import lapr.project.gpsd.model.OperatesAt;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ZipCode;
import lapr.project.utils.Utils;

/**
 * Class of GeographicalsAreasRegistry
 *
 * @author Beatriz Ribeiro
 */
public class GeographicalsAreasRegistry {

    /**
     * list that has all Company's Geographicals Areas
     */
    private List<GeographicalArea> geographicalsAreas;

    /**
     * Creates a list of Geographicals Areas
     */
    public GeographicalsAreasRegistry() {
        geographicalsAreas = new ArrayList<GeographicalArea>();
    }

    /**
     * Returns a list of Geographicals Areas
     *
     * @return geographicals areas
     */
    public List<GeographicalArea> getGeographicalAreas() {
        return geographicalsAreas;
    }

    /**
     * Validates geographical areas
     *
     * @param ga geographical area
     * @return
     */
    private boolean validateGeographicalArea(GeographicalArea ga) {
        if (!this.geographicalsAreas.contains(ga)) {
            return true;
        }
        return false;
    }

    /**
     * Adds the geographical area to the list
     *
     * @param ga geographical area to add
     */
    private void addGeographicalArea(GeographicalArea ga) {
        geographicalsAreas.add(ga);
    }

    /**
     * Creates a new geographical area
     *
     * @param name name of the geographical area
     * @param travelCost cost of travel
     * @param zipCodeString zip code
     * @param operatingRadius operating radius of the geographical area
     * @return geographical area
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public GeographicalArea newGeographicalArea(String name, double travelCost, String zipCodeString, double operatingRadius) throws FileNotFoundException, ParseException {
        return new GeographicalArea(name, travelCost, operatingRadius, zipCodeString);
    }

    /**
     * registers geographical area
     *
     * @param ga geographical area to register
     */
    public void registerGeographicalArea(GeographicalArea ga) {
        boolean validation = validateGeographicalArea(ga);
        if (validation) {
            this.geographicalsAreas.add(ga);
        }

    }

    /**
     * Returns nearest geographicala area
     *
     * @param zipC - zipCode
     * @return geographical area
     */
    public GeographicalArea getAreaGeograficaMaisPerto(ZipCode zipC) {
        List<GeographicalArea> nearestGeographicalAreas = new ArrayList<GeographicalArea>();
        for (GeographicalArea geographicalArea : this.geographicalsAreas) {
            List<OperatesAt> OperatesAtList = geographicalArea.getOperatesAt();
            for (OperatesAt atuaEm : OperatesAtList) {
                if (atuaEm.getZc().equals(zipC)) {
                    nearestGeographicalAreas.add(geographicalArea);
                    break;
                }
            }
        }
        if (nearestGeographicalAreas.size() >= 1) {
            double minDist = Utils.getDistance(nearestGeographicalAreas.get(0).getZipCode().getLatitude(), nearestGeographicalAreas.get(0).getZipCode().getLongitude(), zipC.getLatitude(), zipC.getLongitude());
            GeographicalArea gaMin = nearestGeographicalAreas.get(0);
            for (GeographicalArea ga : nearestGeographicalAreas) {
                double dist = Utils.getDistance(ga.getZipCode().getLatitude(), ga.getZipCode().getLongitude(), zipC.getLatitude(), zipC.getLongitude());
                if (dist<minDist) {
                    gaMin=ga;
                }
            }
            return gaMin;
        }
        return null;
    }
}
