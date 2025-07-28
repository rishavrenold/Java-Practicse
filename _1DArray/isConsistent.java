package _1DArray;

import java.util.ArrayList;
import java.util.Arrays;

public class isConsistent {
    
    public static boolean isconsistent(ArrayList<String> expressions)
    {
        boolean flag=true;
        if(expressions.size()==0)
        {
            return false;
        }
        for(String s:expressions)
        {
            String ss[]=s.split(">");
            char a=ss[0].charAt(0);
            char b=ss[1].charAt(0);
            if(a-b>=0)
            {
                flag=false;
                break;
            }

        }
        return flag;
    }
    public static void main(String[] args) {
        ArrayList<String> al=new ArrayList<>(Arrays.asList("a>b","y>z","z>w"));
        System.out.println(isconsistent(al));
    }
}
