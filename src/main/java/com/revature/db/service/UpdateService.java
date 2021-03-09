package com.revature.db.service;

import com.revature.service.CarService;
import com.revature.service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;

public  class UpdateService {

    private static UpdateService instance;

    // Load EVERYTHING from the database
    private UpdateService(){
        System.out.println("Loading Users");
        ResultSet logRS = SQLQueryService.query("select * from login");
        ResultSet empRS = SQLQueryService.query("select login.user_id from employee, login where employee.user_id = login.user_id");
        ResultSet custRS = SQLQueryService.query("select login.user_id from customer, login where customer.user_id = login.user_id;");
        // I could make sure no one is a customer and employee, but that's out of scope for MVP

        System.out.println("Loading Cars");
        ResultSet carRS = SQLQueryService.query("select * from car");
        try {
            assert logRS != null;
            assert empRS != null;
            assert custRS != null;
            boolean empValid = empRS.next();
            boolean custValid = custRS.next();
            // Users
            while(logRS.next()){
                int id = logRS.getInt("user_id");
                if(empValid && id == empRS.getInt("user_id")){
                    UserService.loadEmployee(id,logRS.getString("username"),logRS.getString("password"));
                    empValid = empRS.next();
                } else if (custValid && id == custRS.getInt("user_id")){
                    UserService.loadCustomer(id,logRS.getString("username"),logRS.getString("password"));
                    custValid = custRS.next();
                } else {
                    UserService.loadUser(id,logRS.getString("username"),logRS.getString("password"));
                }
            }
            // Cars
            assert carRS != null;
            while (carRS.next()){
                int owner = carRS.getInt("user_id");
                // TODO: refactor everything so user_id 0 can own a car
                if (owner == 0) owner = -1;
                CarService.loadCar(
                        carRS.getInt("car_id"),
                        owner,
                        carRS.getBoolean("in_lot"),
                        carRS.getString("model")
                );
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