/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaapp;

/**
 *
 * @author emont
 */
public class Persona {
    public String Nombre;
    public String Apellido;
    public Integer Edad;
    
    public Persona(String nombre, String apellido, Integer edad){
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
    }
    
    public String getNombre(){
        return Nombre;        
    }
}
