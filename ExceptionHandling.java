/*
===============================================================================
                    EXCEPTION HANDLING IN JAVA
===============================================================================

Topics Covered
--------------

1. What is Exception?
2. Why Exception Handling?
3. Exception Hierarchy
4. try Block
5. catch Block
6. finally Block

Remaining Topics (Part 2)

7. throw
8. throws
9. Checked Exceptions
10. Unchecked Exceptions
11. Multiple catch blocks
12. Custom Exception
13. Interview Questions

===============================================================================
                    WHAT IS AN EXCEPTION?
===============================================================================

Definition

An Exception is an unexpected event that occurs during the execution of
a program and interrupts the normal flow of execution.

Examples

• Dividing by zero
• Accessing an invalid array index
• Reading a file that doesn't exist
• Accessing a null object

Interview Definition

"An exception is an abnormal event that occurs during program execution
and disrupts the normal flow of the program."

===============================================================================
                    WHY DO WE NEED EXCEPTION HANDLING?
===============================================================================

Imagine an ATM.

Normal Flow

Insert Card
      ↓
Enter PIN
      ↓
Withdraw Money
      ↓
Take Cash

Suppose

• Wrong PIN
• No Cash
• Server Down

Should ATM stop working?

NO.

It should display an error message and continue working.

Java Exception Handling works exactly like this.

Instead of crashing,

it handles the problem gracefully.

===============================================================================
                    WITHOUT EXCEPTION HANDLING
===============================================================================

Example

int a = 10;
int b = 0;

System.out.println(a / b);

Output

Exception in thread "main"

ArithmeticException

Program Terminates.

===============================================================================
                    WITH EXCEPTION HANDLING
===============================================================================

try{

    System.out.println(a/b);

}

catch(Exception e){

    System.out.println("Cannot divide by zero.");

}

Program continues normally.

===============================================================================
                    EXCEPTION HIERARCHY
===============================================================================

Everything starts from Object class.

Object
   |
Throwable
   |
-------------------------
|                       |
Error               Exception
                        |
             ----------------------
             |                    |
     Checked Exception    Unchecked Exception

Throwable

Parent class of every Exception and Error.

Error

Serious problems.

Usually cannot be recovered.

Examples

OutOfMemoryError

StackOverflowError

Exception

Problems that can usually be handled.

Examples

IOException

ArithmeticException

===============================================================================
*/

public class ExceptionHandling {

    public static void main(String[] args) {

        System.out.println("========= TRY - CATCH =========\n");

        divideNumbers();

        System.out.println("\nProgram Continues...\n");

        System.out.println("========= FINALLY =========\n");

        finallyExample();
    }

    /*
    ===========================================================================
                                TRY BLOCK
    ===========================================================================

    try block contains code that may generate an exception.

    If an exception occurs,

    Java immediately stops executing the remaining statements inside try
    and jumps to the matching catch block.

    Syntax

    try{

        risky code

    }

    */

    static void divideNumbers() {

        int a = 20;
        int b = 0;

        try {

            /*
            This statement throws ArithmeticException because
            division by zero is not allowed.
            */

            int result = a / b;

            /*
            This line never executes because exception occurs above.
            */

            System.out.println(result);

        }

        /*
        ===========================================================================
                                CATCH BLOCK
        ===========================================================================

        catch block handles the exception.

        Instead of terminating the program,

        it prints a meaningful message.

        */

        catch (ArithmeticException e) {

            System.out.println("Exception Caught.");

            System.out.println("Reason : Division by Zero.");

            /*
            e.getMessage()

            Returns the actual exception message.
            */

            System.out.println("Message : " + e.getMessage());

        }

    }

    /*
    ===========================================================================
                                FINALLY BLOCK
    ===========================================================================

    finally block executes whether exception occurs or not.

    Mainly used for

    • Closing files

    • Closing database connections

    • Closing network connections

    • Releasing resources

    Syntax

    try{

    }

    catch(){

    }

    finally{

    }

    */

    static void finallyExample() {

        try {

            System.out.println("Inside Try Block");

            int x = 10;

            int y = 2;

            System.out.println("Result = " + (x / y));

        }

        catch (ArithmeticException e) {

            System.out.println("Exception Occurred");

        }

        finally {

            /*
            Always executes.

            Whether exception occurs or not.

            */

            System.out.println("Finally Block Executed.");

            System.out.println("Resources Released.");

        }

    }

}



