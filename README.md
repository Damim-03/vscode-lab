# Refactoring Demo - Java

مشروع يوضح تقنيات Refactoring من محاضرة البرمجة.

## هيكل المشروع

```
src/
├── main/java/com/refactoring/
│   ├── Main.java
│   ├── rename/           → Rename Variables/Methods
│   ├── extract/          → Extract Method
│   ├── polymorphism/     → Replace Conditional with Polymorphism
│   ├── guardclauses/     → Simplify Conditionals with Guard Clauses
│   ├── strategy/         → Strategy Pattern
│   └── duplicate/
│       ├── inheritance/  → Eliminate Duplicate via Inheritance
│       ├── utility/      → Eliminate Duplicate via Utility Class
│       └── composition/  → Eliminate Duplicate via Composition
└── test/java/com/refactoring/
    ├── rename/           → CalculatorAfterTest
    ├── extract/          → OrderProcessorAfterTest
    ├── polymorphism/     → EmployeeTest
    ├── guardclauses/     → DiscountCalculatorTest
    ├── strategy/         → PaymentProcessorTest
    └── duplicate/
        └── composition/  → CompositionTest
```

## تشغيل المشروع

```bash
mkdir -p out
javac -d out $(find src/main -name "*.java")
java -cp out com.refactoring.Main
```

## تشغيل الـ Tests (JUnit 5)

```bash
chmod +x run-tests.sh
./run-tests.sh
```

## ملفات الـ Tests

| Test Class | ما يختبره | عدد الـ Tests |
|---|---|---|
| rename/CalculatorAfterTest | حسابات نسبة المجموع/الحاصل | 4 |
| extract/OrderProcessorAfterTest | طباعة ملخص الطلب لأنواع العملاء | 4 |
| polymorphism/EmployeeTest | مكافآت كل موظف + polymorphism | 6 |
| guardclauses/DiscountCalculatorTest | الخصومات + Before==After behavior | 6 |
| strategy/PaymentProcessorTest | كل strategy + runtime switch + exception | 5 |
| duplicate/composition/CompositionTest | CalculationService + Calculators | 8 |

المجموع: 33 test - 33 ناجح
