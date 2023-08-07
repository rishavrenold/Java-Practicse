package Stacks;

import java.util.Stack;

public class ValidParathesis {

    public static boolean validparan(String str)
    {
        Stack<Character> st= new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch==')' && st.peek()=='(')
            {
               return false;
            }
            else{
                if(ch==')')
                {
                    while(st.peek()!='(')
                    {
                        st.pop();
                    }
                    st.pop();
                }
                else{
                    st.push(ch);
                }   
            }            
        }
        return true;
    }
    public static void main(String[] args) {
        String str="((a+b)*(a-c))";
        if(validparan(str))
        {
            System.out.println("Valid Paranthesis");
        }
        else{
            System.out.println("Invalid Parathesis");
        }
        
    }
}
