package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MissingNumber {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int n=5;
        int arr[]={1,2,3,5};
        int sum1=0;
        int totalsum=(n*(n+1))/2;

        for(int i=0;i<arr.length;i++)
        {
            sum1+=arr[i];
        }
        System.out.println("Missing Number "+ (totalsum-sum1));
    }
}
