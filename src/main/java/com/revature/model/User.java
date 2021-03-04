package com.revature.model;

public class User{

    private String username;
    private String password;
    private UserType userType;

    public User(){
        userType = UserType.USER;
    }

    public User(String username){
        userType = UserType.USER;
        this.username = username;
    }

    public User(String username, String password) {
        userType = UserType.USER;
        this.username = username;
        this.password = password;
    }

    public UserType getUserType(){
        return userType;
    }

    public void setUserType(UserType type){
        userType = type;
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