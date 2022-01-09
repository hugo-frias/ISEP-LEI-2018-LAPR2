/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.utils.Utils;
import model.collections.ZipCodeCollection;

/**
 *
 * @author Vera Pinto
 */
public class ExternalService {

    public ExternalService() {
    }

    public List<OperatesAt> getsOperatesAt(ZipCode zipCode, double operatingRadius) {
        List<OperatesAt> operatesAtList = new ArrayList<OperatesAt>();
        for (ZipCode zc : ZipCodeCollection.getInstance().getAllZipCodes()) {
                double d = Utils.getDistance(zc.getLatitude(), zc.getLongitude(), zipCode.getLatitude(), zipCode.getLongitude());
                if (d <= operatingRadius) {
                    OperatesAt ot = new OperatesAt(zc, d);
                    operatesAtList.add(ot);
                }
        }
        return operatesAtList;
    }


    
}
