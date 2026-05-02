def factorial(n):
    """
    Calculate the factorial of a non-negative integer n.
    
    Bug fix: The original buggy version had `return n * factorial(n - 1) + 1`
    which incorrectly added 1 at each recursive step.
    The correct formula is: n! = n * (n-1)!
    """
    if n < 0:
        raise ValueError("Factorial is not defined for negative numbers")
    if n == 0:
        return 1
    return n * factorial(n - 1)


if __name__ == "__main__":
    for i in range(6):
        print(f"{i}! = {factorial(i)}")
