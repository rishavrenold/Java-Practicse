package Trie;

import java.util.ArrayList;

public class CreationOfTrie {

    static class Node{
        Node[] children=new Node[26];
        boolean endOfWord;
        int freq=0;
        Node()
        {
            for(int i=0;i<26;i++)
            {
                children[i]=null;
            }
        }

    }

    public static Node root=new Node();
    
    public static void insert(String word)
    {
        Node curr=root;
        for(int level=0;level<word.length();level++)
        {
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null)
            {
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.endOfWord=true;
    }

    public static boolean search(String key)
    {
        System.out.println("Call of search");
        Node curr=root;
        for(int level=0;level<key.length();level++)
        {
            int idx=key.charAt(level)-'a';
            if(curr.children[idx]==null)
            {
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.endOfWord==true;
    }

    public static boolean wordbreak(String key)
    {
        System.out.println("Call of word break");
        if(key.length()==0)
        {
            return true;
        }
        for(int i=1;i<=key.length();i++)
        {
            System.out.println("Part to be checked "+ key.substring(0, i));
            System.out.println("remaing part "+key.substring(i));
            if(search(key.substring(0, i)) && wordbreak(key.substring(i)))
            {
                return true;
            }
        }
        return false;
    }

    public static void modifiedinsert(String key)
    {
        Node curr=root;
        for(int i=0;i<key.length();i++)
        {
            if(curr.children[key.charAt(i)-'a']==null)
            {
                curr.children[key.charAt(i)-'a']=new Node();
                curr.children[key.charAt(i)-'a'].freq=1;
            }else{
                curr.children[key.charAt(i)-'a'].freq+=1;
            }
            curr=curr.children[key.charAt(i)-'a'];
        }
        curr.endOfWord=true;
    }

    public static void modifiedSearch(String key)
    {
        if(key.length()==0)
        {
            return;
        }
        Node curr=root;
       StringBuilder sb = new StringBuilder();
        for(int i=0;i<key.length();i++)
        {
            if(curr.children[key.charAt(i)-'a']==null && curr.children[key.charAt(i)-'a'].freq!=1)
            {
                return;
            }
            else if(curr.children[key.charAt(i)-'a']!=null && curr.children[key.charAt(i)-'a'].freq==1)
            {
                sb.append(key.charAt(i));
                res.add(sb.toString());
                return;
            }
            else{
                sb.append(key.charAt(i));
                curr=curr.children[key.charAt(i)-'a'];
            }
        }

    }

    static ArrayList<String> res = new ArrayList<String>();

    public static ArrayList<String>prefix(String[] words)
    {
        for(int i=0;i<words.length;i++)
        {
            modifiedinsert(words[i]);
        }
        
        for(int i=0;i<words.length;i++)
        {
            modifiedSearch(words[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        String words[]={"zebra","dog","duck","dove"};
        System.out.println(prefix(words));
        // for(int i=0;i<words.length;i++)
        // {
        //     insert(words[i]);
        // }
        // if(wordbreak("thereathe"))
        // {
        //     System.out.println("Word Present");
        // }else{
        //     System.out.println("Word not present");
        // }


    }
}
