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
public class UsersRegistry {

    private List<User> usersList = new ArrayList<>();

    public User newUser(String name, String email, String password) {
        return new User(name, email, password);
    }

    public boolean addUser(User user) {
        if (user != null) {
            return this.usersList.add(user);
        }
        return false;
    }

    public boolean removeUser(User user) {
        if (user != null) {
            return this.usersList.remove(user);
        }
        return false;
    }

    public User searchUser(String email) {
        for (User user : this.usersList) {
            if (user.hasEmail(email)) {
                return user;
            }
        }
        return null;
    }

    public boolean hasUser(String email) {
        User user = searchUser(email);
        return user != null;
    }
    
}
