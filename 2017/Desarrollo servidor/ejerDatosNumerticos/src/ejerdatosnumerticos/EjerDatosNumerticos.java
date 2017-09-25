package ejerdatosnumerticos;

import java.util.*;

public class EjerDatosNumerticos {

    public static void main(String[] args) {
        System.out.print("Dato\tValores");
        System.out.print("\n---------------------");

        int intmax = Integer.MAX_VALUE;
        int intmin = Integer.MIN_VALUE;
        String builder = "[" + intmin + "," + intmax + "]";
        System.out.print("\nint\t" + builder);

        long longmax = Long.MAX_VALUE;
        long longmin = Long.MIN_VALUE;
        builder = "[" + longmin + "," + longmax + "]";
        System.out.print("\nlong\t" + builder);

        float floatmax = Float.MAX_VALUE;
        float floatmin = Float.MIN_NORMAL;
        builder = "[" + floatmin + "," + floatmax + "]";
        System.out.print("\nfloat\t" + builder);

        double doublemax = Double.MAX_VALUE;
        double doublemin = Double.MIN_NORMAL;
        builder = "[" + doublemin + "," + doublemax + "]";
        System.out.print("\ndouble\t" + builder);

        System.out.print("\n\nDato\tBits");
        System.out.print("\n---------------------");

        double b = (Math.log10(Integer.MAX_VALUE) / Math.log10((2)));
        double c = (Math.log10(Long.MAX_VALUE) / Math.log10((2)));

        System.out.print("\nint\t" + (Math.round(b) + 1));
        System.out.print("\nlong\t" + (Math.round(c) + 1));
    }

}
