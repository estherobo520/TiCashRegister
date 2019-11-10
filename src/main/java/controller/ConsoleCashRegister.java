package controller;


import service.CustomerCheckout;

import java.util.Scanner;
import model.Item;

public class ConsoleCashRegister {


    public static Scanner keyboard = new Scanner(System.in);
    public static void main (String[] args) throws IllegalAccessException {
        String storeName;
        String storeNumber;
        String description ="";
        Double price= 0.0;
        String addAnotherItem = "yes";
        String userAnswer ="yes";
        Item itemToScan;
        String priceString;

        System.out.println("Enter store name:");
        storeName = keyboard.nextLine();
        System.out.println("Enter store number:");
        storeNumber = keyboard.nextLine();
        CustomerCheckout customerCheckout = new CustomerCheckout(storeName, storeNumber);
        while  (userAnswer.equalsIgnoreCase(addAnotherItem)) {
            System.out.println("Enter first item to scan:");
            description = keyboard.nextLine();
            System.out.println("Enter price:");
            priceString = keyboard.nextLine();
            price = Double.parseDouble(priceString);
            itemToScan = new Item(price, description);
            customerCheckout.scanAnItem(itemToScan);

            System.out.println("Do you want to scan another item? Yes or No");
            userAnswer = keyboard.nextLine();
        }

        System.out.println("Printing receipt...");
        customerCheckout.endTransaction();
    }
}