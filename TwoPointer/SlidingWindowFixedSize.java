package TwoPointer;

public class SlidingWindowFixedSize {
    public static void main(String[] args) {
        int arr[]={1, 3, 2, 6, 4, 8, 5};
        int k=3;
        int sum=0;
        for(int i=0;i<k;i++)
        {
            sum+=arr[i];
        }
        System.out.println(sum);
        for(int i=k;i<arr.length;i++)
        {
            sum+=arr[i-k]+arr[i];
            System.out.println("Window"+(i-k+2)+":"+ sum);
        }
    }
}
