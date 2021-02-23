package com.revature.ui;

import com.revature.people.*;
import com.revature.services.UserService;

import java.util.Scanner;

public class UserMenu {

    public void CreateUserMenu(){
        Scanner scan = new Scanner(System.in);

        System.out.println("===Welcome to Car Dealership===");
        System.out.println("provide username");
        String username = scan.nextLine();
        while(UserService.isUsernameDupe(username)){
            System.out.println("that username is already in use");
            System.out.println("provide different username");
            username = scan.nextLine();
        }
        System.out.println("provide password");
        String password = scan.nextLine();
        // TODO: add the new user to a database
        User user = UserService.makeUser(username, password);
        // TODO: check if user was created
        System.out.println("Hello " + user);
    }
}