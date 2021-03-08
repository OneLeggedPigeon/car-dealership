package com.revature.db.service;

import com.revature.db.ConnectionSession;

import java.sql.*;

/*
 * Template from https://www.tutorialspoint.com/jdbc/jdbc-select-records.htm
 */
public abstract class PrimaryKeyService {
    public static int newUserID(){
        Connection conn = null;
        Statement stmt = null;
        int id = -1;
        try {
            ConnectionSession sess = new ConnectionSession();
            conn = sess.getActiveConnection();
            stmt = conn.createStatement();
            String sql = "SELECT MAX(user_id) FROM login";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                id = rs.getInt("max")+1;
            }
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle other errors
            e.printStackTrace();
        }
        if(id == -1){throw new IndexOutOfBoundsException("Couldn't get the new Primary Key for some reason");}
        return id;
    }
}
