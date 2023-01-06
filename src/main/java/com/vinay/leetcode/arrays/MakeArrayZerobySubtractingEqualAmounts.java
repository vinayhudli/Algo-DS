package com.vinay.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeArrayZerobySubtractingEqualAmounts {


    public int minimumOperations(int[] nums) {
        if (nums.length == 1)
            return nums[0] == 0?0:1;

        Arrays.sort(nums);
        int cntOfUniqueNum = 0;
        int previousElement = -1;
        for (int i=0;i<nums.length;i++){
            if (nums[i] != previousElement && nums[i] > 0){
                cntOfUniqueNum++;
                previousElement = nums[i];
            }
        }
        return cntOfUniqueNum;
    }

    public int minimumOperationsAlternate(int[] nums) {
        if (nums.length == 1)
            return nums[0] == 0?0:1;

        byte[] occurence = new byte[101];
        int cnt = 0;
        for (int e:nums){
            if (e != 0 && occurence[e] == 0)
                cnt++;
            occurence[e]++;
        }
        return cnt;
    }
}
