package com.revature.service;

import com.revature.model.Car;
import com.revature.model.Customer;
import com.revature.model.Offer;
import com.revature.model.User;

import java.text.NumberFormat;

import java.text.NumberFormat;

public abstract class PaymentService {
    public static final double defaultSalesTax = .10;
    public static final double defaultDownPayment = 0;
    public static final double defaultAPI = .3;
    public static final int defaultTerm = 12;

    public static float calculateMonthlyPayment(double price){
        return calculateMonthlyPayment(price, defaultSalesTax, defaultDownPayment, defaultAPI, defaultTerm);
    }

    public static float calculateMonthlyPayment(double price, double salesTax, double downPayment, double api, int term){
        double result = 0;
        double r = api/12;
        result = (price*(1+salesTax)-downPayment)*r*Math.pow(1+r,term)/(Math.pow(1+r,term)-1);
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.format(result);
        return (float) result;
    }
}