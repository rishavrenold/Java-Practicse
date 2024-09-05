package Basics;

import java.util.*;
public class Practice {

    public static int[] nge(int arr[])
    {
        Stack<Integer> st= new Stack<>();
        int len=arr.length;
        st.push(len-1);
        int res[]=new int[len];
        Arrays.fill(res,-1);
        for(int i=len-2;i>=0;i--)
        {   
            while(!st.isEmpty() && arr[st.peek()]<=arr[i])
            {
                st.pop();
            }
            if(!st.empty() && arr[st.peek()]>arr[i])
            {
                res[i]=arr[st.peek()];
            }
            st.push(i);            
        }

        while(st.size()>0)
        {
            int eleidx=st.pop();
            if(arr[eleidx]<st.peek())
            {
                res[eleidx]=arr[st.peek()];
            }
            res[st.pop()]=-1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int arr[]={3,10,4,2,1,2,6,1,7};
        int res[]=nge(arr);
        for(int ii:res)
        {
            System.out.print(ii+" ");
        }
    }   

}

 /**
  *     0 1 2 3 4 5 6 7 8 
  arr = 3 10 4 2 1 2 6 1 7  
  res =         6  2 6 7 7 
  stack= 8 ,6 ,3
  i= 7 ,6 ,5 ,4,3
  check = value> arr[i] 
  */
