package com.revature.model;

import com.revature.collections.FlexArray;
import com.revature.service.CarService;

import java.util.Optional;

public class Car {
    private int id;
    private String model;
    private Customer owner;

    //FlexArray of all offers for a car
    private FlexArray<Offer> offers;


    public Car(int id, String model){
        this.id = id;
        this.model = model;
        try {
            offers = new FlexArray<Offer>(Class.forName("com.revature.model.Offer"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Car(int id, String model, Customer owner){
        this.id = id;
        this.model = model;
        this.owner = owner;
        try {
            offers = new FlexArray<Offer>(Class.forName("com.revature.model.Offer"));
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

    public void clearOffers() {
        offers.Clear();
    }

    public boolean inLot(){
        return CarService.inLot(this);
    }

    public String getModel() {
        return model;
    }

    public int getID() {
        return id;
    }

    public Optional<Customer> getOwner() {
        return Optional.ofNullable(owner);
    }

    public String toString(){
       return id + ": " + model;
    }

    /*public void setModel(String model) {
        this.model = model;
    }*/

}