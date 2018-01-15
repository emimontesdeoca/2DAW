/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.bean;

import es.cifcpm.forvago_emiliano.utils.Cookies;
import es.cifpcm.forvago_emiliano.pojo.HotelOffer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author emont
 */
@Named(value = "hotelResultsBean")
@SessionScoped
public class hotelResultsBean implements Serializable {

    /**
     * Creates a new instance of hotelResultsBean
     */
    public hotelResultsBean() {

    }

    private List<HotelOffer> offers = new ArrayList<>();
    private List<HotelOffer> selectedOffer;

    public List<HotelOffer> getOffers() {

        Integer idMunicipioBusqueda = Integer.parseInt(Cookies.getCookie("idMunicpio").toString());

        this.offers = new MasterDataBean().getHotelOffers(idMunicipioBusqueda);

        return offers;
    }

    public void setOffers(List<HotelOffer> offers) {

        this.offers = offers;
    }

}
