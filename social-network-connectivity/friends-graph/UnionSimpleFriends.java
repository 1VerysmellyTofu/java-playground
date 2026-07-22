import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;;

public class UnionSimpleFriends {
    static class UnionFind {
        int[] groups;
        int n;
        //constructor
        UnionFind(int n){
            this.n = n;
            this.groups = new int[n];
            for(int i = 0; i < n; i++) {
                this.groups[i] = i;
            }
        }
        // union function
        void union(int p, int q) {
            int m = this.groups[p];
            int s = this.groups[q];
            //----------------方法三-----------------------
            int theSmaller = 0;
            int theBigger = 0;
            if (m < s) {
                theSmaller = m;
                theBigger = s;
            }
            else {
                theSmaller = s;
                theBigger = m;
            }
            int sml = Math.min(m, s);
            int big = Math.max(m, s);

            // groups.length 
            // reading an attribute of an array is _free_
            //
            // calling a function (like) arrayList.size()
            // or string.length()
            // these are _almost_ free.

            for(int i = 0; i < groups.length; i++) {
                if(this.groups[i] == theBigger) {
                    this.groups[i] = theSmaller;
                }
            }
            // if(p < q) {
            //     for(int i = 0; i < n; i++) {
            //         if (this.groups[i] == s) {
            //             this.groups[i] = p;
            //         }
            //     }
            // }
            // else {
            //     for(int i = 0; i < n; i++) {
            //         if (this.groups[i] == m) {
            //             this.groups[i] = q;
            //         }
            //     }
            // }
            //----------------方法二---------------------------------------
            // for(int i = 0; i < n; i++) {
            //     if(m < s && this.groups[i] == s) {
            //         this.groups[i] = m;
            //     }
            //     else if(s < m && this.groups[i] == m) {
            //         this.groups[i] = s; 
            //     }
            // }
        }

        //connected checker
        boolean connected(int p, int q) { 
            return (this.groups[p] == this.groups[q]);
        }

        //root finder ---- in need




        int numGroups() {
            HashSet<Integer> countGroup = new HashSet<>();
            int c = 0;
            for(int i = 0; i < groups.length; i++) {
                if(!countGroup.contains(groups[i])) {
                    countGroup.add(groups[i]);
                    c += 1;
                }
            }
            System.out.println(c);
            return c;
        }

        void printGroups() {
            int len= groups.length;
            for(int i = 0; i < len; i++) {
                System.out.print(groups[i]);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File(args[0]));
        int nodes = sc.nextInt();
        ArrayList<int[]> pairs = new ArrayList<>();
        while(sc.hasNextInt()) {
            int[] pair = new int[2];
            pair[0] = sc.nextInt();
            pair[1] = sc.nextInt();
            pairs.add(pair);
        }

        UnionFind uf = new UnionFind(nodes);
        
        for (int i = 0; i < pairs.size(); i++) {
            int[] curPair = pairs.get(i);
            int p = curPair[0];
            int q = curPair[1];
            uf.union(p, q);
            uf.printGroups();
            System.out.println();
            uf.numGroups();
        }
        
        

        // int numGroups = uf.numGroups(nodes);
        // System.out.println("Currently we have " + numGroups + " groups");


        // //test
        // for(int i = 0; i < pairs.size(); i++) {
        //     int p = pairs.get(i)[0];
        //     int q = pairs.get(i)[1];
        //     System.out.println("pair: " + p + ", " + q);
        // }
    }
}
