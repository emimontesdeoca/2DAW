/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifp.descuentos.view;

import es.cifp.descuentos.controller.Customer;
import es.cifp.descuentos.controller.Items;
import es.cifp.descuentos.controller.Visit;
import es.cifp.descuentos.descuentosApp;
import es.cifp.descuentos.model.FilePersistanceCustomers;
import es.cifp.descuentos.model.FilePersistanceItems;
import es.cifp.descuentos.model.FilePersistanceReceipt;
import static es.cifp.descuentos.view.Utils.roundDouble;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author emont
 */
public class CustomerMenu {

    public static void showCreateNewCustomerMenu() {

        Utils.showHeader();
        System.out.println();
        System.out.println("Create an user in order to use our stuff!");
        String a = Utils.getString("Customer name: ");
        String b = Utils.getString("Member type (premium, silver, gold): ");
        try {

            if (new FilePersistanceCustomers().customerExists(a, b)) {
                System.out.println();
                System.out.println("User already exist!");
            } else {
                Customer c = new Customer(a, true, b.toLowerCase());
                new FilePersistanceCustomers().save(c);
                System.out.println();
                System.out.println("User created!");
            }

        } catch (Exception e) {
        }
        Utils.finishStuff();
    }

    public static void showLoginCustomerMenu() {

        Utils.showHeader();
        String a = Utils.getString("Customer name: ");
        try {
            Customer c = new Customer().getCustomerByName(a);
            if (c != null) {
                descuentosApp.isLoggedIn = true;
                Date dt = new Date();
                descuentosApp.currentVisit = new Visit(a, dt);

                System.out.println();
                System.out.println("Login successful!");

                Utils.finishStuff();

                showMainCustomerMenu();

            } else {
                descuentosApp.isLoggedIn = false;
                System.out.println();
                System.out.println("Customer not found!");
            }

        } catch (Exception e) {
        }
        Utils.finishStuff();
    }

    public static void showMainCustomerMenu() {
        Integer option = 0;
        do {
            Utils.showHeader();
            System.out.println();
            System.out.println("--------------- ACCOUNT ----------------");
            System.out.println("Account name: " + descuentosApp.currentVisit.getName());
            String input = descuentosApp.currentVisit.getCustomerType();
            String output = input.substring(0, 1).toUpperCase() + input.substring(1);
            System.out.println("Account type: " + output);
            System.out.println("Login date: " + descuentosApp.currentVisit.getDate());
            System.out.println("----------------- CART -----------------");
            System.out.println("Product cart without discount: " + roundDouble(descuentosApp.currentVisit.getProductExpense()) + "$");
            System.out.println("Service cart without discount: " + roundDouble(descuentosApp.currentVisit.getServiceExpense()) + "$");
            System.out.println("Total without discount: " + roundDouble(descuentosApp.currentVisit.getTotalExpenseWithoutDiscount()) + "$");
            System.out.println("----------------------------------------");
            System.out.println("Total with discount: " + roundDouble(descuentosApp.currentVisit.getTotalExpense()) + "$");
            System.out.println("----------------------------------------");
            System.out.println();

            System.out.println("1. Buy a product");
            System.out.println("2. Buy a service");
            System.out.println("-----------------");
            System.out.println("9. Pay");
            System.out.println("-----------------");
            System.out.println("0. Log out");

            option = Utils.getInteger("Select an option: ");

            switch (option) {
                case 1:
                    showCustomerProductMenuToBuy();
                    break;
                case 2:
                    showCustomerServiceMenuToBuy();
                    break;
                case 9:
                    showCustomerPaymentDone();
                    break;
                case 0:
                    descuentosApp.isLoggedIn = false;
                    System.out.println();
                    System.out.println("Logged out successfully!");
                    break;

            }

        } while (option != 0);

    }

