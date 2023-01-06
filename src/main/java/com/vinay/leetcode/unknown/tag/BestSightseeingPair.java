package com.vinay.leetcode.unknown.tag;

public class BestSightseeingPair {

    public static void main(String[] args) {
        BestSightseeingPair bestSightseeingPair = new BestSightseeingPair();
        System.out.println(bestSightseeingPair.maxScoreSightseeingPair(new int[]{1,2}));
    }

    /**
     * This method is interesting
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int i = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int j=1;j<values.length;j++){
            int currentValue = values[i]+i+values[j]-j;
            maxValue = Math.max(maxValue, currentValue);
            if(values[i]+i<values[j]+j){
                i = j;
            }
        }
        return maxValue;
    }

    private int getMaxSum(int index, int[] valueSubIndex, int val){
        int maxSum = val + valueSubIndex[index];
        for (int i=index+1;i<valueSubIndex.length;i++){
            maxSum = Math.max(maxSum, val+valueSubIndex[i]);
        }
        return maxSum;
    }


}
