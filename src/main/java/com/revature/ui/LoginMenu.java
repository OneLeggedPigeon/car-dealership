package com.revature.ui;

import java.util.Scanner;

import com.revature.model.*;
import com.revature.services.*;

public abstract class LoginMenu {

    public static void showMenu(Scanner scan){
        System.out.println("username: ");
        String username = scan.nextLine();
        System.out.println("password: ");
        String password = scan.nextLine();
        User user = UserService.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("login successful");
            UserMenu.showMenu(scan, user);
        } else {
            System.out.println("login is invalid");
        }
    }
}
