package com.revature.model;

// held in an array by car
public class Offer {
    private final int id;
    private final int amount;
    private final Customer customer;
    private final Car car;

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

    public String toString(){
        return "id: "+id+" "+customer.getUsername()+" offers $"+amount+" for "+car.getModel();
    }

    // remove all references to the offer
    public void remove(){
        customer.getOffers().remove(this);
        car.getOffers().remove(this);
    }
}
