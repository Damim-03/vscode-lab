# BUGGY VERSION - For reference only
# Bug: range(2, 2*n) includes n itself, so n % n == 0 makes every number return False

def is_prime(n):
    if n < 2:
        return False
    for i in range(2, 2*n):  # BUG HERE: should be range(2, n) or up to sqrt(n)
        if n % i == 0:
            return False
    return True
