import java.util.Optional;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemLoopException;
// import java.lang.Math;
import java.util.Random;

public class NumberGuessingGame {
    public static void main (String[] args) {
        int X = rand(args[0]);
        int guess = attempt();
        while (X != guess) {
            if (guess < X) {
                System.out.println("Haha, you fed up, daha buyuk bir sayi deneyin!!!");
                guess = attempt();
            }
            else if (guess > X) {
                System.out.println("Haha, you fed up, daha kucuk bir sayi deneyin!!!");
                guess = attempt();
            }
        }
        System.out.println("tebrik ederim, Pidor ~");
    }
    private static int rand (String args) {
        Scanner sc = new Scanner(args);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int target = (int) (Math.random() * (B - A + 1)) + A;
        return target;
    }

    private static int attempt() {
        Scanner sc = new Scanner(System.in);
        boolean haveWeParsed = false;
        int attempt = 0;
        while (!haveWeParsed) {
            try {
                attempt = sc.nextInt();
                haveWeParsed = true;
            } catch (NumberFormatException e) {
                System.out.println("hayyaa, bu sayi degil!!!");
            }
        }
        return attempt;
    }

    // alternative eleganto bebek way
    private static int attempt2(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("hayyaa, bu sayi degil!!!");
            }            
        }
    }

}