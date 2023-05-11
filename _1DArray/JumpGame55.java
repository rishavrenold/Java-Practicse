package _1DArray;

import java.util.Scanner;

/**
 * JumpGame55
 */
public class JumpGame55 {

    public static boolean findend(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int jump=1;jump<=arr[i];jump++)
            {
            if(arr[i]+i==arr.length-1)
            {
                return true;
            }
            else{
                i=arr[i]+i;
            }
        }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(findend(arr));
    }
}