/*
===============================================================================
                            ABSTRACTION IN JAVA
===============================================================================

Topics Covered
--------------
1. What is Abstraction?
2. Why do we need Abstraction?
3. Abstract Class
4. Abstract Method
5. Concrete Method
6. Partial Abstraction

===============================================================================
1. WHAT IS ABSTRACTION?
===============================================================================

Definition

Abstraction means hiding unnecessary implementation details and showing
only the essential functionality to the user.

The user knows WHAT an object does,
but not HOW it does it.

Interview Definition

"Abstraction is the process of hiding implementation details and exposing
only the required functionality to the user."

===============================================================================
REAL WORLD EXAMPLE

Think about driving a Car.

You know:

✔ Start the car
✔ Accelerate
✔ Brake

But do you know

• Fuel injection system?
• Engine timing?
• Gear mechanism?
• ECU programming?

No.

You only use the car.

The complex implementation is hidden.

This is Abstraction.

===============================================================================
*/

public class Abstraction {

    public static void main(String[] args) {

        /*
        Vehicle v = new Vehicle();

        Not Allowed.

        Abstract classes cannot be instantiated.
        */

        Vehicle car = new Car();

        car.start();      // Concrete Method

        car.drive();      // Abstract Method implemented by Car

        car.stop();       // Concrete Method
    }
}

/*
===============================================================================
                    ABSTRACT CLASS
===============================================================================

An abstract class is declared using the keyword 'abstract'.

It may contain

✔ Abstract methods
✔ Concrete methods
✔ Variables
✔ Constructors

It cannot be instantiated(In Java, instantiated simply means "created.").

Example

Vehicle v = new Vehicle();   // Error
*/

abstract class Vehicle {

    /*
    ===========================================================================
                    ABSTRACT METHOD
    ===========================================================================

    An abstract method has only a declaration.

    No implementation.

    Every child class MUST provide its own implementation.

    Syntax

    abstract void drive();
    */

    abstract void drive();

    /*
    ===========================================================================
                    CONCRETE METHOD
    ===========================================================================

    A concrete method has complete implementation.

    Child classes inherit it directly.
    */

    void start() {

        System.out.println("Vehicle Started");
    }

    void stop() {

        System.out.println("Vehicle Stopped");
    }
}

/*
===============================================================================
                    CONCRETE CLASS
===============================================================================

A normal class extending an abstract class.

It MUST implement all abstract methods.
*/

class Car extends Vehicle {

    @Override
    void drive() {

        System.out.println("Car is Driving");
    }
}

/**
 Abstract Class

An abstract class is a class declared using the abstract keyword.

Example

abstract class Animal{

}

Properties

Cannot create object
Can have constructors
Can have variables
Can have abstract methods
Can have normal methods



Abstract Method

An abstract method has

declaration
no body

Example

abstract void drive();

Child class must implement it.



Concrete Method

A concrete method has complete implementation.

Example

void start(){

    System.out.println("Started");
}

Nothing special.

Just a normal method
 
 
| Abstraction                                             | Encapsulation                                                                                     |
| ------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| Hides implementation details                            | Hides data                                                                                        |
| Focuses on **what** an object does                      | Focuses on **protecting** data                                                                    |
| Achieved using abstract classes and interfaces          | Achieved using private fields and controlled access (getters/setters)                             |
| Example: Driving a car without knowing engine internals | Example: Bank account balance is private and can only be changed through deposit/withdraw methods |


Placement Tip ⭐

Remember this sequence:

Abstract Class
        ↓
Contains Abstract Methods
        ↓
Child Class Extends It
        ↓
Implements Abstract Methods
        ↓
Achieves Abstraction


*/