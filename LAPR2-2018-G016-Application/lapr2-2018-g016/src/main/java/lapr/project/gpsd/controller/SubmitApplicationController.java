/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;
import lapr.project.gpsd.model.Application;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.PostalAddress;
import lapr.project.gpsd.model.ZipCode;

/**
 *
 * @author momog
 */
public class SubmitApplicationController {

    private final Company company;

    private Application app;

    public SubmitApplicationController() throws FileNotFoundException, ParseException {
        company = GPSD.getInstance().getCompany();
    }

    public boolean newApplication(String name, String nif, String phoneNumber, String email, String address, String zipCodeAux, String locality) {
        if (Application.validateAdress(address, locality, zipCodeAux) == true) {
            ZipCode zipCode = new ZipCode(zipCodeAux);
            PostalAddress addr1 = new PostalAddress(address, zipCode, locality);
            if (Application.validateName(name, nif, phoneNumber, email) == true) {
                app = company.getApplicationsRegistry().newApplication(name, Integer.parseInt(nif), Integer.parseInt(phoneNumber), email, addr1);
                return true;
            }
        }
        return false;
    }

    public boolean addAcadQualification(String designation, String degree, String classification) {
        return app.addAcadQualifications(designation, degree, classification);
    }

    public boolean addProQualification(String description) {
        return app.addProQualification(description);
    }

    public List<Category> getCategories() {
        return company.getCategoriesRegistry().getCategories();
    }

    public boolean addCategory(Category category) {
        return app.addCategory(category);
    }

    public void registerApplication() {
        if (company.getApplicationsRegistry().validatesApplication(app)) {
            company.getApplicationsRegistry().addApplication(app);
        }
    }

    public String printApp() {
        return app.toString();
    }
}
