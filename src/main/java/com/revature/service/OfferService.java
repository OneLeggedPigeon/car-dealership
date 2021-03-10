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
        attachOffer(offer, car, customer);
    }

    public static void createOffer(Customer customer, Car car, int amount) {
        Offer offer = new Offer(PrimaryKeyService.newOfferId(), customer, car, amount);
        attachOffer(offer, car, customer);
        PreparedOffer.createOffer(offer.getId(), customer.getId(), car.getId(), amount);
    }

    private static void attachOffer(Offer offer, Car car, Customer customer){
        car.addOffer(offer);
        customer.addOffer(offer);
    }

    public static void acceptOffer(Offer offer) {
        Customer customer = offer.getCustomer();
        Car car = offer.getCar();

        // assign the loan to the customer
        LoanService.createLoan(customer,car,offer.getAmount());
        // give the car to the Customer
        CarService.assignCar(car, customer);

        // once transferred to a loan,
        //  remove the offer
        removeOffer(offer);
        //  and remove all offers from the matching car
        for(Offer o : car.getOffers().toArray()){
            removeOffer(o);
        }
    }

    public static void removeOffer(Offer offer) {
        // remove local references
        offer.remove();
        // remove from database
        PreparedOffer.deleteOffer(offer);
    }
}