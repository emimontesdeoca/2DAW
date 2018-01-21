/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.dao;

import es.cifpcm.forvago_emiliano.pojo.Municipio;
import es.cifpcm.forvago_emiliano.pojo.Provincia;
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
public class ProvinciaDaoImpl implements ProvinciaDao {

    public List<Provincia> selectAll() {
        List<Provincia> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            String error = "error";
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos", "2daw", "2daw")) {

            String query = "select * from provincias";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    Provincia a = new Provincia();

                    a.setId_provinicia(rs.getInt("id_provincia"));
                    a.setNombre(rs.getString("nombre"));

                    lista.add(a);
                }
            }
            conn.close();
        } catch (SQLException ex) {
        }

        return lista;
    }
}
