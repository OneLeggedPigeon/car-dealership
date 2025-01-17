package com.revature.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class PreparedLoan {


    public static void createLoan(int loanId, int customerId, int carId, int terms, double amount, int principle) {
        try (ConnectionSession ses = new ConnectionSession()) {
            Connection conn = ses.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO loan (loan_id, user_id, car_id, remaining_terms, monthly_due, principle) VALUES(?, ?, ?, ?, ?, ?)"
            );
            ps.setInt(1, loanId);
            ps.setInt(2, customerId);
            ps.setInt(3, carId);
            ps.setInt(4, terms);
            ps.setFloat(5, (float) amount);
            ps.setInt(6, principle);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}