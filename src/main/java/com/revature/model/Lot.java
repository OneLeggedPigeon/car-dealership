package com.revature.model;

import com.revature.collections.FlexArray;

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

    public static Lot getInstance() {
        if (instance == null) {
            instance = new Lot();
        }
        return instance;
    }

    // checks if arg: id matches one of the values in this.cars
    public boolean inLot(int id) {
        return (cars.get(id) != null);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Car car : cars.toArray()){
            result.append(car.getId())
                    .append(": ")
                    .append(car.getModel())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
