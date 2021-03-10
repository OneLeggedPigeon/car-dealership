package com.revature.db.service;

import java.sql.*;

public abstract class PrimaryKeyService {

    private static int newId(String query) {
        int id = -1;
        try {
            ResultSet rs = SQLQueryService.query(query);
            if (rs != null) {
                rs.next();
                //Retrieve by column name
                id = rs.getInt("max") + 1;
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }//Handle other errors

        if (id == -1) {
            throw new IndexOutOfBoundsException("Couldn't get the new Primary Key for some reason");
        }
        return id;
    }

    public static int newUserId(){
        return newId("SELECT MAX(user_id) FROM login");
    }

    public static int newOfferId() {
        return newId("SELECT MAX(offer_id) FROM offer");
    }

    public static int newLoanId() {
        return newId("SELECT MAX(loan_id) FROM loan");
    }
}
