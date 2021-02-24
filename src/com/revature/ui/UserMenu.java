package com.revature.ui;

import com.revature.model.*;
import com.revature.services.UserService;

import java.util.Scanner;

public abstract class UserMenu {

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