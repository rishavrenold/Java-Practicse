import java.util.*;

public class LastOccurence {

    static int lastidx;

    public static int lastocc(int arr[], int idx,int digit)
    {
        if(idx==arr.length)
        {
            return -1;
        }
        lastidx =lastocc(arr, idx+1, digit);
        if(arr[idx]==digit)
        {
            lastidx=Math.max(idx, lastidx);
        }
        return lastidx;
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
        int idx=lastocc(arr,0,x);
        System.out.println(idx==-1?"Not found":idx+1);
    }
}
