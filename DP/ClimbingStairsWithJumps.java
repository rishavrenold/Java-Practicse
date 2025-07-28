package DP;

import java.util.Arrays;

public class ClimbingStairsWithJumps {
    public static void main(String[] args) {
        int arr[]={4,2,5,3,6};
        int n=arr.length;
        int dp[]=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--)
        {
            for(int jumps=1;jumps<=arr[i] && i+jumps<dp.length;jumps++)
            {
                    dp[i]+=dp[i+jumps];
            }
        }
        System.out.println(dp[0]);
    }
}
