package com.revature.ui;

import java.util.Scanner;

public abstract class QueryMenu {
    public static boolean yesNo(Scanner scan){
        boolean result = false;
        boolean continueLoop = true;
        do {
            System.out.println("y/n");
            String answer = scan.nextLine();
            if(answer.equals("y")){
                continueLoop = false;
                result = true;
            } else if(answer.equals("n")){
                continueLoop = false;
            }
        } while(continueLoop);
        return result;
    }
}
