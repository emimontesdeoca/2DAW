/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.pojo;

/**
 *
 * @author emont
 */
public class Provincia {

    public Integer getId_provinicia() {
        return id_provinicia;
    }

    public void setId_provinicia(Integer id_provinicia) {
        this.id_provinicia = id_provinicia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia(Integer id_provinicia, String nombre) {
        this.id_provinicia = id_provinicia;
        this.nombre = nombre;
    }

    public Provincia() {
    }
    private Integer id_provinicia;
    private String nombre;
    
}
