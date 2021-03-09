package com.revature.service;

import com.revature.db.PreparedOffer;
import com.revature.db.service.PrimaryKeyService;
import com.revature.model.Car;
import com.revature.model.Customer;
import com.revature.model.Offer;

public abstract class OfferService {

    public static void makeOffer(int amount, Customer customer, Car car) {
        Offer offer = new Offer(PrimaryKeyService.newOfferID(), amount, customer, car);
        attachOffer(offer, car);
        PreparedOffer.createOffer(offer.getId(), customer.getID(), car.getID(), amount);
    }

    public static void attachOffer(Offer offer, Car car){
        car.addOffer(offer);
    }
}