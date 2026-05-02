# Lab 02 — Building Java Applications Using Gradle

A complete Gradle-based Java project with `Calculator` class, JUnit 5 tests, and Apache Commons Lang integration.

## Project Structure

```
my-gradle-app/
├── build.gradle              # Gradle build configuration
├── settings.gradle           # Gradle settings
└── src/
    ├── main/java/com/example/
    │   ├── App.java          # Main entry point
    │   └── Calculator.java   # Calculator with add, multiply, subtract, divide, reverseString
    └── test/java/com/example/
        └── CalculatorTest.java   # JUnit 5 test cases
```

---

## Prerequisites

Make sure you have **Java 11 or higher** and **Gradle 7+** installed:

```bash
java -version
gradle -v
```

If Gradle is not installed:
- Download from: https://gradle.org/install/
- Or on Windows with Chocolatey: `choco install gradle`
- Or on macOS with Homebrew: `brew install gradle`

---

## Step-by-Step Guide

### Step 1: Open the project

Open the folder `my-gradle-app` in IntelliJ IDEA, VS Code, or any IDE that supports Gradle. The IDE will automatically download dependencies on first open.

Alternatively, from the terminal:
```bash
cd my-gradle-app
```

### Step 2: View dependencies

```bash
gradle dependencies
```

You'll see `commons-lang3:3.12.0` and `junit-jupiter:5.7.1`.

### Step 3: Build the project

```bash
gradle build
```

This compiles, runs tests, and packages the JAR.

### Step 4: Run the application

```bash
gradle run
```

**Expected output:**
```
Sum: 15
Product: 50
Difference: 5
Quotient: 2.0
Reversed: eldarG olleH
```

### Step 5: Run all tests

```bash
gradle test
```

You'll see 7 tests passing (2 original + 5 from the TODO part).

### Step 6: Package as a JAR

```bash
gradle jar
```

Then run it directly:
```bash
java -jar build/libs/my-gradle-app-1.0-SNAPSHOT.jar
```

> The `build.gradle` file builds a "fat JAR" that includes Apache Commons Lang inside, so the JAR runs standalone without needing the dependency on the classpath.

---

## TODO Part — What Was Added

### 1. `subtract(int a, int b)` method
Returns `a - b`.

### 2. `divide(int a, int b)` method
Returns `a / b` as a double. Throws `ArithmeticException` when dividing by zero.

### 3. `reverseString(String input)` method
Uses `StringUtils.reverse()` from Apache Commons Lang to reverse a string. Handles `null` safely.

### 4. Corresponding test cases in `CalculatorTest.java`
- `testSubtraction()`
- `testDivision()`
- `testDivisionByZeroThrowsException()` — uses `assertThrows`
- `testReverseString()`
- `testReverseNullString()`

### 5. Running a specific test case (instead of the whole suite)

Gradle supports the `--tests` flag to run a single test method or class:

```bash
# Run only the testAddition method
gradle test --tests "com.example.CalculatorTest.testAddition"

# Run only the division-related tests using a wildcard
gradle test --tests "com.example.CalculatorTest.testDivision*"

# Run all tests in a specific class
gradle test --tests "com.example.CalculatorTest"
```

You can also re-run tests even if nothing changed:
```bash
gradle test --tests "com.example.CalculatorTest.testSubtraction" --rerun-tasks
```

---

## Useful Gradle Commands

| Command | Description |
|---------|-------------|
| `gradle tasks` | List all available tasks |
| `gradle clean` | Delete the `build/` folder |
| `gradle build` | Compile, test, and package |
| `gradle compileJava` | Compile main source only |
| `gradle test` | Run all tests |
| `gradle run` | Run the main application |
| `gradle jar` | Create a JAR file |
| `gradle dependencies` | Show the dependency tree |
| `gradle --refresh-dependencies` | Force re-download dependencies |

---

## Test Results Summary

| Test | Description |
|------|-------------|
| `testAddition` | Tests `add()` with positive and negative numbers |
| `testMultiplication` | Tests `multiply()` including multiplication by zero |
| `testSubtraction` | Tests `subtract()` with various inputs |
| `testDivision` | Tests `divide()` with normal cases |
| `testDivisionByZeroThrowsException` | Verifies exception on division by zero |
| `testReverseString` | Tests `reverseString()` with normal strings |
| `testReverseNullString` | Verifies null-safety of `reverseString()` |

**Total: 7 tests, all expected to pass ✅**
