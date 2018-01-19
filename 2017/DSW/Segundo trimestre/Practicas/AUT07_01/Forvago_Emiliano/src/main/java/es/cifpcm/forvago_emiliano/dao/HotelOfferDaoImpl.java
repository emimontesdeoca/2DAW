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
import java.util.*;

/**
 *
 * @author emont
 */
public class HotelOfferDaoImpl implements HotelOfferDao {

    public List<HotelOffer> selectAll() {

        List<HotelOffer> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        /// Connection string 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos", "2daw", "2daw")) {

            String query = "select * from hoteloffer";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                /// Ejecutar la query
                ResultSet rs = pstmt.executeQuery();
                /// Mientras tenga resultados añadir a una lista
                while (rs.next()) {
                    HotelOffer h = new HotelOffer();

                    h.setHotel_id(rs.getInt("hotel_id"));
                    h.setName(rs.getString("name"));
                    h.setPrice(rs.getDouble("price"));
                    h.setHotel_picture(rs.getString("hotel_picture"));
                    h.setId_municipio(rs.getInt("id_municipio"));

                    lista.add(h);
                }
            }
        } catch (SQLException ex) {
        }

        return lista;
    }

    public void insert(HotelOffer h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        /// Connection string 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos", "2daw", "2daw")) {

            String query = "INSERT INTO `hoteloffer`(`name`, `price`, `hotel_picture`, `id_municipio`) VALUES (?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, h.getName());
                pstmt.setDouble(2, h.getPrice());
                pstmt.setString(3, h.getHotel_picture());
                pstmt.setInt(4, h.getId_municipio());

                /// Ejecutar la query
                pstmt.execute();

            }
        } catch (SQLException ex) {
        }
    }

    public void select(HotelOffer h) {

    }

    public void update(HotelOffer h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        /// Connection string 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos", "2daw", "2daw")) {

            String query = "UPDATE `hoteloffer` SET `name`=?,`price`=?,`hotel_picture`=?,`id_municipio`=? WHERE hotel_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, h.getName());
                pstmt.setDouble(2, h.getPrice());
                pstmt.setString(3, h.getHotel_picture());
                pstmt.setInt(4, h.getId_municipio());
                pstmt.setInt(5, h.getHotel_id());

                /// Ejecutar la query
                pstmt.execute();

            }
        } catch (SQLException ex) {
        }
    }

    public void delete(Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        /// Connection string 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos", "2daw", "2daw")) {

            String query = "DELETE FROM `hoteloffer` WHERE hotel_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setInt(1, id);

                /// Ejecutar la query
                pstmt.execute();

            }
        } catch (SQLException ex) {
        }
    }

    public List<HotelOffer> selectByCriteria(Integer idMunicipio) {
        List<HotelOffer> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        /// Connection string 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos", "2daw", "2daw")) {

            String query = "select * from hoteloffer where id_municipio = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setInt(1, idMunicipio);

                /// Ejecutar la query
                ResultSet rs = pstmt.executeQuery();
                /// Mientras tenga resultados añadir a una lista
                while (rs.next()) {
                    HotelOffer h = new HotelOffer();

                    h.setHotel_id(rs.getInt("hotel_id"));
                    h.setName(rs.getString("name"));
                    h.setPrice(rs.getDouble("price"));
                    h.setHotel_picture(rs.getString("hotel_picture"));
                    h.setId_municipio(rs.getInt("id_municipio"));

                    lista.add(h);
                }
            }
        } catch (SQLException ex) {
        }

        return lista;
    }

    public List<HotelOffer> selectByCriteria(String nombreMunicipio) {
        List<HotelOffer> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
        }

        /// Connection string 
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos", "2daw", "2daw")) {

            String query = "select * from hoteloffer where name like %?%";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, nombreMunicipio);

                /// Ejecutar la query
                ResultSet rs = pstmt.executeQuery();
                /// Mientras tenga resultados añadir a una lista
                while (rs.next()) {
                    HotelOffer h = new HotelOffer();

                    h.setHotel_id(rs.getInt("hotel_id"));
                    h.setName(rs.getString("name"));
                    h.setPrice(rs.getDouble("price"));
                    h.setHotel_picture(rs.getString("hotel_picture"));
                    h.setId_municipio(rs.getInt("id_municipio"));

                    lista.add(h);
                }
            }
        } catch (SQLException ex) {
        }

        return lista;
    }

}
