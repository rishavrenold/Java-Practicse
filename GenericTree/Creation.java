package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class Creation {

     static class Node {
        int data;
        ArrayList<Node> al;

        Node()
        {
            this.data=0;
            al=new ArrayList<>();
        }
        Node(int data)
        {
            this.data=data;
            al=new ArrayList<>();
        }
    }

    public static Node creation(Integer arr[])
    {
        Stack<Node> st= new Stack<>();
        Node root=null;
        for(int i=0;i<arr.length;i++)
        {
            if(st.isEmpty())
            {   
                Node temp=new Node(arr[i]);
                root=temp;
                st.push(root);
            }else{
                if(arr[i]!=null)
                {
                    Node child=new Node(arr[i]);
                    Node parent=st.peek();
                    parent.al.add(child);
                    st.push(child);
                }else{
                    st.pop();
                }
            }
        }
        return root;
    }

    public static void print(Node root)
    {
        if(root.al.size()==0)
        {
            System.out.print("["+ root.data+"] -> {");
            System.out.print("no child }");
            System.out.print("\n");
        }
        else{
            System.out.print("["+ root.data+"] -> {");
            for(int i=0;i<root.al.size();i++)
            {
                System.out.print(root.al.get(i).data+" ");
            }
            System.out.print("}");
            System.out.println();
            for(Node child :root.al)
            {
                print(child);
            }
        }
    }

    public static int size(Node root)
    {
        int sz=0;
        for(Node child:root.al)
        {
            sz+=size(child);
        }
        return sz+1;
    }

    public static void main(String[] args) {
        Integer arr[]={1,2,3,null,4,null,null,5,6,null,7,null,null};
        Node root=creation(arr);
        print(root);
        System.out.println(size(root));
    }
    
}
