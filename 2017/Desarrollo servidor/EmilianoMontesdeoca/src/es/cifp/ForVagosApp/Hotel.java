/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifp.ForVagosApp;

/**
 *
 * @author emont
 */
public class Hotel {

    public static String filename = "C:\\Users\\emont\\Desktop\\hoteles.txt";

    private String nombre;
    private String localidad;
    private Integer estrellas;
    private Integer precioNoche;

    public Hotel() {
    }

    public Hotel(String nombre, String localidad, Integer estrellas, Integer precioNoche) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.estrellas = estrellas;
        this.precioNoche = precioNoche;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getEstrellas() {
        return this.estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public Integer getPrecioNoche() {
        return this.precioNoche;
    }

    public void setPrecioNoche(Integer precioNoche) {
        this.precioNoche = precioNoche;
    }

}
