/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.autorizacao;

import lapr.project.autorizacao.model.User;
import lapr.project.autorizacao.model.UserRole;
import lapr.project.autorizacao.model.UserRolesRegistry;
import lapr.project.autorizacao.model.UserSession;
import lapr.project.autorizacao.model.UsersRegistry;

/**
 *
 * @author Diogo Ribeiro
 */
public class FacadeAuthorization {

    /**
     * attribute that represent the user session
     */
    private UserSession session = null;

    /**
     * attriute that represents user roles registry
     */
    private final UserRolesRegistry roles = new UserRolesRegistry();

    /**
     * atribute that represents users's registry
     */
    private final UsersRegistry users = new UsersRegistry();

    /**
     * Regists user role
     *
     * @param roleString - user role
     * @return true or false
     */
    public boolean registerUserRole(String roleString) {
        UserRole role = this.roles.newUserRole(roleString);
        return this.roles.addRole(role);
    }

    /**
     * Regists user
     *
     * @param name - user's name
     * @param email - user's email
     * @param password - user's password
     * @return true or false
     */
    public boolean registerUser(String name, String email, String password) {
        User user = this.users.newUser(name, email, password);
        return this.users.addUser(user);
    }

    /**
     * Regists user with roler
     *
     * @param name - user's name
     * @param email - user's email
     * @param password - user's password
     * @param roleString - user's role
     * @return true or false
     */
    public boolean registerUserWithRole(String name, String email, String password, String roleString) {
        UserRole role = this.roles.searchRole(roleString);
        User user = this.users.newUser(name, email, password);
        user.addRole(role);
        return this.users.addUser(user);
    }

    /**
     * public boolean registaUtilizadorComPapeis(String strNome, String
     * strEmail, String strPassword, String[] papeis) { Utilizador utlz =
     * this.users.novoUtilizador(strNome, strEmail, strPassword); for (String
     * strPapel : papeis) { PapelUtilizador papel =
     * this.m_oPapeis.procuraPapel(strPapel); utlz.addPapel(papel); }
     *
     * return this.users.addUtilizador(utlz); }
     */
    /**
     * Checks if there is an user
     *
     * @param email - user's email
     * @return true or false
     */
    public boolean thereIsAUser(String email) {
        return this.users.hasUser(email);
    }

    /**
     * Logins the user
     *
     * @param email - user's mail
     * @param password - user's password
     * @return true or false
     */
    public UserSession doLogin(String email, String password) {
        User user = this.users.searchUser(email);
        if (user != null) {
            if (user.hasPassword(password)) {
                this.session = new UserSession(user);
            }
        }
       
        return getCurrentSession();
    }

    /**
     * Returns current user session
     * @return user session
     */
    public UserSession getCurrentSession() {
        return this.session;
    }

    /**
     * Does the logout of the user
     */
    public void doLogout() {
        if (this.session != null) {
            this.session.doLogout();
            this.session = null;
        }
    }
}
