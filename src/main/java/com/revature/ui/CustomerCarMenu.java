package com.revature.ui;

import com.revature.model.Car;
import com.revature.model.User;
import com.revature.service.CarService;
import com.revature.service.MenuService;

import java.util.Scanner;

public abstract class CustomerCarMenu {
    protected static String[] options = new String[]{
            "select",
            "back",
            "exit"
    };

    public static void showMenu(Scanner scan, User user, Car car){
        System.out.println("=== ===");
        boolean back;
        do {
            back = query(scan, user);
        } while(!back);
    }

    protected static boolean query(Scanner scan, User user) {
        System.out.println(CarService.toStringCarsLot());
        switch (MenuService.queryMenu(scan, options)) {
            case "select":
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
}
