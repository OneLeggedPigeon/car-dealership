package com.revature.ui;

import com.revature.model.Car;
import com.revature.model.Lot;
import com.revature.model.User;
import com.revature.service.CarService;
import com.revature.service.MenuService;

import java.util.Scanner;

public abstract class EmployeeLotMenu {
    protected static String[] options = new String[]{
            "add",
            "remove",
            "back",
            "exit"
    };

    public static void showMenu(Scanner scan, User user){
        System.out.println("===Welcome to the Car Lot, EMPLOYEE===");
        boolean back;
        do {
            back = query(scan, user);
        } while(!back);
    }

    protected static boolean query(Scanner scan, User user) {
        System.out.println(CarService.toStringCarsUnowned());
        switch (MenuService.queryMenu(scan, options)) {
            case "add":
                add(scan);
                break;
            case "remove":
                remove(scan);
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

    private static void add(Scanner scan) {
        Lot lot = Lot.getInstance();
        boolean back = false;
        while(!back && CarService.unownedNoLotCarExists()) {
            int input = MenuService.queryInt(scan, CarService.toStringCarsUnownedNoLot(),"car_id");
            assert input >= -1;
            if(input > -1){
                for(Car car : CarService.unownedNoLotCarArray()){
                    if(car.getID() == input){
                        lot.addCar(car);
                        System.out.println("added " + car.toString());
                        break;
                    }
                }
            } else {
                back = true;
            }
        }
        if(!CarService.unownedNoLotCarExists()){
            System.out.println("no stored cars");
        }
    }

    private static void remove(Scanner scan) {
        Lot lot = Lot.getInstance();
        boolean back = false;
        while(!back && !lot.isEmpty()) {
            int input = MenuService.queryInt(scan, CarService.toStringCarsLot(),"car_id");
            assert input >= -1;
            if(input > -1){
                for(Car car : lot.toArray()){
                    if(car.getID() == input){
                        lot.removeCar(car);
                        System.out.println("removed " + car.toString());
                        break;
                    }
                }
            } else {
                back = true;
            }
        }
        if(lot.isEmpty()){
            System.out.println("lot is empty");
        }
    }
}
