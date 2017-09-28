package es.cifp.ForVagosApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sun.misc.FpUtils;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @asignatura: Desarrollo de entorno servidor
 * @clase: 2DAW-B
 */
public class ForVagosApp {

    static List<Hotel> hotelList;

    public static void main(String[] args) {

        Integer option = null;
        do {
            /// Get current hotel List
            hotelList = new FilePersistence().list();

            /// Display menu
            Utils.showMenu();

            /// Get option from user
            option = Utils.getInteger("Escriba una opcion: ");

            switch (option) {
                /// Case 1: buscar por hotel
                case 1:
                    /// Mostar menu
                    Utils.showMenuBusqueda();
                    /// Llamada a metodo buscar por nombre 
                    buscarHoteles();
                    break;
                /// Buscar por localidad 
                case 2:
                    /// Mostrar menu
                    Utils.showMenuBusqueda();
                    /// Llamada a metodo de buscar localidad
                    buscarHotelesLocalidad();
                    break;
                case 3:
                    /// Mostrar menu de hoteles
                    listarHoteles();
                    break;
                /// Admin
                case 9:
                    /// Mostrar menu administracion
                    Utils.showMenuAdministracion();
                    /// Preguntar por opcion 
                    Integer opt = Utils.getInteger("Escriba una opcion: ");
                    /// Admin panel
                    switch (opt) {
                        /// Añadir hotel
                        case 1:
                            /// Llamada a metodo de insercion de hotel.
                            insertarHotel();
                            break;
                        /// Borrar hotel
                        case 2:
                            /// Mostrar menu de borrar
                            Utils.showMenuAdministracionBorrar();
                            /// Llamada a metodo de borrado de hotel
                            borrarHotel();
                            break;
                        case 0:
                            /// Salir.
                            break;
                    }
                    break;
            }
        } while (option != 0);

    }

    public static void insertarHotel() {
        /// Menu
        System.out.println("================= FOR VAGOS =================");
        System.out.println("");
        /// Preguntar por Nombre
        String hname = Utils.getString("Nombre del hotel: ");

        /// Preguntar por localidad
        String hloc = Utils.getString("Localidad del hotel: ");

        /// Preguntar por Estrellas
        Integer hestrellas = Utils.getInteger("Estrellas del hotel: ");

        /// Preguntar por precio de noche
        Integer hprecionoche = Utils.getInteger("Precio de noche del hotel: ");

        try {
            /// Crear hotel con parametro
            Hotel h = new Hotel(hname, hloc, hestrellas, hprecionoche);
            /// Guardar en fichero
            new FilePersistence().save(h);
            System.out.println("-------------------------");
            System.out.println("Hotel añadido.");
        } catch (Exception e) {
            System.out.println("-------------------------");
            System.out.println("Hubo un error.");
        }
        /// Terminar
        System.out.println("-------------------------");
        System.out.println("Pulse una tecla para continuar...");
        new Scanner(System.in).nextLine();

    }

    public static void borrarHotel() {
        /// Pedir nombre hoel
        String hotelname = Utils.getString("Nombre del hotel: ");
        /// Pedir lista de hoteles
        hotelList = new FilePersistence().list();
        try {
            for (Hotel hotel : hotelList) {
                if (hotel.getNombre().equals(hotelname)) {
                    /// Si los nombres coinciden, borrar hotel
                    new FilePersistence().delete(hotel);

                    System.out.println("");
                    System.out.println("Borrado completado.");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("-------------------------");
            System.out.println("Hubo un error.");
        }
        System.out.println("-------------------------");

        System.out.println("Pulse una tecla para continuar...");
        new Scanner(System.in).nextLine();
    }

    public static void listarHoteles() {
        /// Menu
        System.out.println("================= FOR VAGOS =================");
        System.out.println("-- Échese una siestita mientras nosotros buscamos");
        System.out.println("");
        /// Actualizar lista
        hotelList = new FilePersistence().list();
        try {
            for (Hotel hotel : hotelList) {
                /// Escribir informacion de hotel
                Utils.menuEscribirHotel(hotel);

            }
        } catch (Exception e) {
            System.out.println("No se ha encotrado ningun hotel.");
            System.out.println("-------------------------");
        }
        System.out.println("Pulse una tecla para continuar...");
        new Scanner(System.in).nextLine();
    }

    public static void buscarHoteles() {
        /// Pedir nombre de hotel
        String hotelname = Utils.getString("Introduzca nombre del hotel: ");
        /// Instanciar un objeto hotel.
        Hotel searchHotel = null;
        /// Actualizar lista
        hotelList = new FilePersistence().list();
        try {
            for (Hotel hotel : hotelList) {
                if (hotel.getNombre().equals(hotelname)) {
                    /// Si los nombres coinciden, es nuestro hotel.
                    searchHotel = hotel;
                    break;
                }
            }
        } catch (Exception e) {
        }

        System.out.println("================= FOR VAGOS =================");
        System.out.println("-- Échese una siestita mientras nosotros buscamos");
        System.out.println("");
        /// Mostrar en pantalla
        if (searchHotel != null) {
            Utils.menuEscribirHotel(searchHotel);
        } else {
            /// Mostrar en pantallla
            System.out.println("No se ha encontrado un hotel con ese nombre.");
            System.out.println("-------------------------");
        }
        /// Terminar
        System.out.println("Pulse una tecla para continuar...");
        new Scanner(System.in).nextLine();
    }

    public static void buscarHotelesLocalidad() {
        /// Pedir localidad
        String hotellocalidad = Utils.getString("Introduzca nombre de la localidad: ");
        /// Nueva lista de hoteles donde se mostraran los hoteles por localidad
        List<Hotel> hotelesloc = new ArrayList<Hotel>();

        for (Hotel hotel : hotelList) {
            if (hotel.getLocalidad().equals(hotellocalidad)) {
                /// Añadir a la lista los que tengan esa localidad
                hotelesloc.add(hotel);
            }
        }
        System.out.println("================= FOR VAGOS =================");
        System.out.println("");
        /// Si al lista es mayor a 0, escribir
        if (hotelesloc.size() > 0) {
            for (Hotel hotel : hotelesloc) {
                /// Mostrar hoteles
                Utils.menuEscribirHotel(hotel);
            }
            /// Si es 0 o nulo no escribir.
        } else if (hotelesloc.size() == 0 || hotelesloc == null) {
            System.out.println("No se ha encontrado un hotel con esa localidad.");
            System.out.println("-------------------------");
        }
        /// Terminar

        System.out.println("Pulse una tecla para continuar...");
        new Scanner(System.in).nextLine();
    }

}
