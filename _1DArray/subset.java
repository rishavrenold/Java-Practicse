package _1DArray;
import java.util.Scanner;

public class subset {

    public static void subsett(int arr[],int n)
    {
        int power=(int)Math.pow(2,n);
        for(int i=0;i<power;i++)
        {
            String ans="";
            int temp=i;
            for(int j=arr.length-1;j>=0;j--)
            {
                int rem=temp%2;
                temp=temp/2;
                if(rem==0)
                {
                    ans="_"+ans;
                }
                else{
                    ans=arr[j]+" "+ans;
                }
            }
            System.out.println(ans);        
        }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements :");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        subsett(arr,n);
    }
}
