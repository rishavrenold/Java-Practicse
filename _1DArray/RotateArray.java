package _1DArray;
import java.io.*;
import java.util.*;

public class RotateArray {
 public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }
    
  public static void rotate(int[] a, int k){
    // write your code here
    int temp[]=new int[k];
    for(int i=0;i<k;i++)
    {
        temp[i]=a[a.length-i-1];
    } 
    display(temp);
    int temp1[]=new int[a.length-k];
    for(int i=0;i<temp1.length;i++)
    {
        temp1[i]=a[i];
    }
    display(temp1);
    for(int i=0;i<k;i++)
    {
        a[i]=temp[k-i-1];
    }
    display(a);
    for(int i=k;i<a.length;i++)
    {
        a[i]=temp1[i-k];
    }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}