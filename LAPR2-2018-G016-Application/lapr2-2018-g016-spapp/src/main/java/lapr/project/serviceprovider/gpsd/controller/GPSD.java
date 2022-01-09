package lapr.project.serviceprovider.gpsd.controller;

import lapr.project.serviceprovider.gpsd.model.Company;
import lapr.project.serviceprovider.utils.CompanyFinals;

/**
 *
 * @author Diogo Ribeiro
 */
public class GPSD {

    private final Company company;

    private GPSD() {
        this.company = new Company(CompanyFinals.COMPANY_NAME, CompanyFinals.COMPANY_NIF);
    }

    public Company getCompany() {
        return this.company;
    }
    
    private static GPSD singleton = null;

    public static GPSD getInstance() {
        if (singleton == null) {
            synchronized (GPSD.class) {
                singleton = new GPSD();
            }
        }
        return singleton;
    }
}
