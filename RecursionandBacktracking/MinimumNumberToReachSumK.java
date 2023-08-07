import java.util.Scanner;

public class MinimumNumberToReachSumK {

    public static int minNumber(int arr[],int amount,int idx)
    {
        if (idx==0) {
            if(amount % arr[0]==0)
                return amount/arr[idx];
            else
                return (int) 1e9;
        }
    
         int withCoin=Integer.MAX_VALUE;
        if(arr[idx]<=amount)
        {
        withCoin= 1 + minNumber(arr, amount - arr[idx], idx);
        }
        int withoutCoin = minNumber(arr, amount, idx - 1);
               
        return Math.min(withCoin, withoutCoin);
    }
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter the number to make");
        int k=sc.nextInt();

        System.out.println("Minimum number "+ minNumber(arr,k,n-1));

    }
}
