package com.example.domain;

public class Order {
    private int orderId;
    private Customer customer;
    private double totalAmount;

    // Constructor, getters, setters
    public Order(int orderId, Customer customer, double totalAmount) {
        this.orderId = orderId;
        this.customer = customer;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
