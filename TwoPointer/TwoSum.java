package TwoPointer;

import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] arr, int num) {
       int start=0,end=arr.length-1;
      int res[]=new int[2];
       while(start<end)
       {
           if(arr[start]+arr[end]==num)
           {
               res[0]=arr[start];
               res[1]=arr[end];
               break;
           }
           else if(arr[start]+arr[end]<num)
           {
               start++;
           }
           else{
               end--;
           }
        }
       return res;
   }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int num=sc.nextInt();
        int res[]=twoSum(arr,num);
        for(int i=0;i<res.length;i++)
        {
            System.out.print(" "+res[i]+" ");
        }

    }
}
