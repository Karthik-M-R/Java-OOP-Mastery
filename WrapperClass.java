/*
===============================================================================
                        WRAPPER CLASSES IN JAVA
===============================================================================

1. WHAT ARE THEY?
   - Special Java classes that turn primitive types (int, char) into Objects.
   - Located in the 'java.lang' package (imported automatically).

   Primitive Type  -->  Wrapper Class (Object)
   ------------------------------------------
   byte            -->  Byte
   short           -->  Short
   int             -->  Integer   <-- (Note the full name)
   long            -->  Long
   float           -->  Float
   double          -->  Double
   char            -->  Character <-- (Note the full name)
   boolean         -->  Boolean

2. WHY DO WE NEED THEM?
   - Primitives: Fast, live on Stack memory, but have NO methods.
   - Objects: Required by Java Collections (ArrayList, HashMap).
   
   * ArrayList<int> list;      ❌ ERROR (Primitives not allowed)
   * ArrayList<Integer> list;  ✅ VALID (Objects allowed)

3. THE WALLET ANALOGY
   - Primitive = Loose cash (₹100 note). Fast to use, but can't go in complex slots.
   - Wrapper Object = A wallet holding that ₹100 note. 
   - The wallet is the container (Object); the cash is the value inside (Primitive).
*/

import java.util.ArrayList;

public class WrapperClasses {

    public static void main(String[] args) {

        System.out.println("========= MANUAL BOXING =========");
        /*
          - Old Method: 'new Integer(100)' is deprecated (slow).
          - New Method: Use 'valueOf()' factory methods.
          - Optimization: Values between -128 and 127 use a built-in "Cache" 
            to reuse existing objects instead of creating new ones in memory.
         */
        Integer number = Integer.valueOf(100);
        Double salary = Double.valueOf(55000.50);
        Character grade = Character.valueOf('A');
        Boolean placed = Boolean.valueOf(true);

        System.out.println(number);
        System.out.println(salary);
        System.out.println(grade);
        System.out.println(placed);
        System.out.println();


        System.out.println("========= AUTOBOXING =========");
        /*
          - What: Automatic conversion: Primitive -> Wrapper Object
          - Who: Done by the Java Compiler behind the scenes.
          
          What you write:          What the Compiler compiles:
          ----------------------------------------------------
          Integer age = 21;   -->  Integer age = Integer.valueOf(21);
          Double cgpa = 9.12; -->  Double cgpa = Double.valueOf(9.12);
         */
        Integer age = 21;
        Double cgpa = 9.12;
        Character section = 'A';
        Boolean status = true;

        System.out.println(age);
        System.out.println(cgpa);
        System.out.println(section);
        System.out.println(status);
        System.out.println();


        System.out.println("========= UNBOXING =========");
        /*
          - What: Automatic conversion: Wrapper Object -> Primitive
          - Who: Done by the Java Compiler behind the scenes.
          
          What you write:      What the Compiler compiles:
          ------------------------------------------------
          int x = age;    -->  int x = age.intValue();
          char ch = sec;  -->  char ch = sec.charValue();
          
          ⚠️ CRITICAL CRASH WARNING:
          If a Wrapper object is 'null', unboxing it will crash your app!
          Integer points = null;
          int myPoints = points; ❌ Throws NullPointerException!
         */
        int x = age;
        double y = cgpa;
        char ch = section;
        boolean flag = status;

        System.out.println(x);
        System.out.println(y);
        System.out.println(ch);
        System.out.println(flag);
        System.out.println();


        System.out.println("========= ARRAYLIST =========");
        /*
          - ArrayList needs Objects, so we specify <Integer>.
          - Thanks to Autoboxing, we can pass raw numbers like 10, 20, 30.
          - Java automatically updates 'list.add(10)' into 'list.add(Integer.valueOf(10))'.
         */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); 
        list.add(20); 
        list.add(30); 
        
        System.out.println(list); // Prints: [10, 20, 30]
    }
}