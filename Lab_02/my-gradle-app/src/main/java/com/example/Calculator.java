package com.example;

import org.apache.commons.lang3.StringUtils;

/**
 * A simple calculator with basic arithmetic operations and string utilities.
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    // ----- TODO Part: subtract, divide, reverseString -----

    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Divides a by b. Throws ArithmeticException when b == 0.
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    /**
     * Reverses a string using StringUtils from Apache Commons Lang.
     * Returns null if input is null (StringUtils handles this safely).
     */
    public String reverseString(String input) {
        return StringUtils.reverse(input);
    }
}
