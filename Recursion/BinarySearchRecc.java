package Recursion;

import java.util.Scanner;

public class BinarySearchRecc {
    public static int  binarysearch(int start, int end , int arr[], int ele)
    {
        if(start>end)
        {
            return -1;
        }
        int mid=(start+end)/2;
        if(arr[mid]==ele)
        {
            return mid;
        }
        if(arr[mid]<ele)
        {
            return binarysearch(mid+1,end,arr,ele);
        }else{
            return binarysearch(start,mid-1, arr, ele);
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the numbers of array in sorted order :");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the element to find :");
        int ele=sc.nextInt();
        int idx=binarysearch(0,n-1,arr,ele);
        if(idx==-1)
        {
            System.out.println("Not Present ");
        }
        else{
            System.out.println("Present at index "+ (idx+1));
        }
        sc.close();1
    }
}
