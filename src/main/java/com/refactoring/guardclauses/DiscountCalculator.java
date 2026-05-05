package com.refactoring.guardclauses;

/**
 * Guard Clauses - تبسيط الشروط المتداخلة
 */
public class DiscountCalculator {

    // ---------- BEFORE ----------
    /**
     * المشكلة: شروط متداخلة تجعل الكود صعب القراءة
     */
    public double calculateDiscountBefore(Order order) {
        double discount = 0.0;
        if (order.getTotalAmount() > 100) {
            if (order.getCustomer().isPremium()) {
                discount = 0.2; // 20% for premium
            } else {
                discount = 0.1; // 10% for regular
            }
        }
        return discount;
    }

    // ---------- AFTER ----------
    /**
     * الحل: Guard Clauses - خروج مبكر للحالات الخاصة مما يجعل الكود خطياً وسهل القراءة
     */
    public double calculateDiscountAfter(Order order) {
        if (order.getTotalAmount() <= 100) {
            return 0.0; // Early return: no discount for small orders
        }

        if (order.getCustomer().isPremium()) {
            return 0.2; // 20% for premium customers
        }

        return 0.1; // 10% for regular customers
    }
}