/*
===============================================================================
                        PART 2
===============================================================================

Topics Covered

7. throw Keyword
8. throws Keyword
9. Checked Exceptions
10. Unchecked Exceptions
11. Multiple Catch Blocks

===============================================================================
                            throw KEYWORD
===============================================================================

Definition

The 'throw' keyword is used to manually create and throw an exception.

Normally,

Java throws exceptions automatically.

Example

10 / 0

↓

ArithmeticException

Sometimes we want to throw an exception ourselves.

Example

Age must be 18 or above.

If age is less than 18,

we throw an exception manually.

Syntax

throw new ExceptionType("Message");

===============================================================================
*/

class ThrowExample {

    static void checkAge(int age) {

        /*
        If age is less than 18,
        manually throw an exception.
        */

        if (age < 18) {

            throw new ArithmeticException("Age must be 18 or above.");

        }

        System.out.println("Eligible to Vote.");
    }

}

/*
===============================================================================
                        throws KEYWORD
===============================================================================

Definition

The throws keyword is used in a method declaration.

It tells the caller that

"This method may throw an exception."

The method itself does NOT handle the exception.

Instead,

it passes the responsibility to the calling method.

Syntax

returnType methodName() throws ExceptionName{

}

===============================================================================
*/

class ThrowsExample {

    /*
    FileNotFoundException is a Checked Exception.

    Therefore,

    compiler forces us to either

    1. Handle it

    OR

    2. Declare it using throws
    */

    static void readFile() throws java.io.FileNotFoundException {

        java.io.FileReader file =
                new java.io.FileReader("abc.txt");

    }

}

/*
===============================================================================
                    CHECKED EXCEPTIONS
===============================================================================

Definition

Checked Exceptions are checked by the compiler.

Compiler forces programmer to

either

handle them

or

declare them using throws.

Examples

IOException

SQLException

FileNotFoundException

===============================================================================
*/

class CheckedExceptionExample {

    static void demo() {

        try {

            /*
            File does not exist.

            This generates FileNotFoundException.

            */

            java.io.FileReader file =
                    new java.io.FileReader("sample.txt");

        }

        catch (java.io.FileNotFoundException e) {

            System.out.println("File Not Found.");

        }

    }

}

/*
===============================================================================
                    UNCHECKED EXCEPTIONS
===============================================================================

Definition

Unchecked Exceptions occur during Runtime.

Compiler does NOT force us to handle them.

Examples

ArithmeticException

NullPointerException

ArrayIndexOutOfBoundsException

===============================================================================
*/

class UncheckedExceptionExample {

    static void demo() {

        int a = 10;

        int b = 0;

        /*
        ArithmeticException

        Compiler allows this.

        Exception occurs only during execution.
        */

        try {

            System.out.println(a / b);

        }

        catch (ArithmeticException e) {

            System.out.println("Cannot Divide By Zero.");

        }

    }

}

/*
===============================================================================
                    MULTIPLE CATCH BLOCKS
===============================================================================

One try block can have multiple catch blocks.

Each catch handles a different exception.

Always write

Specific Exception

↓

General Exception

Otherwise,

Compiler gives an error.

===============================================================================
*/

class MultipleCatchExample {

    static void demo() {

        try {

            int arr[] = {10,20,30};

            /*
            Uncomment one statement at a time
            to test different exceptions.
            */

            // System.out.println(arr[5]);

            int x = 10 / 0;

        }

        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Invalid Array Index.");

        }

        catch (ArithmeticException e) {

            System.out.println("Division By Zero.");

        }

        /*
        General Exception

        Must always come LAST.

        It catches every remaining exception.
        */

        catch (Exception e) {

            System.out.println("Some Other Exception.");

        }

    }

}

/*
| throw                          | throws                          |
| ------------------------------ | ------------------------------- |
| Used inside method             | Used in method declaration      |
| Throws an exception object     | Declares possible exceptions    |
| Throws one exception at a time | Can declare multiple exceptions |
| Uses `new` keyword             | Uses exception class names      |



| Checked         | Unchecked              |
| --------------- | ---------------------- |
| Compile-Time    | Runtime                |
| Must Handle     | Optional to Handle     |
| Compiler Forces | Compiler Doesn't Force |
| IOException     | ArithmeticException    |



throw
↓

I am throwing an exception.

-------------------------

throws
↓

This method MAY throw an exception.

-------------------------

Checked
↓

Compiler checks.

-------------------------

Unchecked
↓

Runtime checks.
 */