package com.hesenid.stockMgt;

import java.util.Scanner;

/**
 * Created by hsenid on 10/17/16.
 * @author Vidushka
 */
public class StockController {
    static Scanner input = new Scanner(System.in);
    static StockService newStock = new StockService();
    static int id = 3;

    /**
     *main method executes add record method of this class
     */
    public static void main(String[] args) {
        addRecord();
    }

    /**
     * Method use to add update a record. This method uses objects of EntityDetails and StockServices classes
     */
    public static void addRecord() {

        /*
        Defalut value set
         */
        EntryDetails d1 = new EntryDetails();
        d1.pId = 1;
        d1.pName = "Suger";
        d1.qty = 10;
        d1.unitPrice = 100;
        newStock.newEntry.put(String.valueOf(d1.pId), d1);

        EntryDetails d2 = new EntryDetails();
        d2.pId = 2;
        d2.pName = "Tomato";
        d2.qty = 20;
        d2.unitPrice = 80;
        newStock.newEntry.put(String.valueOf(d2.pId), d2);

        top:
        for (; ; ) {
            System.out.println("Are you going to update(u) or add(a) new record or view(v) or genarate bill(b) or exit(ex)? ");
            String insertType = input.nextLine();
            insert:
            if (insertType.equals("a")) {

                EntryDetails ent = new EntryDetails();
                ent.pId = id;

                System.out.println("Please enter Product name ");
                String product = input.nextLine().toLowerCase();
                ent.pName = product;

                System.out.println("Enter Qty of " + product);
                double pQty = Double.parseDouble(input.nextLine());
                ent.qty = pQty;

                System.out.println("Enter the unit price ");
                double price = Double.parseDouble(input.nextLine());
                ent.unitPrice = price;

                newStock.putRecords(String.valueOf(id), ent);
                id++;

                System.out.println("Do you enter more records (y/n)? ");
                String swtch = input.nextLine();
                if (swtch.equals("n")) {
                    newStock.getReport();
                    break top;

                } else if (swtch.equals("y")) {
                    continue;
                }

            } else if (insertType.equals("u")) {
                System.out.println("Type product Id");
                String updatingId = input.nextLine();

                System.out.println("Is this the record that you want to update ?");
                newStock.viewSelected(updatingId);

                System.out.println("To update Product name(p), Quantity(q), Unit price(up) or Exit (x)");
                String updateSelection = input.nextLine();

                if (updateSelection.equals("x")) {
                    break insert;
                } else if (updateSelection.equals("p")) {
                    System.out.println("New product name");
                    String pNameUp = input.nextLine();
                    EntryDetails a = newStock.newEntry.get(updatingId);
                    a.pName = pNameUp;

                    newStock.newEntry.put(updatingId, a);
                    newStock.viewSelected(updatingId);
                } else if (updateSelection.equals("q")) {
                    System.out.println("New quantity");
                    double qtyUp = Double.parseDouble(input.nextLine());
                    EntryDetails a = newStock.newEntry.get(updatingId);
                    a.qty = qtyUp;

                    newStock.newEntry.put(updatingId, a);
                    newStock.viewSelected(updatingId);
                } else if (updateSelection.equals("up")) {
                    System.out.println("New unit price");
                    double priceUp = Double.parseDouble(input.nextLine());
                    EntryDetails a = newStock.newEntry.get(updatingId);
                    a.unitPrice = priceUp;

                    newStock.newEntry.put(updatingId, a);
                    newStock.viewSelected(updatingId);
                }

            } else if (insertType.equals("v")) {
                System.out.println("View all(all) or type product id");
                String viewType = input.nextLine();

                if (viewType.equals("all")) {
                    newStock.viewAllStocks();
                } else {
                    newStock.viewSelected(viewType);
                }
            } else if (insertType.equals("b")) {
                newStock.getReport();

                System.out.println("Payment");
                double payment = Double.parseDouble(input.nextLine());
                double balance = payment - newStock.tot;
                newStock.getReport();
                System.out.println("Paied " + payment);
                System.out.println("balance " + balance);
            } else if (insertType.equals("ex")) {
                break top;
            }
        }
    }
}


