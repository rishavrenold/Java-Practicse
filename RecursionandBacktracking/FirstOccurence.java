/**
 * FirstOccurence
 */
import java.util.*;
public class FirstOccurence {

    public static int firstocc(int arr[], int idx,int digit)
    {
        if(idx==arr.length)
        {
            return -1;
        }
        if(arr[idx]==digit)
        {
            return idx;
        }
        idx=firstocc(arr, idx+1, digit);
        return idx;
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
        int idx=firstocc(arr,0,x);
        System.out.println(idx==-1?"Not found":idx+1);
    }
}