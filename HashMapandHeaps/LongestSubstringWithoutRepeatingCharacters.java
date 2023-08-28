package HashMapandHeaps;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int longestsubstring(String str)
    {
        int count=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int i=-1;
        int j=-1;
        while(true)
        {
            boolean flag1=false;
            boolean flag2=false;
            while(i<str.length()-1)
            {
                flag1=true;
                i++;
                char ch=str.charAt(i);
                hm.put(ch,hm.getOrDefault(ch,0)+1);
                if(hm.get(ch)==2)
                {
                    break;
                }else{
                    int currlen=i-j;
                    if(currlen>count)
                    {
                        count=currlen;
                    }
                }
            }

            while(j<i)
            {
                flag2=true;
                j++;
                char ch=str.charAt(j);
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch)==1)
                {
                    break;
                }
            }
            if(flag1 ==false && flag2==false)
            {
                break;
            }
        }

        return count;

    }
    
    public static void main(String[] args) {
        String str="aabcbcdbca";
        System.out.println(longestsubstring(str));
    }
}
