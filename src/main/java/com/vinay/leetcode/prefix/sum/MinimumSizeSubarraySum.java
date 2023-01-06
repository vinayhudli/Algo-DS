package com.vinay.leetcode.prefix.sum;

public class MinimumSizeSubarraySum {

//    This is sliding window approach to the problem
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right=0;
        int length = Integer.MAX_VALUE;
        int sum = 0;
        while (right< nums.length){
            sum += nums[right];
            while (sum >= target){
                length = Math.min(length, right+1-left);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return length == Integer.MAX_VALUE?0:length;
    }

}
