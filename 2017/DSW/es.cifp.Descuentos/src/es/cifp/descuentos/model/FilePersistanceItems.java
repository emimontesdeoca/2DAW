package es.cifp.descuentos.model;

import es.cifp.descuentos.controller.Customer;
import es.cifp.descuentos.controller.Items;
import es.cifp.descuentos.descuentosApp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @asignatura: Desarrollo de entorno servidor
 * @clase: 2DAW-B
 */
public class FilePersistanceItems {

    List<Items> itemList;

    public void save(Items i) {
        try {
            /// Instanciar objetos
            FileWriter f = new FileWriter(descuentosApp.fileItems, true);
            BufferedWriter bw = new BufferedWriter(f);

            /// Cadena a escribir
            String builder = "";

            /// Añadir valores
            builder += i.getName() + ":";
            builder += i.getValue();

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

    public void delete(Items i) {
        /// Nueva lista para guardar en el fichero
        List<Items> newList;
        newList = list();

        for (Iterator<Items> iter = newList.listIterator(); iter.hasNext();) {
            Items search = iter.next();

            String a = search.getName();
            String b = i.getName();

            if (a.equals(b)) {
                /// Borrar en la nueva lista el objeto que no queremos
                iter.remove();
                break;
            }
        }

        /// Escribir de nuevo el archivo con la lista filtrada/objeto eliminado
        try {
            /// Elementos para tratar ficheros
            FileWriter f = new FileWriter(descuentosApp.fileItems,true);
            BufferedWriter bw = new BufferedWriter(f);

            /// Por cada hotel, escribir en fichero
            for (Items ni : newList) {

                /// Crear builder
                String builder = "";

                /// Añadir valores
                builder += ni.getName() + ":";
                builder += ni.getValue();

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

    public List<Items> list() {
        /// Instanciar lista
        itemList = new ArrayList<Items>();
        try {
            /// Leer archivo
            FileReader f = new FileReader(descuentosApp.fileItems);
            BufferedReader br = new BufferedReader(f);

            /// Leer linea
            String line = "";

            /// Si la linea no es null, significa que tiene valor
            while ((line = br.readLine()) != null) {
                /// Split para conseguir valores
                String[] split = line.split(":");
                String cname = split[0];
                Double cvalue = Double.parseDouble(split[1]);

                //Crear y agregar a la lista de hoteles
                itemList.add(new Items(cname, cvalue));
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        /// Devolver lista
        return itemList;
    }
}
