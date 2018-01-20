/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.dao;

import es.cifpcm.forvago_emiliano.pojo.HotelOffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author emont
 */
public class UserDaoImpl implements UserDao {

    @Override
    public Boolean login(String username, String password) {
        Boolean res = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        /// Connection string 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos", "2daw", "2daw")) {

            String query = "select * from users where user_name = ? and password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, username);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    res = true;
                    break;
                }
            }
        } catch (SQLException ex) {
        }

        return res;
    }

}
