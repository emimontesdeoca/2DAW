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

    public static List<Actor> selectAll() {
        List<Actor> lista = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "2daw", "2daw")) {
                String query = "select * from actor";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        Actor a = new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getDate("last_update").toString());
                        lista.add(a);
                    }
                }
            } catch (SQLException ex) {

            }
        } catch (Exception e) {
        }
        return lista;
    }

}
