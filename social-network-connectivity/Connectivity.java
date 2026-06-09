public class Connectivity {
    public static void main(String[] args) {
        int numArgs = args.length;
        System.out.println("Herro");
        System.out.println(numArgs);
        int n = Integer.parseInt(args[0]);
        System.out.println(n);
        for(int i = 0; i < numArgs; i++) {
            String arg = args[i]; // editing this file
            System.out.println(arg);
        }
    }
}