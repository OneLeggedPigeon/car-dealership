package com.revature.model;

import com.revature.collections.FlexArray;
import com.revature.db.PreparedCar;
import com.revature.service.CarService;
import com.revature.service.UserService;

// Singleton
public class Lot {

    //FlexArray of all the cars in the Lot
    private static FlexArray<Car> cars;

    static {
        try {
            cars = new FlexArray<Car>(Class.forName("com.revature.model.Car"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Lot instance;

    private Lot(){

    }

    public static Lot getInstance() {
        if (instance == null) {
            instance = new Lot();
        }
        return instance;
    }

    // checks if arg: id matches one of the values in this.cars
    public boolean inLot(Car car) {
        return (cars.has(car));
    }

    public void addCar(Car car) {
        cars.add(car);
        PreparedCar.updateInLot(car.getID(), true);
    }

    public void removeCar(Car car) {
        cars.remove(car);
        PreparedCar.updateInLot(car.getID(), false);
    }

    public Car[] toArray(){
        return cars.toArray();
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }
}
