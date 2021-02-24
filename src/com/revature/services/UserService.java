package com.revature.services;

import com.revature.model.*;

import com.revature.collections.*;

public abstract class UserService {

    //ArrayList of all the usernames that have been instantiated
    static FlexArray users = new FlexArray();
    static User activeUser = null;

    public static User makeUser(String username, String password){
        User user = new User(username, password);
        users.add(user);
        return user;
    }

    //Is the username currently in use?
    public static boolean isUsernameDupe(String username){

        for( Object user : users.toArray()){

            if(username.equals(user.toString())){
                return true;
            }
        }
        return false;
    }

    //returns null if name not found
    public static User findUserByUsername(String username) {
        int i = 0;
        boolean found = false;
        User user = null;
        while(i < users.length() && !found){
            User current = (User) users.get(i);
            if(current.getUsername().equals(username)){
                found = true;
                user = current;
            }
            i++;
        }
        return user;
    }

    public static boolean isLoginValid(String username, String password) {
        // first check that user exists
        // then check if password matches
        User user = findUserByUsername(username);
        boolean result = false;
        if(user != null && user.getPassword().equals(password)){
            result = true;
        }
        return result;
    }
}
