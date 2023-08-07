package Stacks;

import java.util.Stack;


public class BalancedBrackets {
    public static boolean balanced(String str)
    {
        
        Stack<Character> st= new Stack<>();
        for(int i=0;i<str.length();i++)
        {
                    char ch=str.charAt(i);
                    if(ch=='[' || ch=='(' ||ch=='{')
                    {
                        st.push(ch);
                    }
                   
                    else if(ch==')')
                    {
                        if(st.size()==0)
                        {
                            return false;
                        }
                        else{
                            if(st.peek()!='(')
                            {
                                return false;
                            }
                            else{
                                st.pop();
                            }
                        }
                    }
                    else if(ch==']')
                    {
                        if(st.size()==0)
                        {
                            return false;
                        }
                        else{
                            if(st.peek()!='[')
                            {
                                return false;
                            }
                            else{
                                st.pop();
                            }
                        }
                    }
                    else if(ch=='}')
                    {
                        if(st.size()==0)
                        {
                            return false;
                        }
                        else{
                            if(st.peek()!='{')
                            {
                                return false;
                            }
                            else{
                                st.pop();
                            }
                        }
                    }
                    else{
                        continue;
                    }
                                               
            
        }
        return st.size()==0;

    }
    public static void main(String[] args) {
        String str="[(a+b)+{(c+d)*(e/f)}]";
        System.out.println(balanced(str));
    }
}
