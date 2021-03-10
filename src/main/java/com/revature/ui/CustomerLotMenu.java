package com.revature.ui;

import com.revature.model.Car;
import com.revature.model.Customer;
import com.revature.model.Lot;
import com.revature.service.CarService;
import com.revature.utility.MenuService;

import java.util.Scanner;

public abstract class CustomerLotMenu {

    public static void showMenu(Scanner scan, Customer customer){
        System.out.println("===Welcome to the Car Lot, CUSTOMER===");
        boolean back;
        do {
            back = query(scan, customer);
        } while(!back);
    }

    protected static boolean query(Scanner scan, Customer customer) {
        System.out.println(CarService.toStringCarsLot());
        return select(scan, customer);
    }

    private static boolean select(Scanner scan, Customer customer) {
        if (CarService.existsLotCar()) {
            System.out.println("which car?");
            int input = MenuService.queryInt(scan, CarService.toStringCarsLot(), "car_id");
            assert input >= -1;
            if (input > -1) {
                for (Car car : Lot.getInstance().toArray()) {
                    if (car.getId() == input) {

                        CustomerCarMenu.showMenu(scan, customer, car);
                        return false;
                    }
                }
            }
        } else {
            System.out.println("no cars in the lot");
        }
        return true;
    }
}
