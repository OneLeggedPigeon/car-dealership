package com.revature.service;

import com.revature.db.PreparedOffer;
import com.revature.db.service.PrimaryKeyService;
import com.revature.model.Car;
import com.revature.model.Customer;
import com.revature.model.Offer;

public abstract class OfferService {

    public static void loadOffer(int offer_id, int user_id, int car_id, int amount) {
        Car car = CarService.getCarById(car_id);
        Customer customer = UserService.getCustomerById(user_id);
        Offer offer = new Offer(offer_id, customer, car, amount);
        assert car != null;
        attachOffer(offer, car);
    }

    public static void makeOffer(int amount, Customer customer, Car car) {
        Offer offer = new Offer(PrimaryKeyService.newOfferID(), customer, car, amount);
        attachOffer(offer, car);
        PreparedOffer.createOffer(offer.getId(), customer.getID(), car.getId(), amount);
    }

    public static void attachOffer(Offer offer, Car car){
        car.addOffer(offer);
    }
}