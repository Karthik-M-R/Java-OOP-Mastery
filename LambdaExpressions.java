/*
===============================================================================
                    LAMBDA EXPRESSIONS IN JAVA
===============================================================================

Topics Covered

1. What is Lambda Expression?
2. Why do we need Lambda?
3. Syntax
4. Functional Interface
5. Lambda Examples

===============================================================================
                    WHAT IS LAMBDA EXPRESSION?
===============================================================================

Definition

A Lambda Expression is a short way of writing the implementation of a
method for a Functional Interface.

Instead of creating a separate class,

we directly write the method implementation.

Interview Definition

"A Lambda Expression is an anonymous function used to provide the
implementation of a Functional Interface."

===============================================================================
                    WHY DO WE NEED LAMBDA?
===============================================================================

Without Lambda

Create Interface

↓

Create Class

↓

Implement Method

↓

Create Object

↓

Call Method

Lots of code.

With Lambda

Just write

(parameters) -> { code }

Simple and short.

===============================================================================
*/

public class LambdaDemo {

    public static void main(String[] args) {

        /*
        ============================================================
                    NORMAL WAY
        ============================================================

        Creating object of implementation class.
        */

        Addition normal = new AdditionImpl();

        System.out.println("Normal Method");

        normal.add(10, 20);

        System.out.println();

        /*
        ============================================================
                    LAMBDA EXPRESSION
        ============================================================

        No separate class required.

        Java automatically creates the object.
        */

        Addition lambda = (a, b) -> {

            System.out.println("Lambda Method");

            System.out.println("Sum = " + (a + b));

        };

        lambda.add(30, 40);

        System.out.println();

        /*
        ============================================================
                    ANOTHER EXAMPLE
        ============================================================
        */

        Greeting greet = () -> {

            System.out.println("Welcome to Java 8!");

        };

        greet.sayHello();

    }

}

/*
===============================================================================
                FUNCTIONAL INTERFACE
===============================================================================

A Functional Interface contains ONLY ONE abstract method.

Lambda Expressions work ONLY with Functional Interfaces.
*/

@FunctionalInterface

interface Addition {

    void add(int a, int b);

}

/*
===============================================================================
            NORMAL IMPLEMENTATION CLASS
===============================================================================
*/

class AdditionImpl implements Addition {

    @Override
    public void add(int a, int b) {

        System.out.println("Sum = " + (a + b));

    }

}

/*
===============================================================================
            ANOTHER FUNCTIONAL INTERFACE
===============================================================================
*/

@FunctionalInterface

interface Greeting {

    void sayHello();

}

/*
Lambda Expression
↓

Anonymous Function

↓

Works with

Functional Interface

↓

Syntax

(parameters) -> { code }

↓

Reduces Boilerplate Code

↓

Introduced in Java 8 */