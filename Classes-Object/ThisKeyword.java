/*
===============================================================================
                            this KEYWORD
===============================================================================

Topics

1. What is this?
2. Access Current Object
3. Resolve Variable Shadowing
4. Constructor Chaining
5. Pass Current Object
6. Return Current Object

===============================================================================
                        WHAT IS this ?
===============================================================================

Definition

this is a reference variable that refers to the CURRENT OBJECT.

Whenever an object calls a method,

this points to that object.

Example

Student s1 = new Student();

s1.display();

Inside display(),

this == s1

Interview Definition

"this is a reference variable that refers to the current object whose method or
constructor is being executed."

===============================================================================
*/

public class ThisKeyword {

    public static void main(String[] args){

        Student s1=new Student("Karthik",21);

        s1.display();

        System.out.println();

        s1.showCurrentObject();

        System.out.println();

        Demo demo=new Demo();

        demo.acceptObject(s1);

        System.out.println();

        Student returned=s1.getCurrentObject();

        returned.display();

    }

}

class Student{

    String name;
    int age;

    /*
    ===========================================================================
                RESOLVING VARIABLE SHADOWING
    ===========================================================================

    Local variables have same name as instance variables.

    this distinguishes them.

    */

    Student(String name,int age){

        this.name=name;
        this.age=age;

    }

    /*
    ===========================================================================
                    ACCESS CURRENT OBJECT
    ===========================================================================

    */

    void display(){

        System.out.println(this.name);

        System.out.println(this.age);

    }

    /*
    ===========================================================================
                    CONSTRUCTOR CHAINING
    ===========================================================================

    */

    Student(){

        this("Unknown",0);

    }

    /*
    ===========================================================================
                    PASS CURRENT OBJECT
    ===========================================================================

    */

    void showCurrentObject(){

        Demo demo=new Demo();

        demo.acceptObject(this);

    }

    /*
    ===========================================================================
                    RETURN CURRENT OBJECT
    ===========================================================================

    */

    Student getCurrentObject(){

        return this;

    }

}

class Demo{

    void acceptObject(Student obj){

        System.out.println("Student received.");

        obj.display();

    }

}