import java.util.Random;

public class Connectivity {
    public static void main(String[] args) {
        int numArgs = args.length;
        System.out.println("Herro");
        System.out.println(numArgs);
        for(int i = 0; i < numArgs; i++) {
            String arg = args[i]; // editing this file
            System.out.println(arg);
        }

        // Let's see two ways to generate random numbers in Java.
        //
        // First way is using Math.random(). Mth.random() generates a **double** value between 0.0 (inclusive) and 1.0 (exclusive).
        // So if we want to generate a random integer between 10 and 15 (inclusive), we can do the following:
        // Multiply the random double by 6 (the range of numbers we want) and add 10 (the minimum value we want).
        // The (int) cast will convert the double to an integer.
        int randomNum = (int) (Math.random() * 6) + 10;

        // Second way is using the Random class. The Random class has a method called nextInt
        // that generates a random integer between given two values. The first value is inclusive
        // and the second value is exclusive. So if we want to generate a random integer between 10 and 15 (inclusive)
        // we do the following:
        Random rand = new Random();
        int randomNum2 = rand.nextInt(10, 16); 
    }

}