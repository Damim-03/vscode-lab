package com.refactoring.duplicate.utility;

import java.util.List;

// --- Model ---
class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice()  { return price; }
    public int getQuantity()  { return quantity; }
}

class Order {
    private List<Item> items;

    public Order(List<Item> items) { this.items = items; }
    public List<Item> getItems()   { return items; }
}

// --- AFTER: Utility Class ---
/**
 * المنطق المشترك في مكان واحد
 */
class OrderUtils {
    public static double calculateTotal(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}

// --- Classes that USE the utility ---
class OrderProcessor {
    public double calculateTotal(Order order) {
        return OrderUtils.calculateTotal(order);
    }
}

class InvoiceGenerator {
    public double calculateTotal(Order order) {
        return OrderUtils.calculateTotal(order);
    }
}
