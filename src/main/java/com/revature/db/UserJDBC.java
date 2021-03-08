package com.revature.db;

import com.revature.config.DBProperties;
import com.revature.model.User;

import java.sql.*;

public abstract class UserJDBC{

    public static void saveUser(Connection connection, User user){
        String sql = "insert into user values ()";
        Statement st = null;
        try {
            st = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}