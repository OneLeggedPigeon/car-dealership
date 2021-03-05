package com.revature.model;

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

    public UserType getUserType(){
        return UserType.USER;
    }

    public String getUsername(){
        return username;
    }

    public Object getPassword() {
        return password;
    }

    public String toString(){
        return getUsername();
    }
}
