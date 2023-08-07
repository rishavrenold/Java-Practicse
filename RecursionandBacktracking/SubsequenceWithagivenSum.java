import java.util.*;

public class SubsequenceWithagivenSum {

    public static void getsumsubsequence(int arr[],int idx,int sum,int ssf,ArrayList<Integer> al)
    {
        if(idx==arr.length)
        {
            if(ssf==sum)
            {
                System.out.println(al);
            }
            return;
        }
        // either we can update the sum so far value before calling or
        //  it should be passed in parameter
        // ssf+=arr[idx];
        al.add(arr[idx]);
        getsumsubsequence(arr, idx+1, sum, ssf+arr[idx], al);        
        // ssf-=arr[idx];
        al.remove(al.size()-1);
        getsumsubsequence(arr, idx+1, sum, ssf, al);
        
    }
    // only print the first subsequence 
    public static boolean getsumsubsequence2(int arr[],int idx,int sum,int ssf,ArrayList<Integer> al)
    {
        if(idx==arr.length)
        {
            if(ssf==sum)
            {
                System.out.println(al);
                return true;
            }
            return false;
        }

        ssf+=arr[idx];
        al.add(arr[idx]);
        if(getsumsubsequence2(arr, idx+1, sum, ssf, al))
             return true;
        ssf-=arr[idx];
        al.remove(al.size()-1);
        if( getsumsubsequence2(arr, idx+1, sum, ssf, al))
            return true;
       
        return false;
        
    }
    // count the number of subsequence
    public static int getsumsubsequence3(int arr[],int idx,int sum,int ssf,ArrayList<Integer> al)
    {
        if(idx==arr.length)
        {
            if(ssf==sum)
            {
                // System.out.println(al);
                return 1;
            }
            return 0;
        }

        ssf+=arr[idx];
        al.add(arr[idx]);
        int yescall= getsumsubsequence3(arr, idx+1, sum, ssf, al);
        ssf-=arr[idx];
        al.remove(al.size()-1);
        int nocall= getsumsubsequence3(arr, idx+1, sum, ssf, al);
           
       
        return yescall+nocall;
        
    }
    public static void main(String[] args) {
        int arr[]={1,2,1};
        int sum=2;
        //  getsumsubsequence(arr,0,sum,0, new ArrayList<Integer>());
        // getsumsubsequence2(arr,0,sum,0, new ArrayList<Integer>());
        int total=getsumsubsequence3(arr,0,sum,0, new ArrayList<Integer>());
        System.out.println("Total subsequence with the given sum = "+total);
    }
}
