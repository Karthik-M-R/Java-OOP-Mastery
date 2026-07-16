/*
===============================================================================
                    COLLECTIONS FRAMEWORK IN JAVA
===============================================================================

Topics Covered

1. What is Collection Framework?
2. Why Collection Framework?
3. Collection Hierarchy
4. List
5. Set
6. Queue
7. Map

===============================================================================
                    WHAT IS COLLECTION FRAMEWORK?
===============================================================================

Definition

The Java Collections Framework (JCF) is a set of classes and interfaces
used to store, organize, and manipulate groups of objects efficiently.

Instead of creating our own data structures,

Java already provides

ArrayList

LinkedList

HashSet

HashMap

PriorityQueue

etc.

Interview Definition

"The Java Collections Framework is a collection of interfaces and classes
that provide reusable data structures and algorithms for storing and
managing groups of objects."

===============================================================================
WHY DO WE NEED COLLECTIONS?
===============================================================================

Suppose you want to store marks of 100 students.

Without Collections

int[] marks = new int[100];

Problems

• Fixed Size

• Difficult insertion/deletion

• No built-in searching/sorting

Collections solve all these problems.

===============================================================================
COLLECTION HIERARCHY
===============================================================================

                    Iterable
                        │
                  Collection
        ┌──────────┼──────────┐
        │          │          │
      List        Set       Queue

Map is NOT part of Collection interface.

It is a separate hierarchy.

===============================================================================
*/

import java.util.*;

public class CollectionsFramework {

    public static void main(String[] args) {

        /*
        ==========================================================
                            LIST
        ==========================================================

        Ordered Collection

        Allows duplicates.

        */

        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Python");
        list.add("Java");

        System.out.println("List : " + list);

        /*
        ==========================================================
                            SET
        ==========================================================

        No duplicate values.

        */

        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("Python");
        set.add("Java");

        System.out.println("Set : " + set);

        /*
        ==========================================================
                            QUEUE
        ==========================================================

        FIFO

        First In First Out

        */

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Queue : " + queue);

        System.out.println("Removed : " + queue.poll());

        System.out.println("Queue : " + queue);

        /*
        ==========================================================
                            MAP
        ==========================================================

        Stores

        Key → Value

        */

        Map<Integer,String> map = new HashMap<>();

        map.put(101,"Karthik");
        map.put(102,"Rahul");
        map.put(103,"Anjali");

        System.out.println(map);

        System.out.println(map.get(101));

    }

}

/*
Collection Framework
        │
        ├── List
        │      Ordered
        │      Duplicates Allowed
        │
        ├── Set
        │      Unique Elements
        │
        ├── Queue
        │      FIFO
        │
        └── Map
               Key → Value
 */