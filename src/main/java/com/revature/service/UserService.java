package com.revature.service;

import com.revature.db.PreparedUser;
import com.revature.db.service.SQLQueryService;
import com.revature.model.*;

import com.revature.collections.*;

import java.sql.ResultSet;
import java.sql.SQLException;

// Holds all Users, Customers, Employees locally
public abstract class UserService {

    //FlexArray of all users
    static FlexArray<User> users;

    static {
        try {
            users = new FlexArray<User>(Class.forName("com.revature.model.User"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static User activeUser = null;

    public static void makeUser(int id, String username, String password){
        User user = new User(id, username, password);
        users.add(user);
        // add to database
        PreparedUser.createLogin(id,username,password);
    }

    public static void loadUser(int id, String username, String password){
        User user = new User(id, username, password);
        users.add(user);
    }

    public static void loadCustomer(int id, String username, String password){
        Customer customer = new Customer(id, username, password);
        users.add(customer);
    }

    public static void loadEmployee(int id, String username, String password){
        Employee employee = new Employee(id, username, password);
        users.add(employee);
    }

    // Change a User to a Customer
    public static Customer registerUser(User u){
        Customer c = new Customer(u.getID(), u.getUsername(), u.getPassword());
        users.add(c);
        // add to database
        PreparedUser.createCustomer(u.getID());
        return c;
    }

    //Is the username currently in use?
    public static boolean isUsernameDupe(String username) throws SQLException {
        ResultSet rs = SQLQueryService.query("SELECT Count(*) FROM login WHERE (username = '" + username + "')");
        try {
            assert rs != null;
            rs.next();
            int result = rs.getInt("count");
            return (result == 1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // returns null if name not found
    public static User getUserByUsername(String username) {
        for(User u : users.toArray()){
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }

    public static User getUserByID(int id) {
        for(User u : users.toArray()){
            if(u.getID() == id){
                return u;
            }
        }
        return null;
    }
}
