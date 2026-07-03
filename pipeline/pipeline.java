
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
public class pipeline {

    //okioki we try to make a file read on the customer info, assuming 
    public static void main(String[] args) throws Exception {
        ArrayList<int[]> custInfo = readCustInfo(args[0]);
        int len = custInfo.size();
        int foodFinishTime = 0;
        int msgFinishTime = 0;
        int waiting = 0;
        for(int i = 0; i < len; i++){
            int processStartTime = custInfo.get(i)[0];
            int processTime = custInfo.get(i)[1];
            foodFinishTime = processFinishingTime(processStartTime, processTime, foodFinishTime, 1);
            msgFinishTime = processFinishingTime(foodFinishTime, processTime, msgFinishTime, 2);
            waiting += msgFinishTime - processStartTime;
            System.out.println("food finish time: " + foodFinishTime);
            System.out.println("massage finish time: " + msgFinishTime);
            System.out.println("waiting time: " + waiting);
        }
        int avWaitingTime = waiting / len;
        System.out.println("method 1 : " + avWaitingTime);
    }

    private static int processFinishingTime(int processStartTime, int processTime, int processFinishTime, int timeUnits) {
        
        if (processStartTime <= processFinishTime) {
            processFinishTime += timeUnits * processTime;
        }
        else {
            processFinishTime = processStartTime + timeUnits * processTime;
        }
        return processFinishTime;
    }


    private static double averageWaitingTime(ArrayList<int[]> customers) {
        int len = customers.size();
        int bekliZaman = 0;
        int birBittiZaman = 0;

        for (int i = 0; i < len; i++) {
            if (customers.get(i)[0] <= birBittiZaman) {
                birBittiZaman += 2 * customers.get(i)[1];
            } else {
                birBittiZaman = customers.get(i)[0] + 3 * customers.get(i)[1];
            }
            bekliZaman = bekliZaman + birBittiZaman - customers.get(i)[0];
            System.out.println("birBittiZaman " + birBittiZaman);
            System.out.println("bekliZaman " + bekliZaman);
        }

        // int divison: 15 / 4 == 3
        double dBeklemeZamani = bekliZaman;
        return dBeklemeZamani / len;
    }

    private static ArrayList <int[]> readCustInfo (String fileName) throws Exception {
        Scanner sc = new Scanner(new File(fileName));
        ArrayList <int[]> custInfo = new ArrayList<>(); 
        while(sc.hasNext()) {
            int fi = sc.nextInt();
            int se = sc.nextInt();
            // int[] SCV = new int[2]; 
            // SCV[0] = fi;
            // SCV[1] = se;
            // custInfo.add(SCV);
            custInfo.add(new int[]{fi, se});
        } 
        return custInfo;   
    }

}

// create & asssign array at the same time
// int fi = 10;
// int se = 6;
// new int[]{fi, se}
