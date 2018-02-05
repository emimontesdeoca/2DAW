/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.pojo;

import java.io.Serializable;

/**
 *
 * @author emont
 */
public class Municipio implements Serializable{

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public Integer getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(Integer id_provincia) {
        this.id_provincia = id_provincia;
    }

    public Integer getCod_municipio() {
        return cod_municipio;
    }

    public void setCod_municipio(Integer cod_municipio) {
        this.cod_municipio = cod_municipio;
    }

    public Integer getDC() {
        return DC;
    }

    public void setDC(Integer DC) {
        this.DC = DC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Municipio() {
    }

    public Municipio(Integer id_municipio, Integer id_provincia, Integer cod_municipio, Integer DC, String nombre) {
        this.id_municipio = id_municipio;
        this.id_provincia = id_provincia;
        this.cod_municipio = cod_municipio;
        this.DC = DC;
        this.nombre = nombre;
    }
    private Integer id_municipio;
    private Integer id_provincia;
    private Integer cod_municipio;
    private Integer DC;
    private String nombre;
    
}
