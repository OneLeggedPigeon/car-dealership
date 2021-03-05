package com.revature.model;

import com.revature.collections.FlexArray;

public abstract class Lot {
    private FlexArray<Car> cars = new FlexArray<Car>();

    public void addCar(Car c){
        cars.add(c);
    }

    public void addCar(Car[] c){
        cars.add(c);
    }

    public Car[] getCars(){
        return (Car[]) cars.toArray();
    }
}