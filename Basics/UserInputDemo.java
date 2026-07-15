/*
===============================================================================
                          CAPTURING USER INPUT IN JAVA
===============================================================================

Topics Covered
--------------
1. Importing the Scanner Class
2. Instantiating the Scanner Object with System.in
3. Reading Primitives and Strings
4. Resolving the infamous ".nextLine() skipping" trap
5. Closing the Scanner resource



===============================================================================
*/

import java.util.Scanner; // Step 1: Import the Scanner class

public class UserInputDemo {

    public static void main(String[] args) {
        
        // Step 2: Instantiate the Scanner object. 
        // 'System.in' tells Java to listen to your keyboard input.
        Scanner scanner = new Scanner(System.in);

        System.out.println("================== CAPTURING INPUT ==================\n");

        // 1. Reading an Integer
        System.out.print("Enter your Roll Number (Integer): ");
        int rollNo = scanner.nextInt(); // Reads a whole number

        // 2. Reading a Double (Decimals)
        System.out.print("Enter your CGPA (Decimal): ");
        double cgpa = scanner.nextDouble(); // Reads a precise fractional number

        /*
        -----------------------------------------------------------------------
        THE SCANNER TRAP: The skipped nextLine() issue
        -----------------------------------------------------------------------
        When you type your CGPA (e.g. 9.15) and press Enter, 'nextDouble()' only 
        reads the 9.15. The "Enter Key" (New Line character '\n') stays behind in 
        the scanner's buffer.
        
        If we immediately try to call 'nextLine()', it will read that leftover 
        'Enter Key' and skip right past, leaving your name blank!
        
        The Solution: We consume the leftover newline character first.
        */
        scanner.nextLine(); // Consumes the leftover newline character in the buffer

        // 3. Reading a full String (Sentence)
        System.out.print("Enter your Full Name (String): ");
        String name = scanner.nextLine(); // Reads the entire line including spaces

        // 4. Reading a single Character
        System.out.print("Enter your Grade (Single Character): ");
        // Scanner doesn't have a nextChar(). We read it as a String and grab the first character index.
        char grade = scanner.next().charAt(0); 

        System.out.println("\n================== OUTPUT DETAILS ==================\n");
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
        System.out.println("CGPA         : " + cgpa);
        System.out.println("Grade        : " + grade);

        // Step 3: Always close the scanner when you are completely done using it.
        // This prevents memory leaks by releasing the system resources.
        scanner.close(); 
    }
}