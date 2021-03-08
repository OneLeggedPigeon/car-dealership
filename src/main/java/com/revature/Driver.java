package com.revature;

import com.revature.db.*;
import com.revature.ui.*;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        ConnectionFactory.getInstance();

        Scanner scan = new Scanner(System.in);

        RootMenu.showMenu(scan);
    }
}