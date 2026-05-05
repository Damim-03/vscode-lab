package com.refactoring.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Strategy Pattern - PaymentProcessor Tests")
class PaymentProcessorTest {

    private PaymentProcessor processor;
    private ByteArrayOutputStream outputCapture;

    @BeforeEach
    void setUp() {
        processor = new PaymentProcessor();
        outputCapture = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCapture));
    }

    @Test
    @DisplayName("CreditCard strategy تطبع الرسالة الصحيحة")
    void testCreditCardPayment_printsCorrectMessage() {
        processor.setPaymentStrategy(new CreditCardPayment());
        processor.processPayment(100.0);

        assertTrue(outputCapture.toString().contains("credit card"));
        assertTrue(outputCapture.toString().contains("100.0"));
    }

    @Test
    @DisplayName("PayPal strategy تطبع الرسالة الصحيحة")
    void testPayPalPayment_printsCorrectMessage() {
        processor.setPaymentStrategy(new PayPalPayment());
        processor.processPayment(50.0);

        assertTrue(outputCapture.toString().contains("PayPal"));
        assertTrue(outputCapture.toString().contains("50.0"));
    }

    @Test
    @DisplayName("Bitcoin strategy تطبع الرسالة الصحيحة")
    void testBitcoinPayment_printsCorrectMessage() {
        processor.setPaymentStrategy(new BitcoinPayment());
        processor.processPayment(200.0);

        assertTrue(outputCapture.toString().contains("Bitcoin"));
        assertTrue(outputCapture.toString().contains("200.0"));
    }

    @Test
    @DisplayName("يمكن تغيير الـ strategy في runtime (مرونة الـ Pattern)")
    void testSwitchStrategy_atRuntime() {
        processor.setPaymentStrategy(new CreditCardPayment());
        processor.processPayment(10.0);
        String firstOutput = outputCapture.toString();

        outputCapture.reset();

        processor.setPaymentStrategy(new PayPalPayment());
        processor.processPayment(10.0);
        String secondOutput = outputCapture.toString();

        assertNotEquals(firstOutput, secondOutput);
        assertTrue(firstOutput.contains("credit card"));
        assertTrue(secondOutput.contains("PayPal"));
    }

    @Test
    @DisplayName("processPayment بدون strategy يرمي IllegalStateException")
    void testProcessPayment_withoutStrategy_throwsException() {
        assertThrows(IllegalStateException.class,
                () -> processor.processPayment(100.0));
    }
}
