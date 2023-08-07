import java.util.Scanner;

public class CoinChangePrac {

    public static int minNumber(int arr[], int amount)
    {
        if(amount ==0)
        {
            return 0;
        }
        if(amount <0)
        {
            return Integer.MAX_VALUE;
        }

        int mini=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            int ans=minNumber(arr,amount-arr[i]);
            if(ans!=Integer.MAX_VALUE)
            {
                mini=Math.min(mini,ans+1);
            }
        }
       return mini;
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

        System.out.println("Minimum number "+ minNumber(arr,k));
    }
}
