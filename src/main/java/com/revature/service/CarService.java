package com.revature.service;

import com.revature.collections.FlexArray;
import com.revature.collections.HashMap;
import com.revature.model.Car;

// Holds all Cars locally
public abstract class CarService {
    private static HashMap<Integer,Car> cars = new HashMap<Integer,Car>();

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
        Car car;
        if(ownerID == -1){
            //car = new Car();
        } else if (ownerID >=0){
            //car = new Car();
        }
        //cars.put((Integer) id,)
        if(inLot){

        }
    }

    // TODO: check cars for id
    public static boolean inLot(int id) {
        return false;
    }

    public void addCar(Car c){
        cars.put(c.getID(),c);
        // TODO: also add to db
    }
}
