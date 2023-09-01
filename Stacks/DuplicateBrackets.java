package Stacks;

import java.util.Stack;

public class DuplicateBrackets {

    public static boolean isDuplicate(String str)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch!=')')
            {
                st.push(ch);
            }
            else if(ch==')')
            {
                if(st.size()==0)
                {
                    return false;
                }
                else if(ch==')' && st.peek()=='(')
                {
                    return true;
                }
                while(st.size()>0 && st.peek()!='(')
                {
                    st.pop();
                }
                st.pop();
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str="((a+b)+(c+d))";
        System.out.println(isDuplicate(str));
    }
}
