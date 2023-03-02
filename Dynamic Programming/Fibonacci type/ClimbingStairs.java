import java.util.Scanner;

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? */

 class ClimbingStairs{

    public static int climbStair(int n){
        int stairs [] = new int[n+1];
        stairs[0] = stairs[1] = 1;
        for(int i = 2; i<=n; i++){
            stairs[i] = stairs[i-1] + stairs[i-2];
        }
        return stairs[n];
    }
    public static void main(String[] args) {
        System.out.println("Enter the number of stairs");
        Scanner sc  = new Scanner(System.in);
        int n= sc.nextInt();
        int ways = climbStair(n);
        System.out.println("The number of ways : "+ ways);
        if(ways == 165580141){
            System.out.println("success");
        }
    }


    }