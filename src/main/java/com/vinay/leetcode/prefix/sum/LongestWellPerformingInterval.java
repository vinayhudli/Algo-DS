package com.vinay.leetcode.prefix.sum;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval {

    public static void main(String[] args) {
        LongestWellPerformingInterval longestWellPerformingInterval = new LongestWellPerformingInterval();
        System.out.println(longestWellPerformingInterval.longestWPI(new int[]{9,6,6}));
    }

    public int longestWPI(int[] hours) {
        int[] sum = new int[hours.length];
        sum[0] = hours[0]>8?1:-1;
        Map<Integer, Integer> sumToFirstIndex = new HashMap<>();
        sumToFirstIndex.put(sum[0], 0);
        int longestWPI = sum[0]>0?1:0;
        for (int i=1;i< hours.length;i++){
            sum[i] = hours[i]>8?1:-1;
            sum[i] += sum[i-1];
            sumToFirstIndex.putIfAbsent(sum[i], i);
            int lessThanOne = sumToFirstIndex.getOrDefault(sum[i]-1, i);
            longestWPI = Math.max(i-lessThanOne, longestWPI);
            if (sum[i]>0){
                longestWPI = Math.max(longestWPI, i+1);
            }
        }

        return longestWPI;
    }
}
