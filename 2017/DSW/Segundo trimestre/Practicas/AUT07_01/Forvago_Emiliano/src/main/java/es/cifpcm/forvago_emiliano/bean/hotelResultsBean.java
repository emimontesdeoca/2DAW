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
import javax.servlet.http.Cookie;

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

    public List<HotelOffer> getSelectedOffer() {
        return selectedOffer;
    }

    public void setSelectedOffer(List<HotelOffer> selectedOffer) {
        this.selectedOffer = selectedOffer;
    }
    private List<HotelOffer> selectedOffer;

    public List<HotelOffer> getOffers() {

        Cookie a = Cookies.getCookie("idMunicipio");

        String b = a.getValue();

        Integer idMunicipioBusqueda = Integer.parseInt(b);

        this.offers = new MasterDataBean().getHotelOffers(idMunicipioBusqueda);

        return offers;
    }

    public void setOffers(List<HotelOffer> offers) {

        this.offers = offers;
    }

}
