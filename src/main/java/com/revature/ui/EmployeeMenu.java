package com.revature.ui;

import com.revature.model.Employee;
import com.revature.model.User;
import com.revature.service.MenuService;

import java.util.Scanner;

public abstract class EmployeeMenu{
    protected static String[] options = new String[]{
            "lot",
            "payments",
            "logout",
            "exit"
    };

    //Loop through user options until logout
    public static void showMenu(Scanner scan, User user){
        System.out.println("===Welcome "+user.getUserType()+" "+user+"===");
        boolean logout;
        assert user instanceof Employee;
        do {
            logout = query(scan, (Employee) user);
        } while(!logout);
    }

    protected static boolean query(Scanner scan, Employee employee) {
        switch (MenuService.queryMenu(scan, options)) {
            case "lot":
                EmployeeLotMenu.showMenu(scan, employee);
                break;
            case "payments":
                //TODO:
                System.out.println("payments");
                break;
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