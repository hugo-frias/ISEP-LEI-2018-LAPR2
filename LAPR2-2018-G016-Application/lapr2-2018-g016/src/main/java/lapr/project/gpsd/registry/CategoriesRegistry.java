/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.registry;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;

/**
 * Class of Categories Registry
 *
 * @author(s) Beatriz Ribeiro and Andre Novo
 */
public class CategoriesRegistry {

    /**
     * list that has all Company's Categories
     */
    private List<Category> categories;

    /**
     * Creates a list of Categories
     */
    public CategoriesRegistry() {
        categories = new ArrayList<>();
    }

    /**
     * Returns a list of Categories
     *
     * @return categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * Creates a new Category
     *
     * @param cod
     * @param desc
     * @return the new Category
     */
    public Category newCategory(String cod, String desc) {
        return new Category(cod, desc);
    }

    /**
     * validates Category
     * @param cat - category
     * @return true or false
     */
    public boolean validatesCategory(Category cat) {
        if (!categories.contains(cat)) {
            return true;
        }
        return false;
    }

    /**
     * Adds a category to the list
     *
     * @param cat - category
     * @return true or false
     */

    public boolean addCategory(Category cat) {

        return categories.add(cat);

    }
    

}
