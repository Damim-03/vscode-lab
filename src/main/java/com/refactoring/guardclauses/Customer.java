package com.refactoring.guardclauses;

public class Customer {
    private boolean isPremium;

    public Customer(boolean isPremium) {
        this.isPremium = isPremium;
    }

    public boolean isPremium() { return isPremium; }
}
