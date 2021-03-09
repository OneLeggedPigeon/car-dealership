package com.revature.model;

public class Offer {
    private int id;
    private int amount;
    private Customer customer;

    public Offer(int amount, Customer customer, Car car) {
        this.amount = amount;
        this.customer = customer;
        car.addOffer(this);
    }
}
