def sum_positives(numbers):
    """
    Sum all positive numbers in a list.
    
    Args:
        numbers: A list of numbers (int or float).
    
    Returns:
        The sum of positive numbers in the list. Returns 0 if list is empty.
    
    Raises:
        ValueError: If any negative number is present in the list.
        TypeError: If input is not a list or contains non-numeric values.
    """
    if not isinstance(numbers, list):
        raise TypeError("Input must be a list")

    total = 0
    for num in numbers:
        if not isinstance(num, (int, float)) or isinstance(num, bool):
            raise TypeError(f"All elements must be numbers, got {type(num).__name__}")
        if num < 0:
            raise ValueError(f"Negative number found: {num}")
        total += num
    return total


if __name__ == "__main__":
    # Some examples
    print(sum_positives([1, 2, 3, 4, 5]))     # 15
    print(sum_positives([0, 10, 20]))         # 30
    print(sum_positives([]))                  # 0
    try:
        print(sum_positives([1, -2, 3]))
    except ValueError as e:
        print(f"Error: {e}")
