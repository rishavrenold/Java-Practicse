package HashMapandHeaps;

// input
// A C
// B C
// C F
// D E
// E F
// F F

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindNumberOfEmployee {

    public static void treecreation(HashMap<Character,Character> hm)
    {
        Character head=null;
        HashMap<Character,HashSet<Character>> tree= new HashMap<>();
        for(Map.Entry<Character,Character>pair:hm.entrySet())
        {
            Character child=pair.getKey();
            Character parent=pair.getValue();
            if(child==parent)
            {
                head=pair.getKey();
            }
            else{
                if(tree.containsKey(parent))
                {
                    HashSet<Character> temp=tree.get(parent);
                    temp.add(child);
                    tree.put(parent,temp);
                }else{
                    HashSet<Character> temp= new HashSet<>();
                    temp.add(child);
                    tree.put(parent,temp);
                }
            }
        }
        HashMap<Character,Integer> noe=new HashMap<>();
        System.out.println(findnumberofemployee(tree,head, noe));
        printtree(noe);
    }

    public static int findnumberofemployee(HashMap<Character,HashSet<Character>> tree,Character head,HashMap<Character,Integer> noe)
    {
        if(tree.get(head)==null)
        {
            noe.put(head,0);
            return 1;
        }
        int size=0;
        if(tree.containsKey(head))
        {
            for(Character emp:tree.get(head))
            {
                size+=findnumberofemployee(tree,emp, noe);
            }
        }
        noe.put(head,size);
        return size+1;
    }
    public static void printtree(HashMap<Character,Integer> tree)
    {
        for(Map.Entry<Character,Integer> h:tree.entrySet())
        {
            System.out.println(h.getKey()+" "+h.getValue());
        }
    }
    public static void main(String[] args) {
        HashMap<Character,Character> hm= new HashMap<>();
        hm.put('A','C');
        hm.put('B','C');
        hm.put('C','F');
        hm.put('D','E');
        hm.put('E','F');
        hm.put('F','F');
        treecreation(hm);
       
    }
}
