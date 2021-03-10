package com.revature.ui;

import com.revature.model.Car;
import com.revature.model.Customer;
import com.revature.model.Lot;
import com.revature.service.CarService;
import com.revature.utility.MenuService;

import java.util.Scanner;

public abstract class CustomerOwnedMenu {
    protected static String[] options = new String[]{
            "back",
            "exit"
    };

    public static void showMenu(Scanner scan, Customer customer){
    }

    protected static boolean query(Scanner scan, Customer customer) {
            switch (MenuService.queryMenu(scan, options)) {
                case "back":
                    return true;
                case "exit":
                    System.exit(1);
                    break;
                default:
                    System.out.println("This shouldn't show up.");
            }
        return true;
    }
}
