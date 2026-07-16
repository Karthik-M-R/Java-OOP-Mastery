/*
===============================================================================
                HASHMAP, LINKEDHASHMAP & TREEMAP
===============================================================================

Topics Covered

1. What is Map?
2. HashMap
3. LinkedHashMap
4. TreeMap
5. Difference Between Them

===============================================================================
                            MAP
===============================================================================

Definition

A Map stores data in the form of

Key -> Value

Unlike List,

elements are accessed using a KEY instead of an index.

Example

101 -> Karthik
102 -> Rahul
103 -> Anjali

Interview Definition

"A Map is a collection that stores data as Key-Value pairs where
each key is unique."

===============================================================================
*/

import java.util.*;

public class MapDemo {

    public static void main(String[] args) {

        /*
        ============================================================
                        HASHMAP
        ============================================================

        Stores Key -> Value pairs.

        Keys must be unique.

        Values can be duplicated.

        Does NOT maintain insertion order.
        */

        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(101, "Karthik");
        hashMap.put(102, "Rahul");
        hashMap.put(103, "Anjali");

        System.out.println("HashMap");
        System.out.println(hashMap);

        /*
        get()

        Get value using key.
        */

        System.out.println(hashMap.get(101));

        /*
        remove()

        Remove by key.
        */

        hashMap.remove(102);

        System.out.println(hashMap);

        System.out.println();

        /*
        ============================================================
                    LINKEDHASHMAP
        ============================================================

        Maintains insertion order.
        */

        LinkedHashMap<Integer, String> linkedMap =
                new LinkedHashMap<>();

        linkedMap.put(1, "Java");
        linkedMap.put(2, "Python");
        linkedMap.put(3, "C++");

        System.out.println("LinkedHashMap");
        System.out.println(linkedMap);

        System.out.println();

        /*
        ============================================================
                        TREEMAP
        ============================================================

        Automatically sorts keys.
        */

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(30, "Java");
        treeMap.put(10, "Python");
        treeMap.put(20, "C++");

        System.out.println("TreeMap");
        System.out.println(treeMap);

    }

}

/*
HashMap
↓

Fast Search

No Order

--------------------

LinkedHashMap
↓

Fast Search

Insertion Order

--------------------

TreeMap
↓

Sorted Keys

O(log n)
 */