/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micafeteria.web.controller;

/**
 *
 * @author emont
 */
public class Order {

    private Integer orderID;
    private String tipoCafe;
    private String extras;
    private Integer numeroExtras;
    private Double total;

    public Order(Integer orderID, String tipoCafe, String extras, Integer numeroExtras, Double total) {
        this.orderID = orderID;
        this.tipoCafe = tipoCafe;
        this.extras = extras;
        this.numeroExtras = numeroExtras;
        this.total = total;
    }

    public Order() {
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getTipoCafe() {
        return tipoCafe;
    }

    public void setTipoCafe(String tipoCafe) {
        this.tipoCafe = tipoCafe;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public Integer getNumeroExtras() {
        return numeroExtras;
    }

    public void setNumeroExtras(Integer numeroExtras) {
        this.numeroExtras = numeroExtras;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
