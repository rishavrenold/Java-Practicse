package _1DArray;

import java.util.Scanner;

public class MaxSubarraySumO3 {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        //creating prefix sum array 
        int prefixsum[]=new int[n];
        prefixsum[0]=arr[0];
        for(int i=1;i<n;i++)
        {
            prefixsum[i]=prefixsum[i-1]+arr[i];
        }

       int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int start=i;
            int currsum=0;
            for(int j=i;j<n;j++)
            {
                int end=j;

              //calculating currsum using formula prefixsum[end]-prefixsum[start-1]
                currsum=(start-1)<0?prefixsum[end]:prefixsum[end]-prefixsum[start-1];
                if(currsum>maxsum)
                {
                    maxsum=currsum;
                }
            }
        }
        System.out.println("Maximum Sum = "+maxsum);
    }
}
