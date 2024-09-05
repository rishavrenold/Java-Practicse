package BinarySearch;

public class PainterPartition {
    public static boolean check(int arr[],int time,int k)
    {
        int timeleft=0;
        int workersneed=0;
        for(int i=0;i<arr.length;i++)
        {
            if(timeleft>=arr[i])
            {
                timeleft-=arr[i];
            }else{
                timeleft=time;
                workersneed+=1;
                if(workersneed>k)
                {
                    return false;
                }
                if(timeleft>=arr[i])
                {
                    timeleft-=arr[i];
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static int partition(int arr[],int k)
    {
        int lo=0;
        int hi=0;
        for(int i=0;i<arr.length;i++)
        {
            hi+=arr[i];
        }
        int ans=-1;
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
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
        int arr[]={10, 20, 30, 40};
        int k=2;
        System.out.println(partition(arr,k));
    }
}
