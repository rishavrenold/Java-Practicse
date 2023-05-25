package _1DArray;
public class SlidingWindow {
    public static int maxsumwithslidingwindow(int arr[],int windowsize)
    {
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<windowsize;i++)
        {
            currsum+=arr[i];
        }
        maxsum=currsum;
        int tempsum=currsum;
        for(int i=windowsize;i<arr.length;i++)
        {
            tempsum=tempsum+arr[i]-arr[i-windowsize];
            maxsum=Math.max(maxsum,tempsum);
        }
        return maxsum;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,5,6,7};
        int windowsize=4;
        int res=maxsumwithslidingwindow(arr,windowsize);
        System.out.println("Maximum sum = "+res);
    }
}
