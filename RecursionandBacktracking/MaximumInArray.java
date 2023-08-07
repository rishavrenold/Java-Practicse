
import java.util.*;
public class MaximumInArray {

    public static int Maximum(int arr[],int idx,int maxi)
    {
        if(idx==arr.length)
        {
            return Integer.MIN_VALUE;
        }

        int ans= Maximum(arr,idx+1,maxi);

        if(arr[idx]>ans)
        {
            ans=arr[idx];
        }
        
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int maxi=Integer.MIN_VALUE;
        int res=Maximum(arr,0,maxi);
        System.out.println(res);
    }
}
