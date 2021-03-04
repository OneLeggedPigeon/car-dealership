package com.revature.db;

import com.revature.model.User;

import java.sql.*;

public class UserJDBC {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgrespq://revature-project-0.cu9tcaqykiil.us-east-2.rds.amazonaws.com:5432/enterprise?","OneLeggedPigeon","bikes0191");
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