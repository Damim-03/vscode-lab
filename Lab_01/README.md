# Lab 01 — Python Development with VS Code

This lab covers setting up a Python project in VS Code, writing & debugging code, and adding tests with `pytest`.

## Project Structure

```
Lab_01/
├── README.md
├── requirements.txt
├── Part_01/                    # Hello World + tests
│   ├── main.py
│   └── test_main.py
├── Part_02/
│   ├── factorial_fix/          # Buggy factorial - debug & fix
│   │   ├── factorial.py        # Fixed version
│   │   ├── factorial_buggy.py  # Original buggy version (reference)
│   │   └── test_factorial.py
│   └── prime_fix/              # Buggy prime checker - debug & fix
│       ├── prime.py            # Fixed version
│       ├── prime_buggy.py      # Original buggy version (reference)
│       └── test_prime.py
└── Part_03/                    # Sum of positive numbers + edge cases
    ├── sum_positives.py
    └── test_sum_positives.py
```

## Setup Instructions

### 1. Open the folder in VS Code
File > Open Folder > select `Lab_01`.

### 2. Install the Python extension (Microsoft) from the Extensions view (Ctrl+Shift+X).

### 3. Create and activate a virtual environment

Open the integrated terminal (Ctrl+`) and run:

```bash
python -m venv venv
```

Activate it:
- Windows: `.\venv\Scripts\activate`
- macOS / Linux: `source venv/bin/activate`

### 4. Select the Python interpreter
Press `Ctrl+Shift+P` → type `Python: Select Interpreter` → choose `./venv`.

### 5. Install dependencies

```bash
pip install -r requirements.txt
```

## Running the Code & Tests

For each part, navigate into its folder and run:

```bash
# Run the program
python main.py          # or factorial.py / prime.py / sum_positives.py

# Run the tests
pytest -v
```

You can also use VS Code's built-in **Testing** view (the flask icon in the sidebar) to discover and run tests visually.

---

## Part 01 — Hello World

A simple `greet(name)` function that returns `"Hello, {name}!"`.

**Debugging exercise:** put a breakpoint on the `return` line of `greet` in `main.py`, open the Run and Debug view (Ctrl+Shift+D), and step through the function to inspect variables.

---

## Part 02 — Debugging Buggy Functions

### 2.1 Factorial bug

**Buggy version:**
```python
return n * factorial(n - 1) + 1   # ❌ extra +1 corrupts the result
```

`factorial(5)` returns `154` instead of `120`.

**Fix:** remove the `+ 1` so the recurrence becomes `n * factorial(n - 1)`.

### 2.2 Prime checker bug

**Buggy version:**
```python
for i in range(2, 2*n):           # ❌ range includes n itself
```

Since the loop reaches `i = n`, `n % n == 0` is always true, so every input returns `False`.

**Fix:** use `range(2, n)` — or better, loop while `i*i <= n` (only check up to √n).

---

## Part 03 — Sum of Positive Numbers

`sum_positives(numbers)`:
- returns the sum of positive numbers in the list,
- returns `0` for an empty list,
- raises `ValueError` if any negative number is present,
- raises `TypeError` for invalid input (non-list, or non-numeric elements).

### Edge cases covered by the tests
- normal positive list
- list with zeros
- empty list
- single element
- floats
- negative numbers (should raise)
- all negatives (should raise)
- invalid types: string input, non-numeric elements, `None` (should raise `TypeError`)

---

## Test Summary

After running `pytest` in each part, you should see:

| Part | Tests | Status |
|------|-------|--------|
| Part 01 | 3 | ✅ pass |
| Part 02 / factorial | 3 | ✅ pass |
| Part 02 / prime | 4 | ✅ pass |
| Part 03 | 9 | ✅ pass |
| **Total** | **19** | **✅ all pass** |
