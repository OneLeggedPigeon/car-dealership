package com.revature.service;

import com.revature.collections.FlexArray;
import com.revature.model.Car;
import com.revature.model.Customer;
import com.revature.model.Lot;
import com.revature.model.User;

import java.util.Optional;

// Holds all Cars locally
public abstract class CarService {

    //FlexArray of all cars
    private static FlexArray<Car> cars;

    static {
        try {
            cars = new FlexArray<Car>(Class.forName("com.revature.model.Car"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Car makeCar(int id, String model){
        return null;
    }

    /*
     * arg:
     *  id: car_id
     *  ownerID: user_id of owner, -1 if unowned
     *  inLot: bool if it should be be added to the Lot cars as well as this.cars
     *  model: name of the car
     */
    public static void loadCar(int id, int ownerID, boolean inLot, String model){
        if (ownerID >= -1){
            Car car;
            if(ownerID == -1){
                car = new Car(id, model);
            } else {
                User customer = UserService.getUserByID(ownerID);
                assert customer instanceof Customer;
                car = new Car(id, model, (Customer) customer);
            }
            cars.add(car);
            // redundant check that an owned car is not in the lot
            if(inLot && !car.getOwner().isPresent()){
                Lot.getInstance().addCar(car);
            }
        }
    }

    public static boolean inLot(Car car) {
        return Lot.getInstance().inLot(car);
    }


    // returns entries for all cars in lot
    public static String toStringCarsLot(){
        return getEntries(Lot.getInstance().toArray());
    }

    // returns entries for all unowned cars not in lot
    public static String toStringCarsUnownedNoLot(){
        return getEntries(unownedNoLotCarArray());
    }

    // returns entries for all cars
    public static String toStringCarsUnowned(){
        StringBuilder result = new StringBuilder(System.lineSeparator());
        for (Car car : unownedCarArray()) {
            String s;
            if(car.inLot()){
                s = "in lot|";
            } else{
                s = "stowed|";
            }
            result.append(s)
                    .append(car.getId())
                    .append(": ")
                    .append(car.getModel())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }

    // returns entries for all cars
    public static String toStringCars(){
        return getEntries(cars.toArray());
    }

    private static String getEntries(Car[] cars) {
        StringBuilder result = new StringBuilder(System.lineSeparator());
        for (Car car : cars) {
            result.append(car.getId())
                    .append(": ")
                    .append(car.getModel())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }


    // are there any cars?
    public static boolean isEmpty() {
        return cars.isEmpty();
    }

    // are there any unowned cars outside the lot?
    public static boolean unownedNoLotCarExists() {
        for (Car car : cars.toArray()){
            if(!car.inLot() && !car.getOwner().isPresent()){
                return true;
            }
        }
        return false;
    }


    public static Car[] unownedCarArray() {
        FlexArray<Car> result = null;
        try {
            result = new FlexArray<Car>(Class.forName("com.revature.model.Car"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert result != null;
        for (Car car : cars.toArray()){
            if(!car.getOwner().isPresent()){
                result.add(car);
            }
        }
        return result.toArray();
    }

    public static Car[] unownedNoLotCarArray() {
        FlexArray<Car> result = null;
        try {
            result = new FlexArray<Car>(Class.forName("com.revature.model.Car"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert result != null;
        for (Car car : cars.toArray()){
            if(!car.inLot() && !car.getOwner().isPresent()){
                result.add(car);
            }
        }
        return result.toArray();
    }

    /*
    public void addCar(Car c){
        cars.put(c.getID(),c);
        // TODO: also add to db
    }
    */
}
