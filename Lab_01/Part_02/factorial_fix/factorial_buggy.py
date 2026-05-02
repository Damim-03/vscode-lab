# BUGGY VERSION - For reference only
# Bug: adds +1 at each recursive step, giving wrong results
# Example: factorial(5) returns 154 instead of 120

def factorial(n):
    if n == 0:
        return 1
    return n * factorial(n - 1) + 1  # BUG HERE: should not add +1
