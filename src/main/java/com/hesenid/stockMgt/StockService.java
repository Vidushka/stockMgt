package com.hesenid.stockMgt;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by hsenid on 10/17/16.
 * @author Vidushka
 */
public class StockService {
    HashMap<String, EntryDetails> newEntry = new HashMap<String, EntryDetails>();
    /**
     * Method to calculate the total price and genarate a bill for stock
     */
    double tot = 0.0;

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

        double[] productTot = new double[newEntry.size()];

        for (int i = 0; i < newEntry.size(); i++) {
            EntryDetails en = newEntry.get(Integer.toString(i + 1));
            productTot[i] = en.qty * en.unitPrice;
            System.out.print(en.pName + "        | ");
            System.out.print(en.unitPrice + "      | ");
            System.out.print(en.qty + "     | ");
            System.out.print(productTot[i]);
            System.out.println();
            tot = tot + productTot[i];
        }

        System.out.println();
        System.out.print("Total           ----------             " + tot);
        System.out.println();
        System.out.println();

    }

}

