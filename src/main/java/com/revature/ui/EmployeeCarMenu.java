package com.revature.ui;

import com.revature.model.Car;
import com.revature.model.Employee;
import com.revature.model.Offer;
import com.revature.utility.MenuService;
import com.revature.service.OfferService;

import java.util.Scanner;

public abstract class EmployeeCarMenu {

    protected static String[] offerOptions = new String[]{
            "accept",
            "reject",
            "back"
    };

    public static void showMenu(Scanner scan, Employee employee, Car car){
        System.out.println("==="+car.getModel()+"===");
        boolean back;
        do {
            back = query(scan, employee, car);
        } while(!back);
    }

    protected static boolean query(Scanner scan, Employee employee, Car car) {
        if(!car.getOffers().isEmpty()){
            return select(scan, employee, car);
        } else {
            System.out.println("no offers remain for this car");
            return true;
        }
    }

    private static boolean select(Scanner scan, Employee employee, Car car) {
        boolean result = false;
        int input = MenuService.queryInt(scan, car.getOffers().toString(),"offer_id");
        assert input >= -1;
        if(input > -1){
            for(Offer offer : car.getOffers().toArray()){
                if(offer.getId() == input){
                    result = judgeOffer(scan, employee, offer);
                }
            }
        } else {
            result = true;
        }
        return result;
    }

    private static boolean judgeOffer(Scanner scan, Employee employee, Offer offer) {
        switch (MenuService.queryMenu(scan, offerOptions)) {
            case "accept":
                OfferService.acceptOffer(offer);
                System.out.println("offer accepted!");
                break;
            case "reject":
                OfferService.removeOffer(offer);
                System.out.println("offer rejected!");
                break;
            case "back":
                return true;
            default:
                System.out.println("This shouldn't show up.");
        }
        return false;
    }
}
