/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifp.descuentos.view;

import java.util.Scanner;

/**
 *
 * @author emont
 */
public class Utils {

    public static String getString(String text) {
        /// Metodo para pedir un String
        String res = "";

        /// El siguiente codigo para recibir strings se encarga de mirar si esta vacio 
        /// o si se puede parsear, significa que es un numero
        do {
            System.out.println();
            System.out.print(text);

            res = new Scanner(System.in).nextLine();
            if (res.trim().isEmpty()) {
                System.out.println("It can't be empty");
            } else {
                try {
                    double d = Double.parseDouble(res);
                    System.out.println("It can't be numeric!");
                } catch (Exception e) {
                    break;
                }
            }
        } while (true);
        return res;
    }

    public static Integer getInteger(String text) {
        /// Metodo para pedir un entero
        Integer res = 0;

        do {
            try {
                System.out.println();
                System.out.print(text);
                String test = (new Scanner(System.in)).nextLine();
                res = Integer.parseInt(test);
                break;
            } catch (Exception e) {
                System.out.println("It has to be numeric!");
            }
        } while (true);

        return res;
    }
    /// Get double
    public static Double getDouble(String text) {
        /// Metodo para pedir un entero
        Double res = 0.;

        do {
            try {
                System.out.print(text);
                String test = (new Scanner(System.in)).nextLine();
                res = Double.parseDouble(test);
                break;
            } catch (Exception e) {
                System.out.println("It has to be decimal");
            }
        } while (true);

        return res;
    }
    /// end line for everything
    public static void finishStuff() {
        System.out.println("");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Press a key to continue...");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        new Scanner(System.in).nextLine();
    }

    /// header line for everything
    public static void showHeader() {
        System.out.println("|----------------------------------------|");
        System.out.println("|                AMAZON.EMI              |");
        System.out.println("|----------------------------------------|");
    }

    /// round double
    public static Double roundDouble(Double a) {
        return Math.round(a * 100.0) / 100.0;
    }
}
