package com.revature.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

//hitting the membership table
public abstract class PreparedCar {

    // set in_lot in DB to arg: inLot
    public static void updateInLot(int id, boolean inLot){
        try (ConnectionSession ses = new ConnectionSession()) {
            Connection conn = ses.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE car SET in_lot=? WHERE car_id=?");
            ps.setBoolean(1, inLot);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateOwner(int carId, int ownerId) {
        // make sure car is out of the lot
        updateInLot(carId, false);
        try (ConnectionSession ses = new ConnectionSession()) {
            Connection conn = ses.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE car SET user_id=? WHERE car_id=?");
            ps.setInt(1, ownerId);
            ps.setInt(2, carId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}