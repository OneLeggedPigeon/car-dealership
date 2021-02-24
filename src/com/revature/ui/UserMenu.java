package com.revature.ui;

import com.revature.collections.FlexArray;
import com.revature.model.*;
import com.revature.services.UserService;

import java.util.Scanner;

public abstract class UserMenu {

    public static void actionMenu(Scanner scan, User user){
        System.out.println("===Welcome "+user.getUserType()+" "+user+"===");
        FlexArray options = new FlexArray(new String[]{
                "logout",
                "exit"
        });
        //select what options to show the user based on UserType
        switch (user.getUserType()){
            case USER:
                options.add(new String[]{
                        "register customer account"
                });
                break;
            case CUSTOMER:
                options.add(new String[]{
                        "owned"
                });
            case EMPLOYEE:
                options.add(new String[]{
                        "lot",
                        "payments"
                });
                break;
            default:
        }
        boolean logout = false;

        while(!logout) {
            switch (QueryMenu.showMenu(scan, options.getStringArray())) {
                case "logout":
                    logout = true;
                    break;
                case "register customer account":
                    System.out.println("register");
                    switch (user.getUserType()){
                        case USER:
                            break;
                        case CUSTOMER:
                            System.out.println("you already have a customer account");
                            break;
                        case EMPLOYEE:
                            System.out.println("make a separate account for customer activities");
                            break;
                        default:
                    }
                    break;
                case "owned":
                    System.out.println("owned");
                    switch (user.getUserType()){
                        case USER:
                            System.out.println("you don't have permission for that");
                            break;
                        case CUSTOMER:
                            break;
                        case EMPLOYEE:
                            System.out.println("make a separate account for customer activities");
                            break;
                        default:
                    }
                    break;
                case "lot":
                    System.out.println("lot");
                    switch (user.getUserType()){
                        case USER:
                            System.out.println("you don't have permission for that");
                            break;
                        case CUSTOMER:
                            break;
                        case EMPLOYEE:
                            break;
                        default:
                    }
                    break;
                case "payments":
                    System.out.println("payments");
                    switch (user.getUserType()){
                        case USER:
                            System.out.println("you don't have permission for that");
                            break;
                        case CUSTOMER:
                            break;
                        case EMPLOYEE:
                            break;
                        default:
                    }
                    break;
                case "exit":
                    System.exit(1);
                    break;
                default:
                    System.out.println("Command not recognised.");
            }
        }
    }

    public static void newUser(Scanner scan){
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