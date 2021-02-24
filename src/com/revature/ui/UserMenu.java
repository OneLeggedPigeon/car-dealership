package com.revature.ui;

import com.revature.collections.FlexArray;
import com.revature.model.*;
import com.revature.services.UserService;

import java.util.Scanner;

public abstract class UserMenu {

    public static void actionMenu(Scanner scan, User user){
        System.out.println("===Welcome "+user+"===");
        FlexArray options = new FlexArray(new String[]{
                "logout"
        });
        if(user.getUserType() == UserType.USER){
            options.add(new String[]{
                    "register customer account"
            });
        }
        if(user.getUserType() == UserType.CUSTOMER){
            options.add(new String[]{
                    "lot",
                    "owned",
                    "payments"
            });
        }
        if(user.getUserType() == UserType.EMPLOYEE){
            options.add(new String[]{
                    "lot",
                    "payments"
            });
        }

        while(true) {
            switch (QueryMenu.showMenu(scan, options.getStringArray())) {
                case "login":
                    LoginMenu.showMenu(scan);
                    break;
                case "new user":
                    UserMenu.newUser(scan);
                    break;
                case "logout":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Command not recognised.");
            }
        }
    }

    public static void newUser(Scanner scan){
        String username = "";
        boolean dupe;
        boolean exit = false;
        do {
            System.out.println("provide username");
            username = scan.nextLine();
            dupe = UserService.isUsernameDupe(username);
            if (dupe){
                System.out.println("that username is already in use");
                System.out.println("try again?");
                if(!QueryMenu.yesNo(scan)){
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