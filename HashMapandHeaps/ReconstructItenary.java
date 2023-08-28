package HashMapandHeaps;
import java.util.*;
/* input Chennai Banglore 
Bombay Delhi 
Goa Chennai 
Delhi Goa
---------------
output = Bombay -> Delhi -> Goa -> Chennai -> Banglore.
*/
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItenary {

    public static String findStart(HashMap<String,String> hm)
    {
        HashMap<String,Boolean> test= new HashMap<>();
        for(Map.Entry<String,String> cities:hm.entrySet())
        {
            String source=cities.getKey();
            String des=cities.getValue();
            if(test.containsKey(des) && test.get(des)==true)    
            {
                test.put(des,false);
                test.put(source,true);
            }else{
                test.put(source,true);
                test.put(des,false);
            }
        }
        String s="";
        for(Map.Entry<String,Boolean> val:test.entrySet())
        {
            if(val.getValue()==true)
            {
                s=val.getKey();
                break;
            }
        }
        return s;
    }

    public static void sourcetodes(HashMap<String,String> hm,String source,ArrayList<String> res)
    {
        if(source== null)
        {
            return;
        }

        String newdes=hm.get(source);
        res.add(source);
        sourcetodes(hm,newdes, res);
    }
    public static void main(String[] args) {
        HashMap<String,String> hm= new HashMap<>();
        hm.put("Chennai", "Banglore");
        hm.put("Bombay", "Delhi");
        hm.put("Goa", "Chennai");
        hm.put("Delhi", "Goa");
        String source=findStart(hm);
        ArrayList<String> res=new ArrayList<>();
        sourcetodes(hm, source, res);
        System.out.println(res);
    }
}
