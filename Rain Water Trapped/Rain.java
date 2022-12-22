//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class Rain{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        int[] leftAuxArray = new int[n];
        int[] rightAuxArray = new int[n];
        
        int leftMax = arr[0];
        leftAuxArray[0] = leftMax;
        for(int i=1; i<n; i++){
            if(arr[i]>leftMax){
                leftAuxArray[i] =arr[i];
                leftMax = arr[i];
            }
            else{
            leftAuxArray[i] = leftMax;
            }
        }
        
        int rightMax = arr[n-1];
        rightAuxArray[n-1] = rightMax;
        for(int i=n-2; i>=0; i--){
            if(arr[i]>= rightMax){
                rightAuxArray[i] = arr[i];
                rightMax = arr[i];
                
            }
            else{
                rightAuxArray[i] = rightMax;
            }
        }
        
        // for(int i=0; i<n; i++){
        //     System.out.print(leftAuxArray[i]);
        // }
        // System.out.println();
        
        // for(int i=0; i<n; i++){
        //     System.out.print(rightAuxArray[i]);
        // }

       //cal waterlevel and subtract height of bar
       long trappedWater = 0;
       for(int i=0; i<n; i++){
           trappedWater += Math.min(leftAuxArray[i],rightAuxArray[i]) - arr[i];
       }
       
       return trappedWater;
    } 


    public static void main(String[] args) {
        System.out.println("Enter Size of array:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            System.out.println("Enter array element");
            arr[i] = sc.nextInt();
        }
        System.out.println("The trapped Water volume is :"+ trappingWater(arr,n));
    }
}


