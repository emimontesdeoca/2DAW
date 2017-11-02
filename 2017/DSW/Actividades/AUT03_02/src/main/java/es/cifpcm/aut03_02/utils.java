/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.aut03_02;

import es.cifpcm.aut03_02.buscador.web.BuscadorConsumoElectricoServlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emont
 */
public class utils {

    public static cliente getClienteByNombre(String nombre) {
        /// Cliente para devolver
        cliente newcliente = null;
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName(BuscadorConsumoElectricoServlet.driverClassName);
            // Se obtiene una conexión con la base de datos.
            // En este caso nos conectamos a la base de datos prueba
            // con el usuario root y contraseña 1daw
            conexion = DriverManager.getConnection(BuscadorConsumoElectricoServlet.dbUrl, BuscadorConsumoElectricoServlet.dbUser, BuscadorConsumoElectricoServlet.dbPassword);
            // Se crea un Statement, para realizar la consulta
            Statement s = (Statement) conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
            ResultSet rs = s.executeQuery("select * from misclientes where nombre = '" + nombre + "'");
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {
                /// Crea un nuevo cliente para devolver 
                newcliente = new cliente(rs.getInt("Id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("NombreCalle"), rs.getInt("numero"), rs.getInt("CodPostal"), rs.getString("CodPostal"), rs.getString("Provincia"));
                /// Ha consguido un cluente con ese nombre por lo que salimos del bucle
                break;
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
        }

        return newcliente;
    }

    public static List<cliente> getAllClientes() {
        /// Lista para devolver clientes
        List<cliente> res = new ArrayList<>();
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName(BuscadorConsumoElectricoServlet.driverClassName);
            // Se obtiene una conexión con la base de datos.
            // En este caso nos conectamos a la base de datos prueba
            // con el usuario root y contraseña 1daw
            conexion = DriverManager.getConnection(BuscadorConsumoElectricoServlet.dbUrl, BuscadorConsumoElectricoServlet.dbUser, BuscadorConsumoElectricoServlet.dbPassword);
            // Se crea un Statement, para realizar la consulta
            Statement s = (Statement) conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
            ResultSet rs = s.executeQuery("select * from misclientes limit " + BuscadorConsumoElectricoServlet.dbPageSize);
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {
                /// Crea un cluente con los datos que recibe de la bases de datos y lo agrega a la lista
                cliente newcliente = new cliente(rs.getInt("Id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("NombreCalle"), rs.getInt("numero"), rs.getInt("CodPostal"), rs.getString("CodPostal"), rs.getString("Provincia"));
                res.add(newcliente);
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
        }
        return res;
    }

    public static Double getTotalMedicionCliente(Integer id) {
        /// Double para devolver
        Double totalMedicion = 0.0;
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName(BuscadorConsumoElectricoServlet.driverClassName);
            // Se obtiene una conexión con la base de datos.
            // En este caso nos conectamos a la base de datos prueba
            // con el usuario root y contraseña 1daw
            conexion = DriverManager.getConnection(BuscadorConsumoElectricoServlet.dbUrl, BuscadorConsumoElectricoServlet.dbUser, BuscadorConsumoElectricoServlet.dbPassword);
            // Se crea un Statement, para realizar la consulta
            Statement s = (Statement) conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
            ResultSet rs = s.executeQuery("SELECT * FROM mediciones WHERE `Cliente` = " + id);
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {
                // Suma cada uno de los doubles
                totalMedicion += rs.getDouble("KW");
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
        }
        return totalMedicion;

    }

    public static List<medicion> getMedicionesById(Integer id) {
        /// Lista para devolver mediciones
        List<medicion> list = new ArrayList<>();
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName(BuscadorConsumoElectricoServlet.driverClassName);
            // Se obtiene una conexión con la base de datos.
            // En este caso nos conectamos a la base de datos prueba
            // con el usuario root y contraseña 1daw
            conexion = DriverManager.getConnection(BuscadorConsumoElectricoServlet.dbUrl, BuscadorConsumoElectricoServlet.dbUser, BuscadorConsumoElectricoServlet.dbPassword);
            // Se crea un Statement, para realizar la consulta
            Statement s = (Statement) conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
            ResultSet rs = s.executeQuery("SELECT * FROM mediciones WHERE `Cliente` = " + id);
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {
                /// Crea objeto medicion con nada fetch y lo agrega a la lista
                medicion m = new medicion(rs.getInt("idMedicion"), rs.getInt("Cliente"), rs.getDate("FechaHora"), rs.getDouble("KW"));
                list.add(m);
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
        }
        return list;

    }
}
