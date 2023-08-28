package HashMapandHeaps;

import java.util.HashMap;
import java.util.HashSet;

public class SmallestSubStringOfAllUniqueCharacters {

    public static int solution(String str)
    {
        HashSet<Character> set= new HashSet<>();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            set.add(ch);
        }

        int start=-1;
        int end=-1;
        int minlen=Integer.MAX_VALUE;
        HashMap<Character,Integer> hm= new HashMap<>();
        while(true)
        {
            boolean f1=false;
            boolean f2=false;

            while(start<str.length()-1 && hm.size()<set.size())
            {
                f1=true;
                start++;
                char ch= str.charAt(start);
                hm.put(ch,hm.getOrDefault(ch, 0)+1);
            }
            while(end<start && set.size()==hm.size())
            {
                int currlen=start-end;
                    if(minlen>currlen)
                    {
                        minlen=currlen;
                    }
                f2=true;
                end++;
                char ch=str.charAt(end);
                if(hm.get(ch)==1)
                {
                    hm.remove(ch);
                    
                }else{
                    hm.put(ch,hm.get(ch)-1);
                }

            }
            if(f1==false && f2==false)
        {
            break;
        }

        }
        return minlen;
    }
    public static void main(String[] args) {
        String str="aabcbcdbca";
        System.out.println(solution(str));
    }
}
