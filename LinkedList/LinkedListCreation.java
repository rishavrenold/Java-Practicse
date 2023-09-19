package LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class LinkedListCreation {

    static class Node{
        int data;
        Node next;
       public  Node()
        {

        }
        public Node(int data)
        {
            this.data=data;
            this.next=null;
        } 
    }
    public static Node head=null;
    public static Node tail=null;
    public static int size;

    public void addFirst(int data)
    {
        Node n1=new Node(data);
        size+=1;
        if(head==null)
        {
            head=tail=n1;
            return;
        }    
        n1.next=head;
        head=n1;
    }
    public void addLast(int data)
    {
        Node n1= new Node(data);
        size+=1;
        if(head==null)
        {
            head=tail=n1;
        }       
        tail.next=n1;
        tail=n1;      
    }

    public void addInMiddle(int data, int idx)
    {
        Node n1=new Node(data);
        size+=1;
        Node temp=head;
        int i=0;
        while(i>idx-1)
        {
            temp=temp.next;
            i--;
        }
        n1.next=temp.next;
        temp.next=n1;
    }

    public int removeFirst()
    {
        if(size==0)
        {
            return -1;
        }
        else if(size==1)
        {
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public void reverse()
    {
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;           
        }
        head=prev;
    }

    public Node reverserecur(Node head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }

        Node chotahead=reverserecur(head.next);

        System.out.println("Head abhi "+head.data);
        System.out.println("Head ka next "+head.next.data);
        head.next.next=head;
        head.next=null;
        return chotahead;
    }

    public Node reversekgroup(Node head , int k)
    {
        if(head==null)
        {
            return null;
        }
        Node prev=null;
        Node curr=head;
        Node next;
        int count=k;
        while(curr!=null && count>0)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count--;
        }

        head.next=reversekgroup(curr, k);
        
        return prev;
    }

    public static Node findmid()
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public void display(Node head)
    {
        Node ptr=head;
        while(ptr!=null)
        {
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
    }

    public void printrec(Node head)
    {
        if(head.next==null)
        {
            System.out.print(head.data);
            return;
        }

        System.out.print(head.data+"->");
        printrec(head.next);
    }

    public void printKthnodefromendrec(Node head,ArrayList<Integer> al)
    {
        if(head==null)
        {
            return;
        }
        printKthnodefromendrec(head.next,al);
        int k=al.get(0);
        k--;
        if(k==0)
        {
            System.out.println("K-th Node from the end is "+head.data);
        }
        al.set(0,k);
        
    }

    public static void main(String[] args) {
        LinkedListCreation ll= new LinkedListCreation();
        Scanner sc= new Scanner(System.in);
        while(sc.hasNextInt())
        {
            int n= sc.nextInt();
            ll.addLast(n);
        }
         ll.printrec(head);
         System.out.println();
        //  ll.printrec(ll.reverserecur(head));
        ll.display(ll.reversekgroup(head,2));
        // ArrayList<Integer> al=new ArrayList<>();
        // al.add(3);
        // ll.printKthnodefromendrec(head,al);
        // ll.addInMiddle(99, 2);
        // System.out.println("Size is "+ size);
        // ll.display(head);
        // System.out.println("Former Head =" +ll.removeFirst());
        // ll.reverse();
        // System.out.println();
        // System.out.println("Size is "+ size);
        // System.out.println("Middle = "+ findmid().data);
        // ll.display(head);
    }
}
