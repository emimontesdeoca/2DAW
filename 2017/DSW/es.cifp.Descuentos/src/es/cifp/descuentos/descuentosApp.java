/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifp.descuentos;

import es.cifp.descuentos.controller.Visit;
import es.cifp.descuentos.view.MainMenu;
import es.cifp.descuentos.view.Utils;
import java.io.File;

/**
 *
 * @author emont
 */
public class descuentosApp {

    public static Boolean isLoggedIn = false;
    public static Visit currentVisit = null;
    public static String fileCustomers = "\\customers.txt";
    public static String fileItems = "\\items.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MainMenu.showMainMenu();

    }

}
