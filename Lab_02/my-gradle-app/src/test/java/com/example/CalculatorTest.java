package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    // ----- Original tests -----

    @Test
    public void testAddition() {
        assertEquals(15, calculator.add(10, 5));
        assertEquals(0, calculator.add(-5, 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(50, calculator.multiply(10, 5));
        assertEquals(0, calculator.multiply(0, 5));
    }

    // ----- TODO Part tests: subtract, divide, reverseString -----

    @Test
    public void testSubtraction() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-10, calculator.subtract(-5, 5));
        assertEquals(0, calculator.subtract(7, 7));
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculator.divide(10, 5));
        assertEquals(0.5, calculator.divide(1, 2));
        assertEquals(-2.0, calculator.divide(-10, 5));
    }

    @Test
    public void testDivisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test
    public void testReverseString() {
        assertEquals("olleH", calculator.reverseString("Hello"));
        assertEquals("", calculator.reverseString(""));
        assertEquals("a", calculator.reverseString("a"));
        assertEquals("elgniauD", calculator.reverseString("Duaingle"));
    }

    @Test
    public void testReverseNullString() {
        // StringUtils.reverse(null) returns null safely
        assertNull(calculator.reverseString(null));
    }
}
