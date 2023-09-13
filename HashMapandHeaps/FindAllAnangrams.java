package HashMapandHeaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindAllAnangrams {

    public static boolean compare(HashMap<Character,Integer> pmap, HashMap<Character,Integer> hm)
    {
       for(Character e:pmap.keySet())
       {
            char ch=e;
            if(pmap.getOrDefault(ch,0)!=hm.get(e))
            {
                return false;
            }
       }
       return true;
    }

    public static ArrayList<Integer> findana(String str, String pattern)
    {
        HashMap<Character,Integer> pmap=new HashMap<>();
        HashMap<Character,Integer> hm= new HashMap<>();
        for(int i=0;i<pattern.length();i++)
        {
            char ch=pattern.charAt(i);
            pmap.put(ch,pmap.getOrDefault(ch, 0)+1);
        }

        for(int i=0;i<pattern.length();i++)
        {
            char ch=str.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        int i=pattern.length();
        ArrayList<Integer> res=new ArrayList<>();
        int count=0;
        while(i<str.length())
        {
            if(compare(hm,pmap)==true)
            {
                count++;
                res.add(i-pattern.length());
            }

            char ch=str.charAt(i);
            hm.put(ch,hm.getOrDefault(ch, 0)+1);
            char removech=str.charAt(i-pattern.length());
            if(hm.get(removech)==1)
            {
                hm.remove(removech);
            }
            else{
                hm.put(removech,hm.get(removech)-1);
            }
            i++;
        }
        if(compare(hm,pmap)==true)
            {
                count++;
                res.add(i-pattern.length());
            }
        return res;
    }
    public static void main(String[] args) {
        String str="cbaebabacd";
        String pattern="abc";
        System.out.println(findana(str, pattern));
    }
}
