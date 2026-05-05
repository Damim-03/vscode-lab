package com.refactoring.strategy;

/**
 * BEFORE Refactoring - if-else على نوع الدفع
 */
class PaymentProcessorBefore {
    public void processPayment(String paymentMethod, double amount) {
        if (paymentMethod.equals("CreditCard")) {
            System.out.println("Processing credit card payment of $" + amount);
        } else if (paymentMethod.equals("PayPal")) {
            System.out.println("Processing PayPal payment of $" + amount);
        } else if (paymentMethod.equals("Bitcoin")) {
            System.out.println("Processing Bitcoin payment of $" + amount);
        } else {
            throw new IllegalArgumentException("Unknown payment method");
        }
    }
}

/**
 * AFTER Refactoring - Strategy Pattern
 * الحل: الـ Context يفوض العمل للاستراتيجية المحددة
 */
public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        paymentStrategy.pay(amount);
    }
}
