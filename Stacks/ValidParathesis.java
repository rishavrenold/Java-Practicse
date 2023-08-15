package Stacks;

import java.util.Stack;

public class ValidParathesis {

    public static boolean isValid(String str) {
        Stack <Character> st= new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch= str.charAt(i);
            if(ch=='{' || ch=='[' || ch=='(')
            {
                st.push(ch);
            }
            else if(ch=='}')
            {
                if(st.size()>0 && st.peek()=='{')
                {
                    st.pop();
                }else{
                    return false;
                }
            }
            else if(ch==']')
            {
                if(st.size()>0 && st.peek()=='[')
                {
                    st.pop();
                }else{
                    return false;
                }
            }
            else if(ch==')')
            {
                if(st.size()>0 && st.peek()=='(')
                {
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.size()>0?false:true;
    }
    public static void main(String[] args) {
        String str="((a+b)*(a-c))";
        if(isValid(str))
        {
            System.out.println("Valid Paranthesis");
        }
        else{
            System.out.println("Invalid Parathesis");
        }
        
    }
}
