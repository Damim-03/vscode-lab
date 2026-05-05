package com.refactoring.strategy;

public class BitcoinPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Bitcoin payment of $" + amount);
    }
}
