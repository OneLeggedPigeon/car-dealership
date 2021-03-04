package com.revature.services;

public abstract class PaymentService {
    public double calculateMonthlyPayment(double price, double salesTax, double downPayment, double api, int term){
        double result = 0;
        double r = api/12;
        result = (price*(1+salesTax)-downPayment)*r*Math.pow(1+r,term)/(Math.pow(1+r,term)-1);
        return result;
    }
}
