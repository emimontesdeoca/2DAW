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
        System.out.print(text);
        return new Scanner(System.in).nextLine();
    }

    public static Integer getInteger(String text) {
        System.out.print(text);
        return new Scanner(System.in).nextInt();
    }

    public static Double getDouble(String text) {
        System.out.print(text);
        return new Scanner(System.in).nextDouble();
    }

    public static void finishStuff() {
        System.out.println("###############");
        System.out.println("Press a key to finish...");
        new Scanner(System.in).nextLine();
    }
}
