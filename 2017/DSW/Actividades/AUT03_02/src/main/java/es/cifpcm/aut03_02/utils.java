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

                newcliente = new cliente(rs.getInt("Id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("NombreCalle"), rs.getInt("numero"), rs.getInt("CodPostal"), rs.getString("CodPostal"), rs.getString("Provincia"));
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

        Double totalMedicion = 0.0;
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            // Se obtiene una conexión con la base de datos.
            // En este caso nos conectamos a la base de datos prueba
            // con el usuario root y contraseña 1daw
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/consumoelectrico", "2daw", "2daw");
            // Se crea un Statement, para realizar la consulta
            Statement s = (Statement) conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
            ResultSet rs = s.executeQuery("SELECT * FROM mediciones WHERE `Cliente` = " + id);
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {

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

    public static List<Integer[]> getIdMedicionClienteByCodigoPostal(Integer cp) {

        List<Integer[]> list = new ArrayList<>();
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            // Se obtiene una conexión con la base de datos.
            // En este caso nos conectamos a la base de datos prueba
            // con el usuario root y contraseña 1daw
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/consumoelectrico", "2daw", "2daw");
            // Se crea un Statement, para realizar la consulta
            Statement s = (Statement) conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
            ResultSet rs = s.executeQuery("SELECT mediciones.idMedicion, misclientes.CodPostal, mediciones.Cliente FROM `mediciones` INNER join misclientes on mediciones.idMedicion = misclientes.id WHERE misclientes.CodPostal = " + cp);
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {

                Integer[] item = new Integer[3];
                item[0] = rs.getInt("idMedicion");
                item[1] = rs.getInt("CodPostal");
                item[2] = rs.getInt("Cliente");
                list.add(item);
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
