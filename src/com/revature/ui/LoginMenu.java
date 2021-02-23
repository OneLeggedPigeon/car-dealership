package com.revature.ui;

import java.util.Scanner;
import com.revature.services.*;

public abstract class LoginMenu {

    public static void showMenu(){
        Scanner scan = new Scanner(System.in);
        boolean loggedIn = false;

        do {
            System.out.println("username: ");
            String username = scan.nextLine();
            System.out.println("password: ");
            String password = scan.nextLine();
            if (UserService.isLoginValid(username, password)) {
                System.out.println("login successful");
                loggedIn = true;
            } else System.out.println("login is invalid");
        } while(!loggedIn);
    }
}
