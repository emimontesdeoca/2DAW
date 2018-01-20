/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.bean;

import es.cifpcm.forvago_emiliano.dao.HotelOfferDao;
import es.cifpcm.forvago_emiliano.dao.HotelOfferDaoImpl;

import es.cifpcm.forvago_emiliano.pojo.HotelOffer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author emont
 */
@Named(value = "hotelOfferBean")
@SessionScoped
public class HotelOfferBean extends HotelOffer implements Serializable {

    /**
     * Creates a new instance of HotelOfferBan
     */
    public HotelOfferBean() {
    }

    public void save() {
        HotelOfferDao h = new HotelOfferDaoImpl();
        System.out.println(this);
        h.insert(this);
    }

    public void delete() {
        HotelOfferDao h = new HotelOfferDaoImpl();
        System.out.println(this);
        h.delete(this.getHotel_id());
    }
}
