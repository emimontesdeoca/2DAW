/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.aut03_02;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author emont
 */
public class medicion {

    private Integer id;
    private Integer idCliente;
    private Date fechaMedicion;
    private Double kilow;

    public medicion() {
    }

    public medicion(Integer id, Integer idCliente, Date fechaMedicion, Double kilow) {
        this.id = id;
        this.idCliente = idCliente;
        this.fechaMedicion = fechaMedicion;
        this.kilow = kilow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(Date fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public Double getKilow() {
        return kilow;
    }

    public void setKilow(Double kilow) {
        this.kilow = kilow;
    }

}
