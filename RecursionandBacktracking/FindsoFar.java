package RecursionandBacktracking;
import java.util.*;
public class FindsoFar 
{
    public static int[] occ(int arr[], int idx,int digit,int fsf)
    {
        if(idx==arr.length)
        {
            return new int[fsf];
        }
        if (arr[idx]==digit) {
            fsf+=1;
        }
        int temp[]=occ(arr, idx+1, digit,fsf);
        if(arr[idx]==digit)
        {
            temp[--fsf]=idx;
        }
        return temp;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements to be inserted ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the element to be found ");
        int x=sc.nextInt();
        int idx[]=occ(arr,0,x,0);
        for(int ii:idx)
        {
            System.out.println("The number "+x+" is present in "+ii+1);
        }
        
    }
}
