package com.revature.model;

public class Car {
    private int id;
    private String name;

    public Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
       return id + ": " + name;
    }
}