package com.revature.db;

import com.revature.model.Offer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class PreparedOffer {


    public static void createOffer(int id, int userId, int carId, int amount) {
        try (ConnectionSession ses = new ConnectionSession()) {
            Connection conn = ses.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("insert into offer values (?,?,?,?)");
            ps.setInt(1, id);
            ps.setInt(2, userId);
            ps.setInt(3, carId);
            ps.setInt(4, amount);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteOffer(Offer offer) {
        deleteOffer(offer.getId());
    }

    public static void deleteOffer(int id) {
        try (ConnectionSession ses = new ConnectionSession()) {
            Connection conn = ses.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM offer WHERE offer_id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}