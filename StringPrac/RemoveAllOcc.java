package StringPrac;

import java.util.*;

public class RemoveAllOcc {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.next();
        String t=sc.next();
        StringBuilder sb= new StringBuilder(str);
        int pos=sb.indexOf(t);
        while(pos!=-1)
        {
          sb.delete(pos,pos+t.length());
          pos=sb.indexOf(t);
        }

        System.out.println(sb.toString().trim());
    }
}
