package com.vinay.leetcode;

import java.math.BigDecimal;
import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
//        CoinChange coinChange = new CoinChange();
//        System.out.println(coinChange.coinChange(new int[]{1}, 0));
        int testInt = 15;
        BigDecimal test = new BigDecimal(.1543);
        System.out.println(BigDecimal.valueOf((double) testInt/100));
        System.out.println(test.doubleValue());
        System.out.println(test);
        System.out.println(test.compareTo(BigDecimal.valueOf((double) testInt/100)));
        double test1 = 0.0;
        double test2 = (double) 0/ 100;
        System.out.println(test1<=test2);
    }

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length+1];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        for (int i=0;i<coins.length;i++){
            int rem = amount - coins[i];
            int cnt = topdownRecursive(coins, rem);
            min = Math.min(cnt, min);
        }
        return topdownRecursive(coins, amount);
    }

    int[] dp;
    private int topdownRecursive(int[] coins, int amount){
        if (amount < 0)
            return -1;
        else if (dp[amount] < Integer.MAX_VALUE)
            return dp[amount];

        int min = Integer.MAX_VALUE;
        for (int i=0;i<coins.length;i++){
            int rem = amount - coins[i];
            int cnt = topdownRecursive(coins, rem);
            if (cnt > -1)
                min = Math.min(cnt+1, min);
        }
        dp[amount] = min;
        return -1;
    }
}
