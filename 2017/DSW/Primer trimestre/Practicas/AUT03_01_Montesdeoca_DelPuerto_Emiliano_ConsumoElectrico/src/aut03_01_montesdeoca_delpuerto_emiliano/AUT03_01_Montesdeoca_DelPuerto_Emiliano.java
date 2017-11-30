/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aut03_01_montesdeoca_delpuerto_emiliano;

import java.util.List;

/**
 *
 * @author emont
 */
public class AUT03_01_Montesdeoca_DelPuerto_Emiliano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*  
        . En primer lugar sacaremos por consola un listado de clientes con todos sus datos.
        2. Repetimos el ejercicio insertando una línea horizontal cada diez registros.
        3. Esta vez sacaremos por consola solamente la identificación del cliente (nuestro código
        id) y la calle y número donde vive.
        4. Seguidamente sacaremos un listado con las mediciones en Kw de todos los clientes y el
        consumo total desde la primera medición hasta la última.
        5. Repetimos pero esta vez solo mostramos los registros de mediciones para aquellos
        clientes que vivan en el código postal 15402
        6. Sacaremos por pantalla los datos personales y de mediciones de una persona
        introducida por consola.  
         */
        //Ejercicio1();
        //Ejercicio2();
        //Ejercicio3();
        //Ejercicio4();
        //Ejercicio5();        
        Ejercicio6();
    }

    public static void Ejercicio1() {
        System.out.println("Ejercicio 1:");
        List<cliente> clientes = cliente.getAllClientes();
        for (cliente cliente1 : clientes) {
            String show = cliente1.getId() + " " + cliente1.getNombre() + " " + cliente1.getApellido() + " " + cliente1.getNombreCalle() + " " + cliente1.getCodPostal() + " " + cliente1.getPoblacion() + " " + cliente1.getProvincia();
            System.out.println(show);
        }
    }

    public static void Ejercicio2() {
        System.out.println("Ejercicio 2:");
        List<cliente> clientes = cliente.getAllClientes();
        Integer i = 0;
        for (cliente cliente1 : clientes) {
            String show = cliente1.getId() + " " + cliente1.getNombre() + " " + cliente1.getApellido() + " " + cliente1.getNombreCalle() + " " + cliente1.getCodPostal() + " " + cliente1.getPoblacion() + " " + cliente1.getProvincia();
            System.out.println(show);

            if (i == 10) {
                System.out.println("--------------------------------------------------------------------");
                i = 0;
            }
            i++;
        }
    }

    public static void Ejercicio3() {
        System.out.println("Ejercicio 3:");
        List<cliente> clientes = cliente.getAllClientes();
        Integer i = 0;
        for (cliente cliente1 : clientes) {
            String show = cliente1.getId() + " " + cliente1.getNombreCalle() + " " + cliente1.getNumero();
            System.out.println(show);
        }
    }

    public static void Ejercicio4() {
        System.out.println("Ejercicio 4:");
        List<cliente> clientes = cliente.getAllClientes();
        Integer i = 0;
        for (cliente cliente1 : clientes) {
            Double totalMedicion = medicion.getTotalMedicionCliente(cliente1.getId());

            String show = cliente1.getId() + " " + totalMedicion;
            System.out.println(show);
        }
    }

    public static void Ejercicio5() {
        System.out.println("Ejercicio 5:");
        List<Integer[]> list = medicion.getIdMedicionClienteByCodigoPostal(15402);
        Integer i = 0;

        for (Integer[] integers : list) {
            Double totalMedicion = medicion.getTotalMedicionCliente(integers[2]);
            String show = integers[2] + " " + totalMedicion;
            System.out.println(show);
        }
    }

    public static void Ejercicio6() {
        cliente c = cliente.getClienteByNombre("Abel");
        Double totalMedicion = medicion.getTotalMedicionCliente(c.getId());

        String show = c.getId() + " " + c.getNombre() + " " + c.getApellido() + " " + c.getNombreCalle() + " " + c.getCodPostal() + " " + c.getPoblacion() + " " + c.getProvincia() + " >> " + totalMedicion;
        System.out.println(show);
    }

}
