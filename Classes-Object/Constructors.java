/*
===============================================================================
                            CONSTRUCTORS IN JAVA
===============================================================================

Topics Covered
--------------
1. What is a Constructor?
2. Why Constructors are Needed?
3. Characteristics of Constructors
4. Default Constructor
5. Parameterized Constructor
6. Constructor Overloading
7. Copy Constructor (Custom)
8. Constructor Chaining using this()

===============================================================================
                        1. WHAT IS A CONSTRUCTOR?
===============================================================================

Definition

A constructor is a special member of a class that is automatically invoked
whenever an object is created.

Its primary purpose is to initialize the object.

When you declare an object variable in Java—for example, Car myCar;—all you have done is
 created a reference pointer. The object doesn't actually exist in memory yet, 
 and it doesn't hold any real data.

Initializing an object means bringing that object to life in memory and setting its initial state

Example

Student s = new Student();

When the above statement executes,

1. Memory is allocated.
2. Constructor executes automatically.
3. Object gets initialized.

Unlike methods, constructors are NOT called explicitly,invoked automatically the 
exact moment you use the new keyword to create an object.

Its primary job is to initialize the instance variables of the newly created object.

Interview Definition

"A constructor is a special member of a class having the same name as the class
and no return type. It is automatically called when an object is created to
initialize the object's state."

===============================================================================
                    WHY DO WE NEED CONSTRUCTORS?
===============================================================================

Imagine creating 100 Student objects.

Without constructors

Student s1 = new Student();
s1.name="Karthik";
s1.age=21;

Student s2 = new Student();
s2.name="Rahul";
s2.age=20;

Very repetitive.

Instead,

Student s1 = new Student("Karthik",21);

Cleaner
Less code
Less chance of mistakes

===============================================================================
                CHARACTERISTICS OF CONSTRUCTORS
===============================================================================

✔ Same name as class

✔ No return type

✔ Called automatically

✔ Used for initialization

✔ Can be overloaded

✔ Cannot be inherited

✔ Cannot be static

✔ Cannot be final

===============================================================================
                    TYPES OF CONSTRUCTORS
===============================================================================

1. Default Constructor

2. Parameterized Constructor

3. Copy Constructor (custom implementation)

===============================================================================
*/

public class Constructors {

    public static void main(String[] args) {

        System.out.println("=========== DEFAULT CONSTRUCTOR ==========\n");

        Student s1 = new Student();

        s1.display();

        System.out.println("\n====== PARAMETERIZED CONSTRUCTOR ======\n");

        Student s2 = new Student("Karthik",21,9.15);

        s2.display();

        System.out.println("\n====== CONSTRUCTOR OVERLOADING ======\n");

        Student s3 = new Student("Rahul");

        s3.display();

        System.out.println("\n====== COPY CONSTRUCTOR ======\n");

        Student s4 = new Student(s2);

        s4.display();

        System.out.println("\n====== CONSTRUCTOR CHAINING ======\n");

        Student s5 = new Student("Rohit",20);

        s5.display();

    }

}

/*
===============================================================================
                            STUDENT CLASS
===============================================================================
*/

class Student{

    String name;
    int age;
    double cgpa;

    /*
    ===========================================================================
                        DEFAULT CONSTRUCTOR
    ===========================================================================

    If no constructor is written by programmer,

    Java automatically provides one.

    Here we are writing our own default constructor.

    It initializes object with default values.

    */

    Student(){

        System.out.println("Default Constructor Called");

        name="Unknown";
        age=0;
        cgpa=0.0;

    }

    /*
    ===========================================================================
                    PARAMETERIZED CONSTRUCTOR
    ===========================================================================

    Used for initializing object with user supplied values.

    */

    Student(String name,int age,double cgpa){

        this.name=name;
        this.age=age;
        this.cgpa=cgpa;

    }

    /*
    ===========================================================================
                    CONSTRUCTOR OVERLOADING
    ===========================================================================

    Same constructor name

    Different parameters.

    Java decides which constructor to call based on arguments.

    */

    Student(String name){

        this.name=name;
        age=18;
        cgpa=7.5;

    }

    /*
    ===========================================================================
                        CONSTRUCTOR CHAINING
    ===========================================================================

    this()

    Calls another constructor of SAME CLASS.

    Must be first statement.

    */

    Student(String name,int age){

        this(name,age,8.0);

    }

    /*
    ===========================================================================
                        COPY CONSTRUCTOR
    ===========================================================================

    Java DOES NOT provide copy constructor automatically.

    We manually create one.

    */

    Student(Student other){

        this.name=other.name;
        this.age=other.age;
        this.cgpa=other.cgpa;

    }

    void display(){

        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("CGPA : "+cgpa);

    }

}