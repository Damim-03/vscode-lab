import pytest
from sum_positives import sum_positives


def test_normal_case():
    assert sum_positives([1, 2, 3, 4, 5]) == 15


def test_with_zero():
    assert sum_positives([0, 10, 20]) == 30
    assert sum_positives([0, 0, 0]) == 0


def test_empty_list():
    assert sum_positives([]) == 0


def test_single_element():
    assert sum_positives([42]) == 42
    assert sum_positives([0]) == 0


def test_floats():
    assert sum_positives([1.5, 2.5, 3.0]) == 7.0


def test_negative_raises_exception():
    with pytest.raises(ValueError):
        sum_positives([1, -2, 3])


def test_all_negatives_raises_exception():
    with pytest.raises(ValueError):
        sum_positives([-1, -2, -3])


def test_single_negative_raises_exception():
    with pytest.raises(ValueError):
        sum_positives([-5])


def test_invalid_type_raises_exception():
    with pytest.raises(TypeError):
        sum_positives("not a list")
    with pytest.raises(TypeError):
        sum_positives([1, 2, "three"])
    with pytest.raises(TypeError):
        sum_positives([1, 2, None])
