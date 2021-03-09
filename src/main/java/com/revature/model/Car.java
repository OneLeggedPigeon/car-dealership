package com.revature.model;

import com.revature.service.CarService;

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
        return Lot.getInstance().inLot(id);
    }
    public String getModel() {
        return model;
    }

    public int getID() {
        return id;
    }

    /*public void setModel(String model) {
        this.model = model;
    }*/

    public String toString(){
       return id + ": " + model;
    }
}