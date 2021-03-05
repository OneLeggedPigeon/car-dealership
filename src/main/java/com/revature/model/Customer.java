package com.revature.model;

public class Customer extends User{

    public UserType getUserType(){
        return UserType.CUSTOMER;
    }

}
