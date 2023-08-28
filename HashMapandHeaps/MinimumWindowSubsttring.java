package HashMapandHeaps;

import java.util.HashMap;

public class MinimumWindowSubsttring {

    public static String miniString(String s1, String s2)
    {
        String ans="";
        int dcount=s2.length();
        int mcount=0;
        HashMap<Character,Integer> map2= new HashMap<>();
        for(int i=0;i<s2.length();i++)
        {
            char ch=s2.charAt(i);
            map2.put(ch,map2.getOrDefault(ch, 0)+1);
        }

        HashMap<Character,Integer> map1=new HashMap<>();
        int start=-1,end=-1;
        while(true)
        {
        boolean flag1=false;
        boolean flag2=false;
        while(end<s1.length() && mcount<dcount)
        {
            end++;
            char ch= s1.charAt(end);
            map1.put(ch,map1.getOrDefault(ch,0)+1);

            if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0))
            {
                mcount++;
            }
            flag1=true;
        }
        while(mcount==dcount && start<end)
        {
            String pstr=s1.substring(start+1,end+1);
            if(ans.length()==0 || pstr.length()<ans.length())
            {
                ans=pstr;
            }
            start++;
            char ch=s1.charAt(start);
            if(map1.get(ch)==1)
            {
                map1.remove(ch);
            }
            else
            {
                map1.put(ch,map1.get(ch)-1);

            }
            if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0))
            {
                mcount--;
            }
            
            flag2=true;
        }
            if(flag1==true && flag2==true)
            {
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s1="timetopractice";
        String s2="toc";
        String ans=miniString(s1, s2);
        System.out.println(ans);
    }
}
