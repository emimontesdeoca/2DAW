package es.cifp.descuentos.controller;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @clase Desarrollo entorno servidor
 * @curso 2DAW-B 2017-2018
 */
public class DiscountRate {

    private static final Double serviceDiscountPremium = 0.2;
    private static final Double serviceDiscountGold = 0.15;
    private static final Double serviceDiscountSilver = 0.1;
    private static final Double productDiscountPremium = 0.2;
    private static final Double productDiscountGold = 0.15;
    private static final Double productDiscountSilver = 0.1;

    public static Double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premiuim":
                return serviceDiscountPremium;
            case "Gold":
                return serviceDiscountSilver;
            case "Silver":
                return serviceDiscountGold;
            default:
                return 0.0;
        }
    }

    public static Double getProductDiscountRate(String type) {
        switch (type) {
            case "Premiuim":
                return productDiscountPremium;
            case "Gold":
                return productDiscountSilver;
            case "Silver":
                return productDiscountGold;
            default:
                return 0.0;
        }
    }
}
