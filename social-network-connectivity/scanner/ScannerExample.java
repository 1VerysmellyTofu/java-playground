import java.util.Scanner;
import java.io.File;

public class ScannerExample{
    // We talked about "returning two things from a function". Java doesn't
    // natively support that idea.
    // 
    // But that's not a hard-limitation. You can always define a class like the below
    // that contains 2 "things", and return an instance of this class.
    //
    // For example, if we wanted to return 2 ints from a function,
    // we can create this below "Pair" class, and return that.
    static class Pair {
        int first;
        int second;

        Pair(int thingiWillAssignToFirst, int se) {
            this.first = thingiWillAssignToFirst;
            this.second = se;
        }

        Pair(int onlyOneNumber) {
            this.first = onlyOneNumber;
            this.second = 0;
        }
    }

    // We wanna make a couple of improvements:
    //
    // 1. We think the constraints are too strict.
    // We want the scanner to scan the first 2 integers in its source
    // while skipping all the non-integer tokens.
    //
    // 2. We want to do error handling a little better:
    // If there aren't 2 ints in the input, we complain to the user.
    // Or if the "input" file is missing, we can complain again.
    // (2) can be done after we learn about exception management.
    public static void main(String[] args) throws Exception {
        Scanner sc = createScanner(args);
        Pair meows = filterTwoInt(sc);
        int fi = meows.first;
        int se = meows.second;
        int sum = fi + se;
        System.out.println(sum);
    }
    private static Scanner createScanner(String[] args) throws Exception {
        String source = args[0].toLowerCase();
        Scanner sc = null;
        if(source.equals("stdin")) {
            sc = new Scanner(System.in);
        }
        else if(source.equals("file")) {
            String file = args[1];
            sc = new Scanner(new File(file));
        }
        else if(source.equals("string")) {
            String herhangi = args[1];
            sc = new Scanner(herhangi);
        }
        return sc;
    }
    private static Pair filterTwoInt(Scanner sc) {
        int[] meow = new int[2];
        int i = 0;
        while (i < 2) {
            if (!sc.hasNextInt()) {
                sc.next();
            }
            else {
                meow[i] = sc.nextInt();
                i ++;    
            }
        }
        Pair p = new Pair(meow[0], meow[1]);
        return p;
    }
}

   
    