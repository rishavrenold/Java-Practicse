package _1DArray;
import java.util.Scanner;


public class Sort0sand1s {

    public static void swap(int pos1, int pos2,int arr[]) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
      }

       public static void sortt(int arr[])    {
        int start=0,end=arr.length-1,i=0;
        while(start<=end)
        {
            if(arr[i]==0)
            {
                swap(start,i,arr);
                i++;
                start++;
            }
            else{
                swap(end, i,arr);
                end--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        sortt(arr);
        for(int ii=0;ii<arr.length;ii++)
        {
            System.out.print(arr[ii]+" ");
        }
        
       
        
    }
}
