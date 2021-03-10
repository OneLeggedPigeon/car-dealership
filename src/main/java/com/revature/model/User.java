package com.revature.model;

public class User{

    private final int id;
    private final String username;
    private final String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserType getUserType(){
        return UserType.USER;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return getUsername();
    }
}
