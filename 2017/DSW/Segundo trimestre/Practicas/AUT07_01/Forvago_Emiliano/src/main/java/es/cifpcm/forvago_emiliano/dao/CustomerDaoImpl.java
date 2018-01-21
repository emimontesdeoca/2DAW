/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.dao;

import es.cifpcm.forvago_emiliano.pojo.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emont
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void insert(Customer c, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos", "2daw", "2daw")) {

            String query = "INSERT INTO `customer`(`first_name`, `last_name`, `telefono`, `email`, `fecha_de_nacimiento`) VALUES (?,?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, c.getFirst_name());
                pstmt.setString(2, c.getLast_name());
                pstmt.setString(3, c.getTelefono());
                pstmt.setString(4, c.getEmail());
                java.sql.Date sqlDate = new java.sql.Date(c.getFecha_de_nacimiento().getTime());
                pstmt.setDate(5, sqlDate);

                pstmt.execute();
            }

            String query2 = "INSERT INTO `users`(`user_name`, `password`) VALUES (?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query2)) {

                pstmt.setString(1, user);
                pstmt.setString(2, password);

                pstmt.execute();
            }

            conn.close();
        } catch (SQLException ex) {
        }
    }

}
