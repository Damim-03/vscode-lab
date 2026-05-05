package com.refactoring.polymorphism;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Polymorphism - Employee Bonus Tests")
class EmployeeTest {

    @Test
    @DisplayName("Manager يحصل على مكافأة 5000")
    void testManagerBonus() {
        Employee manager = new Employee.Manager();
        assertEquals(5000.0, manager.calculateBonus(), 0.0001);
    }

    @Test
    @DisplayName("Developer يحصل على مكافأة 3000")
    void testDeveloperBonus() {
        Employee developer = new Employee.Developer();
        assertEquals(3000.0, developer.calculateBonus(), 0.0001);
    }

    @Test
    @DisplayName("Intern يحصل على مكافأة 1000")
    void testInternBonus() {
        Employee intern = new Employee.Intern();
        assertEquals(1000.0, intern.calculateBonus(), 0.0001);
    }

    @Test
    @DisplayName("Manager مكافأته أكبر من Developer")
    void testManagerBonusGreaterThanDeveloper() {
        Employee manager   = new Employee.Manager();
        Employee developer = new Employee.Developer();
        assertTrue(manager.calculateBonus() > developer.calculateBonus());
    }

    @Test
    @DisplayName("Developer مكافأته أكبر من Intern")
    void testDeveloperBonusGreaterThanIntern() {
        Employee developer = new Employee.Developer();
        Employee intern    = new Employee.Intern();
        assertTrue(developer.calculateBonus() > intern.calculateBonus());
    }

    @Test
    @DisplayName("كل نوع موظف instance من Employee (polymorphism)")
    void testPolymorphism_allAreEmployee() {
        Employee manager   = new Employee.Manager();
        Employee developer = new Employee.Developer();
        Employee intern    = new Employee.Intern();

        assertInstanceOf(Employee.class, manager);
        assertInstanceOf(Employee.class, developer);
        assertInstanceOf(Employee.class, intern);
    }
}
