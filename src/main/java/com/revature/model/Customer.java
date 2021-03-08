package com.revature.model;

import com.revature.collections.FlexArray;

public class Customer extends User{
    private FlexArray<Car> cars;
    private FlexArray<Offer> offers;
    private FlexArray<Payment> payments;

    public Customer(int id, String username, String password) {
        super(id,username,password);
    }

    public UserType getUserType(){
        return UserType.CUSTOMER;
    }

}
