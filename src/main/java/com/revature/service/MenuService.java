package com.revature.service;

import java.util.Scanner;

public abstract class MenuService {
    public static String queryMenu(Scanner scan, String[] queries){
        String result = "";
        boolean continueLoop = true;
        do {
            //display all query options
            for(int i = 0; i<queries.length; i++){
                System.out.print(queries[i]);
                //add slash after all but the last query
                if (i<queries.length-1){System.out.print("/");}
            }
            System.out.println();
            //check which option was chosen
            String answer = scan.nextLine();
            for (String q : queries) {
                if (answer.equals(q)) {
                    result = q;
                    continueLoop = false;
                    break;
                }
            }
            if(continueLoop) System.out.println("Command not recognised.");
        } while(continueLoop);
        return result;
    }
    //"y" returns true, "n" returns false
    public static boolean yesNo(Scanner scan){
        while(true) {
            System.out.println("y/n");
            String answer = scan.nextLine();
            if(answer.equals("y")){
                return true;
            } else if(answer.equals("n")){
                return false;
            }
        }
    }
}
