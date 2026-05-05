package com.refactoring;

import com.refactoring.rename.*;
import com.refactoring.extract.*;
import com.refactoring.polymorphism.*;
import com.refactoring.guardclauses.*;
import com.refactoring.strategy.*;
import com.refactoring.duplicate.inheritance.*;
import com.refactoring.duplicate.composition.*;

import java.util.List;

/**
 * Main - يشغل جميع أمثلة Refactoring
 */
public class Main {

    public static void main(String[] args) {

        sep("1. RENAME VARIABLES / METHODS");
        CalculatorAfter calc = new CalculatorAfter();
        double ratio = calc.calculateSumProductRatio(4, 2);
        calc.printResult(ratio);

        sep("2. EXTRACT METHOD");
        Customer customer = new Customer("Ahmed", true);
        List<Item> items = List.of(
            new Item("Laptop", 1200.0, 1),
            new Item("Mouse",    25.0, 2)
        );
        Order order = new Order(customer, items);
        new OrderProcessorAfter().printOrderSummary(order);

        sep("3. POLYMORPHISM - Employee Bonus");
        Employee[] employees = {
            new Employee.Manager(),
            new Employee.Developer(),
            new Employee.Intern()
        };
        for (Employee e : employees) {
            System.out.println(e.getClass().getSimpleName()
                    + " bonus: $" + e.calculateBonus());
        }

        sep("4. GUARD CLAUSES - Discount");
        DiscountCalculator dc = new DiscountCalculator();
        com.refactoring.guardclauses.Order smallOrder =
            new com.refactoring.guardclauses.Order(50,
                new com.refactoring.guardclauses.Customer(false));
        com.refactoring.guardclauses.Order premiumOrder =
            new com.refactoring.guardclauses.Order(200,
                new com.refactoring.guardclauses.Customer(true));
        System.out.println("Small order discount:   " + dc.calculateDiscountAfter(smallOrder));
        System.out.println("Premium order discount: " + dc.calculateDiscountAfter(premiumOrder));

        sep("5. STRATEGY PATTERN - Payment");
        PaymentProcessor processor = new PaymentProcessor();
        processor.setPaymentStrategy(new CreditCardPayment());
        processor.processPayment(100.0);
        processor.setPaymentStrategy(new PayPalPayment());
        processor.processPayment(50.0);
        processor.setPaymentStrategy(new BitcoinPayment());
        processor.processPayment(200.0);

        sep("6. DUPLICATE / INHERITANCE - Animal");
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.eat();   dog.sleep();
        cat.eat();   cat.sleep();

        sep("7. DUPLICATE / COMPOSITION - Calculation");
        CalculationService svc = new CalculationService();
        OrderCalculator oc = new OrderCalculator(svc);
        DiscountCalculator dCalc = new DiscountCalculator(svc);
        System.out.println("Order Total:      $" + oc.calculateOrderTotal(100.0, 0.1));
        System.out.println("Discounted Total: $" + dCalc.calculateDiscountedTotal(100.0, 0.1, 0.2));
    }

    private static void sep(String title) {
        System.out.println("\n========== " + title + " ==========");
    }
}
