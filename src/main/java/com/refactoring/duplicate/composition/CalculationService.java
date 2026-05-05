package com.refactoring.duplicate.composition;

/**
 * AFTER Refactoring - Composition
 * الخطوة 1: عزل المنطق المشترك في كلاس مستقل
 */
public class CalculationService {

    public double calculateTotal(double subtotal, double taxRate) {
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    public double applyDiscount(double total, double discountRate) {
        return total * (1 - discountRate);
    }
}
