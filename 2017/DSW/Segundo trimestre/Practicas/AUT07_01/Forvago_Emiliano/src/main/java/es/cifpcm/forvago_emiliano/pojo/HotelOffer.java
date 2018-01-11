/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.pojo;

import java.io.Serializable;

/**
 *
 * @author emont
 */
public class HotelOffer implements Serializable {

    private Integer hotel_id;
    private String name;
    private Double price;
    private String hotel_picture;
    private Integer id_municipio;

    public HotelOffer(Integer hotel_id, String name, Double price, String hotel_picture, Integer id_municipio) {
        this.hotel_id = hotel_id;
        this.name = name;
        this.price = price;
        this.hotel_picture = hotel_picture;
        this.id_municipio = id_municipio;
    }

    public HotelOffer() {
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getHotel_picture() {
        return hotel_picture;
    }

    public void setHotel_picture(String hotel_picture) {
        this.hotel_picture = hotel_picture;
    }

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

}
