package HashMapandHeaps;

import java.util.HashMap;

public class MaximumConsecutivesOnes {

    public static int maxconsecutive(int[] arr){
        int maxlen=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        int i=-1;
        int j=-1;
        while(true)
        {
            boolean f1=false;
            boolean f2=false;
            while(i<arr.length-1)
            {
                f1=true;
                i++;
                int ele=arr[i];
                hm.put(ele,hm.getOrDefault(ele, 0)+1);
                if(ele==0 && hm.get(ele)>1)
                {
                    break;
                }
               maxlen=Math.max(maxlen, i-j); 
            }

            while(j<i)
            {
                f2=true;
                j++;
                if(arr[j]==1)
                {
                    hm.put(arr[j],hm.get(arr[j]-1));
                }
                else if(arr[j]==0 && hm.get(arr[j])>1)
                {
                        hm.put(arr[j],hm.get(arr[j])-1);
                        if(hm.get(arr[j])==1)
                        {
                            break;
                        }
                }
            }
            if(f1==false && f2==false)
            {
                break;
            }
        }

        return maxlen;
    }

    // normal counting consecutives 1
    public static int findMaxConsecutiveOnes(int[] arr) {
        int maxlen=0;
       int i=-1;
       int j=-1;
           while(i<arr.length-1 && j<=i)
           {
               i++;
               int ele=arr[i];
               if(ele==0)
               {
                   j=i;
                   continue;
               }
              maxlen=Math.max(maxlen, i-j); 
           }

       return maxlen;
   }
    public static void main(String[] args) {
        int arr[]={1,1,0,0,1,1};
        System.out.println(maxconsecutive(arr));
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
