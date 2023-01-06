package com.vinay.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/4sum-ii/
public class FourSum2 {

    public static void main(String[] args) {
        FourSum2 fourSum2 = new FourSum2();
        System.out.println(fourSum2.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> set1 = new HashMap<>();
        int num1Cnt = 0, nums2Cnt=0, nums3Cnt=0,nums4Cnt=0;
        int result = 0;
        while (num1Cnt<nums1.length ){
            while (nums2Cnt<nums2.length){
                int sum = nums1[num1Cnt]+nums2[nums2Cnt] ;
                set1.compute(sum, (k,v)->v==null?1:v+1);
                nums2Cnt++;
            }
            nums2Cnt=0;
            num1Cnt++;
        }
        while (nums3Cnt<nums3.length ){
            while (nums4Cnt<nums4.length){
                int sum = -1*(nums3[nums3Cnt]+nums4[nums4Cnt]);
                result+= set1.getOrDefault(sum, 0);
                nums4Cnt++;
            }
            nums4Cnt=0;
            nums3Cnt++;
        }
        return result;
    }
}
