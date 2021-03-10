package com.revature.ui;

import com.revature.model.Car;
import com.revature.model.Customer;
import com.revature.model.Lot;
import com.revature.service.CarService;
import com.revature.utility.MenuService;

import java.util.Scanner;

public abstract class CustomerPaymentMenu {
    protected static String[] options = new String[]{
            "back",
            "exit"
    };

    public static void showMenu(Scanner scan, Customer customer){
        boolean back;
        do {
            back = query(scan, customer);
        } while(!back);
    }

    protected static boolean query(Scanner scan, Customer customer) {
        return true;

    }
}
