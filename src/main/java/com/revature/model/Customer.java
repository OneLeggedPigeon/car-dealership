package com.revature.model;

public class Customer extends User{

    public Customer(String username, String password) {
        super(username,password);
    }

    public UserType getUserType(){
        return UserType.CUSTOMER;
    }

}
