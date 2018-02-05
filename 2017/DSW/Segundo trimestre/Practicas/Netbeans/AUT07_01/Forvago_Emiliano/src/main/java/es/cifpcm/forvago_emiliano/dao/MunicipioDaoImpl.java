/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.dao;

import es.cifpcm.forvago_emiliano.pojo.Municipio;
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
public class MunicipioDaoImpl implements MunicipioDao {

    public List<Municipio> selectAll() {
        List<Municipio> lista = new ArrayList<>();

        /// Instanciamos la clase
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos", "2daw", "2daw")) {

            String query = "select * from municipios";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    Municipio a = new Municipio();

                    a.setId_municipio(rs.getInt("id_municipio"));
                    a.setId_provincia(rs.getInt("id_provincia"));
                    a.setCod_municipio(rs.getInt("cod_municipio"));
                    a.setDC(rs.getInt("DC"));
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
