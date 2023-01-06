package com.vinay.leetcode.dp;

import java.util.Arrays;

public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray maximumLengthOfRepeatedSubarray = new MaximumLengthOfRepeatedSubarray();
        System.out.println(maximumLengthOfRepeatedSubarray.findLength(new int[]{0,0,0,0}, new int[]{0,0,0,0,0,0}));
    }


    public int findLength(int[] nums1, int[] nums2) {
        int maxLength = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i=0;i< nums1.length;i++){
            for (int j=0;j< nums2.length;j++)
                dp[i][j] = 0;
        }
//        findMaxLength(dp, nums1, 0, nums2, 0);
//        bottom up approach
        for (int i=0;i< nums1.length;i++){
            for (int j=0;j< nums2.length;j++){
                int matchCount = 0;
                if (nums1[i] == nums2[j]){
                    if (i==0 || j==0)
                        matchCount = 1;
                    else
                        matchCount = dp[i-1][j-1] + 1;
                }
                dp[i][j] = matchCount;
                maxLength = Math.max(maxLength, matchCount);
            }
        }
        return maxLength;
    }

    private void findMaxLength(int[][] dp, int[] nums1, int nums1Idx, int[] nums2, int nums2Idx){
        if (nums1Idx == nums1.length || nums2Idx == nums2.length || dp[nums1Idx][nums2Idx] != -1)
            return;

        findMaxLength(dp, nums1, nums1Idx+1, nums2, nums2Idx);
        findMaxLength(dp, nums1, nums1Idx, nums2, nums2Idx+1);
        findMaxLength(dp, nums1, nums1Idx+1, nums2, nums2Idx+1);
        int previous = 0;
        if (nums1[nums1Idx] == nums2[nums2Idx]){
            if (nums1Idx+1 < nums1.length && nums2Idx+1 < nums2.length)
                previous = dp[nums1Idx+1][nums2Idx+1]+1;
            else
                previous++;
        }
        dp[nums1Idx][nums2Idx] = previous;
//        maxLength = Math.max(maxLength, previous);
    }
}
