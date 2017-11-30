/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ut04_05.controller;

import es.cifpcm.ut04_05.category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emont
 */
public class categoryController {

    public static List<es.cifpcm.ut04_05.category> getAllCategories() {

        List<es.cifpcm.ut04_05.category> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas", "2daw", "2daw")) {
            String query = "select * from categories";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        category c = new category(rs.getInt("IdCategory"), rs.getString("Description"));
                        list.add(c);

                    }
                }
            }
        } catch (SQLException ex) {

        }

        return list;
    }
}
