package Recursion;

import java.util.Scanner;

public class NumberOfRods {

    public static int maxnumberofcuts(int len,int arr[])
    {
        if(len==0)
        {
            return 0;
        }
        if(len<0)
        {
            return Integer.MIN_VALUE;
        }

        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            int ans=maxnumberofcuts(len-arr[i], arr);
            if(ans!=Integer.MIN_VALUE)
            {
                maxi=Math.max(maxi, ans+1);
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the length of the rod");
        int len=sc.nextInt();
        System.out.println("Enter the number of cuts to be performed");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the different size of cuts of the rod :");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int res=maxnumberofcuts(len,arr);
        if(res<=Integer.MIN_VALUE)
            res=0;
        System.out.println("The maximum number of cuts of different sizes are :" + res);
        
    }
}
