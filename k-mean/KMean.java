import java.util.*;

public class KMean {

    public static void main(String[] args) {
        System.out.println("Enter the size of data set");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of dataset");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int m1, m2, a, b;
        double sum1, sum2;
        int[] cluster1, cluster2;
        boolean flag;
        int iteration = 0;
        a = arr[0];
        b = arr[5];
        m1 = a;
        m2 = b;

        do {
            sum1 = 0;
            sum2 = 0;
            cluster1 = new int[arr.length];
            cluster2 = new int[arr.length];
            iteration++;
            int j = 0;
            int k = 0;
            for (int i = 0; i < arr.length; i++) {
                if (Math.abs(arr[i] - m1) <= (Math.abs(arr[i] - m2))) {
                    cluster1[j] = arr[i];
                    j++;
                }

                else {
                    cluster2[k] = arr[i];
                    k++;
                }
            }
            System.out.println();
            for (int i = 0; i < j; i++) {
                sum1 = sum1 + cluster1[i];
            }
            for (int i = 0; i < k; i++) {
                sum2 = sum2 + cluster2[i];
            }
            a = m1;
            b = m2;

            m1 = (int) Math.round(sum1 / j);
            m2 = (int) Math.round(sum2 / k);
            flag = !(m1 == a && m2 == b);
            System.out.println("After iteration " + iteration + " Cluster 1");
            for (int i = 0; i < cluster1.length; i++) {
                System.out.print(cluster1[i] + "\t");
            }
            System.out.println();
            System.out.println("After iteration " + iteration + " Cluster 2");
            for (int i = 0; i < cluster2.length; i++) {
                System.out.print(cluster2[i] + "\t");
            }
            System.out.println();

        } while (flag);

        System.out.println("Final clusters");
        System.out.println("Cluster 1");
        for (int i = 0; i < cluster1.length; i++) {
            System.out.print(cluster1[i] + "\t");
        }
        System.out.println();
        System.out.println("Cluster 2");
        for (int i = 0; i < cluster2.length; i++) {
            System.out.print(cluster2[i] + "\t");
        }
    }

}