package RecursionandBacktracking;

import java.util.*;


/**
 * Subset78
 */
public class Subset78 {

//    forming ans on the way down the recursion call 
    public static List<List<Integer>> subsets(int[] nums,int idx) {
    if(idx==nums.length)
    {
        List<List<Integer>> temp= new ArrayList<>();
        ArrayList<Integer> t= new ArrayList<>();
        temp.add(t);
        return temp;
    }
    List<List<Integer>> rres= new ArrayList<>();
    List<List<Integer>> noincludecall=subsets(nums, idx+1);
    for(List<Integer> ll:noincludecall)
    {
        rres.add(ll);
    }

    List<List<Integer>> includecall=subsets(nums, idx+1);
    for(List<Integer> ll:includecall)
    {
        ll.add(0,nums[idx]);
        rres.add(ll);
    }
    
     return rres;        
    }

    

//forming ans on the way up 
public static ArrayList<ArrayList<Integer>> f=new ArrayList<>();
public static void subsets2(int[] nums,int idx,ArrayList<Integer> temp2) {
    if(idx==nums.length)
    {
        f.add(temp2);
        return;
    }   
    temp2.add(nums[idx]);
    subsets2(nums, idx+1,temp2);
    temp2.remove(temp2.size()-1);
    subsets2(nums, idx+1,temp2);
 
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(subsets(arr,0));
        subsets2(arr, n,new ArrayList<Integer>());
    }
}