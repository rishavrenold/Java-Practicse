package HashMapandHeaps;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckIfArrayPairSumDividedByK {

    public static void remfreqmap(HashMap<Integer,Integer> rf,int arr[],int divisor)
    {
        for(int i=0;i<arr.length;i++)
        {
            int rem=arr[i]%divisor;
            if(rf.containsKey(rem))
            {
                rf.put(rem,rf.getOrDefault(rem,0)+1);
            }else{
                rf.put(rem, 1);
            }
        }
    }
    public static void findpairs(HashMap<Integer,Integer> rf,int arr[],int divisor,ArrayList<ArrayList<Integer>> res)
    {
        for(int i=0;i<arr.length;i++)
        {
            int rem=arr[i]%divisor;
            if(2*rem==divisor)
            {
                if(rf.get(rem)%2==0)
                {
                ArrayList<Integer> mres=new ArrayList<>();
                mres.add(rem);
                mres.add(rem);
                res.add(mres);
                }
                else{
                    break;
                }
            }
            else if(rem==0 && rf.get(rem)%2==0)
            {
                ArrayList<Integer> mres=new ArrayList<>();
                mres.add(rem);
                res.add(mres);
            }
            else{
                if(rf.get(rem)!=rf.getOrDefault(divisor-rem,0))
                {
                   break;
                }else{
                ArrayList<Integer> mres=new ArrayList<>();
                mres.add(rem);
                mres.add(divisor-rem);
                res.add(mres);
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={9,7,5,3};
        int divisor=6;
        HashMap<Integer,Integer> rf=new HashMap<>();
        remfreqmap(rf, arr, divisor);
        System.out.println(rf);
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        findpairs(rf, arr, divisor, res);
        System.out.println(res);
    }
}
