package com.revature;

import com.revature.ui.*;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        UserMenu menu = new UserMenu();
        Scanner scan = new Scanner(System.in);

        boolean continueLoop = true;
        do {
            System.out.println("Do you want to create a new user? y/n");
            String answer = scan.nextLine();
            if(answer.equals("n")){
                continueLoop = false;
            } else if(answer.equals("y")){
                menu.createUserMenu();
            }
        } while(continueLoop);

        LoginMenu.showMenu();
    }
}
