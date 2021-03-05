package com.revature.ui;

import com.revature.collections.FlexArray;
import com.revature.model.*;
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
        boolean logout = false;

        do {
            logout = query(scan, user, logout);
        } while(!logout);
    }

    // called by showMenu, overloaded by child menus
    protected static boolean query(Scanner scan, User user, boolean logout) {
        switch (MenuService.queryMenu(scan, options)) {
            case "register":
                //TODO: registration
                System.out.println("customer account registered");
                logout = true;
                break;
            case "logout":
                logout = true;
                break;
            case "exit":
                System.exit(1);
                break;
            default:
        }
        return logout;
    }
}