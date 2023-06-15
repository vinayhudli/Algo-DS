package com.vinay.leetcode.binarysearch;

/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        System.out.println(findMinimumInRotatedSortedArray.findMin(new int[]{13,15,17,11}));
    }

    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE, low = 0, high = nums.length-1;
        int lastElement = nums[nums.length-1];
        while (low<=high){
            int mid = (low+high)/2;
            if (nums[mid]<=lastElement){
                min = nums[mid];
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return min;
    }
}
