/*
 Given an array we have to check number of element of array if
 they divide by 2 and still present in array.
 */


import java.util.HashSet;

public class Sol1 {
    static int doubleCount(int n, int []a) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i<n; i++){
            set.add(a[i]);
        }

        for(int i: a){
            if(set.contains(i/2)){
                count++;
            }
        }

        return count;
    }
}