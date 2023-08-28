package StringPrac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,ArrayList<String>> hm= new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            String s=strs[i];
            HashMap<Character,Integer> freq= new HashMap<>();
            for(int j=0;j<s.length();j++)
            {
                char ch=s.charAt(j);
                if(freq.containsKey(ch))
                {
                    freq.put(ch,freq.get(ch)+1);
                }else
                {
                    freq.put(ch,1);
                }
            }
            if(hm.containsKey(freq))
            {
                hm.get(freq).add(s);
            }else
            {
                ArrayList<String> temp=new ArrayList<>();
                temp.add(s);
                hm.put(freq,temp);
            }
        }
        List<List<String>> al= new ArrayList<>();
        for(Map.Entry<HashMap<Character,Integer>,ArrayList<String>> h:hm.entrySet())
        {
            System.out.println("Key "+h.getKey()+" Value "+h.getValue());
            ArrayList<String> mres= new ArrayList<>();
            for(String ss:h.getValue())
            {
                mres.add(ss);
            }
            al.add(mres);            
        }
        return al;   
    }
    public static void main(String[] args) {
        String arr[]={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(arr));
    }
}
