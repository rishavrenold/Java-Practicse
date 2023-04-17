package Recursion;

import java.util.Scanner;
//minimum number of coins required

public class MinimumNumberCoins {
public static int minimumcoinsrequired(int num,int arr[])
{
    if(num==0)
    {
        return 0;
    }
    if(num<0)
    {
        return Integer.MAX_VALUE;
    }

    int mini=Integer.MAX_VALUE;
    for(int i=0;i<arr.length;i++)
    {
        int res=minimumcoinsrequired(num-arr[i], arr);
        if(res!=Integer.MAX_VALUE)
        {
            mini=Math.min(mini,res+1);
        }
    }
    return mini;
}

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number to form ");
        int num=sc.nextInt();
        System.out.println("Enter the number of elements :");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the numbers in arr which will from the array :");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int res=minimumcoinsrequired(num, arr);
        if(res>=Integer.MAX_VALUE)
        {
            res=0;
        }else{
            System.out.println("The minimum number of coins required is : "+res);
        }
        
        
    }
}
