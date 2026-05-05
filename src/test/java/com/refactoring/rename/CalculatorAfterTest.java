package com.refactoring.rename;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Rename Variables/Methods - CalculatorAfter Tests")
class CalculatorAfterTest {

    private final CalculatorAfter calculator = new CalculatorAfter();

    @Test
    @DisplayName("calculateSumProductRatio: (4, 2) → sum=6, product=8 → 6/8 = 0.75")
    void testCalculateSumProductRatio_normalValues() {
        double result = calculator.calculateSumProductRatio(4, 2);
        assertEquals(0.75, result, 0.0001);
    }

    @Test
    @DisplayName("calculateSumProductRatio: (3, 3) → sum=6, product=9 → 6/9 = 0.666...")
    void testCalculateSumProductRatio_equalValues() {
        double result = calculator.calculateSumProductRatio(3, 3);
        assertEquals(6.0 / 9.0, result, 0.0001);
    }

    @Test
    @DisplayName("calculateSumProductRatio: (1, 9) → sum=10, product=9 → 10/9")
    void testCalculateSumProductRatio_differentValues() {
        double result = calculator.calculateSumProductRatio(1, 9);
        assertEquals(10.0 / 9.0, result, 0.0001);
    }

    @Test
    @DisplayName("printResult لا ترمي exception عند استدعائها")
    void testPrintResult_doesNotThrow() {
        assertDoesNotThrow(() -> calculator.printResult(0.75));
    }
}
