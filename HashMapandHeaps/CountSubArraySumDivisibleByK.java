package HashMapandHeaps;

import java.util.HashMap;

public class CountSubArraySumDivisibleByK {
    public static int subarraysDivByK(int[] arr, int k) {
         HashMap<Integer,Integer> hm= new HashMap<>();
        hm.put(0,1);
        int count=0;
        int currsum=0;
        for(int i=0;i<arr.length;i++)
        {
            currsum+=arr[i];
            int rem=currsum%k;
            if(rem<0)
            {
                rem=rem+k;
            }
            if(!hm.containsKey(rem))
            {
                hm.put(rem,1);
            }
            else{
               count+=hm.get(rem);
               hm.put(rem,hm.getOrDefault(rem,0)+1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[]={2,7,6,1,4,5};
        int k=3;
        System.out.println(subarraysDivByK(arr, k));
    }   
}
