package com.revature.model;

public class Employee extends User{

    public Employee(int id, String username, String password) {
        super(id,username,password);
    }

    public UserType getUserType(){
        return UserType.EMPLOYEE;
    }
}
