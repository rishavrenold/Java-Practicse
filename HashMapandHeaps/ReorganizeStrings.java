package HashMapandHeaps;

import java.util.PriorityQueue;

public class ReorganizeStrings {

    public static class Pair{
        char ch;
        int f;

        Pair(char ch, int f)
        {
            this.ch=ch;
            this.f=f;
        }
    }
    public static  String reorganizeString(String str) {
        int freq[]= new int[26];
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            freq[ch-'a']++;
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> {
            return b.f-a.f;
        });

        for(int i=0;i<26;i++)
        {
            if(freq[i]>0)
            {
                char ch=(char)(i+'a');
                pq.add(new Pair(ch,freq[i]));
            }
        }

        StringBuilder sb= new StringBuilder();
        Pair blocked=pq.poll();
        sb.append(blocked.ch);
        if(blocked.f>0)
        {
            blocked.f--;
        }

        while(pq.size()>0)
        {
            Pair temp=pq.poll();
            if(temp.f!=0)
            {
                sb.append(temp.ch);
                if(temp.f>0)
                {
                    temp.f--;
                }
            } 
            if(blocked.f>0)
            {
                pq.add(blocked);
            }       
            blocked=temp;
        }
        if(blocked.f>0)
        {
            return "";
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String str="aab";
        System.out.println(reorganizeString(str));
    }
}
