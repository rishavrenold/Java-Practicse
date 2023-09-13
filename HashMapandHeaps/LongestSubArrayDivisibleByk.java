package HashMapandHeaps;

import java.util.HashMap;

public class LongestSubArrayDivisibleByk {

    public static int longestsub(int arr[],int k)
    {
        HashMap<Integer,Integer> hm= new HashMap<>();
        hm.put(0,-1);
        int maxlen=Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++)
        {
            int ele=arr[i];
            int rem=ele%k;
            if(rem<0)
            {
                rem=rem+k;
            }
            if(!hm.containsKey(rem))
            {
                hm.put(rem,1);
            }
            else{
                int previdx=hm.get(rem);
                maxlen=Math.max(maxlen,i-previdx);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int arr[]={2,7,6,1,4,5};
        int k=3;
        System.out.println(longestsub(arr, k));
    }
}
