package model;

import CsLinkedList.CsLinkedList;
import org.junit.Test;
import service.CustomerCheckout;
import java.util.Date;
import static org.junit.Assert.*;

public class ReceiptTest {
    private Receipt receipt;
    private CustomerCheckout customerCheckout;
    private Double totalPrice =0.0;
    private Integer totalItems=0;
    private CsLinkedList<Item> itemList;
    private Item itemToScan;

    @Test public void getStoreName_returnsStoreName(){

        receipt = new Receipt("Target" ,"123");
        assertEquals("Target", receipt.getStoreName());
    }

    @Test public void getStoreNumber_returnsStoreNumber(){
        receipt = new Receipt("Target" ,"123");
        assertEquals("123", receipt.getStoreNumber());
    }

    @Test public void getTotalPrice_returnsTotalPrice() throws IllegalAccessException {
        receipt = new Receipt("Target" ,"123");
        itemToScan = new Item(2.0, "apples");
        receipt.add(itemToScan);
        receipt.add(itemToScan);
        assertEquals(new Double (4.0), receipt.getTotalPrice());

    }

    @Test public void getTotalItems_returnsTotalItems() throws IllegalAccessException {
        receipt = new Receipt("Target" ,"123");
        itemToScan = new Item(2.20, "apples");
       for (int i = 0; i < 3;i++) {
            receipt.add(itemToScan);
        }
        assertEquals(new Integer(3), receipt.getTotalItems());
    }

    @Test public void getDate_returnsDate() throws InterruptedException {
        receipt = new Receipt("Target" ,"123");
        //Thread.sleep(1000);
        Date date = new Date();
        assertEquals(date, receipt.getDate());
    }

    @Test public void getItemList_returnsItemList_fails() throws IllegalAccessException {
        receipt = new Receipt("Target" ,"123");
        itemToScan = new Item(2.20, "apples");
        CsLinkedList<Item> expectedList = new CsLinkedList<Item>();
        expectedList.add(itemToScan);
        expectedList.add(itemToScan);
        receipt.add(itemToScan);
        receipt.add(itemToScan);
        assertEquals(expectedList, receipt.getItemList());
    }
//wrong - need to remove customerCheckout
    @Test public void add_addsItemToReceipt() throws IllegalAccessException {
        itemList = new CsLinkedList<Item>();
        receipt = new Receipt("Target" ,"123");
        itemToScan = new Item(5.50, "pens");
        customerCheckout = new CustomerCheckout("storeName" ,"storeNum");
        customerCheckout.scanAnItem(itemToScan);
        //itemList.add(itemToScan);
        totalPrice += itemToScan.getPrice();
        totalItems++;

        assertEquals("pens", customerCheckout.endTransaction());
    }

    }