package HashMapandHeaps;

import java.util.HashMap;

public class LongestSubStringWithExactlyKDistinctCharacter {
    
    public static String longsub(String str, int k)
    {
        String ans="";
        HashMap<Character,Integer> hm= new HashMap<>();
        int i=-1;
        int j=-1;
        while(true)
        {
            boolean f1=false;
            boolean f2=false;
            while(i<str.length()-1)
            {
                f1=true;
                i++;
                char ch=str.charAt(i);
                hm.put(ch,hm.getOrDefault(ch,0)+1);
                if(hm.size()>k)
                {
                    break;
                }
                else{
                    String sub=str.substring(j+1, i+1);
                    if(ans.length()<sub.length())
                    {
                        ans=sub;
                    }                    
                }
            }
            while(j<i)
            {
                f2=true;
                j++;
                char ch=str.charAt(j);
                if(hm.get(ch)==1)
                {
                    hm.remove(ch);
                }else{
                   hm.put(ch,hm.get(ch)-1); 
                }
                if(hm.size()==k)
                {
                    String sub=str.substring(j+1, i+1);
                    if(ans.length()<sub.length())
                    {
                        ans=sub;
                    } 
                    break;
                }
            }
            if(f1==false && f2==false)
            {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str="aabcbcdbca";
        int k=2;
        System.out.println(longsub(str, k));
    }
}
