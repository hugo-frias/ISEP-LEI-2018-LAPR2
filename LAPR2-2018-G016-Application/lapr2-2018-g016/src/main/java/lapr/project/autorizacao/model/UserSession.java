/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorizacao.model;

import java.util.List;

/**
 *
 * @author Diogo Ribeiro
 */
public class UserSession {

    /**
     * attribute that represents user
     */
    private User user=null;

    /**
     * public final User USER_FOR_OMISSION = null;
     *
     * private UserSession() { this.user = USER_FOR_OMISSION; }*
     */
    /**
     * Creates User session
     *
     * @param user - user
     */
    public UserSession(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Argument cannot be null.");
        }
        this.user = user;
    }

    /**
     * Does logout of this session
     */
    public void doLogout() {
        this.user = null;
    }

    /**
     * Checks if user is logged in
     *
     * @return true or false
     */
    public boolean isLoggedIn() {
        return this.user != null;
    }

    /**
     * Checks if user is logged in with role
     *
     * @param role - user's role
     * @return true or false
     */
    public boolean isLoggedInWithRole(String role) {
        if (isLoggedIn()) {
            return this.user.hasRole(role);
        }
        return false;
    }

    
    /**
     * public String getUserName() { if (isLoggedIn()) { this.user.getNome(); }
     * return null; }
     *
     **/
     public String getUserEmail() { 
         if (isLoggedIn()) { 
         return this.user.getEmail();
      } 
         return null; }
     
     public List<UserRole> getUserRoles() { return this.user.getRoles(); }
     
     
    
}
