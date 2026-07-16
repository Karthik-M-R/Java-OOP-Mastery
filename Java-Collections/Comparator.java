/*
"Difference between Comparable and Comparator?"

The trick is to understand when to use each.

Comparable → One default sorting rule.
Comparator → Multiple custom sorting rules */

/*
===============================================================================
                        COMPARATOR IN JAVA
===============================================================================

Topics Covered

1. What is Comparator?
2. Why Comparator?
3. compare()
4. Sort by ID
5. Sort by Name

===============================================================================
                    WHAT IS COMPARATOR?
===============================================================================

Definition

Comparator is an interface used to define custom sorting.

Unlike Comparable,

Comparator allows us to create multiple sorting rules
without modifying the original class.

Interview Definition

"Comparator is an interface used to define custom sorting order
by implementing compare()."

===============================================================================
WHY DO WE NEED COMPARATOR?
===============================================================================

Suppose Student has

ID
Name

Today

Sort by ID

Tomorrow

Sort by Name

Next Week

Sort by Marks

Comparable can have ONLY ONE default sorting rule.

Comparator allows MULTIPLE sorting rules.

===============================================================================
*/

import java.util.*;

public class ComparatorDemo {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(103, "Rahul"));
        students.add(new Student(101, "Karthik"));
        students.add(new Student(102, "Anjali"));

        /*
        ===============================================================
                        SORT BY ID
        ===============================================================
        */

        Collections.sort(students, new SortById());

        System.out.println("Sort By ID");

        System.out.println(students);

        System.out.println();

        /*
        ===============================================================
                        SORT BY NAME
        ===============================================================
        */

        Collections.sort(students, new SortByName());

        System.out.println("Sort By Name");

        System.out.println(students);

    }

}

/*
===============================================================================
                    STUDENT CLASS
===============================================================================
*/

class Student {

    int id;
    String name;

    Student(int id, String name) {

        this.id = id;
        this.name = name;

    }

    @Override
    public String toString() {

        return id + " " + name;

    }

}

/*
===============================================================================
                    SORT BY ID
===============================================================================

Comparator<Student>

compare()

returns

Negative -> First object comes first

Positive -> Second object comes first

Zero -> Both are equal

*/

class SortById implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        return Integer.compare(s1.id, s2.id);

    }

}

/*
===============================================================================
                    SORT BY NAME
===============================================================================
*/

class SortByName implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        return s1.name.compareTo(s2.name);

    }

}
/*
| Comparable                  | Comparator                           |
| --------------------------- | ------------------------------------ |
| Interface                   | Interface                            |
| Package: `java.lang`        | Package: `java.util`                 |
| Method: `compareTo()`       | Method: `compare()`                  |
| One default sorting rule    | Multiple custom sorting rules        |
| Class implements Comparable | Separate class implements Comparator |
| Used for natural ordering   | Used for custom ordering             |

Comparable
↓

One Default Sorting

↓

compareTo()

↓

Student implements Comparable

--------------------------------

Comparator
↓

Multiple Custom Sorting

↓

compare()

↓

Separate Comparator Class

--------------------------------

Comparable

↓

java.lang

Comparator

↓

java.util




Comparable
↓

Compare "Myself"

(Default sorting)

-------------------------

Comparator
↓

Compare "Others"

(Custom sorting) */