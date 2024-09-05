package BinarySearch;

public class UpperBound {
    
    public static boolean check(int arr[],int mid,int k)
    {
        if(arr[mid]<=k)
        {
            return false;
        }else{
            return true;
        }
    }

    public static int upper_bound(int arr[],int k)
    {
        int lo=0;
        int hi=arr.length-1;
        int ans=-1;
        while(lo<=hi)
        {
            int mid = lo+((hi-lo)/2);
            if(check(arr,mid,k))
            {
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,4,5,6};
        int k=4;
        System.out.println(arr[upper_bound(arr,k)]);
    }
}
