package com.revature.ui;

import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.utility.MenuService;

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
                payments();
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

    private static void payments() {
        System.out.println("===Oustanding Payments===");
        StringBuilder s = new StringBuilder();
        boolean empty = true;
        for(Customer customer : UserService.getCustomers()){
            if (!customer.getLoans().isEmpty()) {
                empty = false;
                s.append(customer.getLoans().toString());
            }
        }
        if (empty){
            s.append("You have no Outstanding Payments");
        }
        System.out.println(s);
    }
}