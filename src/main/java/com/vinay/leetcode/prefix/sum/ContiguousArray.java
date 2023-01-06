package com.vinay.leetcode.prefix.sum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    private Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {
        int sum = 0;
        int maxLength = 0;
        map.put(0, -1);
        for (int i=0;i< nums.length;i++){
            sum += nums[i] == 1?1:-1;
            Integer value = map.get(sum) ;
            if (value != null){
                maxLength = Math.max(maxLength, i- value);
            }else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
