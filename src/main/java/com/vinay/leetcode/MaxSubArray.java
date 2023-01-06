package com.vinay.leetcode;

/**
 * 53. Maximum Subarray
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(getMaxSubArray(new int[]{5,4,-1,7,8}));
    }

    public static int getMaxSubArray(int[] nums){
        int maxSum = nums[0] ;
        int currentSum = nums[0];
        int currentIndex = 0 ;

        for(int i=1;i<nums.length;i++){
            if(currentSum>0){
                if(currentSum+nums[i]>0 && currentIndex==i-1){
                    currentSum += nums[i] ;
                    currentIndex = i;
                }else if(currentIndex!=i-1){
                    currentSum = nums[i];
                    currentIndex = i;
                }
            }else{
                currentSum = nums[i];
                currentIndex = i;
            }

            if (currentSum > maxSum){
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}
