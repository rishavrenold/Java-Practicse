import java.util.Scanner;

public class IsArraySorted {

    public static boolean isSorted(int arr[], int idx)
    {
        if(idx==arr.length)
        {
            return true;
        }

        if(arr[idx]<arr[idx-1])
        {
            return false;
        }

        return isSorted(arr,idx+1);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        if(isSorted(arr,1))
        {
            System.out.println("is Sorted");
        }
        else
        {
            System.out.println("Not Sorted");
        }
    }

}
