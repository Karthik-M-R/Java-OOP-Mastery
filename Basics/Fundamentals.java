/*
===============================================================================
                    JAVA FUNDAMENTALS (Quick Revision)
===============================================================================

This file covers:

1. Variables
2. Data Types
3. Operators
4. Control Statements
5. Methods
6. Arrays
7. Strings
8. Command-Line Arguments

These are the basic building blocks of Java and are required before learning
Object-Oriented Programming.

===============================================================================
*/

public class Fundamentals {

    /*
    ===========================================================================
                                MAIN METHOD
    ===========================================================================

    Program execution always starts from main().

    Syntax:
        public static void main(String[] args)

    public  -> JVM can access it.
    static  -> Object creation not required.
    void    -> Doesn't return anything.
    String[] args -> Stores command-line arguments.

    ===========================================================================
    */

    public static void main(String[] args) {

        System.out.println("===== JAVA FUNDAMENTALS =====\n");

        // Calling all demonstration methods
        variablesDemo();
        dataTypesDemo();
        operatorsDemo();
        controlStatementsDemo();
        methodsDemo();
        arraysDemo();
        stringsDemo();
        commandLineArgumentsDemo(args);
    }

    /*
    ===========================================================================
                                1. VARIABLES
    ===========================================================================

    Variable:
        A variable is a named memory location used to store data.

    Syntax:
        datatype variableName = value;

    Example:
        int age = 20;

    Types of Variables:
        1. Local Variable
        2. Instance Variable
        3. Static Variable

    In this file we only use Local Variables.
    */

    static void variablesDemo() {

        System.out.println("------ VARIABLES ------");

        int age = 21;
        double salary = 55000.75;
        char grade = 'A';
        boolean placed = true;
        String name = "Karthik";

        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Salary : " + salary);
        System.out.println("Grade : " + grade);
        System.out.println("Placed : " + placed);

        System.out.println();
    }

    /*
    ===========================================================================
                                2. DATA TYPES
    ===========================================================================

    Java Data Types are divided into two categories.

    1. Primitive Data Types
    2. Non-Primitive (Reference) Data Types

    Primitive Types
    Primitive data types are the absolute basic, built-in building blocks of Java. 
    They are predefined by the language,
    named by a reserved keyword (like int or char), 
    and they store the actual value directly in memory

    byte    -> 1 byte
    short   -> 2 bytes
    int     -> 4 bytes
    long    -> 8 bytes
    float   -> 4 bytes
    double  -> 8 bytes
    char    -> 2 bytes
    boolean -> true/false

    Reference Types
    Non-primitive data types are more complex structures. 
    Instead of holding the actual value directly, they store a memory address (a reference)
     pointing to where the object live in memory.

    Unlike primitives, these are created by the programmer (except for a few built-in ones like String) 
     and can hold multiple values or methods

    String
    Arrays
    Classes
    Objects
    Interfaces

    Default integer type -> int
    Default decimal type -> double

    */

    static void dataTypesDemo() {

        System.out.println("------ DATA TYPES ------");

        byte b = 120;
        short s = 32000;
        int i = 100000;
        long l = 9999999999L;

        float f = 10.5f;
        double d = 20.45678;

        char c = 'J';

        boolean flag = true;

        String course = "Java";

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(flag);
        System.out.println(course);

        System.out.println();
    }

    /*
    ===========================================================================
                                3. OPERATORS
    ===========================================================================

    Operators are symbols used to perform operations.

    Types:

    1. Arithmetic
       +  -  *  /  %

    2. Assignment
       =  +=  -=  *=

    3. Relational
       == != > < >= <=

    4. Logical
       && || !

    5. Increment / Decrement
       ++ --

    6. Ternary Operator
       condition ? true : false

    */

    static void operatorsDemo() {

        System.out.println("------ OPERATORS ------");

        int a = 20;
        int b = 6;

        // Arithmetic
        System.out.println("Addition = " + (a + b));
        System.out.println("Subtraction = " + (a - b));
        System.out.println("Multiplication = " + (a * b));
        System.out.println("Division = " + (a / b));
        System.out.println("Modulus = " + (a % b));

        // Assignment
        int x = 10;
        x += 5;
        System.out.println("Assignment += : " + x);

        // Relational
        System.out.println(a > b);
        System.out.println(a == b);

        // Logical
        System.out.println((a > b) && (b > 0));
        System.out.println((a < b) || (b > 0));

        // Increment
        int count = 5;
        count++;
        System.out.println("Increment : " + count);

        // Decrement
        count--;
        System.out.println("Decrement : " + count);

        // Ternary
        String result = (a > b) ? "a is greater" : "b is greater";
        System.out.println(result);

        System.out.println();
    }

