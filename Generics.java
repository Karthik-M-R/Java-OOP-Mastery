/*
===============================================================================
                            GENERICS IN JAVA
===============================================================================

Topics Covered

1. What are Generics?
2. Why do we need Generics?
3. Generic Class
4. Generic Method
5. Wildcards (?, extends, super)

===============================================================================
                        WHAT ARE GENERICS?
===============================================================================

Definition

Generics allow us to create classes, methods, and interfaces that work
with different data types while maintaining type safety.

Instead of writing separate classes for Integer, String, Double, etc.,

we write ONE generic class.

Interview Definition

"Generics allow a class or method to work with different data types
while providing compile-time type safety."

===============================================================================
WHY DO WE NEED GENERICS?
===============================================================================

Without Generics

ArrayList list = new ArrayList();

list.add("Java");
list.add(100);

Both String and Integer can be stored.

This is unsafe.

With Generics

ArrayList<String> list = new ArrayList<>();

Only String objects are allowed.

Compiler catches mistakes before runtime.

===============================================================================
*/

import java.util.*;

public class GenericsDemo {

    public static void main(String[] args) {

        /*
        ============================================================
                    GENERIC CLASS
        ============================================================
        */

        Box<String> box1 = new Box<>();

        box1.setValue("Java");

        System.out.println(box1.getValue());

        Box<Integer> box2 = new Box<>();

        box2.setValue(100);

        System.out.println(box2.getValue());

        System.out.println();

        /*
        ============================================================
                    GENERIC METHOD
        ============================================================
        */

        Printer.print("Hello");

        Printer.print(500);

        Printer.print(99.99);

        System.out.println();

        /*
        ============================================================
                    WILDCARD (?)
        ============================================================
        */

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        display(numbers);

    }

    /*
    ============================================================
                WILDCARD ?
    ============================================================

    ? means

    "Any Type"

    This method accepts

    List<Integer>

    List<String>

    List<Double>

    etc.
    */

    static void display(List<?> list) {

        System.out.println(list);

    }

}

/*
===============================================================================
                    GENERIC CLASS
===============================================================================

<T>

represents a data type.

Java replaces T with

String

Integer

Double

etc.
*/

class Box<T> {

    private T value;

    public void setValue(T value) {

        this.value = value;

    }

    public T getValue() {

        return value;

    }

}

/*
===============================================================================
                    GENERIC METHOD
===============================================================================

Works with any data type.
*/

class Printer {

    public static <T> void print(T value) {

        System.out.println(value);

    }

}
/*
? extends

Means

This type or any subclass

Example

List<? extends Number>

Accepts

List<Integer>

List<Double>

List<Float>

But not

List<String>














? 
↓

Any Type

---------------------

? extends Number

↓

Number or Child

(Integer, Double...)

---------------------

? super Integer

↓

Integer or Parent

(Number, Object...) 









Generics
↓

Type Safety

↓

<T>

↓

Generic Class

↓

Generic Method

↓

Wildcards

?

↓

Any Type

------------------

? extends

↓

Child Classes

------------------

? super

↓

Parent Classes*/