/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.bean;

import es.cifpcm.forvago_emiliano.dao.CustomerDao;
import es.cifpcm.forvago_emiliano.pojo.Customer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author emont
 */
@Named(value = "registerBean")
@SessionScoped
public class RegisterBean extends Customer implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String registrar() {
        String res = "";

        return res;

    }

    /**
     * Creates a new instance of RegisterBean
     */
    public RegisterBean() {
    }

}
