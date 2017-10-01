/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifp.descuentos.view;

/**
 *
 * @author emont
 */
public class MainMenu {

    public static void showMainMenu() {
        Integer option = 0;

        do {

            System.out.println("############### AMAZON.EMI ###############");
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("0. Exit");
            System.out.println("###############");
            System.out.println("9. Admin");

            option = Utils.getInteger("Select an option: ");

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 9:
                    AdminMenu.showAdminMenu();
                    break;

            }
        } while (option != 0);
    }
}
