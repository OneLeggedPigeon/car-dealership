package com.revature.service;

import com.revature.db.PreparedLoan;
import com.revature.db.service.PrimaryKeyService;
import com.revature.model.Car;
import com.revature.model.Customer;
import com.revature.model.Loan;

public abstract class LoanService {

    public static void createLoan(Customer customer, Car car, int amount) {
        Loan loan = new Loan(
                PrimaryKeyService.newLoanId(),
                customer,
                car,
                PaymentService.defaultTerm,
                PaymentService.calculateMonthlyPayment(amount),
                amount
        );
        customer.addLoan(loan);
        PreparedLoan.createLoan(
                loan.getId(),
                loan.getCustomer().getId(),
                loan.getCar().getId(),
                loan.getTerms(),
                loan.getMonthlyDue(),
                loan.getPrinciple()
        );
    }

    public static void loadLoan(int loan_id, int user_id, int car_id, int remaining_terms, float monthly_due, int principle) {
        Customer customer = UserService.getCustomerById(user_id);
        Loan loan = new Loan(
                loan_id,
                customer,
                CarService.getCarById(car_id),
                remaining_terms,
                monthly_due,
                principle
        );
        customer.addLoan(loan);
    }
}
