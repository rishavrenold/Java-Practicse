package DP;

import java.util.Scanner;

public class FibonacciSeries {

    public static int fiborec(int n)
    {
        if(n==0 || n==1)
        {
            return n;
        }
        int res=fiborec(n-1)+fiborec(n-2);
        return res;
    }

    public static int fibdpmemo(int n, int dp[])
    {
        if(n==0 || n==1)
        {
            dp[n]=n;
            return dp[n];
        }

        if(dp[n]!=0)
        {
            return dp[n];
        }

        dp[n]=fibdpmemo(n-1,dp)+fibdpmemo(n-2, dp);
        return dp[n];

    }

    public static int fibtab(int n,int dp[])
    {
         dp[0]=0;
         dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number :");
        int n=sc.nextInt();
        System.out.println(fiborec(n));
        int dp[]=new int[n+1];
        System.out.println(fibdpmemo(n,dp));
        System.out.println(fibtab(n,dp));


        
    }
}
