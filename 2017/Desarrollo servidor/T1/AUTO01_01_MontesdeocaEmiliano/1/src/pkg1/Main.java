package pkg1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Emiliano Montesdeoca del Puerto
        System.out.print("Primer numero: ");
        int a = new Scanner(System.in).nextInt();
        System.out.print("Segundo numero: ");
        int b = new Scanner(System.in).nextInt();
        System.out.println("");
        System.out.println("Suma: " + Suma(a,b));
        System.out.println("Resta: " + Resta(a,b));
        System.out.println("Division: " + Division(a,b));
        System.out.println("Modulo: " + Modulo(a,b));
     
    }
    
    public static int Suma(int a, int b){
        return a+b;
    }
    public static int Resta(int a, int b){
        return a-b;
    }
    public static int Division(int a, int b){
        return a/b;
    }
    public static int Modulo(int a, int b){
        return a%b;
    }
    
    public static String Ejercicio1(){
        return "EL SYSTEM_ROOT de Windows está ubicado en: \nC:\\Windows\\System32\\";
    }
    public static String Ejercicio2(){
        return "En un lugar de la \"La Mancha\" de cuyo nombre no quiero acordarme \nVivía un 'Hidalgo'";
    }
    public static String Ejercicio3(){
        return "Procesador \t Fabricante \nPentiuim \t Intel \nAthlon \t\t AMD";
    }
}
