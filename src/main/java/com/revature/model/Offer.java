package com.revature.model;

public class Offer {
    private int id;
    private int amount;
    private Customer customer;
    private Car car;

    public Offer(int id, Customer customer, Car car, int amount) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }
}
