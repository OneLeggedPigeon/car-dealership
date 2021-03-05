package com.revature.ui;

import com.revature.collections.FlexArray;
import com.revature.model.User;
import com.revature.services.MenuService;
import com.revature.services.UserService;

import java.util.Scanner;

public abstract class UserMenu {

    protected static String[] options = new String[]{
            "register",
            "logout",
            "exit"
    };

    //Loop through user options until logout
    public static void showMenu(Scanner scan, User user){
        System.out.println("===Welcome "+user.getUserType()+" "+user+"===");
        boolean logout;
        do {
            logout = query(scan, user);
        } while(!logout);
    }

    // called by showMenu, overloaded by child menus
    protected static boolean query(Scanner scan, User user) {
        switch (MenuService.queryMenu(scan, options)) {
            case "register":
                //TODO: registration
                LoginMenu.primeLogin(UserService.registerUser(user));
                System.out.println("customer account registered");
                return true;
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
}