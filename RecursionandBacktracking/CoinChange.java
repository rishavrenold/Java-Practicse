public class CoinChange {
   public static int solve(int coins[],int amount,int mini,int dp[])
    {
        if(amount==0)
        {
            return dp[0]=0;
        }
        if(amount<0)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[amount]!=-1)
        {
            return dp[amount];
        }

        for(int i=0;i<coins.length;i++)
        {
            int ans=solve(coins,amount-coins[i],mini,dp);
            if(ans!=Integer.MAX_VALUE)
            {
                mini=Math.min(mini,ans+1);
            }
        }
        dp[amount]=mini;
        return mini;
    }

    public static int coinChange(int[] coins, int amount) {
        int dp[]= new int[amount+1];
        for(int i=0;i<dp.length;i++)
        {
            dp[i]=-1;
        }
        int ans=solve(coins,amount,Integer.MAX_VALUE,dp);
        if(ans==Integer.MAX_VALUE)
        {
            return -1;
        }
        else
        {
            return ans;
        }
    }

    public static void main(String[] args) {
        int coins[]={186,419,83,408};
        int amount=6249;
        System.out.println(coinChange(coins,amount));
    }
}
