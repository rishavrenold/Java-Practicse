package BinaryTree;
import java.util.*;
public class Creation {
    public static class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data)
    {
        this.data=data;
        this.left=this.right=null;
    }
    public Node (int data ,Node left , Node right)
    {
        this.data=data;
        this.left=left;
        this.right=right;
    }
}
public static class Pair{
    Node node;
    int state;
    Pair(Node node, int state)
    {
        this.node=node;
        this.state=state;
    }
}
public static Node construct(Integer arr[])
{
    Node root=new Node (arr[0]);
    Stack<Pair> st=new Stack<>();
    st.push(new Pair(root,0));
    int idx=0;
    while(st.size()>0)
    {
        Pair p=st.peek();
        if(p.state==0)
        {
            // left child
            idx++;
            if(arr[idx]!=null)
            {
            Node nn=new Node(arr[idx]);
            p.node.left=nn;
            st.push(new Pair(nn,0)); 
            }
            p.state++;
            
        }else if(p.state==1)
        {
            // right child
            idx++;
            if(arr[idx]!=null)
            {
                Node nn=new Node(arr[idx]);
                p.node.right=nn;
                st.push(new Pair(nn,0));
            }
            p.state++;
        }else{
            st.pop();
        }
    }
    return root;
}

public static Node fun()
{
    Integer arr[]={50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
    Node root=construct(arr);
    return root;
}

public static void display(Node root)
{
    if(root==null)
    {
        return;
    }
    String str="";
    if(root.left!=null)
    {
       str=str+root.left.data+" <- ";
    }
     str+=" [ "+root.data+" ] " ;
    if(root.right!=null)
    {
        str=str+" -> "+root.right.data;
    }
    System.out.println(str);
    

     display(root.left);
     display(root.right);

}

public static int size(Node root)
{
    if(root==null)
    {
        return 0;
    }
    int leftsz=size(root.left);
    int rightsz=size(root.right);
    return leftsz+rightsz+1;
}

public static int sum(Node root)
{
    if(root==null)
    {
        return 0;
    }
    int leftsz=sum(root.left);
    int rightsz=sum(root.right);
    return leftsz+rightsz+root.data;
}

public static int max(Node root)
{
    if(root==null)
    {
        return Integer.MIN_VALUE;
    }
    int leftmx=max(root.left);
    int rightmx=max(root.right);
    return Math.max(root.data,Math.max(rightmx,leftmx));
}

public static int height(Node root)
{
    if(root==null)
    {
        return 0;
    }
    int leftht=height(root.left);
    int rightht=height(root.right);
    return Math.max(leftht,rightht)+1;
}

public static void levelOrderTraversal(Node root)
{
    Queue<Node> q=new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty())
    {
        int sz=q.size();
        for(int i=0;i<sz;i++)
        {
            Node node=q.poll();
            System.out.print(node.data+" ");
            if(node.left!=null)
            {
                q.offer(node.left);
            }
            if(node.right!=null)
            {
                q.offer(node.right);
            }
        }
        System.out.println();
    }
}

public static void iterativePrePostInorder(Node root)
{
    Stack<Pair> st=new Stack<>();
    st.add(new Pair(root,0));
    while(st.size()>0)
    {
        Pair p=st.peek();
        if(p.state==0)
        {
            System.out.print("PreOrder -> " + p.node.data);
            if(p.node.left!=null)
            {
                st.push(new Pair(p.node.left, 0));
            }
            p.state++;
        }else if(p.state==1)
        {
            System.out.print(" Inorder -> " + p.node.data);
            if(p.node.right!=null)
            {
                st.push(new Pair(p.node.right, 0));
            }
            p.state++;
        }else{
             System.out.print(" PostOrder -> " + p.node.data);
             st.pop();
        }
        System.out.println();
    }
}

public static boolean isPresent(int data, Node root)
{
    if(root==null)
    {
        return false;
    }
    if(root.data==data)
    {
        return true;
    }
    boolean ans=false;
    ans=isPresent(data, root.left);
    ans=ans|| isPresent(data, root.right);
    return ans;
}
    public static void main(String[] args) {
        Node root=fun();
        // display(root);
        // System.out.println(size(root));
        // System.out.println(sum(root));
        //  System.out.println(max(root));
        // System.out.println(height(root));
        // levelOrderTraversal(root);
        // iterativePrePostInorder(root);
        System.out.println(isPresent(0, root));
    }
}
