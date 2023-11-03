package _1DArray;
// Valid subarrays with a range with maximum value

import java.util.ArrayList;

public class MaximumWithinARange {

    public static int valid(int arr[], int start,int end)
    {
        int ans=0;
        int lastgreaterindexplusone=0;
        int prevvalidcount=0;
        for(int ep=0;ep<arr.length;ep++)//ep here stands for end point
        {
            if(arr[ep]>end)
            {
                ans+=0;
                lastgreaterindexplusone=ep+1;
                prevvalidcount=0;
            }
            else if(arr[ep]>=start && arr[ep]<=end )
            {
                ans+=(ep-lastgreaterindexplusone+1);
                prevvalidcount=ep-lastgreaterindexplusone+1;
            }
            else{
                ans+=prevvalidcount;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={9,5,8,7,5,4,1,10,6,8};
        int start=6;
        int end=8;
       System.out.println(valid(arr, start, end));

    }
}
