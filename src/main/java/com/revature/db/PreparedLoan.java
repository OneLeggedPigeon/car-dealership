package com.revature.db;

import com.revature.model.Car;
import com.revature.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

//TODO: CHANGE THIS
public abstract class PreparedLoan {


    public static int createLoan(int loanId, int custId, int carId, int terms, double amount, int principle) {
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO loan (loan_id, user_id, car_id, remaining_terms, monthly_due, principle) VALUES(?, ?, ?, ?, ?, ?)"
            );
            ps.setInt(1, loanId);
            ps.setInt(2, custId);
            ps.setInt(3, carId);
            ps.setInt(4, terms);
            ps.setFloat(5, (float) amount);
            ps.setInt(6, principle);
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int update(String s) {
        return 0;
    }

    public static int delete(Integer id) {
        return 0;
    }
}