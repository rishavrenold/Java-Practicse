package Stacks;
import java.util.*;
public class MinimumNumberOfBracketRemoval {

    public static void main(String[] args) {
        String s=")()())";
        int closing=0;
        int opening=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{' ){
               opening+=1;
            }
            else if(ch==')' || ch==']' || ch=='}') 
            {
               closing+=1;
            }
        }
        if(Math.abs(closing-opening)==0)
        {
            System.out.println("Balanced");
        }else{
            System.out.println(Math.abs(closing-opening));
        }
    }
}
