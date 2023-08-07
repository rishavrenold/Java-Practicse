package Stacks;

import java.util.Stack;

public class NextGreaterElementToRight {

    public static int[] nextgreateright(int arr[])
    {
        Stack<Integer> st=new Stack<>();
        int res[]=new int[arr.length];
        st.push(0);
        for(int i=1;i<arr.length;i++)
        {
            while(st.size()>0 && arr[st.peek()]<arr[i])
            {
                res[st.pop()]=arr[i];
            }
            st.push(i);
        }
        while(st.size()>0)
        {
            res[st.pop()]=-1;
        }
        return res;
    }
    public static int[] nextgreaterleft(int arr[])
    {
        Stack<Integer> st=new Stack<>();
        int res[]=new int[arr.length];
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--)
        {
            while(st.size()>0 && arr[st.peek()]<arr[i])
            {
                res[st.pop()]=arr[i];
            }
            st.push(i);
        }
        while(st.size()>0)
        {
            res[st.pop()]=-1;
        }
        return res;
    }
    public static void display(int res[])
    {
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[]={2,5,9,3,1,12,6,8,7};
        int res[]=nextgreateright(arr);
        int res1[]=nextgreaterleft(arr);
        display(res1);
        

    }
    
}
