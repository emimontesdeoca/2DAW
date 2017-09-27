package es.cifp.ForVagosApp;

import java.util.List;
import java.util.Scanner;

public class ForVagosApp {

    static List<Hotel> hotelList;

    public static void main(String[] args) {
        // TODO code application logic here

        Integer option = null;
        do {
            hotelList = new FilePersistence().list();

            System.out.flush();
            System.out.println("================= FOR VAGOS =================");
            System.out.println("-- Échese una siestita mientras nosotros buscamos");
            System.out.println("");
            System.out.println("1. Busque por nombre");
            System.out.println("2. Busque por localidad");
            System.out.println("0. Salir");
            System.out.println("-------------------------");
            System.out.println("9. Admin");

            option = new Scanner(System.in).nextInt();

            switch (option) {
                case 1:
                    System.out.flush();
                    System.out.println("================= FOR VAGOS =================");
                    System.out.println("-- Échese una siestita mientras nosotros buscamos");
                    System.out.println("");
                    System.out.println("Introduzca nombre del hotel:");

                    buscarHoteles();
                    break;
                case 2:
                    System.out.flush();
                    System.out.println("================= FOR VAGOS =================");
                    System.out.println("-- Échese una siestita mientras nosotros buscamos");
                    System.out.println("");
                    System.out.println("Introduzca nombre de la localidad:");

                    buscarHotelesLocalidad();
                    break;
                case 9:
                    System.out.println("================= FOR VAGOS =================");
                    System.out.println("");
                    System.out.println("1. Añadir hotel:");
                    System.out.println("2. Borrar hotel:");
                    System.out.println("-------------------------");
                    System.out.println("0. Volver");

                    Integer opt = new Scanner(System.in).nextInt();

                    switch (opt) {
                        case 1:
                            System.out.flush();
                            insertarHotel();
                            break;
                        case 2:
                            System.out.flush();
                            System.out.println("================= FOR VAGOS =================");
                            System.out.println("-- Échese una siestita mientras nosotros buscamos");
                            System.out.println("");
                            System.out.println("Introduzca nombre del hotel para borrar:");

                            borrarHotel();
                            break;
                        case 0:
                            break;
                    }
                    break;
            }

        } while (option != 0);

    }

    public static void insertarHotel() {
        System.out.println("================= FOR VAGOS =================");
        System.out.println("");
        System.out.println("Nombre del hotel");
        String hname = (new Scanner(System.in)).nextLine();
        System.out.println("Localidad del hotel");
        String hloc = (new Scanner(System.in)).nextLine();

        System.out.println("Estrellas del hotel");
        Integer hestrellas = (new Scanner(System.in)).nextInt();
        System.out.println("Precio de noche del hotel");
        Integer hprecionoche = (new Scanner(System.in)).nextInt();

        try {
            Hotel h = new Hotel(hname, hloc, hestrellas, hprecionoche);
            new FilePersistence().save(h);
            System.out.println("-------------------------");
            System.out.println("Hotel añadido.");
        } catch (Exception e) {
            System.out.println("-------------------------");
            System.out.println("Hubo un error.");
        }

        System.out.println("-------------------------");
        System.out.println("Pulse una tecla para continuar...");
        String a = new Scanner(System.in).nextLine();

    }

    public static void borrarHotel() {
        String hotelname = (new Scanner(System.in)).nextLine();
        hotelList = new FilePersistence().list();
        try {
            for (Hotel hotel : hotelList) {
                if (hotel.getNombre().equals(hotelname)) {
                    new FilePersistence().delete(hotel);
                    break;
                }
            }
        } catch (Exception e) {
        }
    }

    public static void listarHoteles() {

        System.out.println("================= FOR VAGOS =================");
        System.out.println("-- Échese una siestita mientras nosotros buscamos");
        System.out.println("");

        Hotel searchHotel = null;
        try {
            for (Hotel hotel : hotelList) {

                System.out.println("Nombre de hotel: " + hotel.getNombre());
                System.out.println("Localidad: " + hotel.getLocalidad());
                System.out.println("Estrellas: " + hotel.getEstrellas());
                System.out.println("Precio de la noche: " + hotel.getEstrellas());
                System.out.println("-------------------------");
                break;
            }
        } catch (Exception e) {
            System.out.println("No se ha encotrado ningun hotel.");

        }
        System.out.println("-------------------------");
        System.out.println("Pulse una tecla para continuar...");
        String a = new Scanner(System.in).nextLine();
    }

    public static void buscarHoteles() {

        String hotelname = (new Scanner(System.in)).nextLine();

        Hotel searchHotel = null;
        hotelList = new FilePersistence().list();
        try {
            for (Hotel hotel : hotelList) {
                if (hotel.getNombre().equals(hotelname)) {
                    searchHotel = hotel;
                    break;
                }
            }
        } catch (Exception e) {
        }

        if (searchHotel != null) {
            System.out.println("================= FOR VAGOS =================");
            System.out.println("-- Échese una siestita mientras nosotros buscamos");
            System.out.println("");
            System.out.println("Nombre de hotel: " + searchHotel.getNombre());
            System.out.println("Localidad: " + searchHotel.getLocalidad());
            System.out.println("Estrellas: " + searchHotel.getEstrellas());
            System.out.println("Precio de la noche: " + searchHotel.getPrecioNoche());
            System.out.println("-------------------------");
            System.out.println("Pulse una tecla para continuar...");
        } else {
            System.out.println("================= FOR VAGOS =================");
            System.out.println("-- Échese una siestita mientras nosotros buscamos");
            System.out.println("");
            System.out.println("No se ha encontrado un hotel con ese nombre.");
            System.out.println("-------------------------");
            System.out.println("Pulse una tecla para continuar...");
        }

        String a = new Scanner(System.in).nextLine();
    }

    public static void buscarHotelesLocalidad() {

        String hotellocalidad = (new Scanner(System.in)).next();

        Hotel searchHotel = null;

        for (Hotel hotel : hotelList) {
            if (hotel.getLocalidad().equals(hotellocalidad)) {
                searchHotel = hotel;
                break;
            }
        }

        if (searchHotel != null) {
            System.out.println("================= FOR VAGOS =================");
            System.out.println("");
            System.out.println("Nombre de hotel: " + searchHotel.getNombre());
            System.out.println("Localidad: " + searchHotel.getLocalidad());
            System.out.println("Estrellas: " + searchHotel.getEstrellas());
            System.out.println("Precio de la noche: " + searchHotel.getPrecioNoche());
            System.out.println("-------------------------");
            System.out.println("Pulse una tecla para continuar...");
        } else {
            System.out.println("================= FOR VAGOS =================");
            System.out.println("");
            System.out.println("No se ha encontrado un hotel con esa localidad.");
            System.out.println("-------------------------");
            System.out.println("Pulse una tecla para continuar...");
        }
        String a = new Scanner(System.in).nextLine();
    }

}
