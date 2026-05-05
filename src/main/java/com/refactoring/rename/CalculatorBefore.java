package com.refactoring.rename;

/**
 * BEFORE Refactoring - Rename Variables/Methods
 * المشكلة: أسماء متغيرات وميثودات غير واضحة
 */
public class CalculatorBefore {

    public double calc(double a, double b) {
        double x = a + b;
        double y = a * b;
        return x / y;
    }

    public void prtRes(double res) {
        System.out.println("Result: " + res);
    }
}
