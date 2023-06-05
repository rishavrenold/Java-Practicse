package RecursionandBacktracking;

public class PrintAscendingDescending {

    public static void  printAsc(int arr[],int idx)
    {
        if(idx==arr.length)
        {
            return;
        }
        System.out.print(arr[idx]+" ");
        printAsc(arr, idx+1);
    }

    public static void printDesc(int arr[],int idx)
    {
        if(idx==arr.length)
        {
            return;
        }
        printDesc(arr, idx+1);
        System.out.print(arr[idx]+" ");  
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        printDesc(arr,0);
    }
}
