package com.revature;

import com.revature.config.DBProperties;
import com.revature.db.UserJDBC;
import com.revature.ui.*;
import com.revature.collections.*;
import com.revature.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Connection c = DBProperties.getConnection("dev");

        Scanner scan = new Scanner(System.in);

        RootMenu.showMenu(scan);
    }
}