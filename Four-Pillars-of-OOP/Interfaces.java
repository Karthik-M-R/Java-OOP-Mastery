/*
===============================================================================
                            INTERFACES IN JAVA
===============================================================================

Topics Covered
--------------
1. What is an Interface?
2. Why do we need Interfaces?
3. Implementing an Interface
4. Multiple Interface Implementation
5. Default Methods (Java 8)
6. Static Methods (Java 8)
7. Functional Interface (Preview)

===============================================================================
1. WHAT IS AN INTERFACE?
===============================================================================

Definition

An Interface is a blueprint that defines WHAT a class should do,
but not HOW it should do it.

A class implements an interface and provides the implementation
of its methods.

Keyword

interface

implements

Interview Definition

"An interface is a contract that specifies a set of methods which
a class must implement."

===============================================================================
REAL WORLD EXAMPLE

Imagine a Mobile Charger Socket.

The socket says:

✔ Supply electricity

It does NOT care

Samsung Charger
Apple Charger
OnePlus Charger

All chargers follow the same socket standard.

Socket = Interface

Chargers = Classes

===============================================================================
*/

public class InterfacesDemo {

    public static void main(String[] args) {

        Car car = new Car();

        car.start();

        car.stop();

        Vehicle.showRules();

        System.out.println();

        Duck duck = new Duck();

        duck.walk();

        duck.swim();

        System.out.println();

        Calculator calculator = new Calculator();

        System.out.println("Addition : " + calculator.add(10,20));

    }

}

/*
===============================================================================
                    SIMPLE INTERFACE
===============================================================================
*/

interface Vehicle{

    /*
    Interface methods are public and abstract by default.

    So these two are same

    void start();

    public abstract void start();
    */

    void start();

    void stop();

    /*
    ===========================================================================
                        DEFAULT METHOD
    ===========================================================================

    A default method has implementation.

    Classes may use it directly or override it.
    */

    default void fuelType(){

        System.out.println("Fuel Type : Petrol");

    }

    /*
    ===========================================================================
                        STATIC METHOD
    ===========================================================================

    Belongs to interface itself.

    Called using InterfaceName.method().
    */

    static void showRules(){

        System.out.println("Follow Traffic Rules");

    }

}

/*
===============================================================================
                    IMPLEMENTING INTERFACE
===============================================================================

Keyword

implements

The class MUST implement every abstract method.
*/

class Car implements Vehicle{

    @Override

    public void start(){

        System.out.println("Car Started");

    }

    @Override

    public void stop(){

        System.out.println("Car Stopped");

    }

}

/*
===============================================================================
            MULTIPLE INTERFACE IMPLEMENTATION
===============================================================================

Unlike classes,

Java allows implementing multiple interfaces.

*/

interface Walk{

    void walk();

}

interface Swim{

    void swim();

}

class Duck implements Walk,Swim{

    @Override

    public void walk(){

        System.out.println("Duck Walking");

    }

    @Override

    public void swim(){

        System.out.println("Duck Swimming");

    }

}

/*
===============================================================================
                FUNCTIONAL INTERFACE
===============================================================================

Contains ONLY ONE abstract method.

Used mainly with Lambda Expressions.
*/

@FunctionalInterface

interface Calculator{

    int add(int a,int b);

}
/*
In Java, @FunctionalInterface is a special annotation introduced in Java 8. 
It tells the compiler that this specific interface is meant to have exactly one abstract method.

Think of it as a safety guardrail.
 By adding that annotation, you are locked into a strict contract that unlocks
  one of Java's coolest modern features: Lambda Expressions.
 */

/*--------------------------------------------------------------------------------------------------------------------- */
/*
How Interfaces Solve the Problem
Java allows you to implement multiple interfaces simultaneously.
 Interfaces solve the diamond problem beautifully in two different eras of Java:

1. The Traditional Way (Before Java 8): No Method Bodies
Traditionally, interfaces could only contain abstract methods 
(methods without any implementation logic inside them).

If interface B and interface C both declare void show();,
 they aren't providing any actual code. They are just throwing out a rule saying:
  "Whoever implements me must build a show method."

Java
interface B { void show(); }
interface C { void show(); }

// Class D implements both interfaces
class D implements B, C {
    // Class D provides the ONE and ONLY concrete implementation
    public void show() {
        System.out.println("D's custom implementation!");
    }
}
When you call d.show();, there is absolutely zero ambiguity.
 The compiler doesn't have to choose between B or C because neither B nor C had any executable code. Class D provides the only logic that actually exists.

2. The Modern Way (Java 8+): The default Method Tie-Breaker
Java 8 introduced default methods, which allow interfaces
 to house actual code inside a method body. Suddenly, the diamond problem threat returned!

If Interface B and Interface C both provide a default void show()
 with distinct code blocks, and Class D implements both, a collision occurs.

Java handles this with a strict rule: The Compiler Forces a Tie-Breaker.

Java
interface B {
    default void show() { System.out.println("Interface B"); }
}

interface C {
    default void show() { System.out.println("Interface C"); }
}

// If you just write 'implements B, C' without overriding, it will fail to compile!
class D implements B, C {
    
    // Java FORCES you to override the colliding method to clear up the confusion
    @Override
    public void show() {
        // Option A: Write completely custom code for D
        System.out.println("Class D's custom logic");
        
        // Option B: Explicitly pick one parent interface using 'super'
        // B.super.show(); 
    }
} 



====================================================================================================================================================

| Interface                                                                          | Abstract Class                                     |
| ---------------------------------------------------------------------------------- | -------------------------------------------------- |
| Uses `interface` keyword                                                           | Uses `abstract class`                              |
| Class uses `implements`                                                            | Child uses `extends`                               |
| Supports multiple interface implementation                                         | Class can extend only one class                    |
| Represents a contract (capability)                                                 | Represents a base class with shared state/behavior |
| No constructors                                                                    | Can have constructors                              |
| Cannot have instance variables (only constants)                                    | Can have instance variables                        |
| Methods can be abstract, default, static (and private helper methods since Java 9) | Can have abstract and concrete methods             |
*/