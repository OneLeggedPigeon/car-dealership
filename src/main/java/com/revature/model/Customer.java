package com.revature.model;

import com.revature.collections.FlexArray;

public class Customer extends User{
    private FlexArray<Car> cars;
    private FlexArray<Offer> offers;
    private FlexArray<Loan> loans;

    public Customer(int id, String username, String password) {
        super(id,username,password);
        try {
            cars = new FlexArray<>(Class.forName("com.revature.model.Car"));
            offers = new FlexArray<>(Class.forName("com.revature.model.Offer"));
            loans = new FlexArray<>(Class.forName("com.revature.model.Loan"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public UserType getUserType(){
        return UserType.CUSTOMER;
    }

    public FlexArray<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public FlexArray<Offer> getOffers() {
        return offers;
    }

    public void addOffer(Offer offer) {
        this.offers.add(offer);
    }

    public FlexArray<Loan> getLoans() {
        return loans;
    }

    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }
}
