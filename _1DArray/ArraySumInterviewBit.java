package _1DArray;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySumInterviewBit {
    public static ArrayList<Integer> addArrays(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        int carry=0;
        ArrayList<Integer> res= new ArrayList<Integer>();
        int i=A.size()-1,j=B.size()-1;
        for(;i>=0 && j>=0;i--,j--)
        {
            int digit=0;
            digit+=carry+A.get(i)+B.get(j);
            int rem=digit%10;
            carry=digit/10;
            res.add(0,rem);            
        }
        while(carry>0 && i>=0)
        {
            int digit=0;
            digit+=carry+A.get(i);
            int rem=digit%10;
            carry=digit/10;
            res.add(0,rem);
            i--;
        }
        while(carry>0 && j>=0)
        {
            int digit=0;
            digit+=carry+B.get(j);
            int rem=digit%10;
            carry=digit/10;
            res.add(0,rem);
            j--;
        }
        while(i>=0)
        {
            res.add(0,A.get(i--));
        }
        while(j>=0)
        {
            res.add(0,B.get(j--));
        }
        if(carry>0)
        {
            res.add(0,carry);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> B=new ArrayList<>(Arrays.asList(7,8,9,6,4,2,1));
        ArrayList<Integer> res=addArrays(A, B);
        for(Integer x:res)
        {
            System.out.print(" "+x);
        }
    }
}
