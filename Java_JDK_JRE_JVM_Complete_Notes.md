# Java Runtime Architecture (JDK, JRE, JVM) -- Placement Notes

# 1. Introduction

One of the most frequently asked Java interview questions is:

-   What is the difference between **JDK**, **JRE**, and **JVM**?
-   How does Java achieve **platform independence**?
-   What happens from writing a `.java` file until the program executes?

This document explains the complete flow.

------------------------------------------------------------------------

# 2. Java Program Execution Flow

``` text
Student.java
      │
      ▼
javac (Java Compiler)
      │
      ▼
Student.class (Bytecode)
      │
      ▼
JVM (Java Virtual Machine)
      │
      ▼
Machine Code
      │
      ▼
Operating System
      │
      ▼
Output
```

## Step 1 -- Write Source Code

``` java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

Saved as:

    Main.java

------------------------------------------------------------------------

## Step 2 -- Compilation

The **javac** compiler converts source code into **Bytecode**.

    javac Main.java

Output:

    Main.class

Bytecode is **not machine code**.

------------------------------------------------------------------------

## Step 3 -- JVM Execution

The JVM loads the `.class` file, verifies it, converts Bytecode into
machine instructions (using an interpreter and JIT compiler), and
executes it.

------------------------------------------------------------------------

# 3. Why Java is Platform Independent

C++:

    Source Code
         ↓
    Machine Code
         ↓
    Windows Only

Java:

    Source Code
          ↓
    Bytecode
          ↓
    JVM (Windows)

    OR

    JVM (Linux)

    OR

    JVM (macOS)

Every operating system has its own JVM implementation, so the **same
Bytecode** can run everywhere.

**Write Once, Run Anywhere (WORA).**

------------------------------------------------------------------------

# 4. JVM (Java Virtual Machine)

## Definition

The JVM is the runtime engine that executes Java Bytecode.

### Responsibilities

-   Loads classes
-   Verifies Bytecode
-   Executes code
-   Manages memory
-   Performs Garbage Collection
-   Handles exceptions

Think of the JVM as the engine that runs Java programs.

------------------------------------------------------------------------

# 5. JRE (Java Runtime Environment)

The JRE provides everything needed to **run** Java applications.

    JRE

    ↓

    JVM

    +

    Core Libraries

    +

    Runtime Files

Use JRE if you only want to execute Java programs.

------------------------------------------------------------------------

# 6. JDK (Java Development Kit)

The JDK is used to **develop and run** Java applications.

    JDK

    ↓

    JRE

    ↓

    JVM

It also includes development tools such as:

-   javac
-   java
-   jar
-   javadoc
-   jdb

------------------------------------------------------------------------

# 7. JDK vs JRE vs JVM

  Feature                 JVM   JRE   JDK
  ----------------------- ----- ----- -----
  Executes Bytecode       ✅    ✅    ✅
  Runs Java Programs      ❌    ✅    ✅
  Develop Java Programs   ❌    ❌    ✅
  Contains Compiler       ❌    ❌    ✅
  Contains JVM            \-    ✅    ✅

Easy memory trick:

-   JVM → Execute
-   JRE → Run
-   JDK → Develop + Run

------------------------------------------------------------------------

# 8. JVM Internal Architecture (High Level)

``` text
.class File
     │
     ▼
Class Loader
     │
     ▼
Bytecode Verifier
     │
     ▼
Execution Engine
     │
     ├── Interpreter
     └── JIT Compiler
     │
     ▼
Machine Code
```

## Class Loader

Loads required `.class` files into memory.

## Bytecode Verifier

Checks that the Bytecode is valid and safe.

## Execution Engine

Runs Bytecode.

-   Interpreter executes line by line.
-   JIT (Just-In-Time Compiler) compiles frequently executed code into
    native machine code for better performance.

------------------------------------------------------------------------

# 9. JVM Memory Areas

``` text
JVM Memory

├── Method Area
├── Heap
├── Java Stacks
├── PC Register
└── Native Method Stack
```

For placement interviews, focus mainly on:

-   Heap
-   Stack
-   Method Area

------------------------------------------------------------------------

# 10. Heap Memory

Stores:

-   Objects
-   Arrays

Example:

``` java
Student s = new Student();
```

The object created using `new` is stored in the Heap.

Characteristics:

-   Shared by all threads
-   Managed by Garbage Collector

------------------------------------------------------------------------

# 11. Stack Memory

Each thread has its own stack.

Stores:

-   Local variables
-   Method parameters
-   Object references
-   Method call frames

Example:

``` java
Student s = new Student();
```

The reference `s` is stored in the Stack.

------------------------------------------------------------------------

# 12. Method Area

Stores class-level information such as:

-   Class metadata
-   Static variables
-   Method bytecode
-   Runtime constant pool

Example:

``` java
static int count;
```

------------------------------------------------------------------------

# 13. Heap vs Stack

  Heap                Stack
  ------------------- --------------------------------------------
  Stores Objects      Stores Local Variables & References
  Shared              One per Thread
  Garbage Collected   Automatically cleared after method returns

------------------------------------------------------------------------

# 14. Garbage Collection (GC)

Garbage Collection automatically reclaims memory occupied by objects
that are no longer reachable.

``` java
Student s = new Student();
s = null;
```

The object becomes **eligible** for Garbage Collection.

The JVM decides **when** to reclaim the memory.

------------------------------------------------------------------------

# 15. String Pool

The String Pool is a special area in the Heap used to store string
literals.

``` java
String s1 = "Java";
String s2 = "Java";
```

Both references point to the same pooled string.

``` java
String s3 = new String("Java");
```

Creates a new object outside the pooled literal.

------------------------------------------------------------------------

# 16. Frequently Asked Interview Questions

### Why is Java platform independent?

Because Java compiles source code into Bytecode, and each operating
system provides its own JVM to execute that Bytecode.

### Where are objects stored?

Heap Memory.

### Where are local variables stored?

Stack Memory.

### Difference between Heap and Stack?

Heap stores objects; Stack stores method frames, local variables, and
references.

### Difference between JDK, JRE, and JVM?

-   JVM executes Bytecode.
-   JRE provides the runtime environment.
-   JDK provides development tools along with the JRE.

------------------------------------------------------------------------

# 17. Placement Revision

``` text
Java Source (.java)
        ↓
javac
        ↓
Bytecode (.class)
        ↓
JVM
        ↓
Machine Code
        ↓
Output

JDK
 ↓
JRE
 ↓
JVM

Heap → Objects

Stack → Local Variables + References

Method Area → Class Metadata + Static Members

GC → Cleans unreachable objects

String Pool → Reuses String literals
```
