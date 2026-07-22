import java.util.Stack;
import java.io.File;
import java.util.Scanner;

public class LeetParentheses{
    public static void main (String[] args) throws Exception{
        //stdin scanner
        Scanner scf = new Scanner(new File(args[0]));
        // Scanner sc = new Scanner(System.in);
        String parentheses = scf.next();
        char[] parent = parentheses.toCharArray();
        boolean validMi = checker(parent);
        System.out.println(validMi);
        scf.close();

    }
    private static boolean checker(char[] parent) {
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < parent.length; i++) {
            char p = parent[i];
            if(s.isEmpty()) {
                s.push(p);
            }
            else {
                char q = s.peek();
                int asciDif = p - q;
                if(
                    asciDif == 1 || asciDif == 2
                ) {
                    s.pop();
                }
                else {
                    s.push(p);
                }
            }
        }
        return s.isEmpty();
    }

}