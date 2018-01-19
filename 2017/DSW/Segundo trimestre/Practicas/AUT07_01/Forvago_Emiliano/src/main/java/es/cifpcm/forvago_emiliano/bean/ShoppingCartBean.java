/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.bean;

import es.cifpcm.forvago_emiliano.pojo.ShoppingCart;
import es.cifpcm.forvago_emiliano.utils.Cookies;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.NumberFormat;
import javax.servlet.http.Cookie;

/**
 *
 * @author emont
 */
@Named(value = "shoppingCartBean")
@SessionScoped
public class ShoppingCartBean extends ShoppingCart implements Serializable {

    /**
     * Creates a new instance of ShoppingCartBean
     */
    public ShoppingCartBean() {

    }

    public String getTotalAsString() {
        return NumberFormat.getCurrencyInstance().format(getTotal());
    }

    public String getTotalDays() {

        String d = "0";

        try {
            Cookie getTotalDays = Cookies.getCookie("diasTotales");
            d = getTotalDays.getValue();
        } catch (Exception e) {
        }

        return "- " + d + " dias seleccionados.";
    }

}
