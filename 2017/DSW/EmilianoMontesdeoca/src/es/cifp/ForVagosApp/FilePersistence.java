/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifp.ForVagosApp;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @asignatura: Desarrollo de entorno servidor
 * @clase: 2DAW-B
 */
public class FilePersistence implements Persistence {

    /// Lista estatica
    static List<Hotel> hotelList;

    public void save(Hotel h) {
        try {
            /// Instanciar objetos
            FileWriter f = new FileWriter(Hotel.filename, true);
            BufferedWriter bw = new BufferedWriter(f);

            /// Cadena a escribir
            String builder = "";

            /// Añadir valores
            builder += h.getNombre() + "-";
            builder += h.getLocalidad() + "-";
            builder += h.getEstrellas() + "-";
            builder += h.getPrecioNoche();

            /// Guardar la linea en el fichero
            bw.append(builder);
            /// Nueva linea  bw.append(builder);
            bw.newLine();
            /// Cerrar lector
            bw.close();
            f.close();
        } catch (Exception e) {
        }
    }

    public void delete(Hotel h) {
        /// Nueva lista para guardar en el fichero
        List<Hotel> newList = list();

        for (Iterator<Hotel> iter = newList.listIterator(); iter.hasNext();) {
            Hotel searchh = iter.next();
            if (searchh.getNombre().equals(h.getNombre())) {
                /// Borrar en la nueva lista el objeto que no queremos
                iter.remove();
                break;
            }
        }

        /// Escribir de nuevo el archivo con la lista filtrada/objeto eliminado
        try {
            /// Elementos para tratar ficheros
            FileWriter f = new FileWriter(Hotel.filename);
            BufferedWriter bw = new BufferedWriter(f);

            /// Por cada hotel, escribir en fichero
            for (Hotel nh : newList) {
                /// Crear builder
                String builder = "";
                /// Escribir valores
                builder += nh.getNombre() + "-";
                builder += nh.getLocalidad() + "-";
                builder += nh.getEstrellas() + "-";
                builder += nh.getPrecioNoche();
                /// Guardar en fichero
                bw.append(builder);
                /// Nueva linea
                bw.newLine();
            }
            /// Cerrar 
            bw.close();
            f.close();
        } catch (Exception e) {
        }

    }

    public List<Hotel> list() {
        /// Instanciar lista
        hotelList = new ArrayList<Hotel>();
        try {
            /// Leer archivo
            FileReader f = new FileReader(Hotel.filename);
            BufferedReader br = new BufferedReader(f);

            /// Leer linea
            String line = br.readLine();

            /// Si la linea no es null, significa que tiene valor
            while (line != null) {
                /// Split para conseguir valores
                String[] split = line.split("-");
                String hname = split[0];
                String hloc = split[1];
                Integer hestrellas = Integer.parseInt(split[2]);
                Integer hprecionoche = Integer.parseInt(split[3]);

                //Crear y agregar a la lista de hoteles
                hotelList.add(new Hotel(hname, hloc, hestrellas, hprecionoche));

                /// Leer de nuevo
                line = br.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /// Devolver lista
        return hotelList;
    }

}
