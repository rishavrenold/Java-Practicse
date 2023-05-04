package TwoPointer;

import java.util.Scanner;

/**
 * Leetcode977SquaresofSortedArray
 */
public class Leetcode977SquaresofSortedArray {

    public static int[] sortedSquares(int[] nums) {
        int start=0,end=nums.length-1,ptr=end;
        int result[]=new int[nums.length];
        while(start<=end)
        {
            if(Math.abs(nums[start])<Math.abs(nums[end]))
             {
                 result[ptr--]=nums[end]*nums[end];
                 end--;
             }
             else
             {
                 result[ptr--]=nums[start]*nums[start];
                 start++;
             }
        }
        return result;
     }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int res[]=sortedSquares(arr);
        for(int ii=0;ii<res.length;ii++)
        {
            System.out.print(" "+res[ii]+" ");
        }
    }
}