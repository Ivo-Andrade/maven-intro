package org.xeny;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private String orderNo;
    private LocalDate date;
    private String customerName;
    private List<OrderLine> orderLines;

    public Order() {

        super();

    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Order(String orderNo, LocalDate date, String customerName, List<OrderLine> orderLines) {

        this.setOrderNo(orderNo);
        this.setDate(date);
        this.setCustomerName(customerName);
        this.setOrderLines(orderLines);

    }
    
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode())
            + " [\n     " + getOrderNo() 
            + " ,\n     " + getDate()
            + " ,\n     " + getCustomerName()
            + " ,\n     " + getOrderLines().toString()
            + " \n];";
    }

}