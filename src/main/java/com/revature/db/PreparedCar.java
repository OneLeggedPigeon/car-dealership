package com.revature.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

//hitting the membership table
public abstract class PreparedCar {

    public static int createCar(int id, String model){
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("insert into car values (?,null,false,?)");
            ps.setInt(1, id);
            ps.setString(2, model);
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // TODO: add customers id to car row in db to indicate ownership
    public static int purchaseCar(int carID, int customerID){
        return -1;
    }

    public static String findById(Integer id) {
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

    public static int update(String s) {
        return 0;
    }

    public static int delete(Integer id) {
        return 0;
    }
}