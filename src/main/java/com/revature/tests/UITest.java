package com.revature.tests;

import com.revature.db.ConnectionFactory;
import com.revature.db.service.UpdateService;
import com.revature.service.UserService;
import com.revature.ui.CustomerMenu;
import com.revature.ui.EmployeeMenu;

import java.util.Objects;
import java.util.Scanner;

public class UITest {
    public static void main(String[] args) {
        // Open Connections
        ConnectionFactory.getInstance();
        // Load from the DB
        UpdateService.getInstance();

        Scanner scan = new Scanner(System.in);

        //TESTING EMPLOYEE MENU
        EmployeeMenu.showMenu(scan, Objects.requireNonNull(UserService.getUserByUsername("Nate")));

        //TESTING CUSTOMER MENU
        //CustomerMenu.showMenu(scan, Objects.requireNonNull(UserService.getUserById(1)));
    }
}
