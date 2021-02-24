package com.revature;

import com.revature.ui.*;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        UserMenu menu = new UserMenu();
        Scanner scan = new Scanner(System.in);

        boolean continueLoop = true;
        do {
            System.out.println("Do you want to create a new user?");

            boolean answer = QueryMenu.yesNo(scan);
            if(!answer){
                continueLoop = false;
            } else if(answer){
                menu.createUserMenu();
            }
        } while(continueLoop);

        LoginMenu.showMenu();
    }
}
