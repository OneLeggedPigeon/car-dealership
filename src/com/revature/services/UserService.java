package com.revature.services;

import com.revature.people.*;

import com.revature.collections.*;

public abstract class UserService {

    //ArrayList of all the usernames that have been instantiated
    static FlexArray usernames = new FlexArray();

    public static User makeUser(String username, String password){
        usernames.add(username);
        return new User(username, password);
    }

    //Is the username currently in use?
    public static boolean isUsernameDupe(String username){

        for( Object name : usernames.toArray()){

            if(name.equals(username)){
                return true;
            }
        }
        return false;
    }
}
