/*
===============================================================================
            HASHSET, LINKEDHASHSET & TREESET
===============================================================================

Topics Covered

1. What is Set?
2. HashSet
3. LinkedHashSet
4. TreeSet
5. Difference Between Them

===============================================================================
                            SET
===============================================================================

Definition

A Set is a collection that stores only UNIQUE elements.

Duplicate values are automatically removed.

Interview Definition

"A Set is a collection that does not allow duplicate elements."

Example

10
20
30
20

Stored as

10
20
30

Duplicate 20 is removed automatically.

===============================================================================
*/

import java.util.*;

public class SetDemo {

    public static void main(String[] args) {

        /*
        ============================================================
                        HASHSET
        ============================================================

        Stores unique elements.

        Does NOT maintain insertion order.

        */

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("Java");
        hashSet.add("Python");
        hashSet.add("C++");
        hashSet.add("Java"); // Duplicate

        System.out.println("HashSet");
        System.out.println(hashSet);

        System.out.println();

        /*
        ============================================================
                    LINKED HASHSET
        ============================================================

        Stores unique elements.

        Maintains insertion order.

        */

        LinkedHashSet<String> linkedSet = new LinkedHashSet<>();

        linkedSet.add("Java");
        linkedSet.add("Python");
        linkedSet.add("C++");
        linkedSet.add("Java");

        System.out.println("LinkedHashSet");
        System.out.println(linkedSet);

        System.out.println();

        /*
        ============================================================
                        TREESET
        ============================================================

        Stores unique elements.

        Automatically sorts them.

        */

        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(80);
        treeSet.add(20);
        treeSet.add(10);

        System.out.println("TreeSet");
        System.out.println(treeSet);

    }

}

/*
| Feature            | HashSet    | LinkedHashSet               | TreeSet             
| ------------------ | ---------- | ------------------------    | --------------      
| Duplicate Elements | ❌ No       | ❌ No                     | ❌ No              
| Insertion Order    | ❌ No       | ✅ Yes                    | ❌ No              
| Sorted Order       | ❌ No       | ❌ No                     | ✅ Yes           
| Internal Structure | Hash Table | Hash Table + Linked List | Red-Black Tree |

 
 Set
↓

Unique Elements

-------------------------

HashSet
↓

✔ Fast
✖ No Order

-------------------------

LinkedHashSet
↓

✔ Fast
✔ Maintains Insertion Order

-------------------------

TreeSet
↓

✔ Sorted
✖ Slower than HashSet
*/