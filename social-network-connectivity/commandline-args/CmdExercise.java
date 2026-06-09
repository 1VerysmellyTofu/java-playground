public class CmdExercise {
    public static void main(String[] args) {
        int len = args.length;
        if(len == 3 && args[0].equals("--is-equal")) {
            String s1 = args[1];
            String s2 = args[2];
            if(s1.equals(s2)) {
                System.out.println("Yes");
            }
            else{System.out.println("No");
            }
        }
        else if(len == 2 && args[0].equals("square")){
            Boolean seInt = intChecker(args[1]);
            if(seInt) {
                int n = Integer.parseInt(args[1]);
                int sq = n * n;
                System.out.println(sq);
            }
            else{
                System.out.println("Bad usage");}
        }
        else{
            System.out.println("Bad usage");
        }
    }

    private static boolean intChecker(String n) {
        for(int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if(c < 48 || c > 57) {
                return false;
            }
        }
        return true;
    }

    
}
