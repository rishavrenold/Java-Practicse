package DP;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    public static int solve(String str, int left, int right, int dp[][])
    {
        if(left>=right)
        {
            return 1;
        }
        if(dp[left][right]!=-1)
        {
            return dp[left][right];
        }

        if(str.charAt(left)==str.charAt(right))
        {
            return dp[left][right]=solve(str, left+1, right-1, dp);
        }
        return dp[left][right]=0;

    }

    public static void main(String[] args) {
        String str="abbac";
        int maxlen=Integer.MIN_VALUE;
        int startidx=-1;
        int dp[][]=new int[str.length()][str.length()];
        for(int d[]:dp)
        {
            Arrays.fill(d,-1);
        }
        for(int i=0;i<str.length();i++)
        {
            for(int j=i;j<str.length();j++)
            {
                if(solve(str,i,j,dp)==1)
                {
                    if(j-i+1>maxlen)
                    {
                        maxlen=j-i+1;
                        startidx=i;
                    }
                }
            }
        }
        System.out.println(str.substring(startidx,startidx + maxlen));
    }
}