from prime import is_prime


def test_is_prime():
    assert is_prime(2) == True
    assert is_prime(3) == True
    assert is_prime(4) == False
    assert is_prime(29) == True


def test_small_numbers():
    assert is_prime(0) == False
    assert is_prime(1) == False
    assert is_prime(-5) == False


def test_more_primes():
    assert is_prime(5) == True
    assert is_prime(7) == True
    assert is_prime(11) == True
    assert is_prime(13) == True
    assert is_prime(97) == True


def test_more_composites():
    assert is_prime(9) == False
    assert is_prime(15) == False
    assert is_prime(100) == False
    assert is_prime(91) == False  # 7 * 13
