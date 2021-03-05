package com.revature.ui;

import com.revature.model.User;
import com.revature.services.MenuService;
import com.revature.services.UserService;

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
            switch (MenuService.queryMenu(scan, options)) {
                case "login":
                    LoginMenu.showMenu(scan);
                    break;
                case "new user":
                    newUser(scan);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Command not recognised.");
            }
        }
    }

    private static void newUser(Scanner scan){
        String username;
        boolean dupe;
        boolean exit = false;
        do {
            System.out.println("provide username");
            username = scan.nextLine();
            dupe = UserService.isUsernameDupe(username);
            if (dupe){
                System.out.println("that username is already in use");
                System.out.println("try again?");
                if(!MenuService.yesNo(scan)){
                    dupe = false;
                    exit = true;
                }
            }
        } while(dupe);
        if(!exit) {
            System.out.println("provide password");
            String password = scan.nextLine();
            // TODO: add the new user to a database
            User user = UserService.makeUser(username, password);
            // TODO: check if user was created
            System.out.println("account creation successful");
        }
    }
}
