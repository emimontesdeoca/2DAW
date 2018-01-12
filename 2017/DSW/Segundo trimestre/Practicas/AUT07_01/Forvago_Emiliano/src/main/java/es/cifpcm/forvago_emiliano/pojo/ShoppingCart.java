/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 *
 * @author emont
 */
public class ShoppingCart implements Serializable {

    private final List<HotelOffer> offers = new ArrayList<>();

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
        for (HotelOffer offer : offers) {
            total += offer.getPrice();
        }

        total = total * 100;
        total = Math.round(total);
        total = total / 100;

        return total;
    }

}
