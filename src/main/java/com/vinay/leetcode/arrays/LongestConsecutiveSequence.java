package com.vinay.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
// Whenever a new number is added to the list consider it as joining 2 different contiguous lists,
// so updating the extremes of the list with the updated count will do the job
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i=0;i< nums.length;i++){
            if (map.containsKey(nums[i]))
                continue;

            int preCnt = map.getOrDefault(nums[i] - 1, 0);
            int nextCnt = map.getOrDefault(nums[i]+1, 0);

            int count = 1+preCnt+nextCnt;
            if (preCnt>0){
//                update series length in the first number of series
                map.put(nums[i]-preCnt, count);
            }

            if (nextCnt>0){
//                update series length in the last number of series
                map.put(nums[i]+nextCnt, count);
            }
            map.put(nums[i], count);
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }

//  this is O(n2) actually , not a good solution
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;
        for (int i=0;i< nums.length;i++){
            if (set.contains(nums[i]))
                continue;

            int count = 0;
            int lesserNum = nums[i]-1;
            while (set.contains(lesserNum)){
                count++;
                lesserNum--;
            }

            int higherNum = nums[i]+1;
            while (set.contains(higherNum)){
                count++;
                higherNum++;
            }
            set.add(nums[i]);
            maxLength = Math.max(maxLength, count+1);
        }
        return maxLength;
    }
}
