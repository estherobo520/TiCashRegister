package controller;


import model.Receipt;
import service.CustomerCheckout;

import java.util.Scanner;
import model.Item;

public class ConsoleCashRegister {

    final static String YES = "yes";
    public static Scanner keyboard = new Scanner(System.in);

    public static void main (String[] args) throws IllegalAccessException {
        String storeName;
        String storeNumber;
        String description ="";
        Double price= 0.0;
        String userAnswer ="yes";
        String priceString;

        System.out.println("Enter store name:");
        storeName = keyboard.nextLine();
        System.out.println("Enter store number:");
        storeNumber = keyboard.nextLine();
        CustomerCheckout customerCheckout = new CustomerCheckout(storeName, storeNumber);
        while  (YES.equalsIgnoreCase(userAnswer)) {
            Item itemToScan;
            int quantity = 0;
            String quantityString;
            System.out.println("Enter item to scan:");
            description = keyboard.nextLine();

            System.out.println("How many " + description + "s?");
            quantityString = keyboard.nextLine();
            int x = 0;
            while (x == 0) {
                try {
                    quantity = Integer.parseInt(quantityString);
                    x = 1;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number.");
                }
            }
            System.out.println("Enter price:");
            priceString = keyboard.nextLine();
            while (x !=2) {
                try {
                    price = Double.parseDouble(priceString);
                    x = 2;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a correct price.");
                }
            }
            itemToScan = new Item(price, description);
            if (quantity <= 1) {
                customerCheckout.scanAnItem(itemToScan);
            }
            else {
                customerCheckout.scanAnItem(itemToScan, quantity);
            }

            System.out.println("Do you want to scan another item? Yes or No");
            userAnswer = keyboard.nextLine();
        }

        System.out.println("Printing receipt...");
        Receipt receipt = customerCheckout.endTransaction();
        System.out.println(receipt);


    }
}