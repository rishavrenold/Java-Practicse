package HashMapandHeaps;

import java.util.HashMap;

public class NumberOfSubArrayWithZeroSum {

       public static int nofsub(int arr[])
        {
            int count=0;
            HashMap<Integer,Integer> hm= new HashMap<>();
            int currsum=0;
            hm.put(currsum,1);

            for(int i=0;i<arr.length;i++)
            {
                currsum+=arr[i];
                if(hm.containsKey(currsum))
                {
                    count+=hm.get(currsum);
                    hm.put(currsum,hm.get(currsum)+1);
        
                }
                else{
                    hm.put(currsum,1);
                }
            }

            return count;
        }
    public static void main(String[] args) {
        int arr[]={15 ,-2, 2, -8, 1, 7, 10, 23};
        System.out.println(nofsub(arr));
    }
}
