package HashMapandHeaps;

import java.util.HashMap;

public class PrintAllCommon {

    public static void fremp(HashMap<Integer,Integer> hm,int arr1[])
    {
        for(int i=0;i<arr1.length;i++)
        {
            int ele=arr1[i];
            if(hm.containsKey(ele))
            {
                hm.put(ele,hm.get(ele)+1);
            }
            else{
                hm.put(ele,1);
            }
        }
    }
    public static void main(String[] args) {
        int arr1[]={1,1,2,2,3,3,4,5};
        // int arr2[]={1,2,3,5};
        int arr2[]={1,1,2,3,3,5};
        HashMap<Integer,Integer> hm=new HashMap<>();
        fremp(hm, arr1);
        // -------------------------------------------------------------------------------
        // Variation one where we want to print 1 common between both excluding duplicates
        // for(int i=0;i<arr2.length;i++)
        // {
        //     int ele=arr2[i];
        //     if(hm.containsKey(ele))
        //     {
        //         System.out.println(ele);
        //         hm.remove(ele);
        //     }
        // }
        // --------------------------------------------------------------------------------
        // Variation 2 where we want all the common including duplicates
        for(int i=0;i<arr2.length;i++)
        {
            int ele=arr2[i];
            if(hm.containsKey(ele))
            {
                int freq=hm.get(ele);
                if(freq>0)
                {
                    System.out.println(ele);
                }                
                hm.put(ele,hm.get(ele)-1);
            }
        }
    }
}
