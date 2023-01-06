package com.vinay.leetcode.arrays;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int minTillNow = prices[0];
        int maxDifference = 0;
        for (int i=0;i< prices.length;i++){
            maxDifference = Math.max(maxDifference, prices[i]-minTillNow);
            minTillNow = Math.min(minTillNow, prices[i]);
        }

        return maxDifference;
    }
}
