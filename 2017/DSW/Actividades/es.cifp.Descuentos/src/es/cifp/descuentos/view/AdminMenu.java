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
        /// Show admin menu
        do {
            Utils.showHeader(); 
            System.out.println();
            System.out.println("1. Create new item");
            System.out.println("2. Delete an item");
            System.out.println("3. List all items");
            System.out.println("-----------------");
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
        /// New item menu
        Utils.showHeader(); 
        String a = Utils.getString("Item name: ");
        Double b = Utils.getDouble("Item value: ");
        try {
            /// If item exist
            if (new FilePersistanceItems().itemExistsWithName(a)) {
                System.out.println();
                System.out.println("There's an item with that name.");

            } else {

                switch (Utils.getInteger("Are you sure? (1-Yes | 2-No)")) {
                    case 1:
                        /// Add item
                        Items newItem = new Items(a, b);
                        new FilePersistanceItems().save(newItem);
                        System.out.println("Item added succesfully!");
                        System.out.println();
                        break;
                    case 2:
                        /// Cancel
                        System.out.println();
                        System.out.println("Operation canceled!");
                        break;
                }
            }
        } catch (Exception e) {

        }
        Utils.finishStuff();
    }

    public static void showDeleteItemMenu() {
        /// Delete item
        Utils.showHeader(); 
        String a = Utils.getString("Item name: ");
        try {
            /// If item exist
            if (new FilePersistanceItems().itemExistsWithName(a)) {
                switch (Utils.getInteger("Are you sure? (1-Yes | 2-No)")) {
                    case 1:
                        Items i = new Items();
                        i = i.getItemByName(a);
                        /// Delete item
                        new FilePersistanceItems().delete(i);
                        System.out.println("Item deleted succesfully!");
                        break;
                    case 2:
                        /// Cancel
                        System.out.println();
                        System.out.println("Operation canceled!");
                        break;
                }
            } else {
                System.out.println();
                System.out.println("No item found with that name.");
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("No item found with that name.");
        }
        Utils.finishStuff();
    }

    public static void showAllItemMenu() {
        /// Show all items
        Utils.showHeader(); 
        System.out.println();
        System.out.println("List of products available: ");
        System.out.println();
        /// Get items
        List<Items> list = new Items().getAllItems();
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

        Utils.finishStuff();
    }
}
