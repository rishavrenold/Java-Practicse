package Recursion;

import java.util.Scanner;

public class CheckSorted {

    public static boolean isSorted(int arr[],int idx)
    {
        if(idx==arr.length)
        {
            return true;
        }
        if(arr[idx]<arr[idx-1])
        {
            return false;
        }
        boolean ans=isSorted(arr, idx+1);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner((System.in));
        System.out.println("Enter the number of elements");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        boolean flag=isSorted(arr, 1);
        if(flag==true)
        {
            System.out.println("the array is sorted");
        }
        else{
            System.out.println("not sorted");
        }
    }
}
