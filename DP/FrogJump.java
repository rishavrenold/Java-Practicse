package DP;

import java.util.Scanner;

public class FrogJump {

    public static int mineng(int arr[],int idx)
    {
        if(idx==arr.length-1)
        {
            return 0;
        }

        int jump1=Integer.MAX_VALUE,jump2=Integer.MAX_VALUE;
        if(idx+1<=arr.length-1)
        {
        jump1=Math.abs(arr[idx]-arr[idx+1])+mineng(arr, idx+1);
        }
        if(idx+2<=arr.length-1)
        {
        jump2=Math.abs(arr[idx]-arr[idx+2])+mineng(arr, idx+2);
        }

        return Math.min(jump1, jump2);

    }

    public static int minengdpmemo(int arr[],int idx,int dp[])
    {
        if(idx==arr.length-1)
        {
            return 0;
        }
        if(dp[idx]!=0)
        {
            return dp[idx];
        }
        int jump1=Integer.MAX_VALUE,jump2=Integer.MAX_VALUE;
        if(idx+1<=arr.length-1)
        {
        jump1=Math.abs(arr[idx]-arr[idx+1])+minengdpmemo(arr, idx+1,dp);
        }
        if(idx+2<=arr.length-1)
        {
        jump2=Math.abs(arr[idx]-arr[idx+2])+minengdpmemo(arr, idx+2,dp);
        }
        dp[idx]=Math.min(jump1,jump2);

        return dp[idx];
    }

    public static int minengdptab(int arr[],int dp[])
    {
        dp[arr.length-1]=0;
        int step1=Integer.MAX_VALUE,step2=Integer.MAX_VALUE;
        for(int i=arr.length-2;i>=0;i--)
        {
            if(i+1<=arr.length-1)
            {
           step1=Math.abs(arr[i]-arr[i+1])+dp[i+1];
            }
            if(i+2<=arr.length-1)
            {
           step2=Math.abs(arr[i]-arr[i+2])+dp[i+2];
            }
            dp[i]=Math.min(step1,step2);
       
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elements :");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int dp[]=new int[n+1];
        System.out.println(mineng(arr, 0));
        System.out.println(minengdpmemo(arr, 0,dp));
        System.out.println(minengdptab(arr,dp));

    }
}
