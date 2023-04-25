package com.vinay.leetcode.arrays;

import java.util.*;

/*
https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] kFrequent = topKFrequentElements.topKFrequent(new int[]{1, 3, 2, 1, 2, 1,2,3,3}, 2);
        for (int i=0;i< kFrequent.length;i++){
            System.out.println(kFrequent[i]);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i< nums.length;i++)
            map.compute(nums[i], (key,v)-> v == null?1:v+1);

        List<Integer>[] countToNums = new LinkedList[nums.length+1];
        map.forEach((key, v)->{
            if (countToNums[v] == null)
                countToNums[v] = new LinkedList<>();
            countToNums[v].add(key);
        });
        int[] result = new int[k];
        for (int i=0, j=countToNums.length-1;i<k && j>=0;){
                while (countToNums[j] != null && !countToNums[j].isEmpty() && i<k){
                result[i] = countToNums[j].remove(0);
                i++;
            }
            j--;
        }
        return result;
    }
}
