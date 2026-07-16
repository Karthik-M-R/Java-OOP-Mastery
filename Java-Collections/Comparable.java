/*
===============================================================================
                        COMPARABLE IN JAVA
===============================================================================

Topics Covered

1. What is Comparable?
2. Why Comparable?
3. compareTo()
4. Natural Sorting
5. Collections.sort()

===============================================================================
                    WHAT IS COMPARABLE?
===============================================================================

Definition

Comparable is an interface used to define the natural (default)
sorting order of objects.

For primitive types like Integer and String,

Java already knows how to sort them.

Example

10 30 20

↓

10 20 30

But for our own class like Student,

Java does NOT know how to sort.

Should it sort by

• id?

• name?

• marks?

We must tell Java.

Comparable helps us do that.

Interview Definition

"Comparable is an interface used to define the natural ordering of
objects by implementing compareTo()."

===============================================================================
*/

import java.util.*;

public class ComparableDemo {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(103, "Rahul"));
        students.add(new Student(101, "Karthik"));
        students.add(new Student(102, "Anjali"));

        System.out.println("Before Sorting");

        System.out.println(students);

        /*
        Collections.sort()

        Uses compareTo() automatically.
        */

        Collections.sort(students);

        System.out.println();

        System.out.println("After Sorting");

        System.out.println(students);

    }

}

/*
===============================================================================
                    STUDENT CLASS
===============================================================================

Comparable<Student>

means

Student objects can now be compared.
*/

class Student implements Comparable<Student> {

    int id;
    String name;

    Student(int id, String name) {

        this.id = id;
        this.name = name;

    }

    /*
    ============================================================
                    compareTo()
    ============================================================

    compareTo()

    decides how objects should be sorted.

    Here,

    we sort using Student ID.

    */

    @Override
    public int compareTo(Student other) {

        /*
        Ascending Order

        Small ID comes first.
        */

        return this.id - other.id;

    }

    /*
    toString()

    Makes output readable.
    */

    @Override
    public String toString() {

        return id + " " + name;

    }

}
/*
| Return Value | Meaning                    |
| ------------ | -------------------------- |
| Negative     | Current object comes first |
| Zero         | Objects are equal          |
| Positive     | Current object comes later |


Which method calls compareTo()?
Collections.sort()

Comparable
↓

Natural(Default) Sorting

↓

Implements

Comparable<Student>

↓

Override

compareTo()

↓

Collections.sort()

↓

Objects Sorted */