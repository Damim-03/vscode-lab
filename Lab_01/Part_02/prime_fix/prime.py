def is_prime(n):
    """
    Check if n is a prime number.
    
    Bug fix: The original had `range(2, 2*n)` which always includes n itself,
    so n % n == 0 making every number return False.
    The correct range is from 2 up to sqrt(n) (inclusive), or up to n
    (exclusive) for a simpler version.
    """
    if n < 2:
        return False
    # We only need to check divisors up to sqrt(n)
    i = 2
    while i * i <= n:
        if n % i == 0:
            return False
        i += 1
    return True


if __name__ == "__main__":
    for n in range(1, 20):
        print(f"{n}: {'prime' if is_prime(n) else 'not prime'}")
