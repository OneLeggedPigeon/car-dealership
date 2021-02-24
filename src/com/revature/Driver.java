package com.revature;

import com.revature.ui.*;
import com.revature.collections.*;
import com.revature.model.*;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        MainMenu.rootMenu(scan);
    }
}