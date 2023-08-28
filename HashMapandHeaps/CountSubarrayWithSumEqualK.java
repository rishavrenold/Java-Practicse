package HashMapandHeaps;

import java.util.HashMap;

public class CountSubarrayWithSumEqualK {

    public static int subarraySum(int[] arr, int k) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        int currsum=0;
        hm.put(0,1);
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            currsum+=arr[i];
            if(hm.containsKey(currsum-k))
            {
                count+=hm.get(currsum-k);
            }
            if(hm.containsKey(currsum))
            {
                hm.put(currsum,hm.getOrDefault(currsum,0)+1);
            }else
            {
                hm.put(currsum,hm.getOrDefault(currsum,0)+1);
            }
            
        }
        return count;
    }

    public static void main(String[] args) {
        int a[]={1 ,2 ,3, 1, 1 ,1 ,1};
        int k=3;
        System.out.println(subarraySum(a, k));
    }
    
}
