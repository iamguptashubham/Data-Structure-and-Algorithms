// package 0_1knapsack;

public class Knapsack {

    public static int Knapsack(int val[], int wt[], int W, int i ) {
        if(W==0 || i==0){
            return 0;
        }

        if(wt[i-1]<=W){
            //include
            int ans1 = val[i-1] + Knapsack(val, wt, W-wt[i-1], i-1);

            //exclude
            int ans2 = Knapsack(val, wt, W, i-1);


            return Math.max(ans1, ans2);
        }
        else{
            return Knapsack(val, wt, W, i-1);
        }
    }
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[]  = {10, 20, 30};
        int W = 50;

        int profit = Knapsack(val, wt, W, val.length);
        System.out.println(profit);
    }
}
