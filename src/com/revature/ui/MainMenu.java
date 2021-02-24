package com.revature.ui;

import java.util.Scanner;

public abstract class MainMenu {
    public static void rootMenu(Scanner scan){
        boolean loop = true;
        String[] options = new String[]{
                "login",
                "new user"
        };
        do {
            switch (QueryMenu.query(scan, options)) {
                case "login":
                    LoginMenu.showMenu();
                    break;
                case "new user":
                    UserMenu.newUser();
                    break;
                default:
            }
        }while(loop);
    }
}
