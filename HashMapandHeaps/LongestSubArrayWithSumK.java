package HashMapandHeaps;

import java.util.HashMap;

public class LongestSubArrayWithSumK {

    public static int longestSubarrayWithSumK(int []a, long k) {
        long currsum=0;
        HashMap<Long,Integer> hm= new HashMap<>();
        long maxLen=0;
        for(int i=0;i<a.length;i++)
        {
            currsum+=a[i];
            
                if(currsum==k)
                {
                    maxLen=Math.max(maxLen,i+1);
                }
                if(hm.containsKey(currsum-k))
                {
                    int previdx=hm.get(currsum-k);
                    maxLen=(long)Math.max(maxLen,i-previdx);
                }
                if(!hm.containsKey(currsum))
                {
                   hm.put(currsum,i); 
                }
        }
        return (int)maxLen;
    }
    public static void main(String[] args) {
        int a[]={1 ,2 ,3, 1, 1 ,1 ,1};
        int k=3;
    System.out.println(longestSubarrayWithSumK(a, k));
        
    }
}
