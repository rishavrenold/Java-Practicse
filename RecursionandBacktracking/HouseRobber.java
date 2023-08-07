import java.util.Scanner;
/*
 *the array represent the house with the amount, no adjacent house should be robbed
 */

public class HouseRobber {

    public static int maxiprofit(int arr[],int idx)
    {
        if(idx>=arr.length)
        {
            return 0;
        }

        int profitinchoosing= arr[idx]+ maxiprofit(arr, idx+2);
        int profitinnotchoosing=maxiprofit(arr, idx+1);
        return Math.max(profitinchoosing, profitinnotchoosing);
    }
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of houses");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the amount of each house");
        for (int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Maximum pofit = "+ maxiprofit(arr,0));
        

    }
}
