package com.revature.ui;

import com.revature.model.Employee;
import com.revature.model.Lot;
import com.revature.model.User;
import com.revature.service.MenuService;

import java.util.Scanner;

public abstract class EmployeeLotMenu {
    protected static String[] options = new String[]{
            "add",
            "remove",
            "back",
            "exit"
    };

    public static void showMenu(Scanner scan, User user){
        System.out.println("===Welcome to the Employee Car Lot===");
        boolean back;
        do {
            back = query(scan, user);
        } while(!back);
    }

    protected static boolean query(Scanner scan, User user) {
        switch (MenuService.queryMenu(scan, options)) {
            case "add":
                add(scan);
                break;
            case "remove":
                remove(scan);
                //TODO:
                System.out.println("payments");
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

    private static void add(Scanner scan) {
        System.out.println(Lot.getInstance().toString());
    }

    private static void remove(Scanner scan) {
        // show cars not in lot
    }
}
