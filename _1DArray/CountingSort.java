package _1DArray;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {
    public static void main(String[] args) {
        int arr[]= {7,7,5,5,5,1,1,6,6,9,9,9,3,3};
        int hash[]= new int[10];
        for(int i=0;i<arr.length;i++)
        {
            hash[arr[i]]++;
        }  
        for(int i=0;i<hash.length;i++)
        {
            System.out.println(hash[i]);
        }
        List<Integer> al =new ArrayList<>(); 
        for(int i=0;i<hash.length;i++)
        {
            int count=hash[i];
            while(count>0)
            {
                al.add(i);
                count--;
            }
        }
        System.out.println(al);
    }
}
