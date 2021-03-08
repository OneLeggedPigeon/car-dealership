package com.revature.db.service;

import com.revature.db.ConnectionSession;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class SQLQueryService {
    public static ResultSet query(String statement){
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(statement);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    /*
     * returns: first value in the column, or -1 if unsuccessful.
    */
    public static int intQuery(String statement, String columnLable){
        ResultSet rs = SQLQueryService.query(statement);
        int result = -1;
        try {
            if(rs.next()) {
                result = rs.getInt(columnLable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int idQuery(String username){
        return intQuery("select user_id from login where username = '" +username+"'","user_id");
    }
}
