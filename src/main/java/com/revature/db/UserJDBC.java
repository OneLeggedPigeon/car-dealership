package com.revature.db;

import com.revature.model.User;

import java.sql.*;

public class UserJDBC{

    // static variable single_instance of type Singleton
    private static UserJDBC single_instance = null;
    // private constructor restricted to this class itself
    private UserJDBC(){

    }
    // static method to create instance of Singleton class
    public static UserJDBC getInstance()
    {
        if (single_instance == null)
            single_instance = new UserJDBC();

        return single_instance;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://revature-project-0.cu9tcaqykiil.us-east-2.rds.amazonaws.com:5432/postgres","OneLeggedPigeon","password");
    }
    public void saveUser(User u){
        String sql = "insert into user values ()";
        Statement st = null;
        try {
            st = getConnection().createStatement();
            int i = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}