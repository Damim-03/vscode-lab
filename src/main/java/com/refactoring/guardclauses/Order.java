package com.refactoring.guardclauses;

public class Order {
    private double totalAmount;
    private Customer customer;

    public Order(double totalAmount, Customer customer) {
        this.totalAmount = totalAmount;
        this.customer = customer;
    }

    public double getTotalAmount() { return totalAmount; }
    public Customer getCustomer()  { return customer; }
}
