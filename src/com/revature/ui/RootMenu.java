package com.revature.ui;

import java.util.Scanner;

public abstract class RootMenu {
    public static void showMenu(Scanner scan){
        System.out.println("===Welcome to Car Dealership===");
        String[] options = new String[]{
                "login",
                "new user",
                "exit"
        };
        while(true) {
            switch (QueryMenu.showMenu(scan, options)) {
                case "login":
                    LoginMenu.showMenu(scan);
                    break;
                case "new user":
                    UserMenu.newUser(scan);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Command not recognised.");
            }
        }
    }
}
