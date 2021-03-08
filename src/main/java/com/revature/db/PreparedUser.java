package com.revature.db;

import com.revature.db.service.PrimaryKeyService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//hitting the membership table
public class PreparedUser implements Dao<String, Integer> {

    @Override
    public int create(String s) {
        return create(s, "");
    }

    public int create(String u, String p){
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("insert into login values (?,?,?)");
            int id = PrimaryKeyService.newUserID();
            ps.setInt(1, id);
            ps.setString(2, u);
            ps.setString(3, p);
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public String findById(Integer id) {
        String sql = "select * from membership_type where id=?";
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
        }
    }

    @Override
    public int update(String s) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}