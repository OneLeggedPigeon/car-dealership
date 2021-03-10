package com.revature.model;

public class User{

    private int id;
    private String username;
    private String password;

    public User(){

    }

    public User(String username){
        this.username = username;
    }

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
