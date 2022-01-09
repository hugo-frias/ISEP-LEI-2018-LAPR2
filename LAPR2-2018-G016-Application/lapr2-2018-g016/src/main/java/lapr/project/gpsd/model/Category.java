package lapr.project.gpsd.model;

import lapr.project.utils.*;
/**
 *
 * @author Andr� Novo
 * @author Beatriz Ribeiro
 */
public class Category {

    /**
     * variable that represents Category's id
     */
    private String id;

    /**
     * variable that represents Category's description
     */
    private String description;

    /**
     * Creates Category's instances
     *
     * @param id - Category's id
     * @param description - Category's description
     */
	 
    public Category(String id, String description) {
        Utils.validadeTwoStringFields(id, description);
        this.id = id;
        this.description = description;
    }

    /**
     * Copy Constructor of Category's instances
     *
     * @param cat - other category
     */
	 
    public Category(Category cat) {
		this.id = cat.id;
        this.description = cat.description;
    }

    /**
     * Returns the Category's id
     *
     * @return Category's id
     */
	 
    public String getId() {
        return id;
    }

    /**
     * Return's the Catgory's description
     *
     * @return Category's description
     */
	 
    public String getDescription() {
        return description;
    }

    /**
     * Returns Category's information
     *
     * @return Category's information
     */
    @Override
    public String toString() {
        return String.format("ID: %s%n Decription: %s", id, description);
    }

    /**
     * Compares two objects
     *
     * @param obj - another object
     * @return true or false
     */
	 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Category otherCategory = (Category) obj;
        return (otherCategory.id.equals(this.id) && otherCategory.description.equals(this.description));
    }
		
	
    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}