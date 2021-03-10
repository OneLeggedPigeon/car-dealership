package com.revature.utility;

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

    /*
     * returns min-1 for back, usually -1
     */
    public static int queryInt(Scanner scan, String entries, String label, int min){
        int result = min-1;
        boolean back = false;
        do {
            // display entries to choose from
            System.out.println(entries);
            // display all query options
            System.out.println(label+"/back");
            // check which option was chosen
            String answer = scan.nextLine();
            if(!answer.equals("back")){
                try{
                    int intAnswer = Integer.parseInt(answer);
                    if(intAnswer < min){
                        System.out.println("input is out of bounds");
                    } else {
                        result = intAnswer;
                        back = true;
                    }
                } catch(NumberFormatException e){
                    System.out.println("please input a integer");
                }
            } else {
                result = min-1;
                back = true;
            }// exit query logic
        } while(!back);
        return result;
    }

    public static int queryInt(Scanner scan, String entries, String label){
        return queryInt(scan, entries, label, 0);
    }

    public static int queryInt(Scanner scan, String entries){
        return queryInt(scan, entries, "number", 0);
    }

}
