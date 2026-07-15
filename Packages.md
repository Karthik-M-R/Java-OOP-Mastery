# Packages in Java

## What is a Package?

A **package** is a collection of related Java classes, interfaces, enums, and sub-packages.

Think of a package like a **folder** on your computer.

Just as folders organize files, packages organize Java classes.

### Real-Life Example

Suppose your computer has:

```text
Documents/
    Resume.pdf
    Notes.docx

Pictures/
    Photo1.jpg
    Photo2.jpg

Videos/
    Movie.mp4
```

Instead of keeping every file in one place, you organize them into folders.

Similarly, Java organizes related classes into packages.

---

## Interview Definition

> **A package is a namespace that groups related classes and interfaces together to organize code, avoid naming conflicts, and provide access control.**

---

# Why Do We Need Packages?

Imagine a project with hundreds of Java classes.

Without packages:

```text
Student.java
Teacher.java
Car.java
Employee.java
Account.java
Customer.java
...
```

Finding a class becomes difficult.

Instead, we organize them like this:

```text
college/
    Student.java
    Teacher.java

bank/
    Account.java
    Customer.java

vehicle/
    Car.java
    Bike.java
```

Now everything is easy to find.

---

# Advantages of Packages

### 1. Organize Code

Related classes are kept together.

Example:

```text
bank/
    Account.java
    Customer.java
```

---

### 2. Avoid Naming Conflicts

Suppose two developers create a class named `Student`.

```java
package college;

class Student {

}
```

```java
package school;

class Student {

}
```

Both classes can exist because they belong to different packages.

---

### 3. Provide Access Control

Packages work with access modifiers.

For example, a class with **default** access can only be used inside the same package.

---

### 4. Reuse Code

You can import classes from another package instead of writing them again.

---

# Types of Packages

Java has **two types** of packages.

## 1. Built-in Packages

These are already provided by Java.

Examples:

```java
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
```

Some common built-in packages are:

| Package     | Purpose              |
| ----------- | -------------------- |
| `java.lang` | String, Math, Object |
| `java.util` | Scanner, ArrayList   |
| `java.io`   | File handling        |
| `java.time` | Date & Time          |
| `java.net`  | Networking           |

---

## 2. User-Defined Packages

You can create your own package.

Example:

```java
package college;

public class Student {

}
```

The file should be stored like this:

```text
college/
    Student.java
```

---

# Package Declaration

The **first line** of a Java file is usually the package declaration.

```java
package college;
```

This tells Java that the class belongs to the `college` package.

---

# Import Statement

Suppose `Scanner` is inside the `java.util` package.

Without `import`:

```java
java.util.Scanner sc = new java.util.Scanner(System.in);
```

This is long.

With `import`:

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
```

This is much cleaner and easier to read.

---

# Package Structure

Example project:

```text
src/

college/
    Student.java
    Teacher.java

bank/
    Account.java
    Customer.java

vehicle/
    Car.java
    Bike.java
```

Each folder represents one package.

---

# Using a Class from Another Package

Suppose we have:

```text
college/
    Student.java

office/
    Employee.java
```

**Student.java**

```java
package college;

public class Student {

}
```

**Employee.java**

```java
package office;

import college.Student;

public class Employee {

    public static void main(String[] args) {

        Student s = new Student();

    }
}
```

The `import` statement allows `Employee` to use the `Student` class.

---

# Fully Qualified Name (FQN)

Instead of importing:

```java
import java.util.Scanner;
```

You can write:

```java
java.util.Scanner sc = new java.util.Scanner(System.in);
```

Here,

```text
java.util.Scanner
```

is called the **Fully Qualified Name (FQN)**.

---

# Common Interview Questions

### 1. What is a package?

> A package is a collection of related Java classes and interfaces used to organize code.

---

### 2. Why do we use packages?

* Organize code
* Avoid class name conflicts
* Improve code reuse
* Provide access control

---

### 3. What are the two types of packages?

* Built-in packages
* User-defined packages

---

### 4. Which package is imported automatically?

```text
java.lang
```

Examples:

```java
String
System
Math
Object
```

No `import` is needed.

---

### 5. What is the purpose of the `import` keyword?

It allows a class to use another class from a different package without writing its full name every time.

Example:

```java
import java.util.Scanner;
```

---

### 6. What is a Fully Qualified Name (FQN)?

The complete name of a class including its package.

Example:

```text
java.util.Scanner
```

---

### 7. Package vs Folder

| Package                             | Folder                       |
| ----------------------------------- | ---------------------------- |
| Java concept for organizing classes | Operating system directory   |
| Used by Java compiler and JVM       | Used by the operating system |
| Usually maps to a folder            | Stores all kinds of files    |

---

# Quick Revision

```text
Package
    ↓
Collection of related classes

Why?
    ↓
✔ Organize code
✔ Avoid name conflicts
✔ Reuse code
✔ Access control

Types
    ↓
1. Built-in
2. User-defined

Keywords
    ↓
package
import

Automatically Imported
    ↓
java.lang
```

### Easy Way to Remember

* **Package = Folder for Java classes**
* **`package` = Declares which package a class belongs to**
* **`import` = Lets you use classes from another package**
* **`java.lang` = Imported automatically**
