package com.revature;

import com.revature.db.*;
import com.revature.db.service.UpdateService;
import com.revature.ui.*;
//import org.apache.logging.log4j.*;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        ConnectionFactory.getInstance();
        UpdateService.getInstance();

        Scanner scan = new Scanner(System.in);

        RootMenu.showMenu(scan);
    }
}