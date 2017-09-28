package pkg1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Emiliano Montesdeoca del Puerto
        /*Persona p1 = new Persona("Marta", "Sánchez", 42);
        Persona p2 = new Persona("Juan", "Diego", 39);

        mostrarDatosPersona(p1);
        System.out.println("");
        mostrarDatosPersona(p2);*/
        System.out.println(Integer.parseInt(args[0])*100);
    }

    public static void mostrarDatosPersona(Persona p) {

        System.out.println("Nombre: " + p.nombre);
        System.out.println("Apellido: " + p.apellidos);
        System.out.println("Edad: " + p.edad);

    }

}
