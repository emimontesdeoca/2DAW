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
public class PersonaApp {

    public static void main(String[] args) {
        Persona p = new Persona(args[0], Integer.parseInt(args[1]));

        System.out.println(p.getNombre());
        System.out.println(p.getEdad());

    }

}
