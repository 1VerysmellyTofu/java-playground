import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
 
/**
 * Our students are in students.txt
 * Each line contains a student name and three exam scores (midterm, midterm, final).
 * Exams are weighted, so we need to compute a weighted average for each student.
 * Midterms are worth 30% each, and the final is worth 40%.
 * 
 * Input file format (students.txt), one student per line:
 *   name,firstMid,secondMid,final
 *
 * Passing grade is 50 or higher.
 * 
 * Run with: java SimpleGrader.java
 */
public class SimpleGrader {
 
    static class Student {
        // let's fill this in however we see fit
    }
 
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);

        // Let's understand what this loop intends to do,
        // and then we can fill in the missing pieces to make it work
        while (true) {
            System.out.println("--- Course Grader ---");
            System.out.println("1. Show student names");
            System.out.println("2. Show details of one student");
            System.out.println("3. Class average");
            System.out.println("4. How many are failing?");
            System.out.println("5. Exit");
            System.out.print("> ");
            int choice = keyboard.nextInt();
 
            if (choice == 1) {
                // Print names of every student
            }
            else if (choice == 2) {
                System.out.print("Name: ");
                String name = keyboard.nextLine().trim();
                // Let's print the student's
                // - name
                // - average grade
                // - are they failing (Passing, Failing)
                // If a student with this name doesn't exist, we can jsut print "bad name"
            }
            else if (choice == 3) {
                // class average
            }
            else if (choice == 4) {
                // Num failing students
            }
            else if (choice == 5) {
                System.out.println("We exiting~");
                return;
            }
            else {
                System.out.println("Unknown option: " + choice);
            }
            System.out.println();
        }
    }
}
 