// 1. You are given a number n1, representing the size of array a1.
// 2. You are given n1 numbers, representing elements of array a1.
// 3. You are given a number n2, representing the size of array a2.
// 4. You are given n2 numbers, representing elements of array a2.
// 5. The two arrays represent digits of two numbers.
// 6. You are required to add the numbers represented by two arrays and print the
// arrays.


package _1DArray;
import java.util.*;
public class SumOfTwoArray {

    public static void sum(int a[],int b[],int n1,int n2)
    {
        int arr[]= new int[n1>n2?n1:n2];
        int i=n1-1;
        int j=n2-1;
        int k=arr.length-1;
        int carry=0;
        while(k>=0)
        {
            int digit=carry;
            if(i>=0)
            {
                digit+=a[i--];
            }
            if(j>=0)
            {
                digit+=b[j--];
            }
            carry=digit/10;
            int rem=digit%10;
            arr[k--]=rem;
        }

        if(carry>0)
        {
            System.out.print(carry+" ");
        }
        for(Integer x:arr)
        {
            System.out.print(x+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the length of 1st array ");
        int n1=sc.nextInt();
        int a[]=new int[n1];
        System.out.println("Enter the elements of array 1 ");
        for(int i=0;i<n1;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println("Enter the length of 2nd array ");
        int n2=sc.nextInt();
        int b[]=new int[n2];
        System.out.println("Enter the elements of array 2 ");
        for(int i=0;i<n2;i++)
        {
            b[i]=sc.nextInt();
        }
        sum(a, b,n1,n2);
    }
}
