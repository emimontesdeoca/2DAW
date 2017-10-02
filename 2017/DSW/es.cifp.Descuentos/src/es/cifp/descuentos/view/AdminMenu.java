/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifp.descuentos.view;

import es.cifp.descuentos.controller.Items;
import es.cifp.descuentos.descuentosApp;
import es.cifp.descuentos.model.FilePersistanceItems;
import java.util.List;

/**
 *
 * @author emont
 */
public class AdminMenu {

    public static void showAdminMenu() {
        Integer option = 0;
        do {

            System.out.println("############### AMAZON.EMI ###############");
            System.out.println();
            System.out.println("1. Create new item");
            System.out.println("2. Delete an item");
            System.out.println("3. List all items");
            System.out.println("###############");
            System.out.println("0. Exit");

            option = Utils.getInteger("Select an option: ");

            switch (option) {
                case 1:
                    showCreateNewItemMenu();
                    break;
                case 2:
                    showDeleteItemMenu();
                    break;
                case 3:
                    showAllItemMenu();
                    break;
            }

        } while (option != 0);

    }

    public static void showCreateNewItemMenu() {

        System.out.println("############### AMAZON.EMI ###############");
        System.out.println();
        String a = Utils.getString("Item name: ");
        Double b = Utils.getDouble("Item value: ");
        try {
            Items newItem = new Items(a, b);
            new FilePersistanceItems().save(newItem);

        } catch (Exception e) {
            System.out.println("Theres a Item with that name.");
        }
        Utils.finishStuff();
    }

    public static void showDeleteItemMenu() {
        System.out.println("############### AMAZON.EMI ###############");
        System.out.println();
        String a = Utils.getString("Item name: ");
        try {
            Items i = new Items();
            i = i.getItemByName(a);
            new FilePersistanceItems().delete(i);
            Utils.finishStuff();
        } catch (Exception e) {

        }

    }

    public static void showAllItemMenu() {
        System.out.println("############### AMAZON.EMI ###############");
        System.out.println();
        List<Items> list = new Items().getAllItems();
        if (list.size() > 0) {
            for (Items items : list) {
                System.out.println("Item name: " + items.getName());
                System.out.println("Item value: " + items.getValue());
                System.out.println("###############");
            }
        } else {
            System.out.println("No items found!");
        }

        Utils.finishStuff();
    }
}
