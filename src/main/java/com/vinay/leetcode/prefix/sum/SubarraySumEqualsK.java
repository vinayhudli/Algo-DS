package com.vinay.leetcode.prefix.sum;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(new int[]{1,2,3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> maintainSum = new HashMap<>();
        int sum = 0 ;
        int count = 0;
        for (int i =0;i< nums.length;i++){
            sum += nums[i];
            if (sum == k)
                count++;

            int finalSum = sum;
            count += maintainSum.getOrDefault(sum-k, 0);
            maintainSum.compute(sum, (key, value)->{
                int val = maintainSum.getOrDefault(finalSum, 0);
                val++;
                return val;
            });
        }
        return count;
    }
}