    /*
    ===========================================================================
                            4. CONTROL STATEMENTS
    ===========================================================================

    Control Statements decide the flow of execution.

    Selection
    ---------
    if
    if-else
    else-if
    switch

    Looping
    -------
    for
    while
    do-while
    enhanced for

    Jump Statements
    ---------------
    break
    continue
    return

    */

    static void controlStatementsDemo() {

        System.out.println("------ CONTROL STATEMENTS ------");

        int marks = 82;

        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 75) {
            System.out.println("Grade B");
        } else {
            System.out.println("Grade C");
        }

        int day = 2;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            default:
                System.out.println("Invalid");
        }

        System.out.println("\nFor Loop");

        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }

        System.out.println("\n\nWhile Loop");

        int i = 1;
        while (i <= 3) {
            System.out.println(i);
            i++;
        }

        System.out.println("Do While");

        int j = 1;

        do {
            System.out.println(j);
            j++;
        } while (j <= 2);

        System.out.println("Break and Continue");

        for (int k = 1; k <= 5; k++) {

            if (k == 2)
                continue;

            if (k == 5)
                break;

            System.out.println(k);
        }

        System.out.println();
    }

    /*
    ===========================================================================
                                5. METHODS
    ===========================================================================

    Method:
        A block of reusable code.

    Syntax

        returnType methodName(parameters){

        }

    Advantages

    Code Reusability
    Easy Maintenance
    Better Readability
    Modular Programming

    */

    static void methodsDemo() {

        System.out.println("------ METHODS ------");

        greet();

        int sum = add(10, 20);

        System.out.println("Sum = " + sum);

        System.out.println();
    }

    static void greet() {
        System.out.println("Welcome to Java");
    }

    static int add(int a, int b) {
        return a + b;
    }

    /*
    ===========================================================================
                                6. ARRAYS
    ===========================================================================

    Array:
        Collection of similar data types stored in contiguous memory.

    Advantages

    Fast Random Access
    Stores multiple values

    Disadvantages

    Fixed Size
    Same Data Type Only

    */

    static void arraysDemo() {

        System.out.println("------ ARRAYS ------");

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Length = " + numbers.length);

        System.out.println("Traditional For");

        for (int i = 0; i < numbers.length; i++) {

            System.out.print(numbers[i] + " ");
        }

        System.out.println();

        System.out.println("Enhanced For");

        for (int num : numbers) {

            System.out.print(num + " ");
        }

        System.out.println("\n");
    }

    /*
    ===========================================================================
                                7. STRINGS
    ===========================================================================

    String:
        Sequence of characters.

    String is Immutable.

    Immutable means:
        Once created, its value cannot be changed.

    Common Methods

    length()
    charAt()
    toUpperCase()
    toLowerCase()
    substring()
    contains()
    equals()

    */

    static void stringsDemo() {

        System.out.println("------ STRINGS ------");

        String language = "Java Programming";

        System.out.println(language);

        System.out.println("Length = " + language.length());

        System.out.println(language.toUpperCase());

        System.out.println(language.toLowerCase());

        System.out.println(language.substring(5));

        System.out.println(language.charAt(2));

        System.out.println(language.contains("Java"));

        System.out.println(language.equals("Java Programming"));

        System.out.println();
    }

    /*
    ===========================================================================
                        8. COMMAND-LINE ARGUMENTS
    ===========================================================================

    Command-line arguments are values passed while running the program.

    Example

        javac JavaFundamentals.java

        java JavaFundamentals Karthik 21 BIT

    Output

        Argument 1 : Karthik
        Argument 2 : 21
        Argument 3 : BIT

    args[] is simply a String Array.

    */

    static void commandLineArgumentsDemo(String[] args) {

        System.out.println("------ COMMAND-LINE ARGUMENTS ------");

        if (args.length == 0) {

            System.out.println("No command-line arguments passed.");

        } else {

            System.out.println("Arguments received:");

            for (int i = 0; i < args.length; i++) {

                System.out.println("args[" + i + "] = " + args[i]);
            }
        }

        System.out.println();
    }
}


// [ You write: MyProgram.java ] 
//             │
//             ▼  (You run: javac MyProgram.java)
//    ┌─────────────────┐
//    │  Java Compiler  │ ──> Translates it
//    └─────────────────┘
//             │
//             ▼
// [ Generated: MyProgram.class ] ──> The universal machine code
//             │
//             ▼  (You run: java MyProgram)
//    ┌─────────────────┐
//    │  Your Computer  │ ──> Executes the program perfectly