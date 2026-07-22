import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;;

public class UnionComplicatedFinder {
    static class FriendshipEvent {
        int personBir;
        int personIki;
        int timestamp;

        FriendshipEvent(Scanner sc){
            this.personBir = sc.nextInt();
            this.personIki = sc.nextInt();
            this.timestamp = sc.nextInt();
        }
    }
    static class UnionCFind {
        int[] id;
        int[] size;
        int n;
        int numGroups;

        UnionCFind(int n) {
            this.n = n;
            this.id = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                size[i] = 1;
            } 
            this.numGroups = n;
        }

        // union function union to the smaller--> now we want to keep a tracker of the tree depth
        void unionC(int p, int q) {
            // int i = id[p];
            // int j = id[q];
            // int rootBir = this.root(p);
            // int rootIki = this.root(q);
            // int sizeBir = this.size[rootBir];
            // int sizeIki = this.size[rootIki];
            // if(sizeBir <= sizeIki){
            //     this.id
            // }
            //012345
            int i = id[p];  //1  4. 0  2  3
            int j = id[q];  //3. 3. 3. 5. 5
            
            int sizeI = this.size[i];   //1. 1. 1. 1  4
            int sizeJ = this.size[j];   //1. 2. 3. 1  2

            int dominant = 0;
            int dominantDegil = 0;
            if (sizeI <= sizeJ) {
                dominant = j;      //3. 3  3  2  3
                dominantDegil = i; //1  4. 0. 5  5
            }
            else {
                dominant = i;
                dominantDegil = j;
            }
        
            // int smal = Math.min(i, j); // dominant Group. 
            // int big = Math.max(i, j); // sub group
            for(int m = 0; m < this.n; m++) {
                if(this.id[m] == dominantDegil) {
                    this.id[m] = dominant;   //032345 032335 332335. 335335 333333
                }
            }
            size[dominant] += size[dominantDegil];       //111211 111311 111411. 111412 1115
        }

        // connected checker
        boolean connectedmi(int p, int q) {
            return(this.id[p] == this.id[q]);
        }

        // root finder
        int root(int i) {
            while(this.id[i] != i) {
                i = id[i];  
            }
            return i;
        }

        // return the size of p's group
        int getGroupsSize(int p) {
            return size[id[p]];
        }

        // count group component

    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File(args[0]));
        int n = sc. nextInt();
        ArrayList <FriendshipEvent> pairs = new ArrayList<>(); 
        
        while(sc.hasNext()) {
            FriendshipEvent pair = new FriendshipEvent(sc);
            pairs.add(pair);            
        }
        //test Array mi
        UnionCFind yeniU = new UnionCFind(n);
        for(int i = 0; i < pairs.size(); i++){
            int p = pairs.get(i).personBir;
            int q = pairs.get(i).personIki;
            yeniU.unionC(p, q);
            int sizp = yeniU.getGroupsSize(p);
            int sizq = yeniU.getGroupsSize(q);
            System.out.println("group size: " + sizp +", "+ sizq);
            if(sizp == n || sizq == n) {
                System.out.println(i);
                break;
            }
        }
    }
}