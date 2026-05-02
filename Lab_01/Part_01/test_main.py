from main import greet


def test_greet():
    assert greet("Alice") == "Hello, Alice!"
    assert greet("Bob") == "Hello, Bob!"


def test_greet_world():
    assert greet("World") == "Hello, World!"


def test_greet_empty():
    assert greet("") == "Hello, !"
