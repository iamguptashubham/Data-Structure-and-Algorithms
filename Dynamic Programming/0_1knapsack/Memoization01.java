public class Memoization01 {


    public static int knapsack(int val[], int wt[], int W, int i, int dp[][]) {
        if(W==0 || i == 0){
            return 0;
        }

        if(dp[i][W] != -1){
            return dp[i][W];
        }

        if(wt[i-1] <= W){
            //accept
            int ans1 =  val[i-1] + knapsack(val, wt, W-wt[i-1], i-1, dp);

            //reject
            int ans2 =  knapsack(val, wt, W, i-1, dp);

            dp[i][W] = Math.max(ans1, ans2);

            return dp[i][W];
        }
        else{
            dp[i][W] = knapsack(val, wt, W, i-1, dp);
            return dp[i][W];
        }
    }
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[]  = {10, 20, 30};
        int W = 50;

        int dp[][] = new int [val.length+1][W+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j< dp[0].length; j++ ){
                dp[i][j] = -1;
            }
        }

        int profit = knapsack(val, wt, W, val.length, dp);
        System.out.println("Profit "+ profit);
    }
}
