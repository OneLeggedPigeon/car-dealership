package com.revature.ui;

import com.revature.model.Car;
import com.revature.model.Customer;
import com.revature.service.CarService;
import com.revature.service.MenuService;
import com.revature.service.OfferService;

import java.util.Scanner;

public abstract class CustomerCarMenu {
    protected static String[] options = new String[]{
            "offer",
            "back",
            "exit"
    };

    public static void showMenu(Scanner scan, Customer customer, Car car){
        System.out.println("==="+car.getModel()+"===");
        boolean back;
        do {
            back = query(scan, customer, car);
        } while(!back);
    }

    protected static boolean query(Scanner scan, Customer customer, Car car) {
        switch (MenuService.queryMenu(scan, options)) {
            case "offer":
                offer(scan, customer, car);
                break;
            case "back":
                return true;
            case "exit":
                System.exit(1);
                break;
            default:
                System.out.println("This shouldn't show up.");
        }
        return false;
    }

    private static void offer(Scanner scan, Customer customer, Car car) {
        System.out.println("how much?");
        int input = MenuService.queryInt(scan, car.toString(), "dollar amount", 1);
        assert input >= 0;
        if(input >=1){
            OfferService.makeOffer(input, customer, car);
            System.out.println("offer made: $"+input);
        }
    }
}
