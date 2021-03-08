package com.revature.db;

import com.revature.db.service.PrimaryKeyService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//hitting the membership table
public class PreparedUser {

    public int createLogin(int id, String username, String password){
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("insert into login values (?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, password);
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int createCustomer(int id){
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("insert into customer values (?)");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String findById(Integer id) {
        /*String sql = "select * from membership_type where id=?";
        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            String result = "";
            rs.next();  // since next only needs to be called once to get a single result, a while loop does not
            // have to be used.
            result = rs.getString(2);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }*/
        return null;
    }

    public int update(String s) {
        return 0;
    }

    public int delete(Integer id) {
        return 0;
    }
}