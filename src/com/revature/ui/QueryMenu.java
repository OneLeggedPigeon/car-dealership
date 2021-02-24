package com.revature.ui;

import java.util.Scanner;

public abstract class QueryMenu {
    //"y" returns true, "n" returns false
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

    //return String of the selected query
    public static String query(Scanner scan, String[] queries){
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
        } while(continueLoop);
        return result;
    }
}
