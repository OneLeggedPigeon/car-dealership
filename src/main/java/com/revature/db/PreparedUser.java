package com.revature.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

//hitting the membership table
public abstract class PreparedUser {

    public static void createLogin(int id, String username, String password){
        try (ConnectionSession ses = new ConnectionSession()) {
            Connection conn = ses.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("insert into login values (?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createCustomer(int id){
        try (ConnectionSession ses = new ConnectionSession()) {
            Connection conn = ses.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("insert into customer values (?)");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}