package com.revature.ui;

import com.revature.model.Car;
import com.revature.model.Lot;
import com.revature.model.User;
import com.revature.service.CarService;
import com.revature.service.MenuService;

import java.util.Scanner;

public abstract class CustomerLotMenu {
    protected static String[] options = new String[]{
            "select",
            "back",
            "exit"
    };

    public static void showMenu(Scanner scan, User user){
        System.out.println("===Welcome to the Car Lot, CUSTOMER===");
        boolean back;
        do {
            back = query(scan, user);
        } while(!back);
    }

    protected static boolean query(Scanner scan, User user) {
        System.out.println(CarService.toStringCarsLot());
        switch (MenuService.queryMenu(scan, options)) {
            case "select":
                select(scan, user);
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

    private static void select(Scanner scan, User user) {
        if (CarService.lotCarExists()) {
            System.out.println("which car?");
            int input = MenuService.queryInt(scan, CarService.toStringCarsLot(), "car_id");
            assert input >= -1;
            if (input > -1) {
                for (Car car : Lot.getInstance().toArray()) {
                    if (car.getID() == input) {

                        CustomerCarMenu.showMenu(scan, user, car);
                        break;
                    }
                }
            }
        } else {
            System.out.println("no cars in the lot");
        }
    }
}
