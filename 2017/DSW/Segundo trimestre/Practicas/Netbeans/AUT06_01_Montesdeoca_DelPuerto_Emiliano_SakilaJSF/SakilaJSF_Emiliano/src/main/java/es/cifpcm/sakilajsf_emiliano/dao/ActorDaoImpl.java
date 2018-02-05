/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilajsf_emiliano.dao;

import es.cifpcm.sakilajsf_emiliano.pojo.Actor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emont
 */
public class ActorDaoImpl implements ActorDao {

    public List<Actor> selectAll() {
        List<Actor> lista = new ArrayList<>();

        /// Instanciamos la clase
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        /// Connection string 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "2daw", "2daw")) {
            /// La query para para devolver los actores
            String query = "select * from actor";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                /// Ejecutar la query
                ResultSet rs = pstmt.executeQuery();
                /// Mientras tenga resultados añadir a una lista
                while (rs.next()) {
                    Actor a = new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getDate("last_update"));
                    lista.add(a);
                }
            }
        } catch (SQLException ex) {
        }

        return lista;
    }

    public Actor insert(Actor actor) {
        Actor a = actor;

        /// Instanciamos la clase
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        /// Connection string 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "2daw", "2daw")) {
            /// La query para para devolver los actores
            String query = "INSERT INTO `actor`(`first_name`, `last_name`) VALUES (?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, a.getFirstName());
                pstmt.setString(2, a.getLastName());

                /// Ejecutar la query
                pstmt.executeUpdate();

                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {    
                    Short id = rs.getShort(1);
                    a.setActorId(Integer.parseInt(id.toString()));
                }
            }
        } catch (SQLException ex) {
        }

        return a;

    }
}
