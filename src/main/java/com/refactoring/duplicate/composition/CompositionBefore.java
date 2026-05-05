package com.refactoring.duplicate.composition;

/**
 * BEFORE Refactoring - Composition
 * المشكلة: calculateTotal و applyDiscount مكررتان في كلا الكلاسين
 */

class OrderCalculatorBefore {
    public double calculateTotal(double subtotal, double taxRate) {
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    public double applyDiscount(double total, double discountRate) {
        return total * (1 - discountRate);
    }
}

class DiscountCalculatorBefore {
    public double calculateTotal(double subtotal, double taxRate) {
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    public double applyDiscount(double total, double discountRate) {
        return total * (1 - discountRate);
    }
}
