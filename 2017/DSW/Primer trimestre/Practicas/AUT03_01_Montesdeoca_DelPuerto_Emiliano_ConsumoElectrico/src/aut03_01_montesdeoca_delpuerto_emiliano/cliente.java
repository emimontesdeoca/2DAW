/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aut03_01_montesdeoca_delpuerto_emiliano;

import com.mysql.jdbc.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emont
 */
public class cliente {

    private Integer id;
    private String nombre;
    private String apellido;
    private String nombreCalle;
    private Integer numero;
    private Integer codPostal;
    private String poblacion;
    private String provincia;

    public cliente() {
    }

    public cliente(Integer id, String nombre, String apellido, String nombreCalle, Integer numero, Integer codPostal, String poblacion, String provincia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreCalle = nombreCalle;
        this.numero = numero;
        this.codPostal = codPostal;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public static cliente getClienteByNombre(String nombre) {
        cliente newcliente = null;

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
            Class.forName("com.mysql.jdbc.Driver");
            // Se obtiene una conexión con la base de datos.
            // En este caso nos conectamos a la base de datos prueba
            // con el usuario root y contraseña 1daw
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/consumoelectrico", "2daw", "2daw");
            // Se crea un Statement, para realizar la consulta
            Statement s = (Statement) conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
            ResultSet rs = s.executeQuery("select * from misclientes");
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
