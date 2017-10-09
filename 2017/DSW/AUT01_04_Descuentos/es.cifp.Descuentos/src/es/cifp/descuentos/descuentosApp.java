/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifp.descuentos;

import es.cifp.descuentos.controller.Visit;
import es.cifp.descuentos.view.MainMenu;
import sun.misc.FpUtils;
import java.io.File;

/**
 *
 * @author emont
 */
public class descuentosApp {

    public static Boolean isLoggedIn = false;
    public static Visit currentVisit = null;
    public static String tempf = System.getenv("TEMP") + "\\EmilianoLibros" ;
    public static String fileCustomers = tempf + "\\customers.txt";
    public static String fileItems = tempf + "\\items.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (!new File(tempf ).exists()) {
            try {
                /// Si no crearlo, para evitar excepciones cuando se busca en un archivo
                /// que no existe 
                new File(tempf ).mkdirs();
            } catch (Exception e) {
                System.out.println("No se ha podido crear la carpeta!!!!");
            }
        }

        if (!new File(fileCustomers).exists()) {
            try {
                /// Si no crearlo, para evitar excepciones cuando se busca en un archivo
                /// que no existe 
                new File(fileCustomers).createNewFile();
            } catch (Exception e) {
                System.out.println("No se ha podido crear el archivo!!!!");
            }
        }

        if (!new File(fileItems).exists()) {
            try {
                /// Si no crearlo, para evitar excepciones cuando se busca en un archivo
                /// que no existe 
                new File(fileItems).createNewFile();
            } catch (Exception e) {
                System.out.println("No se ha podido crear el archivo!!!!");
            }
        }

        MainMenu.showMainMenu();

    }

}
