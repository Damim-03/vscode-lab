package com.refactoring.duplicate.inheritance;

/**
 * BEFORE - كود مكرر في Dog و Cat
 */
class DogBefore {
    public void eat()   { System.out.println("Dog is eating"); }
    public void sleep() { System.out.println("Dog is sleeping"); }
}

class CatBefore {
    public void eat()   { System.out.println("Cat is eating"); }
    public void sleep() { System.out.println("Cat is sleeping"); }
}

// -------------------------------------------------------

/**
 * AFTER - نقل الكود المشترك إلى Base Class
 */
abstract class Animal {
    public void eat()   { System.out.println(getClass().getSimpleName() + " is eating"); }
    public void sleep() { System.out.println(getClass().getSimpleName() + " is sleeping"); }
}

class Dog extends Animal {}
class Cat extends Animal {}