    public static void showCustomerProductMenuToBuy() {
        Utils.showHeader();
        System.out.println();
        List<Items> list = new Items().getAllItems();
        System.out.println("List of products available: ");
        System.out.println();

        if (list.size() > 0) {
            for (Items items : list) {
                System.out.println("Item name: " + items.getName());
                System.out.println("Item value: " + items.getValue() + "$");
                System.out.println("-----------------");
                System.out.println();

            }
        } else {
            System.out.println("No items found!");
        }
        try {

            String a = Utils.getString("Product name to buy (exit to cancel): ");
            if (a.equals("exit")) {

            } else {
                if (new FilePersistanceItems().itemExistsWithName(a)) {
                    for (Items items : list) {
                        if (items.getName().equals(a)) {
                            switch (Utils.getInteger("Are you sure? (1-Yes | 2-No)")) {
                                case 1:
                                    Items i = new Items().getItemByName(a);
                                    descuentosApp.currentVisit.setProductExpense(i.getValue());
                                    System.out.println();
                                    System.out.println("Product " + i.getName() + " was successfully added to your cart!");
                                    break;
                                case 2:
                                    System.out.println("Operation canceled!");
                                    break;
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println();
                    System.out.println("No item found with name: " + a);
                }
            }

        } catch (Exception e) {
        }
        Utils.finishStuff();
    }

    public static void showCustomerServiceMenuToBuy() {
        System.out.println("############### AMAZON.EMI ###############");
        System.out.println();
        System.out.println("List of services available: ");
        System.out.println();
        List<Items> list = new Items().getAllItems();
        if (list.size() > 0) {
            for (Items items : list) {
                System.out.println("Item name: " + items.getName());
                System.out.println("Item value: " + items.getValue() + "$");
                System.out.println("-----------------");
                System.out.println();
            }

            String a = Utils.getString("Service name to buy (exit to cancel): ");
            if (a.equals("exit")) {

            } else {
                if (new FilePersistanceItems().itemExistsWithName(a)) {
                    for (Items items : list) {
                        if (items.getName().equals(a)) {
                            switch (Utils.getInteger("Are you sure? (1-Yes | 2-No)")) {
                                case 1:
                                    Items i = new Items().getItemByName(a);
                                    descuentosApp.currentVisit.setServiceExpense(i.getValue());
                                    System.out.println();
                                    System.out.println("Service " + i.getName() + " was successfully added to your cart!");
                                    break;
                                case 2:
                                    System.out.println("Operation canceled!");
                                    break;
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println();
                    System.out.println("No item found with name: " + a);
                }
            }
        } else {
            System.out.println("No items found!");
        }
        Utils.finishStuff();
    }

    public static void showCustomerPaymentDone() {
        System.out.println("############### AMAZON.EMI ###############");
        System.out.println();
        System.out.println("--------------- RECEIPT ---------------");
        System.out.println();
        System.out.println("--------------- ACCOUNT ---------------");
        System.out.println("Account name: " + descuentosApp.currentVisit.getName());
        String input = descuentosApp.currentVisit.getCustomerType();
        String output = input.substring(0, 1).toUpperCase() + input.substring(1);
        System.out.println("Account type: " + output);
        System.out.println("Login date: " + descuentosApp.currentVisit.getDate());
        System.out.println("----------------- CART -----------------");
        System.out.println("Product cart without discount: " + roundDouble(descuentosApp.currentVisit.getProductExpense()) + "$");
        System.out.println("Service cart without discount: " + roundDouble(descuentosApp.currentVisit.getServiceExpense()) + "$");
        System.out.println("Total without discount: " + roundDouble(descuentosApp.currentVisit.getTotalExpenseWithoutDiscount()) + "$");

        System.out.println("--------------------------------------");
        System.out.println("Total with discount: " + roundDouble(descuentosApp.currentVisit.getTotalExpense()) + "$");
        System.out.println("--------------------------------------");
        System.out.println("");

        Integer option = Utils.getInteger("Do you want to checkout? (1-Yes | 2-No)");
        switch (option) {
            case 1:
                System.out.println("");
                System.out.println("Payment completed...");
                System.out.println("");
                System.out.println("Press a button to check the receipt...");
                new Scanner(System.in).nextLine();
                showReceipt(new Date());

                descuentosApp.currentVisit.resetExpenses();
                break;
            case 2:
                System.out.println("Payment canceled...");
                Utils.finishStuff();
                break;
        }

    }

    public static void showReceipt(Date paymentDate) {
        System.out.println("############### AMAZON.EMI ###############");
        System.out.println();
        System.out.println("Thank you. Your payment has been successfully received with the following details. ");
        System.out.println();
        System.out.println("--------------- RECEIPT ---------------");
        System.out.println();
        System.out.println("--------------- ACCOUNT ---------------");
        System.out.println("Account name: " + descuentosApp.currentVisit.getName());
        String input = descuentosApp.currentVisit.getCustomerType();
        String output = input.substring(0, 1).toUpperCase() + input.substring(1);
        System.out.println("Account type: " + output);
        System.out.println("Login date: " + descuentosApp.currentVisit.getDate());
        System.out.println("Payment date: " + paymentDate);
        System.out.println("----------------- CART -----------------");
        System.out.println("Product cart without discount: " + roundDouble(descuentosApp.currentVisit.getProductExpense()) + "$");
        System.out.println("Service cart without discount: " + roundDouble(descuentosApp.currentVisit.getServiceExpense()) + "$");
        System.out.println("Total without discount: " + roundDouble(descuentosApp.currentVisit.getTotalExpenseWithoutDiscount()) + "$");

        System.out.println("--------------------------------------");
        System.out.println("Total with discount: " + roundDouble(descuentosApp.currentVisit.getTotalExpense()) + "$");

        switch (Utils.getInteger("Save this receipt? (1-Yes | 2-No)")) {
            case 1:
                try {
                    String a = new FilePersistanceReceipt().save(descuentosApp.currentVisit, paymentDate);
                    System.out.println("");
                    System.out.println("Receipt saved at: " + a);
                } catch (Exception e) {
                }
                break;
            case 2:
                break;
        }

        Utils.finishStuff();
    }

}
