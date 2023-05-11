package _1DArray;

import java.util.Scanner;

/**
 * SubarraywithsumeqK
 */
public class SubarraywithsumeqK {

    public static int countsubarray(int arr[],int k)
    {
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            int sum=0;
            for(int j=i;j<arr.length;j++)
            {
                sum+=arr[i];
                if(sum==k)
                {
                    count+=1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(countsubarray(arr, k));

    }
}