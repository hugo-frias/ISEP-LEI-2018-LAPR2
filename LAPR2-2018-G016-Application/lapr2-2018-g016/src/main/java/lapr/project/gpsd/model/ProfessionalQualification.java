package lapr.project.gpsd.model;

import java.util.Objects;

/**
 *
 * @author André Novo
 */
public class ProfessionalQualification {
    
    /**
     * 
     */
    
    private String description;
    
    
    /**
     * 
     * @param description 
     */
    
    public ProfessionalQualification (String description) {
        if(description==null || description.isEmpty()){
            throw new NullPointerException();
        }
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * 
     * @param obj
     * @return 
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
        final ProfessionalQualification other = (ProfessionalQualification) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @return 
     */
    
    @Override
    public String toString() {
        return String.format("%s", description);
    }
}
