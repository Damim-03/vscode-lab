package com.refactoring.extract;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Extract Method - OrderProcessorAfter Tests")
class OrderProcessorAfterTest {

    private OrderProcessorAfter processor;

    @BeforeEach
    void setUp() {
        processor = new OrderProcessorAfter();
    }

    // ---- نختبر calculateTotalPrice عبر reflection أو نعيد تصميمه package-private للاختبار ----
    // بما أن الميثودات private نختبر السلوك الكلي عبر printOrderSummary

    @Test
    @DisplayName("printOrderSummary لا يرمي exception لطلب عميل عادي")
    void testPrintOrderSummary_regularCustomer_noException() {
        Customer customer = new Customer("Ali", false);
        List<Item> items = List.of(new Item("Book", 20.0, 2));
        Order order = new Order(customer, items);

        assertDoesNotThrow(() -> processor.printOrderSummary(order));
    }

    @Test
    @DisplayName("printOrderSummary لا يرمي exception لعميل عضو (يأخذ خصم 10%)")
    void testPrintOrderSummary_memberCustomer_noException() {
        Customer customer = new Customer("Sara", true);
        List<Item> items = List.of(
            new Item("Laptop", 1000.0, 1),
            new Item("Mouse", 50.0, 2)
        );
        Order order = new Order(customer, items);

        assertDoesNotThrow(() -> processor.printOrderSummary(order));
    }

    @Test
    @DisplayName("printOrderSummary يعمل مع قائمة عناصر متعددة")
    void testPrintOrderSummary_multipleItems_noException() {
        Customer customer = new Customer("Omar", true);
        List<Item> items = List.of(
            new Item("Phone",  800.0, 1),
            new Item("Case",    15.0, 3),
            new Item("Charger", 25.0, 2)
        );
        Order order = new Order(customer, items);

        assertDoesNotThrow(() -> processor.printOrderSummary(order));
    }

    @Test
    @DisplayName("printOrderSummary يعمل مع عنصر واحد فقط")
    void testPrintOrderSummary_singleItem_noException() {
        Customer customer = new Customer("Nour", false);
        List<Item> items = List.of(new Item("Pen", 2.5, 1));
        Order order = new Order(customer, items);

        assertDoesNotThrow(() -> processor.printOrderSummary(order));
    }
}
