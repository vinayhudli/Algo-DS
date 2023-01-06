package com.vinay.leetcode.dp;

public class StoneGameIII {

    Integer[] dp;
    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length];
        int i = maxDiff(0, stoneValue);
        if (i!=0)
            return i>0?"Alice":"Bob";
        else
            return "Tie";
    }

    private int maxDiff(int i, int[] stoneValue){
        if (i == stoneValue.length)
            return 0;
        else if (dp[i] != null)
            return dp[i];

        int sum = 0;
        int maxDiff = Integer.MIN_VALUE;
        for (int idx = i;idx< stoneValue.length && idx<i+3;idx++){
            sum += stoneValue[idx];
            maxDiff = Math.max(maxDiff, sum-maxDiff(idx+1, stoneValue));
        }

        dp[i] = maxDiff;
        return maxDiff;
    }
}
