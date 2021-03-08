package com.revature.db.service;

import com.revature.db.ConnectionFactory;
import com.revature.service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;

public  class UpdateService {

    private static UpdateService instance;

    // Load EVERYTHING from the database
    private UpdateService(){
        System.out.println("Loading Users");
        ResultSet rs = SQLQueryService.query("select * from login");
        ResultSet ers = SQLQueryService.query("select login.user_id from employee, login where employee.user_id = login.user_id");
        ResultSet crs = SQLQueryService.query("select login.user_id from customer, login where customer.user_id = login.user_id;");
        // I could make sure no one is a customer and employee, but that's out of scope for MVP
        try {
            assert rs != null;
            assert ers != null;
            assert crs != null;
            boolean eValid = ers.next();
            boolean cValid = crs.next();
            while(rs.next()){
                int id = rs.getInt("user_id");
                if(eValid && id == ers.getInt("user_id")){
                    UserService.loadEmployee(id,rs.getString("username"),rs.getString("password"));
                    eValid = ers.next();
                } else if (cValid && id == crs.getInt("user_id")){
                    UserService.loadCustomer(id,rs.getString("username"),rs.getString("password"));
                    cValid = crs.next();
                } else {
                    UserService.loadUser(id,rs.getString("username"),rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Loading Error");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static UpdateService getInstance() {
        if (instance == null) {
            instance = new UpdateService();
        }
        return instance;
    }
}
