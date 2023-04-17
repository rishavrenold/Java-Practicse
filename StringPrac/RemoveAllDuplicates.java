package StringPrac;
import java.util.*;

public class RemoveAllDuplicates {
    public static void main(String[] args) {
     Scanner sc= new Scanner(System.in);
    String str=sc.next();
    StringBuilder sb= new StringBuilder();
    int i=0 ;
    while(i<str.length())
    {
      if(sb.length()==0)
      {
        char ch=str.charAt(i);
        sb.append(ch);
      }
      else if(sb.charAt(sb.length()-1)==str.charAt(i))
      {
        sb.deleteCharAt(sb.length()-1);
      }
      else{
         char ch=str.charAt(i);
        sb.append(ch);
      }
      i++;
    }

    System.out.println(sb.toString().trim());
    sc.close();
    }
    
}
