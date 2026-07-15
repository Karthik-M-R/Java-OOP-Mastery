/*
===============================================================================
                        POLYMORPHISM IN JAVA
===============================================================================

Topics Covered

1. What is Polymorphism?
2. Compile-Time Polymorphism (Method Overloading)
3. Runtime Polymorphism (Method Overriding)
4. Dynamic Method Dispatch
5. Overloading vs Overriding
6. Early Binding vs Late Binding

===============================================================================
                    WHAT IS POLYMORPHISM?
===============================================================================

Poly = Many

Morph = Forms

Polymorphism means "One thing can have many forms."

In Java,

One method name can perform different tasks depending on

• Parameters (Overloading)

OR

• Object calling the method (Overriding)

Real World Example

Suppose there is a person.

Person p = ...

If p is a Student
work() -> Study

If p is a Teacher
work() -> Teach

If p is a Doctor
work() -> Treat Patients

Same method

work()

Different behaviour.

This is Polymorphism.

Interview Definition

"Polymorphism is the ability of an object or method to take multiple forms.
In Java it is achieved using Method Overloading and Method Overriding."

===============================================================================
*/

public class Polymorphism {

    public static void main(String[] args) {

        System.out.println("========== METHOD OVERLOADING ==========\n");

        Calculator cal = new Calculator();

        System.out.println(cal.add(10,20));

        System.out.println(cal.add(10,20,30));

        System.out.println(cal.add(10.5,20.5));



        System.out.println("\n========== METHOD OVERRIDING ==========\n");

        Animal a1 = new Animal();

        a1.sound();



        Dog d = new Dog();

        d.sound();



        System.out.println("\n========== DYNAMIC METHOD DISPATCH ==========\n");

        Animal animal = new Dog();

        animal.sound();

    }

}

/*
===============================================================================
                COMPILE TIME POLYMORPHISM
===============================================================================

Method Overloading

Same method name

Different parameter list.

Compiler decides which method to call.

This is called Early Binding.

*/

class Calculator{

    int add(int a,int b){

        return a+b;

    }

    int add(int a,int b,int c){

        return a+b+c;

    }

    double add(double a,double b){

        return a+b;

    }

}

/*
===============================================================================
                RUNTIME POLYMORPHISM
===============================================================================

Method Overriding

Child class provides its own implementation of parent's method.

Decision is taken at Runtime.

*/

class Animal{

    void sound(){

        System.out.println("Animal makes sound");

    }

}

class Dog extends Animal{

    @Override

    void sound(){

        System.out.println("Dog Barks");

    }

}

/*
| Method Overloading       | Method Overriding    |
| ------------------------ | -------------------- |
| Same class               | Parent & Child class |
| Same method name         | Same method name     |
| Different parameters     | Same parameters      |
| Compile Time             | Runtime              |
| Inheritance not required | Inheritance required |
| Early Binding            | Late Binding         |



Q. Can we overload the main() method?

✅ Yes.

public static void main(String[] args){

}

public static void main(int x){

}

Only

main(String[] args)

is called by JVM.


Q.Why is Method Overloading called Compile-Time Polymorphism?

Because the compiler selects the correct overloaded method based on the method 
signature before the program runs.

Q. Why is Method Overriding called Runtime Polymorphism?

Because the compiler only knows the reference type. The JVM determines which overridden 
method to execute based on the actual object at runtime.

Placement Trick ⭐

Remember this in one line:

Overloading
Same Class
Different Parameters
Compile Time
Early Binding

↓

Overriding
Parent → Child
Same Parameters
Runtime
Late Binding
 */