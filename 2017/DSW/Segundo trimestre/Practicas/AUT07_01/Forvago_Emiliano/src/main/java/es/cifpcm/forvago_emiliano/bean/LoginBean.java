/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.bean;

import es.cifpcm.forvago_emiliano.dao.UserDao;
import es.cifpcm.forvago_emiliano.dao.UserDaoImpl;
import es.cifpcm.forvago_emiliano.utils.Cookies;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author emont
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

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

    public String loginUsuario() {
        UserDao u = new UserDaoImpl();
        if (u.login(this.username, this.password)) {
            Cookies.setCookie("username", this.username.toString(), 10);
            return "/index?faces-redirect=true";
        } else {
            Cookies.setCookie("Anonimo", this.username.toString(), 10);
            return "error?faces-redirect=true";
        }
    }

    public String loginAdministrador() {
        UserDao u = new UserDaoImpl();
        if (this.username.equals("admin") && this.username.equals("admin")) {
            if (u.login(this.username, this.password)) {
                return "/hotel/panel?faces-redirect=true";
            } else {
                return "error?faces-redirect=true";
            }
        } else {
            return "error?faces-redirect=true";
        }
    }

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

}
