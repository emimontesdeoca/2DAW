/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqljava1;

import java.sql.*;

/**
 *
 * @author emont
 */
public class SQLJava1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Connection conexion = null;
        
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            // Se obtiene una conexión con la base de datos.
            // En este caso nos conectamos a la base de datos prueba
            // con el usuario root y contraseña 1daw
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "2daw","2daw");
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
            ResultSet rs = s.executeQuery("select * from persona");
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDate(4));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally { // Se cierra la conexión con la base de datos.
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }*/

 /*
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "2daw",
                    "2daw");
            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();
            //se crea una tabla nueva
            s.executeUpdate(
                    "CREATE TABLE contacto (id INT AUTO_INCREMENT, PRIMARY KEY(id),nombre VARCHAR(20), apellidos VARCHAR(20), telefono VARCHAR(20))");
            //Los datos que vamos a insertar los tenemos en 3 arrays
            String nombres[] = {"Juan", "Pedro", "Antonio"};
            String apellidos[] = {"Gomez", "Lopez", "Alvarez"};
            String telefonos[] = {"987452154", "989654125", "985321478"};
            //se insertan datos en la tabla
            for (int i = 0; i < nombres.length; i++) {
                s.executeUpdate("INSERT INTO contacto (nombre, apellidos, telefono) VALUES ('"
                        + nombres[i] + "','" + apellidos[i] + "','" + telefonos[i] + "' )");
            }
            // Se realiza una consulta sobre la tabla contacto.
            ResultSet rs = s.executeQuery("select * from contacto");
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                        + rs.getString(3) + " " + rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally { // Se cierra la conexión con la base de datos.
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }*/
        Connection conexion = null;
        int id;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "2daw");
            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();

            // Se realiza la consulta
            // Queremos obtener el id del primer contacto con nombre Juan
            ResultSet rs = s.executeQuery("SELECT id FROM contacto WHERE nombre='Juan'");

            if (rs.next()) { //Si rs.next() devuelve true significa que al menos hay un registro
                id = rs.getInt("id"); //se obtienen su id
                //se actualiza el registro
                s.executeUpdate("UPDATE contacto SET telefono='987654321' WHERE id=" + id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally { // Se cierra la conexión con la base de datos.
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
