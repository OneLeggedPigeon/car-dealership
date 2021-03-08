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
}
