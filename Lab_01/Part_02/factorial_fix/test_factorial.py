import pytest
from factorial import factorial


def test_factorial():
    assert factorial(0) == 1
    assert factorial(1) == 1
    assert factorial(5) == 120


def test_factorial_larger():
    assert factorial(6) == 720
    assert factorial(7) == 5040
    assert factorial(10) == 3628800


def test_factorial_negative():
    with pytest.raises(ValueError):
        factorial(-1)
