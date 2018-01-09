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

        /// Instanciamos la clase
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        /// Connection string 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos", "2daw", "2daw")) {
            /// La query para para devolver los actores
            String query = "select * from provincias";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                /// Ejecutar la query
                ResultSet rs = pstmt.executeQuery();
                /// Mientras tenga resultados añadir a una lista
                while (rs.next()) {
                    Provincia a = new Provincia();

                    a.setId_provinicia(rs.getInt("id_provincia"));
                    a.setNombre(rs.getString("nombre"));

                    lista.add(a);
                }
            }
        } catch (SQLException ex) {
        }

        return lista;
    }
}
