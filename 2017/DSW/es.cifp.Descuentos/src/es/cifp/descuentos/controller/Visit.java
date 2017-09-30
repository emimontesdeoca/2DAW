package es.cifp.descuentos.controller;

import java.util.Date;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @clase Desarrollo entorno servidor
 * @curso 2DAW-B 2017-2018
 */
public class Visit {

    private Customer customer;
    private Date date;
    private Double serviceExpense;
    private Double productExpense;

    public Visit(String name, Date date) {

        this.customer = new Customer().getCustomerByName(name);
        this.date = date;
        this.serviceExpense = 0.0;
        this.productExpense = 0.0;
    }

    public String getName() {
        return this.customer.getName();
    }

    public Double getServiceExpense() {
        return this.serviceExpense;
    }

    public void setServiceExpense(double ex) {
        this.serviceExpense += ex;
    }

    public Double getProductExpense() {
        return this.productExpense;
    }

    public void setProductExpense(double ex) {
        this.productExpense += ex;
    }

    public double getTotalExpense() {
        double total = 0.0;

        double s = getServiceExpense() * DiscountRate.getServiceDiscountRate(this.customer.getMemberType());
        double p = getProductExpense() * DiscountRate.getProductDiscountRate(this.customer.getMemberType());

        return s + p;
    }
}
