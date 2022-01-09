/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorizacao.model;

/**
 *
 * @author Diogo Ribeiro
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class UserRole
{
    /**
     * attribute that represents user role
     */
    private String role;
    
    /**
     * attribute that represents role description
     
    private String description;
    
    public final String DESCRIPTION_FOR_OMISSION = "no description";
    **/
    /**
     * Creates user role
     * @param role - user role
     */
    public UserRole(String role)
    {
        if ( (role == null) || (role.isEmpty()))
            throw new IllegalArgumentException("The argument cannot be null or empty.");
        
        this.role = role;
        //this.description = DESCRIPTION_FOR_OMISSION;
    }
    
    /**public UserRole(String role, String description)
    {
        if ( (role == null) || (description == null) || (role.isEmpty())|| (description.isEmpty()))
            throw new IllegalArgumentException("None of the arguments cannot be null or empty.");
        
        this.role = role;
        this.description = description;
    }**/
    
    /**
     * Returns user role
     * @return String with user role
     */
    public String getRole()
    {
        return this.role;
    }
    
    /**public String getDescription()
    {
        return this.description;
    }**/

    /**
     * Checks if user has role
     * @param roleString - user role to compare
     * @return true or false
     */
    public boolean hasRole(String roleString)
    {
        return this.role.equals(roleString);
    }

    /**
     * Returns user role information
     * @return String with user role information
     */
    @Override
    public String toString()
    {
        return String.format("%s "/**- %s**/, this.role/**, this.description**/);
    }
     
}

