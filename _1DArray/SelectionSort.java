package _1DArray;
import java.util.*;

public class SelectionSort {
    public static void swap(int pos1, int pos2,int arr[]) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
      }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<n-1;i++)
        {
        int minPos=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[minPos]>arr[j])
                {
                    minPos=j;
                }
            }
        swap(minPos,i,arr);
        }
    
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
