package HashMapandHeaps;

import java.util.HashMap;

public class SubArrayWithZeroSum {
    
    public static int maxsub(int arr[])
    {
        HashMap<Integer,Integer> hm= new HashMap<>();
        int startidx=-1;
        int currsum=0;
        hm.put(currsum,startidx);
        int maxLen=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            currsum+=arr[i];
            if(hm.containsKey(currsum))
            {
                int currsize=i-hm.get(currsum);
                maxLen=Math.max(maxLen,currsize);
            }else{
                hm.put(currsum,i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[]={15 ,-2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxsub(arr));

    }
}
