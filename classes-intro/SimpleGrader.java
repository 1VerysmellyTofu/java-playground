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
        // what we need: name; avarage grade; fail/pass
        String name;
        double averageGrade;
        String passOrFail;

        Student(String n, int m1, int m2, int f) {
            name = n;
            averageGrade = 0.3 * (m1 + m2) + 0.4 * f; 
            if (averageGrade >= 50) {
                passOrFail = "Pass";
            }
            else {
                passOrFail = "Fail";
            }
        }
    
        boolean isPassing() {
            return passOrFail.equals("Pass");
        }
    }
 
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        Scanner St = new Scanner(new File(args[0]));
        ArrayList <Student> Students = new ArrayList<Student>();
        while( St.hasNext()) {
            String n = St.next();
            int m1 = St.nextInt();
            int m2 = St.nextInt();
            int f = St.nextInt();
            Student s = new Student(n, m1, m2, f);
            Students.add(s);
        }

        int headcount = Students.size();
        // Let's understand what this loop intends to do,
        // and then we can fill in the missing pieces to make it work
        while (true) { // true rcap ????????????????!@#$%^&*()))(*&^%$#@!@#$%^&*()_)(&^%$#@!!@#$%^&*())
            System.out.println("--- Course Grader ---");
            System.out.println("1. Show student names");
            System.out.println("2. Show details of one student");
            System.out.println("3. Class average");
            System.out.println("4. How many are failing?");
            System.out.println("5. Exit");
            System.out.print("> ");


            int choice = readChoice(keyboard);
 
            if (choice == 1) {
                // Print names of every student
                for(int i = 0; i < headcount; i++) {
                    Student s = Students.get(i);
                    System.out.println(s.name);
                }
            }
            else if (choice == 2) {
                System.out.print("Name: ");
                String name = keyboard.next(); //can add case sensitive antihistamine
                // Let's print the student's
                // - name
                // - average grade
                // - are they failing (Passing, Failing)
                // If a student with this name doesn't exist, we can jsut print "bad name"

                Boolean keepSearching = true;
                for(int i = 0; i < headcount && keepSearching == true; i++) {
                    Student s = Students.get(i);
                    if (name.equals(s.name) ) {
                        System.out.println("Name: " + s.name);
                        System.out.println("Average grade: " + s.averageGrade);
                        System.out.println("Pass/Fail: " + s.passOrFail);
                        keepSearching = false;
                    }
                }
                if (keepSearching == true) {
                    System.out.println("bad name!!!!");
                }
            }
            else if (choice == 3) {
                // class average
                double totGrade = 0;
                for(int i = 0; i < headcount; i ++) {
                    Student s = Students.get(i);
                    totGrade += s.averageGrade;
                }
                double classAve = totGrade / headcount;
                System.out.println("Class Average: " + classAve);
            }
            else if (choice == 4) {
                // Num failing students
                int numFail = 0;
                for(int i = 0; i < headcount; i ++) {
                    Student s = Students.get(i);
                    if( !s.isPassing() ) {
                        numFail += 1;
                    }
                }
                System.out.println("Number of failing students: " + numFail);
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

    private static int readChoice(Scanner sc) {
        while (true) {
            try {
                String token = sc.next(); // can throw NoSuchElement
                return Integer.parseInt(token); // can throw NumberFormatException
            } catch (NumberFormatException e) {
                System.out.print("Choice must be an int in range [1, 5] Re-enter: ");
            }            
        }
    }
}
 