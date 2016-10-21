package com.hesenid.stockMgt;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by hsenid on 10/17/16.
 * @author Vidushka
 */
public class StockService {
    HashMap<String, EntryDetails> newEntry = new HashMap<String, EntryDetails>();

    HashMap<String,EntryDetails> purchasedItems = new HashMap<String, EntryDetails>();

    /**
     * Method to calculate the total price and genarate a bill for stock
     */
    double tot = 0.0;
    double balance = 0.0;

    /**
     * @param x - key of newEntry map to put a record
     * @param entry - is a object of EntryDetails it contains productId, productName, quantity, unit price
     * putRecords maethod use to insert a stock record into program
     */
    public void putRecords(String x, EntryDetails entry) {
        newEntry.put(x, entry);
    }

    /**
     * This method will print all the stock entries
     */
    public void viewAllStocks() {
        for (int i = 1; i <= newEntry.size(); i++) {
            EntryDetails x = newEntry.get(Integer.toString(i));
            System.out.print(x.pId);
            System.out.print("  |  ");
            System.out.print(x.pName);
            System.out.print("  |  ");
            System.out.print(x.qty);
            System.out.print("  |  ");
            System.out.print(x.unitPrice);
            System.out.println();
            System.out.println();
        }
    }

    /**
     * @param s - use as a key of newEntry map
     * Use to print selected record
     */
    public void viewSelected(String s) {
        EntryDetails x = newEntry.get(s);
        System.out.print(x.pId);
        System.out.print("  |  ");
        System.out.print(x.pName);
        System.out.print("  | ");
        System.out.print(x.qty);
        System.out.print(" | ");
        System.out.print(x.unitPrice);
        System.out.println();
        System.out.println();
    }

    /**
     * Use to genarate bill
     */
    public void getReport() {
        System.out.println("-----------------My Store ---------------");
        System.out.println();

        Date billDate = new Date();
        System.out.print(billDate.toString());

        System.out.println();
        System.out.println();
        System.out.print("Product Name | Unit Price | Quantity | Price");
        System.out.println();
        System.out.println("--------------------------------------------");

        for (HashMap.Entry<String, EntryDetails> entry : purchasedItems.entrySet()) {
            EntryDetails en = purchasedItems.get(entry.getKey());
            System.out.print(en.pName);
            System.out.print("        |  ");
            System.out.print(en.unitPrice);
            System.out.print("     |  ");
            System.out.print(en.qty);
            System.out.print("     |  ");
            System.out.print(en.totalValue);
            System.out.println();
            tot = tot + en.totalValue;
        }

        System.out.println();
        System.out.print("Total           ----------             " + tot);
        System.out.println();
    }

    /**
     * @param t -- key to store records in purchasedItem map
     * @param d -- quantity of product which user added to cart
     */
    public void addToCart(String t,double d) {
        EntryDetails billData = new EntryDetails();
        billData.pId = Integer.parseInt(t);
        billData.qty = d;
        billData.unitPrice = newEntry.get(t).unitPrice;
        billData.pName = newEntry.get(t).pName;
        billData.totalValue = newEntry.get(t).unitPrice * d;
        purchasedItems.put(t, billData);
    }

    /**
     * Count the remaining balance of your payment
     * @param p -- Is the amount you paid
     */
    public void countBalance(double p) {
        balance = p - tot;
        System.out.println("Payed          -----------             " + p);
        System.out.println("Balance        -----------             " + balance);
    }

    /**
     * count the notes which have to give as the balance of
     */
    public void showNotes() {
        int notes2k = (int)balance/2000;
        System.out.println("2000 notes     -----------             " + notes2k);
        balance = balance - notes2k*2000;

        int notes1k = (int)balance/1000;
        System.out.println("1000 notes     -----------             " + notes1k);
        balance = balance - notes1k*1000;

        int notes500 = (int)balance/500;
        System.out.println("500 notes      -----------             " + notes500);
        balance = balance - notes500*500;

        int notes100 = (int)balance/100;
        System.out.println("100 notes      -----------             " + notes100);
        balance = balance - notes100*100;

        int notes50 = (int)balance/50;
        System.out.println("50 notes       -----------             " + notes50);
        balance = balance - notes50*50;

        int notes20 = (int)balance/20;
        System.out.println("20 notes       -----------             " + notes20);
        balance = balance - notes20*20;

        int coins10 = (int)balance/10;
        System.out.println("10 coins       -----------             " + coins10);
        balance = balance - coins10*10;

        int coins5 = (int)balance/5;
        System.out.println("5 coins        -----------             " + coins5);
        balance = balance - coins5*5;

        int coins2 = (int)balance/2;
        System.out.println("2 coins        -----------             " + coins2);
        balance = balance - coins2*2;

        int coins1 = (int)balance/1;
        System.out.println("1 coins        -----------             " + coins1);
        balance = balance - coins1*1;
    }

}

