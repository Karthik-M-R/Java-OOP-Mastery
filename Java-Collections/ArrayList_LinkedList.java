/*
===============================================================================
                ARRAYLIST & LINKEDLIST IN JAVA
===============================================================================

Topics Covered

1. What is ArrayList?
2. What is LinkedList?
3. ArrayList Methods
4. LinkedList Methods
5. Difference between ArrayList & LinkedList

===============================================================================
                        ARRAYLIST
===============================================================================

Definition

ArrayList is a dynamic array provided by Java.

Unlike normal arrays,

its size can increase or decrease automatically.

Interview Definition

"ArrayList is a resizable array implementation of the List interface
that maintains insertion order and allows duplicate elements."

Real World Example

Imagine a classroom.

Students sit on benches continuously.

Seat Numbers

0
1
2
3
4

Easy to directly access any student.

Need Roll No 3?

Go directly to seat 3.

Very Fast.

But,

if a new student joins at Seat 2,

everyone after Seat 2 must shift one seat.

Insertion becomes slower.

===============================================================================
*/

import java.util.*;

public class ArrayListLinkedList {

    public static void main(String[] args) {

        /*
        ===============================================================
                        ARRAYLIST
        ===============================================================
        */

        ArrayList<String> students = new ArrayList<>();

        /*
        add()

        Adds element at the end.
        */

        students.add("Karthik");
        students.add("Rahul");
        students.add("Anjali");

        System.out.println("ArrayList : " + students);

        /*
        get()

        Access element using index.
        */

        System.out.println("First Student : " + students.get(0));

        /*
        set()

        Replace existing element.
        */

        students.set(1, "Rohit");

        System.out.println(students);

        /*
        remove()

        Removes element.
        */

        students.remove(2);

        System.out.println(students);

        /*
        size()

        Returns total elements.
        */

        System.out.println("Size : " + students.size());

        System.out.println();


        /*
        ===============================================================
                        LINKEDLIST
        ===============================================================
        */

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Bangalore");
        cities.add("Mysore");
        cities.add("Mangalore");

        System.out.println("LinkedList : " + cities);

        /*
        addFirst()

        Insert at beginning.
        */

        cities.addFirst("Hubli");

        /*
        addLast()

        Insert at end.
        */

        cities.addLast("Belgaum");

        System.out.println(cities);

        /*
        removeFirst()

        Removes first node.
        */

        cities.removeFirst();

        /*
        removeLast()

        Removes last node.
        */

        cities.removeLast();

        System.out.println(cities);

    }

}
/**
 ArrayList
↓

Dynamic Array

✔ Fast get()

✖ Slow insert/delete in middle

----------------------------

LinkedList
↓

Nodes Connected by Links

✔ Fast insert/delete (after reaching position)

✖ Slow get()

Easy Way to Remember
ArrayList = Like an array with automatic resizing
LinkedList = Like a chain of connected nodes
ArrayList → Better for reading/access
LinkedList → Better for frequent structural modifications
 */