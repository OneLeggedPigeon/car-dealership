package com.revature.model;

public class Employee extends User{

    public UserType getUserType(){
        return UserType.EMPLOYEE;
    }
}
