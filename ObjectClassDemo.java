/*
===============================================================================
                        THE OBJECT ROOT CLASS IN JAVA
===============================================================================

Topics Covered
--------------
1. What is the Object Class?
2. toString() - Custom String formatting
3. equals() - Content comparison vs Reference comparison
4. hashCode() - The contractual partnership with equals()
5. getClass() - Core reflection properties
6. clone() - Shallow copies, memory boundaries, and structural cloning

===============================================================================
                         1. WHAT IS THE OBJECT CLASS?
===============================================================================
The java.lang.Object class sits at the apex of the Java class hierarchy. Every 
class you create implicitly extends Object if it has no explicit parent. 

This ensures all Java objects share a standard baseline of behaviors.

===============================================================================
                          THE DEEP DIVE ON CLONING
===============================================================================
Object cloning creates an exact copy of an object in a separate memory space. 
However, it is full of critical nuances often targeted in placements:

1. The Cloneable Interface (Marker Contract)
   - Cloneable has NO methods. It is a "Marker Interface" used to broadcast 
     permission to the JVM. If a class calls super.clone() without implementing 
     Cloneable, the JVM throws a CloneNotSupportedException.

2. Shallow Copy vs. Deep Copy
   - super.clone() executes a SHALLOW COPY. It creates a new object container, 
     copies primitives directly, but copies ONLY the reference pointers of 
     nested object fields. If a cloned object changes a shared nested reference, 
     the original object changes too!
   - A DEEP COPY requires manually instantiating new instances for any nested 
     reference fields inside the clone method.
===============================================================================
*/

public class ObjectClassDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        // Instantiating independent instances
        Student s1 = new Student(101, "Karthik", "Bangalore");
        Student s2 = new Student(102, "Karthik", "Bangalore");

        /*
        -----------------------------------------------------------------------
        toString() Execution
        -----------------------------------------------------------------------
        If not overridden, default toString() prints: ClassName@HexadecimalHashCode
        Since we overrode it, it outputs clean, formatted readable key-value state data.
        */
        System.out.println("toString(): " + s1);

        /*
        -----------------------------------------------------------------------
        equals() Execution
        -----------------------------------------------------------------------
        Default Object.equals() evaluates (s1 == s2) checking memory references.
        Because we overrode it, it evaluates state parity (IDs and string text matches).
        */
        System.out.println("equals(): " + s1.equals(s2));

        /*
        -----------------------------------------------------------------------
        hashCode() Execution
        -----------------------------------------------------------------------
        If two objects match via equals(), they MUST produce the exact same 
        integer hash code value. This rule protects hash-based data structures 
        like HashMap and HashSet from breaking.
        */
        System.out.println("hashCode s1 : " + s1.hashCode());
        System.out.println("hashCode s2 : " + s2.hashCode());

        /*
        -----------------------------------------------------------------------
        getClass() Execution
        -----------------------------------------------------------------------
        Returns the runtime representation class metadata. Used heavily for reflection.
        */
        System.out.println("Class Name : " + s1.getClass().getSimpleName());

        /*
        -----------------------------------------------------------------------
        clone() (Shallow Copy Validation)
        -----------------------------------------------------------------------
        We invoke cloning to duplicate s1. Let's inspect reference separations.
        */
        System.out.println("\n========== CLONING EXPERIMENT (SHALLOW VS DEEP) ==========\n");
        
        Student s3 = (Student) s1.clone();
        System.out.println("Original: " + s1);
        System.out.println("Cloned  : " + s3);
        System.out.println("Are s1 and s3 independent object instances? " + (s1 != s3)); // True!

        // DANGER ZONE: Verifying the Shallow Copy Vulnerability
        // Let's modify the nested Address text inside the cloned object (s3)
        s3.address.city = "Mysore";

        System.out.println("\n--- After Altering Cloned Object Address ---");
        System.out.println("Original s1 City: " + s1.address.city); 
        System.out.println("Cloned s3 City: " + s3.address.city);
        
        System.out.println("\n> ALERT: Notice that altering s3 also changed s1!");
        System.out.println("> Reason: super.clone() copied the memory pointer to the SAME Address object.");
    }
}

/*
===============================================================================
                     HELPER CONTAINER (NESTED STATE)
===============================================================================
*/
class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

/*
===============================================================================
                              THE BLUEPRINT CLASS
===============================================================================
*/
class Student implements Cloneable {

    int id;
    String name;
    Address address; // Reference type field that exposes shallow copy limits

    Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.address = new Address(city);
    }

    /*
    ===========================================================================
                                toString()
    ===========================================================================
    Formats values textually. Notice we cleanly display the embedded object state too.
    */
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', city='" + address.city + "'}";
    }

    /*
    ===========================================================================
                                 equals()
    ===========================================================================
    Checks structural property match. Safe defensively with instanceof.
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student other = (Student) obj;
        return this.id == other.id &&
               this.name.equals(other.name) &&
               this.address.city.equals(other.address.city);
    }

    /*
    ===========================================================================
                                hashCode()
    ===========================================================================
    Uses properties to build the signature hash integer value.
    */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.city.hashCode() : 0);
        return result;
    }

    /*
    ===========================================================================
                                 clone()
    ===========================================================================
    By default, Object.clone() is protected. We override it to 'public' to allow 
    global access. 
    
    If we want a TRUE Deep Copy that completely isolates the address memory blocks,
    we have to manually rewrite this method block.
    */
    @Override
    public Object clone() throws CloneNotSupportedException {
        // Step 1: Execute default shallow copy logic (handles primitives & names strings cleanly)
        Student clonedStudent = (Student) super.clone();
        
        // --- TO UPGRADE THIS FROM SHALLOW COPY TO DEEP COPY, UNCOMMENT THE LINE BELOW ---
        // clonedStudent.address = new Address(this.address.city); // Allocates a separate address box
        
        return clonedStudent;
    }
}