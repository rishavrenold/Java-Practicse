package _1DArray;

import java.util.Scanner;

//This algo is used for maximum sum subarray

public class KadanesAlgo {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            currsum+=arr[i];
            if(currsum<0)
            {
                currsum=0;
            }
            if(currsum>maxsum)
            {
                maxsum=currsum;
            }
        }
        System.out.println("Maximum subarray sum = "+maxsum);
    }
}
