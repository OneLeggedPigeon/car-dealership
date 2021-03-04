package com.revature;

import com.revature.db.UserJDBC;
import com.revature.ui.*;
import com.revature.collections.*;
import com.revature.model.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        UserJDBC u = new UserJDBC();
        try {
            u.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Scanner scan = new Scanner(System.in);

        RootMenu.showMenu(scan);
    }
}