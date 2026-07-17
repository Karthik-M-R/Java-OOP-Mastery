/*
===============================================================================
                            JVM BASICS
===============================================================================

Topics Covered

1. JVM
2. JRE
3. JDK
4. Heap Memory
5. Stack Memory
6. Method Area
7. Garbage Collection
8. String Pool

===============================================================================
                    WHAT IS JVM?
===============================================================================

Definition

JVM (Java Virtual Machine) is the virtual machine responsible for
executing Java Bytecode.

It converts Bytecode into Machine Code that the operating system
understands.

Interview Definition

"JVM is the runtime engine that executes Java Bytecode and provides
platform independence."

===============================================================================
WHY JVM?
===============================================================================

Java Source Code (.java)

↓

Compiler (javac)

↓

Bytecode (.class)

↓

JVM

↓

Machine Code

↓

Operating System

Same Bytecode

↓

Windows

Linux

Mac

Because every OS has its own JVM.

===============================================================================
*/

public class JVMBasics {

    public static void main(String[] args) {

        Student s1 = new Student("Karthik");

        Student s2 = new Student("Rahul");

        System.out.println(s1.name);

        System.out.println(s2.name);

        /*
        s1 and s2 are stored in Stack.

        Actual Student objects are stored in Heap.
        */

    }

}

class Student{

    String name;

    Student(String name){

        this.name = name;

    }

}