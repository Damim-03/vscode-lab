# Refactoring Demo - Java

مشروع يوضح تقنيات Refactoring من محاضرة البرمجة.

## هيكل المشروع

```
src/main/java/com/refactoring/
├── rename/           → Rename Variables/Methods
├── extract/          → Extract Method
├── polymorphism/     → Replace Conditional with Polymorphism
├── guardclauses/     → Simplify Conditionals with Guard Clauses
├── strategy/         → Strategy Pattern
└── duplicate/
    ├── inheritance/  → Eliminate Duplicate via Inheritance
    ├── utility/      → Eliminate Duplicate via Utility Class
    └── composition/  → Eliminate Duplicate via Composition
```

## تشغيل المشروع

```bash
javac -d out $(find src -name "*.java")
java -cp out com.refactoring.Main
```
