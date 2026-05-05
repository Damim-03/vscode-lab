package com.refactoring.polymorphism;

/**
 * BEFORE Refactoring - Replace Conditional with Polymorphism
 * المشكلة: استخدام if-else لتحديد نوع الموظف وراتبه
 */
public class EmployeeBefore {

    public double calculateBonus(String type) {
        if (type.equals("Manager")) {
            return 5000;
        } else if (type.equals("Developer")) {
            return 3000;
        } else {
            return 1000; // Intern
        }
    }
}
