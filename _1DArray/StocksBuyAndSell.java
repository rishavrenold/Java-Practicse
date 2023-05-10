package _1DArray;

import java.util.Scanner;

public class StocksBuyAndSell {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        
        int maxProfit=Integer.MIN_VALUE;
        int currentbuy=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<currentbuy)
            {
                currentbuy=arr[i];
            }
            else{
                int profit=arr[i]-currentbuy;
                maxProfit=Math.max(maxProfit,profit);
            }
        }
        System.out.println("Maximum Profit = "+maxProfit);
    }
}
