/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1java;

/**
 *
 * @author emont
 */
public class T1java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Integer [] l = {1,2,3};
       int r = 0;
       
        for (Integer i : l) {
            r = r + i;
        }
        System.out.println("Hola el doble del resultado es: " + r);
    }
    
}
