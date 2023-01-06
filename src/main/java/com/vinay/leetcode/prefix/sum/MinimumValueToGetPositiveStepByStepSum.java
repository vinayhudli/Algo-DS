package com.vinay.leetcode.prefix.sum;

public class MinimumValueToGetPositiveStepByStepSum {

    public static void main(String[] args) {
        MinimumValueToGetPositiveStepByStepSum minimumValueToGetPositiveStepByStepSum = new MinimumValueToGetPositiveStepByStepSum();
        System.out.println(minimumValueToGetPositiveStepByStepSum.minStartValue(new int[]{1,2,3}));
    }

    public int minStartValue(int[] nums) {
        int leastNum = 1;
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            leastNum = Math.min(leastNum, sum);
        }
        if (leastNum == 0)
            leastNum = 1;
        else if(leastNum < 0)
            leastNum = leastNum*-1+1;
        return leastNum;
    }
}
