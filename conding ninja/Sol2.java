/*
 You are given an array 'A' of length 'N'. MEX of the array is defined as the minimum
 non-negative number that is not present in the array.
 Return the minimum number of elements to be added to the array to increase the MEX
 of the array by exactly two or return -1 if it is impossible.


 Explained by suraj
 */

import java.util.HashSet;

public class Sol2 {
    static int modifyMex(int n, int[] a) {
        HashSet<Integer> set = new HashSet<>();
        int mex = 0;
        int max = -1;
        for (int i : a) {
            max = Math.max(i, max);
            set.add(i);
        }
        // finding mex

        boolean flag = false;
        for (int i = 0; i < max; i++) {
            if (!set.contains(i)) {
                mex = i;
                flag = true;
                break;
            }
        }

        if (!flag) {
            return 2;
        }

        if (set.contains(mex + 2)) {
            return -1;
        }
        int count = 0;
        for (int i = mex; i < mex + 2; i++) {
            if (!set.contains(i)) {
                count++;
            }
        }

        return count;

    }
}
