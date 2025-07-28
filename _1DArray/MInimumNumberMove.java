package _1DArray;

import java.util.*;

public class MInimumNumberMove {


    public static int moves(int N ,ArrayList<Integer> A){
        int i=0;
        int j=A.size()-1;
        int count=-1;
        while(i<=j && N>=0)
        {
            if(A.get(i)==A.get(j))
            {
                N=N-A.get(i);
                count+=1;
                i++;
            }else if(A.get(i)<A.get(j)){
                N=N-A.get(j);
                count+=1;
                j--;
            }
            else if(A.get(i)>A.get(j))
            {
                N=N-A.get(i);
                count+=1;
                i++; 
            }

        }
        return count;
    }

   
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<>(Arrays.asList(1,1,4,2,3));
        int k=5;
        System.out.println(moves(k,al));

    }
}
