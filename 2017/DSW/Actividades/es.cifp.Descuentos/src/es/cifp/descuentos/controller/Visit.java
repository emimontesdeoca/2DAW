package es.cifp.descuentos.controller;

import java.util.Date;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @clase Desarrollo entorno servidor
 * @curso 2DAW-B 2017-2018
 */
public class Visit {

    /// Vars
    private Customer customer;
    private Date date;
    private Double serviceExpense;
    private Double productExpense;

    /// Vars constructor
    public Visit(String name, Date date) {

        this.customer = new Customer().getCustomerByName(name);
        this.date = date;
        this.serviceExpense = 0.0;
        this.productExpense = 0.0;
    }

    /// Getters and setters
    public String getDate() {
        return this.date.toString();
    }

    public String getName() {
        return this.customer.getName();
    }

    public String getCustomerType() {
        return this.customer.getMemberType();
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

    public void resetExpenses() {
        this.productExpense = 0.0;
        this.serviceExpense = 0.0;

    }

    /// Geto total expense without discount
    public double getTotalExpenseWithoutDiscount() {
        double total = 0.0;
        double s = getServiceExpense();
        double p = getProductExpense();

        return s + p;
    }

    /// Get total expense with discount
    public double getTotalExpense() {
        double total = 0.0;

        double descuentoServicio = getServiceExpense() * DiscountRate.getServiceDiscountRate(this.customer.getMemberType());
        double descuentoProducto = getProductExpense() * DiscountRate.getProductDiscountRate(this.customer.getMemberType());
        double s = getServiceExpense() - descuentoServicio;
        double p = getProductExpense() - descuentoProducto;

        return s + p;
    }
}
