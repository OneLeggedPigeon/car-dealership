package com.revature.service;

import com.revature.model.*;

import com.revature.collections.*;

public abstract class UserService {

    //ArrayList of all the usernames that have been instantiated
    static HashMap<String,User> users = new HashMap<String,User>();
    static User activeUser = null;

    public static User makeUser(String username, String password){
        User user = new User(username, password);
        users.put(username, user);
        return user;
    }

    // Change a User to a Customer
    public static Customer registerUser(User u){
        Customer c = new Customer(u.getUsername(),u.getPassword());
        users.put(u.getUsername(), c);
        return c;
    }

    //Is the username currently in use?
    public static boolean isUsernameDupe(String username){
        return users.get(username) != null;
    }

    //returns null if name not found
    public static User getUserByUsername(String username) {
        return users.get(username);
    }
}
