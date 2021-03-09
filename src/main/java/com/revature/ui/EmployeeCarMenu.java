package com.revature.ui;

import com.revature.model.Car;
import com.revature.model.Employee;
import com.revature.model.Offer;
import com.revature.service.CarService;
import com.revature.service.MenuService;

import java.util.Scanner;

public abstract class EmployeeCarMenu {
    protected static String[] options = new String[]{
            "select",
            "back",
            "exit"
    };

    public static void showMenu(Scanner scan, Employee employee, Car car){
        System.out.println("==="+car.getModel()+"===");
        System.out.println(car.getOffers().toString());
        boolean back;
        do {
            back = query(scan, employee, car);
        } while(!back);
    }

    protected static boolean query(Scanner scan, Employee employee, Car car) {
        switch (MenuService.queryMenu(scan, options)) {
            case "select":
                select(scan, employee, car);
                break;
            case "back":
                return true;
            case "exit":
                System.exit(1);
                break;
            default:
                System.out.println("This shouldn't show up.");
        }
        return false;
    }

    private static void select(Scanner scan, Employee employee, Car car) {
        boolean back = false;
        while(!back) {
            int input = MenuService.queryInt(scan, car.getOffers().toString(),"offer_id");
            assert input >= -1;
            if(input > -1){
                for(Offer offer : car.getOffers().toArray()){
                    if(offer.getId() == input){

                        // TODO: actually implement this
                        System.out.println("offer accepted!");
                        break;
                    }
                }
            } else {
                back = true;
            }
        }
    }
}
