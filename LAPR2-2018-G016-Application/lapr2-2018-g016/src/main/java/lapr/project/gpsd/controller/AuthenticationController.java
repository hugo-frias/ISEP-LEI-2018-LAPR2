/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.GPSD.GPSD;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.autorizacao.model.UserRole;

/**
 * Controller for authentication
 *
 * @author paulomaio
 */
public class AuthenticationController {

    /**
     * Creates AuthenticationController's intances
     */
    public AuthenticationController() {
    }

    /**
     * Returns GPSD instance
     *
     * @return gpsd
     */
    public GPSD getGpsd() {
        if(GPSD.getInstance()==null){
            return null;
        }
        return GPSD.getInstance();
    }

    /**
     * Does the login
     *
     * @param email - user's email
     * @param pwd - user' password
     * @return true or false
     */
    public boolean doLogin(String email, String pwd) {
        return GPSD.getInstance().doLogin(email, pwd);
    }

    /**
     * Returns UserRoles list
     *
     * @return user roles's list
     */
    public List<UserRole> getUserRoles() {
        List<UserRole> result = new ArrayList<>();
        if (!GPSD.getInstance().getCurrentSession().isLoggedIn()) {
            result = null;
        }else{
            result =GPSD.getInstance().getCurrentSession().getUserRoles();
        }
        if (result == null) {
            throw new RuntimeException();
        } else {
            return result;
        }
    }

    /**
     * Does the logout
     */
    public void doLogout() {
        GPSD.getInstance().doLogout();
    }

}
