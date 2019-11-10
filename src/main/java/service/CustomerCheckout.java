package service;

import model.Item;
import model.Receipt;

public class CustomerCheckout {
    private static Receipt receipt;

    public CustomerCheckout(String storeName, String storeNumber) {

        receipt = new Receipt(storeName, storeNumber);
    }

    public void scanAnItem(Item itemToScan) throws IllegalAccessException {
        receipt.add(itemToScan);
    }

    public void scanAnItem(Item itemToScan, Integer amount) throws IllegalAccessException {
        for (int i = 0; i < amount; i++) {
            scanAnItem(itemToScan);
        }
    }

    public Receipt endTransaction() {
        return receipt;
    }
}
