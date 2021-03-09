package com.revature.model;

import com.revature.collections.HashMap;
import com.revature.db.service.UpdateService;

// Singlton
public class Lot {

    private static HashMap<Integer,Car> cars = new HashMap<Integer,Car>();

    private static Lot instance;

    // TODO: initialize Lot
    private Lot(){
        
    }

    public static Lot getInstance() {
        if (instance == null) {
            instance = new Lot();
        }
        return instance;
    }

    // TODO
    public boolean inLot(int id) {
        return false;
    }
}
