package model;

import CsLinkedList.CsLinkedList;

import java.lang.reflect.Array;
import java.util.Date;

public class Receipt {

   /* //json code
        "StoreName": "Target",
        "totalPrice": 2.99,
    }*/

    private String storeName;
    private String storeNumber;
    private Double totalPrice;
    private Integer totalItems;
    private Date date;
    private CsLinkedList<Item> itemList;

    public String getStoreName() {
        return storeName;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public Date getDate() {
        return date;
    }

    public CsLinkedList<Item> getItemList() {
        return itemList;
    }

    public Receipt(String storeName, String storeNumber) {
        this.storeName = storeName;
        this.storeNumber = storeNumber;
        itemList = new CsLinkedList<Item>();
        totalItems = 0;
        totalPrice = 0.0;
        date = new Date();
    }

    public void add(Item itemToScan) throws IllegalAccessException {
        itemList.add(itemToScan);
        totalPrice += itemToScan.getPrice();
        totalItems++;
    }

    @Override

    public String toString() {

        int counter = 1;
        String itemListString = "";
        while (itemList.size() > 0) {
            try {
                Item item = itemList.getAndRemove(0);
               itemListString += "" + counter + ". " + item.getDescription() + "... " + item.getPrice() +"\n";
               counter++;
            } catch (IllegalAccessException e) {
                //e.printStackTrace();
            }
        }

        return "Thank you for shopping at " + storeName + " " + storeNumber + ".\n " +
                date + "\n" +
                itemListString + "    " + "\n" +
                "Total price " + totalPrice + "\n" +
                "Please come again.";
    }

}
