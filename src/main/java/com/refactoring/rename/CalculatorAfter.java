package com.refactoring.rename;

/**
 * AFTER Refactoring - Rename Variables/Methods
 * الحل: أسماء واضحة تصف الغرض من كل متغير وميثود
 */
public class CalculatorAfter {

    public double calculateSumProductRatio(double num1, double num2) {
        double sum = num1 + num2;
        double product = num1 * num2;
        return sum / product;
    }

    public void printResult(double result) {
        System.out.println("Result: " + result);
    }
}
