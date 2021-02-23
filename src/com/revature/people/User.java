package com.revature.people;

public class User{

    private String username;
    private String password;

    public User(){

    }
    public User(String username){

        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toString(){
        return username;
    }
}
