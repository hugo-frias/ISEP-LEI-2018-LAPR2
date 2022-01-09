/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorizacao.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diogo Ribeiro
 */
public class User {

    /**
     * attribute that repsents user's name
     */
    private String name;

    /**
     * attribute that repsents user's email
     */
    private String email;

    /**
     * attribute that repsents user's password
     */
    private String password;

    /**
     * attribute that repsents user's role list
     */
    private List<UserRole> userRolesList = new ArrayList<>();

    /**
     * Creates User
     *
     * @param name - user's name
     * @param email - user's email
     * @param password - user's password
     */
    public User(String name, String email, String password) {

        if ((name == null) || (email == null) || (password == null) || (name.isEmpty()) || (email.isEmpty()) || (password.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments cannot be null or empty.");
        }

        this.name = name;
        this.email = email;
        this.password = password;

    }

    /**
     * public String getNome() { return this.name; }*
     * @return 
     */
    
      public String getEmail() { return this.email; }
    /**
     * Checks if user has email
     *
     * @param email - email to check
     * @return true or false
     */
    public boolean hasEmail(String email) {
        return this.email.equals(email);
    }

    /**
     * Checks if user has password
     *
     * @param password - user's password to check
     * @return true or false
     */
    public boolean hasPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Adds user role
     *
     * @param role - user's role
     * @return true or false
     */
    public boolean addRole(UserRole role) {
        if (role != null) {
            return this.userRolesList.add(role);
        }
        return false;
    }

    /**
     * Removes user role
     *
     * @param role - user's role
     * @return true or false
     */
    public boolean removeRole(UserRole role) {
        if (role != null) {
            return this.userRolesList.remove(role);
        }
        return false;
    }

    /**
     * Checks if user has role
     *
     * @param roleString - user's role
     * @return true or false
     */
    public boolean hasRole(String roleString) {
        for (UserRole role : this.userRolesList) {
            if (role.hasRole(roleString)) {
                return true;
            }
        }
        return false;
    }

    public List<UserRole> getRoles() {
        List<UserRole> list = new ArrayList<>();
        for (UserRole role : this.userRolesList) {
            list.add(role);
        }
        return list;
    }

    /**
     * Returns user's information
     *
     * @return String with user's information
     */
    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.email);
    }
}
