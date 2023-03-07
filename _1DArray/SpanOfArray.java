// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are required to find the span of input. Span is defined as difference of maximum value and minimum value.
package _1DArray;
import java.util.*;
public class SpanOfArray {
   
    public static int span(int arr[],int n)
    {
        int min=arr[0];
        int max=arr[0];
        for(int i=0;i<n;i++)
        {
            if(min>=arr[i])
            {
                min=arr[i];
            }
            if(max<=arr[i])
            {
                max=arr[i];
            }
        }
        return max-min;
    }
   
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the no. of elements");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("The span of the array is = "+span(arr,n));
    }
}
