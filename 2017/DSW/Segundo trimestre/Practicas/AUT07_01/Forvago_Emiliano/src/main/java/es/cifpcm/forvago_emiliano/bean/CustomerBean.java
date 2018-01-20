/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author emont
 */
@Named(value = "customerBean")
@SessionScoped
public class CustomerBean implements Serializable {

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }
    
}
