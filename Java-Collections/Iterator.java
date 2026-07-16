/*
===============================================================================
                            ITERATOR IN JAVA
===============================================================================

Topics Covered

1. What is Iterator?
2. Why do we need Iterator?
3. hasNext()
4. next()
5. remove()

===============================================================================
                    WHAT IS AN ITERATOR?
===============================================================================

Definition

An Iterator is an object used to traverse (visit) elements of a collection
one by one.

Instead of accessing elements using indexes,

Iterator moves through the collection automatically.

Interview Definition

"Iterator is an interface used to traverse elements of a Collection
one at a time."

===============================================================================
                    WHY DO WE NEED ITERATOR?
===============================================================================

Suppose we have

ArrayList
HashSet
LinkedHashSet

ArrayList supports index

list.get(0)

But

HashSet has NO indexing.

Iterator provides one common way to traverse all collections.

===============================================================================
*/

import java.util.*;

public class IteratorDemo {

    public static void main(String[] args) {

        ArrayList<String> languages = new ArrayList<>();

        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");

        /*
        ============================================================
                        CREATING ITERATOR
        ============================================================

        iterator() returns an Iterator object.
        */

        Iterator<String> itr = languages.iterator();

        System.out.println("Using Iterator");

        /*
        hasNext()

        Checks whether another element exists.
        */

        while (itr.hasNext()) {

            /*
            next()

            Returns the next element.
            */

            String language = itr.next();

            System.out.println(language);

        }

        System.out.println();

        /*
        ============================================================
                    REMOVE USING ITERATOR
        ============================================================

        Safe way to remove elements while traversing.
        */

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {

            int num = iterator.next();

            if (num == 20) {

                /*
                remove()

                Removes current element safely.
                */

                iterator.remove();

            }

        }

        System.out.println("After Remove");

        System.out.println(numbers);

    }

}
/*
Collection

↓

iterator()

↓

Iterator Object

↓

hasNext()

↓

next() */