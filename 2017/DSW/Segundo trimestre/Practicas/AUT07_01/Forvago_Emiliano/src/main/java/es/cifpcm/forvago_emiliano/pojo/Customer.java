/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author emont
 */
public class Customer implements Serializable {

    private Integer customer_id;
    private String first_name;
    private String last_name;
    private String telefono;
    private String email;
    private Date fecha_de_nacimiento;

    public Customer(Integer customer_id, String first_name, String last_name, String telefono, String email, Date fecha_de_nacimiento) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.telefono = telefono;
        this.email = email;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public Customer() {
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

}
