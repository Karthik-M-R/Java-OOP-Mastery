/*
===============================================================================
                            INHERITANCE IN JAVA
===============================================================================

Topics Covered
--------------
1. What is Inheritance?
2. Why do we need Inheritance?
3. Single Inheritance
4. Multilevel Inheritance
5. Hierarchical Inheritance
6. Why Java doesn't support Multiple Inheritance (Classes)

Examples
--------
1. Animal -> Dog
2. Vehicle -> Car

===============================================================================
                    1. WHAT IS INHERITANCE?
===============================================================================

Definition

Inheritance is a mechanism in Java where one class acquires the
properties (variables) and behaviors (methods) of another class.

The existing class is called Parent (Superclass).

The new class is called Child (Subclass).

Keyword Used

extends

Interview Definition

"Inheritance is an OOP feature that allows one class to inherit the
properties and behaviors of another class, promoting code reuse and
establishing an IS-A relationship."

===============================================================================
WHY DO WE NEED INHERITANCE?
===============================================================================

Without Inheritance

class Dog {

    String name;

    void eat(){}

}

class Cat {

    String name;

    void eat(){}

}

Notice

Same code is repeated.

Instead

Animal

↓

Dog

Cat

Now common code is written only once.

Advantages

✔ Code Reusability
✔ Less Duplication
✔ Easy Maintenance
✔ Better Organization

===============================================================================
*/

public class InheritanceDemo {

    public static void main(String[] args) {

        System.out.println("========== SINGLE INHERITANCE ==========\n");

        Dog dog = new Dog();

        dog.eat();     // inherited
        dog.sleep();   // inherited
        dog.bark();    // own method

        System.out.println("\n========== MULTILEVEL INHERITANCE ==========\n");

        Puppy puppy = new Puppy();

        puppy.eat();
        puppy.bark();
        puppy.weep();

        System.out.println("\n========== HIERARCHICAL INHERITANCE ==========\n");

        Cat cat = new Cat();

        cat.eat();
        cat.meow();

        System.out.println("\n========== VEHICLE EXAMPLE ==========\n");

        Car car = new Car();

        car.start();
        car.stop();
        car.drive();

    }

}

/*
===============================================================================
                            PARENT CLASS
===============================================================================

Common properties and methods are placed here.

Every child class inherits them.
*/

class Animal {

    void eat() {

        System.out.println("Animal is Eating");
    }

    void sleep() {

        System.out.println("Animal is Sleeping");
    }

}

/*
===============================================================================
                    SINGLE INHERITANCE
===============================================================================

One Parent

↓

One Child

Animal

↓

Dog
*/

class Dog extends Animal {

    void bark() {

        System.out.println("Dog is Barking");
    }

}

/*
===============================================================================
                    MULTILEVEL INHERITANCE
===============================================================================

Animal

↓

Dog

↓

Puppy

Puppy inherits both

Dog

and

Animal
*/

class Puppy extends Dog {

    void weep() {

        System.out.println("Puppy is Weeping");
    }

}

/*
===============================================================================
                HIERARCHICAL INHERITANCE
===============================================================================

        Animal
       /      \
      /        \
    Dog        Cat

Multiple child classes inherit from one parent.
*/

class Cat extends Animal {

    void meow() {

        System.out.println("Cat says Meow");
    }

}

/*
===============================================================================
                    VEHICLE EXAMPLE
===============================================================================
*/

class Vehicle {

    void start() {

        System.out.println("Vehicle Started");
    }

    void stop() {

        System.out.println("Vehicle Stopped");
    }

}

class Car extends Vehicle {

    void drive() {

        System.out.println("Car is Driving");
    }

}


/*
Why Java Doesn't Support Multiple Inheritance (Classes)

Suppose

      Animal1
         ▲
         │
        Dog
         │
         ▼
      Animal2

Or in Java syntax:

class A{

    void show(){

        System.out.println("A");
    }

}

class B{

    void show(){

        System.out.println("B");
    }

}

// NOT ALLOWED

class C extends A,B{

}

Now,

C obj = new C();

obj.show();

Which show() should Java call?

From

A

or

B

Java cannot decide.

This ambiguity is called the Diamond Problem.

Therefore,

Java does not allow

extends A,B
Diamond Problem Diagram
        A
      /   \
     B     C
      \   /
        D

If both B and C override the same method from A, then D inherits from both. 
Which version should D use? This ambiguity is the diamond problem


How Java Solves It

Java does not support multiple inheritance with classes.

Instead,

Java supports multiple inheritance through interfaces because interfaces provide a clear contract,
 and if there is a conflict, the implementing class must resolve it explicitly.*/