import java.util.Scanner;
import java.io.File;
public class Quickie {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new File("text.txt"));
        while (!sc.hasNextInt()){
            sc.next();
        }
        int fi = sc.nextInt();
        System.out.println(fi);
        // String meow = sc.next();
        // System.out.println(meow);
        // sc.next();
        // sc.nextInt();

        // int besIkiBi = sc.nextInt();
        // System.out.println(besIkiBi);

        // String 我爱宝宝 = sc.next();
        // System.out.println(我爱宝宝);

        // sc.next();
        // sc.next();
        // System.out.println(sc.next());


        // Scanner scI = new Scanner(System.in);
        
        // int five = scI.nextInt();
        // System.out.println(five);
        



        //String seAnnoying = sc.next();

        // int onSekiz = sc.nextInt();
        // System.out.println(onSekiz);
        
        // String lol = sc.next();
        // System.out.println(lol);


        // Scanner s = new Scanner(System.in);

        // int wellReadThis = s.nextInt();
        // System.out.println("huhuhu");
        // String secondThingWeRead = s.next();
        // System.out.println("This is what we read: " + wellReadThis);
        
        // System.out.println("The other thing we read: " + secondThingWeRead);
        //System.out.println(thirdThingWeRead+thirdThingWeRead+thirdThingWeRead);
        
    }
        
}
