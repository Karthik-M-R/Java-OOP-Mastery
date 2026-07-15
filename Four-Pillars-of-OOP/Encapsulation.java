/*
===============================================================================
                            ENCAPSULATION IN JAVA
===============================================================================

Topics Covered
--------------
1. What is Encapsulation?
2. Data Hiding
3. Private Fields
4. Getters and Setters
5. Immutable Objects (Basic)

Examples
--------
1. Employee
2. BankAccount

===============================================================================
                    1. WHAT IS ENCAPSULATION?
===============================================================================

Definition

Encapsulation is the process of wrapping data (variables) and methods
(functions) together into a single unit (class).

It also restricts direct access to data by making variables private and
providing controlled access through methods.

Interview Definition

"Encapsulation is the process of binding data and methods together in a single
class while hiding the internal implementation from the outside world."

===============================================================================
REAL WORLD EXAMPLE

Imagine an ATM Machine.

You can

✔ Deposit money
✔ Withdraw money
✔ Check balance

But can you directly change the bank's database?

balance = 10000000;

NO.

The ATM only allows controlled operations.

Similarly,

Object
----------------------
private balance

deposit()

withdraw()

getBalance()

Users cannot directly modify balance.

This is Encapsulation.

===============================================================================
WHY DO WE NEED ENCAPSULATION?

Without Encapsulation

account.balance = -100000;

Anyone can change data.

This makes the object unsafe.

With Encapsulation

Only deposit() and withdraw() can modify balance.

Now the object remains valid.

===============================================================================
*/

public class Encapsulation {

    public static void main(String[] args) {

        System.out.println("========= EMPLOYEE =========\n");

        Employee emp = new Employee();

        // Setting values using Setter methods

        emp.setId(101);
        emp.setName("Karthik");
        emp.setSalary(50000);

        // Getting values using Getter methods

        System.out.println("ID : " + emp.getId());
        System.out.println("Name : " + emp.getName());
        System.out.println("Salary : " + emp.getSalary());

        System.out.println("\n========= BANK ACCOUNT =========\n");

        BankAccount account = new BankAccount();

        account.deposit(10000);

        account.withdraw(3000);

        account.withdraw(15000);

        System.out.println("Current Balance : " + account.getBalance());

        System.out.println("\n========= IMMUTABLE OBJECT =========\n");

        Person p = new Person("Rahul",21);

        System.out.println(p.getName());
        System.out.println(p.getAge());

    }

}

/*
===============================================================================
                    EMPLOYEE CLASS
===============================================================================

Private Fields

Nobody outside this class can access these variables directly.

Wrong

emp.salary = -1000;

Correct

emp.setSalary(50000);

Only setter decides whether value is valid.
*/

class Employee {

    private int id;
    private String name;
    private double salary;

    /*
    Getter

    Returns value.

    Used for reading private data.
    */

    public int getId() {
        return id;
    }

    /*
    Setter

    Used for updating value.

    Validation can be added here.
    */

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {

        /*
        Salary should never be negative.

        Validation makes object safe.
        */

        if(salary >= 0){

            this.salary = salary;

        }
        else{

            System.out.println("Invalid Salary");
        }

    }

}

/*
===============================================================================
                    BANK ACCOUNT
===============================================================================

Imagine this is your bank.

Can customers directly do

balance = 1000000;

No.

Only

deposit()

withdraw()

can modify balance.

This is Data Hiding.

Real banks work exactly like this.
*/

class BankAccount{

    private double balance;

    /*
    Deposit

    Only positive money accepted.
    */

    public void deposit(double amount){

        if(amount > 0){

            balance += amount;

            System.out.println(amount + " Deposited");
        }
    }

    /*
    Withdraw

    Checks balance before withdrawing.
    */

    public void withdraw(double amount){

        if(amount <= balance){

            balance -= amount;

            System.out.println(amount + " Withdrawn");
        }

        else{

            System.out.println("Insufficient Balance");
        }

    }

    /*
    Getter

    Read balance.

    No Setter because users should not directly change balance.
    */

    public double getBalance(){

        return balance;
    }

}

/*
===============================================================================
                    IMMUTABLE OBJECT
===============================================================================

Immutable means

Once object is created,

its state cannot change.

Example

String

There are NO setter methods.

Fields are final.

Object becomes Read Only.
*/

class Person{

    private final String name;
    private final int age;

    Person(String name,int age){

        this.name=name;
        this.age=age;
    }

    public String getName(){

        return name;
    }

    public int getAge(){

        return age;
    }

}

/*
Remember this sequence:

private variables
        ↓
Hide the data
        ↓
Public methods
(getters/setters)
        ↓
Controlled access
        ↓
Encapsulation

One interview tip: If asked "What is encapsulation?", don't answer only "using getters and setters." 
A stronger answer is:

"Encapsulation is the process of wrapping data and methods into a single class
 and restricting direct access to the data using access modifiers. Getters and setters
 are a common way to provide controlled access, but encapsulation is the broader concept." 
 
 */