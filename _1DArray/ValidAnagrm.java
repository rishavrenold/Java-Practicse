package _1DArray;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagrm {

    public static boolean isAnagram(String s,String t)
    {
        if(s.length()!=t.length())
        {
            return false;
        }
        Map<Character,Integer> hm= new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            char ch=s.charAt(i);
            if(hm.containsKey(ch))
            {
                hm.put(ch,hm.get(ch)+1);
            }else{
                hm.put(ch,1);
            }            
        }

        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);
            if(hm.containsKey(ch))
            {
                hm.put(ch,hm.get(ch)-1);
            }
        }
        for(Map.Entry<Character,Integer> h:hm.entrySet())
        {
            if(h.getValue()!=0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        System.out.println(isAnagram(s, t));
    }
}
