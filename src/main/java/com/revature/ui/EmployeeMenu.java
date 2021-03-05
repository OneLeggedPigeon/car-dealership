package com.revature.ui;

import com.revature.collections.FlexArray;
import com.revature.model.User;
import com.revature.services.MenuService;

import java.util.Scanner;

public class EmployeeMenu extends UserMenu{
    protected static String[] options = new String[]{
            "lot",
            "payments",
            "logout",
            "exit"
    };
    protected static boolean query(Scanner scan, User user, boolean logout) {
        switch (MenuService.queryMenu(scan, options)) {
            case "lot":
                System.out.println("lot");
                break;
            case "payments":
                System.out.println("payments");
                break;
            case "logout":
                logout = true;
                break;
            case "exit":
                System.exit(1);
                break;
            default:
                System.out.println("This shouldn't show up.");
        }
        return logout;
    }
}
