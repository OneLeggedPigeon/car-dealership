package com.revature.service;

import com.revature.model.Car;
import com.revature.model.Customer;
import com.revature.model.Offer;
import com.revature.model.User;

public abstract class PaymentService {
    private static final double defaultSalesTax = .10;
    private static final double defaultDownPayment = 0;
    private static final double defaultAPI = .3;
    private static final int defaultTerm = 12;

    public static double calculateMonthlyPayment(double price){
        return calculateMonthlyPayment(price, defaultSalesTax, defaultDownPayment, defaultAPI, defaultTerm);
    }

    public static double calculateMonthlyPayment(double price, double salesTax, double downPayment, double api, int term){
        double result = 0;
        double r = api/12;
        result = (price*(1+salesTax)-downPayment)*r*Math.pow(1+r,term)/(Math.pow(1+r,term)-1);
        return result;
    }
}