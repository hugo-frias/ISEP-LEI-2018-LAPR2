/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Company;

/**
 *
 * @author André Novo
 */
public class SpecifyCategoryController {

    /**
     * Company variable
     */
    private Company company;

    /**
     * Category variable
     */
    private Category cat;

    /**
     * Empty Constructor
     */
    public SpecifyCategoryController() {
        this.company = GPSD.getInstance().getCompany();
    }

    /**
     * Creates a new Category
     *
     * @param cod
     * @param desc
     */
    public void newCategory(String cod, String desc) {
        cat = company.getCategoriesRegistry().newCategory(cod, desc);
    }

    /**
     * Validates category
     *
     * @return trur or false
     */
    public boolean validatesCategory() {
        return company.getCategoriesRegistry().validatesCategory(cat);
    }

    /**
     * Regists/Adds the new Category to the Registry's list
     * @ true or false
     */

    public boolean registCategory() {
        return company.getCategoriesRegistry().addCategory(cat);
    }

    /**
     * Returns the Category text
     *
     * @return
     */
    public String getCategoryString() {
        return cat.toString();
    }
}
