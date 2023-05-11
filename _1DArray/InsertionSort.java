package _1DArray;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[]= {4,7,9,6,3};
        int n=arr.length;
        for(int i=1;i<n;i++)
        {
            int currval=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]>currval)
            {
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=currval;
        }

        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
