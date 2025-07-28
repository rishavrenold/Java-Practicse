package DP;

public class ClimbingStairsWithMinMoves {
    public static void main(String[] args) {
        int arr[]={4,2,0,5,3,6};
        int n=arr.length;
        Integer dp[]=new Integer[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--)
        {
            if(arr[i]>0)
            {
                int mini=Integer.MAX_VALUE;
                for(int jump=1;jump<=arr[i] && i+jump<dp.length; jump++)
                {
                    if(dp[i+jump]!=null)
                    {
                        mini=Math.min(mini,dp[i+jump]);
                    }
                    if(mini!=Integer.MAX_VALUE)
                    {
                        dp[i]=mini+1;
                    }else{
                        dp[i]=null;
                    }
                }
            }
        }
        System.out.println(dp[0]);
    }
}
