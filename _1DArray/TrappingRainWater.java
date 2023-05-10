package _1DArray;

import java.util.Scanner;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int leftmax[]=new int[height.length];
        int rightmax[]=new int[height.length];
        leftmax[0]=height[0];
        rightmax[height.length-1]=height[height.length-1];
        for(int i=1;i<height.length;i++)
        {
            if(leftmax[i-1]<height[i])
            {
                leftmax[i]=height[i];
            }else
            {
                leftmax[i]=leftmax[i-1];
            }
        }
        for(int i=height.length-2;i>=0;i--)
        {
            if(height[i]>rightmax[i+1])
            {
                rightmax[i]=height[i];
            }else
            {
                rightmax[i]=rightmax[i+1];
            }
        }
        int totalWater=0;
        for(int i=0;i<height.length;i++)
        {
            totalWater+=Math.min(leftmax[i],rightmax[i])-height[i];
        }
        return totalWater;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(trap(arr));
    }
}
