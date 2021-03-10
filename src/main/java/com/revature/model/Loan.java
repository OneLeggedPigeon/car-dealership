package com.revature.model;

import java.text.NumberFormat;

public class Loan {
    private final int id;
    private final Customer customer;
    private final Car car;
    private int terms;
    private final double monthlyDue;
    private final int principle;

    public Loan(int id, Customer customer, Car car, int terms, float monthlyDue, int principle) {
        this.id = id;
        this.customer = customer;
        this.car = car;
        this.terms = terms;
        this.monthlyDue = monthlyDue;
        this.principle = principle;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    public double getMonthlyDue() {
        return monthlyDue;
    }

    public int getPrinciple() {
        return principle;
    }

    public String toString(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        return customer+":"+car.getModel()+" | "+terms+" monthly payments of $"+nf.format(monthlyDue)+" remaining.";
    }
}
