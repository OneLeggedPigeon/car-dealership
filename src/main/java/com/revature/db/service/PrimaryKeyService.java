package com.revature.db.service;

import com.revature.db.ConnectionSession;

import java.sql.*;

public abstract class PrimaryKeyService {
    public static int newUserID(){
        int id = -1;
        try {
            ResultSet rs = SQLQueryService.query("SELECT MAX(user_id) FROM login");
            if (rs != null) {
                rs.next();
                //Retrieve by column name
                id = rs.getInt("max")+1;
                rs.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }//Handle other errors

        if(id == -1){throw new IndexOutOfBoundsException("Couldn't get the new Primary Key for some reason");}
        return id;
    }
}
