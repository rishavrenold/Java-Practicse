package HashMapandHeaps;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctElementAvailableInKWindow {

    public static ArrayList<Integer> numberofdistinct(int arr[],int k)
    {
        ArrayList<Integer> res= new ArrayList<>();
        HashMap<Integer,Integer>freq= new HashMap<>();

        for(int i=0;i<k-1;i++)
        {
            freq.put(arr[i],freq.getOrDefault(arr[i], 0)+1);
        }
        for(int j=0,i=k-1;i<arr.length;)
        {
            freq.put(arr[i],getOrDefault(arr[i],0)+1);

            res.add(freq.size());

            if(freq.get(arr[j])==1)
            {
                freq.remove(arr[j]);
            }else{
                freq.put(arr[j],freq.get(arr[j])-1);
            }
            i++;
            j++;
        }

        return res;
    }
    private static int getOrDefault(int i, int j) {
        return 0;
    }
    public static void main(String[] args) {
        int arr[]={1,2,1,3,4,2,3};
        int windowsize=4;
        System.out.println(numberofdistinct(arr, windowsize));
    }
}
