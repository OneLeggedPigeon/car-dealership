package com.revature.model;

import com.revature.collections.FlexArray;
import com.revature.service.CarService;

import java.util.Optional;

public class Car {
    private final int id;
    private final String model;
    private Customer owner;

    //FlexArray of all offers for a car
    private FlexArray<Offer> offers;


    public Car(int id, String model){
        this.id = id;
        this.model = model;
        try {
            offers = new FlexArray<>(Class.forName("com.revature.model.Offer"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Car(int id, String model, Customer owner){
        this.id = id;
        this.model = model;
        this.owner = owner;
        try {
            offers = new FlexArray<>(Class.forName("com.revature.model.Offer"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FlexArray<Offer> getOffers() {
        return offers;
    }

    public void addOffer(Offer offer) {
        offers.add(offer);
    }

    public boolean inLot(){
        return CarService.inLot(this);
    }

    public String getModel() {
        return model;
    }

    public int getId() {
        return id;
    }

    public Optional<Customer> getOwner() {
        return Optional.ofNullable(owner);
    }

    public void setOwner(Customer customer) {
        owner = customer;
    }

    public String toString(){
       return id + ": " + model;
    }

}