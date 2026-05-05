package com.refactoring.duplicate.composition;

/**
 * AFTER Refactoring - Composition
 * الخطوة 2: OrderCalculator يستخدم CalculationService بدل أن يكرر المنطق
 */
public class OrderCalculator {
    private final CalculationService calculationService;

    public OrderCalculator(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public double calculateOrderTotal(double subtotal, double taxRate) {
        return calculationService.calculateTotal(subtotal, taxRate);
    }

    public double applyOrderDiscount(double total, double discountRate) {
        return calculationService.applyDiscount(total, discountRate);
    }
}
