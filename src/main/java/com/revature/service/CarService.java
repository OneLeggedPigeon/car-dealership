package com.revature.service;

import com.revature.collections.FlexArray;
import com.revature.db.PreparedCar;
import com.revature.model.Car;
import com.revature.model.Customer;
import com.revature.model.Lot;
import com.revature.model.User;

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

    /*
     * arg:
     *  id: car_id
     *  ownerID: user_id of owner, 0 if unowned (There is a user_id:0, but it is manually set to employee and will not be generated)
     *  inLot: bool if it should be be added to the Lot cars as well as this.cars
     *  model: name of the car
     */
    public static void loadCar(int id, int ownerID, boolean inLot, String model){
        if (ownerID >= 0){
            Car car;
            if(ownerID == 0){
                car = new Car(id, model);
            } else {
                Customer customer = UserService.getCustomerById(ownerID);
                car = new Car(id, model, customer);
                customer.addCar(car);
            }
            cars.add(car);
            // redundant check that an owned car is not in the lot
            if(inLot && !car.getOwner().isPresent()){
                Lot.getInstance().addCar(car);
            }
        }
    }

    public static void assignCar(Car car, Customer customer) {
        customer.addCar(car);
        Lot.getInstance().removeCar(car);
        car.setOwner(customer);
        // DataBase (automatically removes from lot as well
        PreparedCar.updateOwner(car.getId(),customer.getId());
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
        return getEntries(arrayUnownedNoLotCar());
    }

    // returns entries for all cars
    public static String toStringCarsUnowned(){
        StringBuilder result = new StringBuilder(System.lineSeparator());
        for (Car car : arrayUnownedCary()) {
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

    public static String toStringCarsOffer() {
        return getEntries(arrayOfferCar());
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

    // are there a car in the lot?
    public static boolean existsLotCar() {
        return !Lot.getInstance().isEmpty();
    }

    // are there any unowned cars outside the lot?
    public static boolean existsUnownedNoLotCar() {
        for (Car car : cars.toArray()){
            if(!car.inLot() && !car.getOwner().isPresent()){
                return true;
            }
        }
        return false;
    }

    // are there any unowned cars with offers?
    public static boolean existsCarWithOffer() {
        for (Car car : arrayUnownedCary()){
            if(!car.getOffers().isEmpty()){
                return true;
            }
        }
        return false;
    }


    public static Car[] arrayUnownedCary() {
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

    public static Car[] arrayOfferCar() {
        FlexArray<Car> result = null;
        try {
            result = new FlexArray<Car>(Class.forName("com.revature.model.Car"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert result != null;
        for (Car car : cars.toArray()){
            if(!car.getOwner().isPresent() && !car.getOffers().isEmpty()){
                result.add(car);
            }
        }
        return result.toArray();
    }

    public static Car[] arrayUnownedNoLotCar() {
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


    public static Car getCarById(int id) {
        for(Car c : cars.toArray()){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    /*
    public void addCar(Car c){
        cars.put(c.getID(),c);
        // TODO: also add to db
    }
    */
}
