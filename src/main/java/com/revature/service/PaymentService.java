package com.revature.service;

public abstract class PaymentService {
    public static final double defaultSalesTax = .10;
    public static final double defaultDownPayment = 0;
    public static final double defaultAPI = .3;
    public static final int defaultTerm = 12;

    public static float calculateMonthlyPayment(double price){
        return calculateMonthlyPayment(price, defaultSalesTax, defaultDownPayment, defaultAPI, defaultTerm);
    }

    public static float calculateMonthlyPayment(double price, double salesTax, double downPayment, double api, int term){
        double r = api/12;
        return (float) ((price*(1+salesTax)-downPayment)*r*Math.pow(1+r,term)/(Math.pow(1+r,term)-1));
    }
}