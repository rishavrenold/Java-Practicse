package _1DArray;

import java.util.Scanner;

public class SortColors75 {

    public static void sortt(int arr[])
    {
        
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        sortt(arr);
        for(int ii=0;ii<arr.length;ii++)
        {
            System.out.print(arr[ii]+" ");
        }
    }
}
