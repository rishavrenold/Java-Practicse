package HashMapandHeaps;

import java.util.HashMap;
import java.util.HashSet;

public class CountOfEquivalentsubArrays {

    public static int countequisubarray(int arr[])
    {
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            h.add(arr[i]);
        }


        int i=-1;
        int j=-1;
        int count=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(true)
        {
            boolean f1=false;
            boolean f2=false;
            while(i<arr.length-1)
            {
                f1=true;
                i++;
                hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
                if(hm.size()==h.size())
                {
                    count+=arr.length-i;
                    break;
                }
            }

            while(j<i)
            {
                f2=true;
                j++;
                if(hm.get(arr[j])==1)
                {
                    hm.remove(arr[j]);
                }else{
                    hm.put(arr[j],hm.get(arr[j])-1);
                }

                if(hm.size()<h.size())
                {
                    break;
                }
                else if(hm.size()==h.size())
                {
                    count+=arr.length-i;
                }
            }

            if(f1==false && f2==false)
            {
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[]={2,5,3,5,2,4,1,3,1,4};
        System.out.println(countequisubarray(arr));
    }
}
