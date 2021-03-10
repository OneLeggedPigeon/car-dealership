package com.revature.ui;

import com.revature.model.Car;
import com.revature.model.Employee;
import com.revature.model.Lot;
import com.revature.service.CarService;
import com.revature.utility.MenuService;

import java.util.Scanner;

public abstract class EmployeeLotMenu {
    protected static String[] options = new String[]{
            "add",
            "remove",
            "offers",
            "back",
            "exit"
    };

    public static void showMenu(Scanner scan, Employee employee){
        System.out.println("===Welcome to the Car Lot, EMPLOYEE===");
        boolean back;
        do {
            back = query(scan, employee);
        } while(!back);
    }

    protected static boolean query(Scanner scan, Employee employee) {
        System.out.println(CarService.toStringCarsUnowned());
        switch (MenuService.queryMenu(scan, options)) {
            case "add":
                add(scan);
                break;
            case "remove":
                remove(scan);
                break;
            case "offers":
                offers(scan, employee);
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
        while(!back && CarService.existsUnownedNoLotCar()) {
            int input = MenuService.queryInt(scan, CarService.toStringCarsUnownedNoLot(),"car_id");
            assert input >= -1;
            if(input > -1){
                for(Car car : CarService.arrayUnownedNoLotCar()){
                    if(car.getId() == input){
                        lot.addCar(car);
                        System.out.println("added " + car.toString());
                        break;
                    }
                }
            } else {
                back = true;
            }
        }
        if(!CarService.existsUnownedNoLotCar()){
            System.out.println("no stored cars");
        }
    }

    private static void remove(Scanner scan) {
        Lot lot = Lot.getInstance();
        boolean back = false;
        while(!back && CarService.existsLotCar()) {
            int input = MenuService.queryInt(scan, CarService.toStringCarsLot(),"car_id");
            assert input >= -1;
            if(input > -1){
                for(Car car : lot.toArray()){
                    if(car.getId() == input){
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

    private static void offers(Scanner scan, Employee employee) {
        System.out.println("which car?");
        boolean back = false;
        while(!back && CarService.existsCarWithOffer()) {
            int input = MenuService.queryInt(scan, CarService.toStringCarsOffer(),"car_id");
            assert input >= -1;
            if(input > -1){
                for(Car car : CarService.arrayOfferCar()){
                    if(car.getId() == input){
                        EmployeeCarMenu.showMenu(scan, employee, car);
                        break;
                    }
                }
            } else {
                back = true;
            }
        }
        if(!CarService.existsCarWithOffer()){
            System.out.println("no current offers");
        }
    }
}
