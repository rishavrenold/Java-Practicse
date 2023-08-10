package _1DArray;

import java.util.ArrayList;
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
            for(int j=i+1;j<arr.length;j++)
            {
                sum+=arr[j];
                if(sum==k)
                {
                    count+=1;
                }
            }
        }
        return count;
    }

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> pos=new ArrayList<>();
        pos.add(-1);
        pos.add(-1);
        for(int i=0;i<arr.length;i++)
        {
            int sum=0;
            for(int j=i;j<arr.length;j++)
            {
                sum+=arr[j];
                if(sum==s)
                {
                    pos.add(i);
                    pos.add(j);
                    return pos;
                } 
                else if(sum>s)
                {
                    break;
                } 
            }
        }
        return pos;
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
        // System.out.println(countsubarray(arr, k));
        System.out.println(subarraySum(arr,n, k));

    }
}