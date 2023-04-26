package com.vinay.leetcode.twopointer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{3,3}, 6);
        System.out.println(ints[0]+"-"+ints[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        int[] result = new int[2];
        for (int i=0;i< nums.length;i++){
            int diff = target-nums[i];
            if (valueToIndex.containsKey(diff)){
                result[0] = i;
                result[1] = valueToIndex.get(diff);
                break;
            }
            valueToIndex.put(nums[i], i);
        }
        return result;
    }
}
