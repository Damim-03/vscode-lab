package com.refactoring.duplicate.composition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Composition - CalculationService Tests")
class CalculationServiceTest {

    private CalculationService service;

    @BeforeEach
    void setUp() {
        service = new CalculationService();
    }

    @Test
    @DisplayName("calculateTotal: 100 subtotal + 10% tax = 110")
    void testCalculateTotal_tenPercentTax() {
        double result = service.calculateTotal(100.0, 0.1);
        assertEquals(110.0, result, 0.0001);
    }

    @Test
    @DisplayName("calculateTotal: بدون ضريبة (0%) → نفس القيمة")
    void testCalculateTotal_zeroTax() {
        double result = service.calculateTotal(200.0, 0.0);
        assertEquals(200.0, result, 0.0001);
    }

    @Test
    @DisplayName("applyDiscount: 110 بخصم 20% = 88")
    void testApplyDiscount_twentyPercent() {
        double result = service.applyDiscount(110.0, 0.2);
        assertEquals(88.0, result, 0.0001);
    }

    @Test
    @DisplayName("applyDiscount: بدون خصم (0%) → نفس القيمة")
    void testApplyDiscount_zeroDiscount() {
        double result = service.applyDiscount(110.0, 0.0);
        assertEquals(110.0, result, 0.0001);
    }
}

@DisplayName("Composition - OrderCalculator Tests")
class OrderCalculatorTest {

    private OrderCalculator orderCalculator;

    @BeforeEach
    void setUp() {
        orderCalculator = new OrderCalculator(new CalculationService());
    }

    @Test
    @DisplayName("calculateOrderTotal: 100 + 10% tax = 110")
    void testCalculateOrderTotal() {
        double result = orderCalculator.calculateOrderTotal(100.0, 0.1);
        assertEquals(110.0, result, 0.0001);
    }

    @Test
    @DisplayName("applyOrderDiscount: 110 - 20% = 88")
    void testApplyOrderDiscount() {
        double result = orderCalculator.applyOrderDiscount(110.0, 0.2);
        assertEquals(88.0, result, 0.0001);
    }
}

@DisplayName("Composition - DiscountCalculator Tests")
class DiscountCalculatorTest {

    private DiscountCalculator discountCalculator;

    @BeforeEach
    void setUp() {
        discountCalculator = new DiscountCalculator(new CalculationService());
    }

    @Test
    @DisplayName("calculateDiscountedTotal: 100 + 10% tax - 20% discount = 88")
    void testCalculateDiscountedTotal_fullFlow() {
        double result = discountCalculator.calculateDiscountedTotal(100.0, 0.1, 0.2);
        assertEquals(88.0, result, 0.0001);
    }

    @Test
    @DisplayName("calculateDiscountedTotal: بدون ضريبة وبدون خصم = القيمة الأصلية")
    void testCalculateDiscountedTotal_noTaxNoDiscount() {
        double result = discountCalculator.calculateDiscountedTotal(100.0, 0.0, 0.0);
        assertEquals(100.0, result, 0.0001);
    }
}
