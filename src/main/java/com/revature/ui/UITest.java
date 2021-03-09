package com.revature.ui;

import com.revature.db.ConnectionFactory;
import com.revature.db.service.UpdateService;
import com.revature.service.UserService;

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
    }
}
