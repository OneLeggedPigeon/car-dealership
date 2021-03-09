package com.revature.model;

import com.revature.service.CarService;

import java.util.Optional;

public class Car {
    private int id;
    private String model;
    private Customer owner;

    public Car(int id, String model){
        this.id = id;
        this.model = model;
    }

    public Car(int id, String model, Customer owner){
        this.id = id;
        this.model = model;
        this.owner = owner;
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