package com.refactoring.polymorphism;

/**
 * AFTER Refactoring - Replace Conditional with Polymorphism
 * الحل: كل نوع موظف يحسب مكافأته بنفسه عبر Override
 */
public abstract class Employee {
    abstract double calculateBonus();

    // ---- Subclasses ----

    public static class Manager extends Employee {
        @Override
        public double calculateBonus() { return 5000; }
    }

    public static class Developer extends Employee {
        @Override
        public double calculateBonus() { return 3000; }
    }

    public static class Intern extends Employee {
        @Override
        public double calculateBonus() { return 1000; }
    }
}
