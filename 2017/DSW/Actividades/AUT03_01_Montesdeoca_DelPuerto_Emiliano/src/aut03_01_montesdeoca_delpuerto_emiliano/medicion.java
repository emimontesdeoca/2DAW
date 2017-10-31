/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aut03_01_montesdeoca_delpuerto_emiliano;

import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emont
 */
public class medicion {

    private Integer id;
    private Integer idCliente;
    private Date fechaMedicion;
    private Double kilow;

    public medicion() {
    }

    public medicion(Integer id, Integer idCliente, Date fechaMedicion, Double kilow) {
        this.id = id;
        this.idCliente = idCliente;
        this.fechaMedicion = fechaMedicion;
        this.kilow = kilow;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(Date fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public Double getKilow() {
        return kilow;
    }

    public void setKilow(Double kilow) {
        this.kilow = kilow;
    }

}
