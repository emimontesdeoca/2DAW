package pkg1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print(("Introduzca un nombre: "));
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        System.out.print(("Bienvenido/a " + a));
    }
}
