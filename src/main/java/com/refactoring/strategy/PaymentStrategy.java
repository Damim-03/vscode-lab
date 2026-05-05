package com.refactoring.strategy;

/**
 * Strategy Interface - واجهة استراتيجية الدفع
 */
public interface PaymentStrategy {
    void pay(double amount);
}
