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
public class UserRolesRegistry {

    private List<UserRole> userRolesList = new ArrayList<>();

    public UserRole newUserRole(String role) {
        return new UserRole(role);
    }

    /**public UserRole newUserRole(String role, String description) {
        return new UserRole(role, description);
    }**/

    public boolean addRole(UserRole role) {
        if (role != null) {
            return this.userRolesList.add(role);
        }
        return false;
    }

    public boolean removeRole(UserRole role) {
        if (role != null) {
            return this.userRolesList.remove(role);
        }
        return false;
    }

    public UserRole searchRole(String role) {
        for (UserRole r : this.userRolesList) {
            if (r.hasRole(role)) {
                return r;
            }
        }
        return null;
    }

    public boolean hasRole(String roleString) {
        UserRole role = searchRole(roleString);
        return role != null;
    }

    public List<UserRole> getRoles() {
        List<UserRole> list = new ArrayList<>();
        for (UserRole role : this.userRolesList) {
            list.add(role);
        }
        return list;
    }
}
