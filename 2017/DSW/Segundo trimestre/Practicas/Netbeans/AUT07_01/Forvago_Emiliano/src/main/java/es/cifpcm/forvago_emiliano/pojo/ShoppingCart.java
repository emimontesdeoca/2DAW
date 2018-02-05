/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.pojo;

import es.cifpcm.forvago_emiliano.utils.Cookies;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.Cookie;

/**
 *
 * @author emont
 */
public class ShoppingCart implements Serializable {

    private List<HotelOffer> offers = new ArrayList<>();
    private Integer totalDays = 1;

    public List<HotelOffer> getOffers() {
        return offers;
    }

    public void setOffers(List<HotelOffer> offers) {
        this.offers = offers;
    }

    public ShoppingCart() {

    }

    public void addOffer(HotelOffer offer) {
        this.offers.add(offer);
    }

    public void removeOffer(HotelOffer offer) {
        this.offers.remove(offer);
    }

    public Double getTotal() {

        double total = 0.0;

        try {
            Cookie getTotalDays = Cookies.getCookie("diasTotales");
            String d = getTotalDays.getValue();
            Integer dias = Integer.parseInt(d);

            this.totalDays = dias;

        } catch (Exception e) {
            String error = e.getMessage();
        }

        for (HotelOffer offer : offers) {
            total += offer.getPrice();
        }

        total = total * 100;
        total = Math.round(total);
        total = total / 100;

        total *= this.totalDays;

        return total;
    }

}
