package es.cifp.descuentos.model;

import es.cifp.descuentos.controller.Customer;
import es.cifp.descuentos.descuentosApp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @asignatura: Desarrollo de entorno servidor
 * @clase: 2DAW-B
 */
public class FilePersistanceCustomers {
    
    static List<Customer> customerList;
    
    public void save(Customer c) throws Exception {
        try {
            /// Instanciar objetos
            FileWriter f = new FileWriter(descuentosApp.fileCustomers, true);
            BufferedWriter bw = new BufferedWriter(f);
            
            customerList = list();
            
            if (customerList.contains(c)) {
                throw new Exception();
            } else {
                /// Cadena a escribir
                String builder = "";

                /// Añadir valores
                builder += c.getName() + ":";
                builder += "true:";
                builder += c.getMemberType();

                /// Guardar la linea en el fichero
                bw.append(builder);
                /// Nueva linea  bw.append(builder);
                bw.newLine();
                /// Cerrar lector
                bw.close();
                f.close();
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    public void delete(Customer c) {
        /// Nueva lista para guardar en el fichero
        List<Customer> newList = (List<Customer>) list();
        
        for (Iterator<Customer> iter = newList.listIterator(); iter.hasNext();) {
            Customer search = iter.next();
            if (search.getName().equals(c.getName()) && search.getMemberType().equals(c.getMemberType())) {
                /// Borrar en la nueva lista el objeto que no queremos
                iter.remove();
                break;
            }
        }

        /// Escribir de nuevo el archivo con la lista filtrada/objeto eliminado
        try {
            /// Elementos para tratar ficheros
            FileWriter f = new FileWriter(descuentosApp.fileCustomers);
            BufferedWriter bw = new BufferedWriter(f);

            /// Por cada hotel, escribir en fichero
            for (Customer nc : newList) {
                /// Crear builder
                String builder = "";
                /// Añadir valores
                builder += nc.getName() + ":";
                builder += "true:";
                builder += nc.getMemberType();

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
    
    public List<Customer> list() {
        /// Instanciar lista
        customerList = new ArrayList<Customer>();
        try {
            /// Leer archivo
            FileReader f = new FileReader(descuentosApp.fileCustomers);
            BufferedReader br = new BufferedReader(f);

            /// Leer linea
            String line = "";

            /// Si la linea no es null, significa que tiene valor
            while ((line = br.readLine()) != null) {
                /// Split para conseguir valores
                String[] split = line.split(":");
                String cname = split[0];
                Boolean cmember = Boolean.parseBoolean(split[1]);
                String cmembertype = split[2];

                //Crear y agregar a la lista de hoteles
                customerList.add(new Customer(cname, cmember, cmembertype));
                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /// Devolver lista
        return customerList;
    }
}
