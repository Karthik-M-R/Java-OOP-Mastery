/*
===============================================================================
                            ENUM IN JAVA
===============================================================================

Topics Covered
--------------

1. What is an Enum?
2. Why do we need Enum?
3. Enum Constants
4. Enum Methods
5. Switch with Enum

===============================================================================
                    WHAT IS AN ENUM?
===============================================================================

Definition

An Enum (Enumeration) is a special type in Java used to represent
a fixed set of constants.

For example,

Days of Week

MONDAY
TUESDAY
WEDNESDAY
...

The days never change.

Instead of storing them as Strings,

we use Enum.

Interview Definition

"An Enum is a special Java type used to represent a fixed collection
of constants."

===============================================================================
                    WHY DO WE NEED ENUM?
===============================================================================

Without Enum

String day = "Monday";

Problem

day = "Mondy";     // Typing mistake

Compiler won't detect this.

With Enum

Day day = Day.MONDAY;

Only valid constants are allowed.

This makes the program safer.

===============================================================================
*/

public class EnumDemo {

    public static void main(String[] args) {

        /*
        Creating Enum variable
        */

        Day today = Day.MONDAY;

        System.out.println("Today : " + today);

        System.out.println();

        /*
        ============================================================
                        ENUM METHODS
        ============================================================
        */

        System.out.println("Ordinal : " + today.ordinal());

        System.out.println("Name : " + today.name());

        System.out.println();

        /*
        Print all Enum constants
        */

        System.out.println("All Days");

        for (Day d : Day.values()) {

            System.out.println(d);

        }

        System.out.println();

        /*
        ============================================================
                    SWITCH WITH ENUM
        ============================================================
        */

        switch (today) {

            case MONDAY:
                System.out.println("Start of Week");
                break;

            case FRIDAY:
                System.out.println("Weekend is Near");
                break;

            case SUNDAY:
                System.out.println("Holiday");
                break;

            default:
                System.out.println("Normal Working Day");

        }

    }

}

/*
===============================================================================
                        ENUM DECLARATION
===============================================================================

Enum constants are written in UPPERCASE by convention.
*/

enum Day {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY

}