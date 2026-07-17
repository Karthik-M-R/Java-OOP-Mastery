/*
===============================================================================
                            STREAM API IN JAVA
===============================================================================

Topics Covered

1. What is Stream API?
2. Why Stream API?
3. filter()
4. map()
5. sorted()
6. reduce()
7. collect()
8. forEach()

===============================================================================
                        WHAT IS STREAM API?
===============================================================================

Definition

A Stream is a sequence of elements that supports operations like
filtering, mapping, sorting, reducing, etc.

A Stream DOES NOT store data.

It processes data from Collections or Arrays.

Interview Definition

"Stream API is a feature introduced in Java 8 that allows processing
collections in a functional and declarative way."

===============================================================================
                    WHY DO WE NEED STREAM API?
===============================================================================

Without Stream

Loop

↓

if condition

↓

Create another list

↓

Sort

↓

Print

Lots of code.

With Stream

list.stream()
    .filter(...)
    .map(...)
    .sorted()
    .collect(...)

Cleaner.

Shorter.

Readable.

===============================================================================
*/

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIDemo {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 25, 8, 40, 15, 60);

        /*
        ============================================================
                            filter()
        ============================================================
        */

        System.out.println("Numbers greater than 20");

        List<Integer> filtered =
                numbers.stream()
                        .filter(num -> num > 20)
                        .collect(Collectors.toList());

        System.out.println(filtered);

        System.out.println();

        /*
        ============================================================
                            map()
        ============================================================
        */

        System.out.println("Square of each number");

        List<Integer> squares =
                numbers.stream()
                        .map(num -> num * num)
                        .collect(Collectors.toList());

        System.out.println(squares);

        System.out.println();

        /*
        ============================================================
                            sorted()
        ============================================================
        */

        System.out.println("Sorted Numbers");

        List<Integer> sorted =
                numbers.stream()
                        .sorted()
                        .collect(Collectors.toList());

        System.out.println(sorted);

        System.out.println();

        /*
        ============================================================
                            reduce()
        ============================================================
        */

        int sum =
                numbers.stream()
                        .reduce(0, (a, b) -> a + b);

        System.out.println("Sum = " + sum);

        System.out.println();

        /*
        ============================================================
                            forEach()
        ============================================================
        */

        System.out.println("Printing using forEach");

        numbers.stream()
                .forEach(num -> System.out.print(num + " "));

        System.out.println();
        System.out.println();

        /*
        ============================================================
                    COMBINING MULTIPLE OPERATIONS
        ============================================================
        */

        System.out.println("Even Numbers Squared");

        List<Integer> result =
                numbers.stream()
                        .filter(num -> num % 2 == 0)
                        .map(num -> num * num)
                        .sorted()
                        .collect(Collectors.toList());

        System.out.println(result);

    }

}