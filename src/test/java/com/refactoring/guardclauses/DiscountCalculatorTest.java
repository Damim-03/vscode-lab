package com.refactoring.guardclauses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Guard Clauses - DiscountCalculator Tests")
class DiscountCalculatorTest {

    private DiscountCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new DiscountCalculator();
    }

    // ---- Early Return: orders <= 100 ----

    @Test
    @DisplayName("طلب أقل من 100 → لا خصم (0.0) بغض النظر عن نوع العميل")
    void testSmallOrder_regularCustomer_noDiscount() {
        Order order = new Order(50, new Customer(false));
        assertEquals(0.0, calculator.calculateDiscountAfter(order), 0.0001);
    }

    @Test
    @DisplayName("طلب أقل من 100 + عميل مميز → لا خصم أيضاً (Guard Clause يقطع مبكراً)")
    void testSmallOrder_premiumCustomer_noDiscount() {
        Order order = new Order(99, new Customer(true));
        assertEquals(0.0, calculator.calculateDiscountAfter(order), 0.0001);
    }

    @Test
    @DisplayName("طلب يساوي 100 بالضبط → لا خصم (الشرط > 100)")
    void testBorderOrder_exactly100_noDiscount() {
        Order order = new Order(100, new Customer(true));
        assertEquals(0.0, calculator.calculateDiscountAfter(order), 0.0001);
    }

    // ---- Orders > 100 ----

    @Test
    @DisplayName("طلب أكثر من 100 + عميل عادي → خصم 10% (0.1)")
    void testLargeOrder_regularCustomer_tenPercentDiscount() {
        Order order = new Order(200, new Customer(false));
        assertEquals(0.1, calculator.calculateDiscountAfter(order), 0.0001);
    }

    @Test
    @DisplayName("طلب أكثر من 100 + عميل مميز → خصم 20% (0.2)")
    void testLargeOrder_premiumCustomer_twentyPercentDiscount() {
        Order order = new Order(200, new Customer(true));
        assertEquals(0.2, calculator.calculateDiscountAfter(order), 0.0001);
    }

    @Test
    @DisplayName("Before vs After: نفس النتيجة (السلوك لم يتغير بعد Refactoring)")
    void testBeforeAndAfterProduceSameResult() {
        Order smallRegular  = new Order(50,  new Customer(false));
        Order smallPremium  = new Order(50,  new Customer(true));
        Order largeRegular  = new Order(500, new Customer(false));
        Order largePremium  = new Order(500, new Customer(true));

        assertEquals(calculator.calculateDiscountBefore(smallRegular),
                     calculator.calculateDiscountAfter(smallRegular),  0.0001);
        assertEquals(calculator.calculateDiscountBefore(smallPremium),
                     calculator.calculateDiscountAfter(smallPremium),  0.0001);
        assertEquals(calculator.calculateDiscountBefore(largeRegular),
                     calculator.calculateDiscountAfter(largeRegular),  0.0001);
        assertEquals(calculator.calculateDiscountBefore(largePremium),
                     calculator.calculateDiscountAfter(largePremium),  0.0001);
    }
}
