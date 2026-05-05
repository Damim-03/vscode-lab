package com.refactoring.duplicate.composition;

/**
 * BEFORE - calculateTotal و applyDiscount مكررتان في الكلاسين
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

// -------------------------------------------------------

/**
 * AFTER - Composition
 * الخطوة 1: نعزل المنطق المشترك في CalculationService
 */
class CalculationService {
    public double calculateTotal(double subtotal, double taxRate) {
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    public double applyDiscount(double total, double discountRate) {
        return total * (1 - discountRate);
    }
}

/**
 * الخطوة 2: نحقن الـ CalculationService بدل تكراره
 */
class OrderCalculator {
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

class DiscountCalculator {
    private final CalculationService calculationService;

    public DiscountCalculator(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public double calculateDiscountedTotal(double subtotal, double taxRate, double discountRate) {
        double total = calculationService.calculateTotal(subtotal, taxRate);
        return calculationService.applyDiscount(total, discountRate);
    }
}
