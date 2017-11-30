/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilajsf_emiliano.web.dao;

import es.cifpcm.sakilajsf_emiliano.web.pojo.Actor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emont
 */
public class ActorDao {

    public static List<Actor> selectAll(Integer skip) {
        /// Lista que va a devolver de actores
        List<Actor> lista = new ArrayList();

        try {
            /// Instanciamos la clase
            Class.forName("com.mysql.jdbc.Driver");

            /// Connection string 
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "2daw", "2daw")) {
                /// La query para para devolver los actores
                String query = "select * from actor LIMIT ?,10";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    /// Asignar el valor
                    pstmt.setInt(1, skip);
                    /// Ejecutar la query
                    ResultSet rs = pstmt.executeQuery();
                    /// Mientras tenga resultados añadir a una lista
                    while (rs.next()) {
                        Actor a = new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getDate("last_update").toString());
                        lista.add(a);
                    }
                }
            } catch (SQLException ex) {

            }
        } catch (Exception e) {
        }
        /// Devolver
        return lista;
    }

    public static Integer selectAll() {
        /// Contador total de actores
        Integer i = 0;

        try {
            /// Instanciar la clase
            Class.forName("com.mysql.jdbc.Driver");

            /// Connection string
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "2daw", "2daw")) {
                /// query, no hace falta que pase parametros
                String query = "select * from actor";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    /// Ejecutar query
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        /// Sumar al contador
                        i++;
                    }
                }
            } catch (SQLException ex) {

            }
        } catch (Exception e) {
        }
        /// Devolver total
        return i;
    }
}
