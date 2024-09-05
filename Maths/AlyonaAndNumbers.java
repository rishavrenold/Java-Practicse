package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
// Number of pair (arr[i]+brr[i])%5==0
// crux: (arr[i]%5 + brr[i]%5)%5==0
public class AlyonaAndNumbers {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int n=5;
        int arr[]={1,2,3,5,6};
        int brr[]={1,2,3,4,5,6,7,8,9,10,11,12};
        int freq1[]=new int[5];
        int freq2[]=new int[5];
        Arrays.fill(freq1,0);
        Arrays.fill(freq2,0);
        for(int i=0;i<arr.length;i++)
        {
           freq1[arr[i]%5]++;
        }
        for(int i=0;i<brr.length;i++)
        {
           freq2[brr[i]%5]++;
        }
        int totalpairs=0;
        for(int i=0;i<5;i++)
        {
            if(i==0)
            {
                totalpairs+=(freq1[i]*freq2[i]);
            }else{
                totalpairs+=(freq1[i]*freq2[5-i]);
            }
        }
        System.out.println("Total Pairs "+ totalpairs);
    }
}
