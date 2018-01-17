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

    private final List<HotelOffer> offers = new ArrayList<>();
    private Integer totalDays;

    public ShoppingCart() {

    }

    public void addOffer(HotelOffer offer) {
        this.offers.add(offer);
    }

    public void removeOffer(HotelOffer offer) {
        this.offers.remove(offer);
    }

    public Double getTotal() {

        Cookie entradaCookie = Cookies.getCookie("fechaEntrada");
        Cookie salidaCookie = Cookies.getCookie("fechaSalida");

        try {

            String entradaString = entradaCookie.getValue();
            String salidaString = salidaCookie.getValue();

            String string = "January 2, 2010";
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date = format.parse(string);
            System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
        } catch (Exception e) {
        }

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
