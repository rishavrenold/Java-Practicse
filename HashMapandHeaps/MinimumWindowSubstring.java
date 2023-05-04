package HashMapandHeaps;

import java.util.*;

public class MinimumWindowSubstring {

    public static String minsub(String s1, String s2)
    {
        String ans="";
        HashMap<Character, Integer> map2=new HashMap<>();
        for(int ii=0;ii<s2.length();ii++)
        {
            char ch=s2.charAt(ii);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }

        int desiredcount=s2.length();
        int presentcount=0;
        int i=-1,j=-1;
        HashMap<Character,Integer> map1=new HashMap<>();
        
        while(true)
        {
            boolean accquire=false;
            boolean release=false;
            // accquire of characters 
            while(i<s1.length()-1 && presentcount<desiredcount)
            {
                i++;
                char ch=s1.charAt(i);
                map1.put(ch,map1.getOrDefault(ch, 0)+1);
                if(map1.getOrDefault(ch, 0)<=map2.getOrDefault(ch, 0))
                {
                    presentcount+=1;
                }
                accquire=true;
            }
            System.out.println(i+" "+j);

            // store the result and release the characters
            while(j<i && presentcount==desiredcount)
            {
                String possibleans=s1.substring(j+1, i+1);
                System.out.println(possibleans);
                if(ans.length()==0 || possibleans.length()<ans.length())
                {
                    ans=possibleans;
                }
                j++;
                char ch=s1.charAt(j);
                if(map1.get(ch)==1)
                {
                    map1.remove(ch);
                }
                else{
                    map1.put(ch,map1.get(ch)-1);
                }
                if(map2.getOrDefault(ch,0)>map1.getOrDefault(ch,0))
                {
                    presentcount-=1;
                }
                release=true;
            }
            if(accquire ==false && release==false)
            {
                break;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        System.out.println(minsub(s1, s2));
    }
}
