package com.revature.ui;

import com.revature.model.Customer;
import com.revature.model.User;
import com.revature.utility.MenuService;

import java.util.Scanner;

public abstract class CustomerMenu{
    protected static String[] options = new String[]{
            "owned",
            "lot",
            "payments",
            "logout",
            "exit"
    };

    //Loop through user options until logout
    public static void showMenu(Scanner scan, User user){
        System.out.println("===Welcome "+user.getUserType()+" "+user+"===");
        boolean logout;
        assert user instanceof Customer;
        do {
            logout = query(scan, (Customer) user);
        } while(!logout);
    }

    protected static boolean query(Scanner scan, Customer customer) {
        switch (MenuService.queryMenu(scan, options)) {
            case "owned":
                owned(customer);
                break;
            case "lot":
                CustomerLotMenu.showMenu(scan, customer);
                break;
            case "payments":
                payments(customer);
                break;
            case "logout":
                return true;
            case "exit":
                System.exit(1);
                break;
            default:
                System.out.println("This shouldn't show up.");
        }
        return false;
    }

    private static void payments(Customer customer) {
        System.out.println("===Oustanding Payments===");
        if (!customer.getLoans().isEmpty()) {
            System.out.println(customer.getLoans().toString());
        } else {
            System.out.println("You have no Outstanding Payments");
        }
    }

    private static void owned(Customer customer) {
        System.out.println("===Look at all your Beautiful Cars!===");
        if (!customer.getCars().isEmpty()) {
            System.out.println(customer.getCars().toString());
        } else {
            System.out.println("Whoops, looks like you don't have any!");
        }
    }
}
