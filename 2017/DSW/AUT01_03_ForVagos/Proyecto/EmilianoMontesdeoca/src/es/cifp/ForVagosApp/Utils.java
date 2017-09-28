package es.cifp.ForVagosApp;

import java.util.Scanner;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @asignatura: Desarrollo de entorno servidor
 * @clase: 2DAW-B
 */
public class Utils {

    public static String getString(String text) {
        /// Metodo para pedir un String
        String res = "";

        /// El siguiente codigo para recibir strings se encarga de mirar si esta vacio 
        /// o si se puede parsear, significa que es un numero
        do {
            System.out.print(text);
            res = new Scanner(System.in).nextLine();
            if (res.trim().isEmpty()) {
                System.out.println("No puede estar vacio");
            } else {
                try {
                    double d = Double.parseDouble(res);
                    System.out.println("No puede ser un numero!");
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
                System.out.print(text);
                String test = (new Scanner(System.in)).nextLine();
                res = Integer.parseInt(test);
                break;
            } catch (Exception e) {
                System.out.println("Tiene que ser numerico!");
            }
        } while (true);

        return res;
    }

    public static void showMenu() {
        /// Metodo para mostrar el menu
        System.out.flush();
        System.out.println("================= FOR VAGOS =================");
        System.out.println("-- Échese una siestita mientras nosotros buscamos");
        System.out.println("");
        System.out.println("1. Busqueda por nombre");
        System.out.println("2. Busqueda por localidad");
        System.out.println("3. Lista todos los hoteles");
        System.out.println("0. Salir");
        System.out.println("-------------------------");
        System.out.println("9. Admin");
    }

    public static void showMenuBusqueda() {
        /// Metodo para mostrar el menu de administracion para borrar
        System.out.flush();
        System.out.println("================= FOR VAGOS =================");
        System.out.println("-- Échese una siestita mientras nosotros buscamos");
        System.out.println("");

    }

    public static void showMenuAdministracion() {
        /// Metodo para mostrar el menu de administracion
        System.out.println("================= FOR VAGOS =================");
        System.out.println("");
        System.out.println("1. Añadir hotel: ");
        System.out.println("2. Borrar hotel: ");
        System.out.println("-------------------------");
        System.out.println("0. Volver ");
    }

    public static void showMenuAdministracionBorrar() {
        /// Metodo para mostrar el menu de administracion para borrar
        System.out.flush();
        System.out.println("================= FOR VAGOS =================");
        System.out.println("-- Échese una siestita mientras nosotros buscamos");
        System.out.println("");
        System.out.println("Introduzca nombre del hotel para borrar: ");
    }

    public static void menuEscribirHotel(Hotel h) {
        /// Metodo para escribir un Hotel
        System.out.println("Nombre de hotel: " + h.getNombre());
        System.out.println("Localidad: " + h.getLocalidad());
        System.out.println("Estrellas: " + h.getEstrellas());
        System.out.println("Precio de la noche: " + h.getPrecioNoche());
        System.out.println("-------------------------");
    }

}
