package com.revature.ui;

import java.util.Scanner;

//surface level menu that's looped through and leads to other menus
public abstract class MainMenu {
    public static void rootMenu(Scanner scan){
        System.out.println("===Welcome to Car Dealership===");
        String[] options = new String[]{
                "login",
                "new user",
                "exit"
        };
        while(true) {
            switch (QueryMenu.query(scan, options)) {
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

    public static void actionMenu(Scanner scan){
        System.out.println("===Welcome to Car Dealership===");
        String[] options = new String[]{
                "login",
                "new user",
                "exit"
        };
    }
}
