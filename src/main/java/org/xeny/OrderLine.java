package org.xeny;

import java.math.BigDecimal;

public class OrderLine {

    private String item;
    private int quantity;
    private BigDecimal unitPrice;

    public OrderLine() {

        super();

    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public OrderLine(String item, int quantity, BigDecimal unitPrice) {

        this.setItem(item);
        this.setQuantity(quantity);
        this.setUnitPrice(unitPrice);

    }
    
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode())
            + " [\n         " + getItem() 
            + " ,\n         " + getQuantity()
            + " ,\n         " + getUnitPrice()
            + " \n      ],\n";
    }

}