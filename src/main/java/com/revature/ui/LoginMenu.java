package com.revature.ui;

import java.util.Scanner;

import com.revature.model.*;
import com.revature.services.*;

public abstract class LoginMenu {
    // User to automatically log in after logout
    private static User primed = null;

    public static void showMenu(Scanner scan){
        System.out.println("username: ");
        String username = scan.nextLine();
        System.out.println("password: ");
        String password = scan.nextLine();
        // TODO: Handel Exception
        User user = UserService.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("login successful");
            //loop login if there is a User primed to relogin automatically
            do{
                if(primed != null){
                    user = primed;
                    primed = null;
                }
                switch(user.getUserType()){
                    case USER:
                        UserMenu.showMenu(scan, user);
                        break;
                    case EMPLOYEE:
                        EmployeeMenu.showMenu(scan, user);
                        break;
                    case CUSTOMER:
                        CustomerMenu.showMenu(scan, user);
                        break;
                    default:
                }
            } while (primed != null);
        } else {
            System.out.println("login is invalid");
        }
    }

    // Automatically login the next time the stack returns to RootMenu
    public static void primeLogin(User user) {
        primed = user;
    }
}
