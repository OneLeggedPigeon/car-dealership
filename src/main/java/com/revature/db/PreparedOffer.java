package com.revature.db;

import com.revature.model.Offer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class PreparedOffer {


    public static int createOffer(int id, int userId, int carId, int amount) {
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("insert into offer values (?,?,?,?)");
            ps.setInt(1, id);
            ps.setInt(2, userId);
            ps.setInt(3, carId);
            ps.setInt(4, amount);
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static int deleteOffer(Offer offer) {
        return deleteOffer(offer.getId());
    }

    public static int deleteOffer(int id) {
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM offer WHERE offer_id=?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int update(String s) {
        return 0;
    }

    public static int delete(Integer id) {
        return 0;
    }
}