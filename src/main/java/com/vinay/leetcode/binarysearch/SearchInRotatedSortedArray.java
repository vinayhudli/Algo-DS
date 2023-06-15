package com.vinay.leetcode.binarysearch;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    /*
    Finding the point of rotation and then doing binary search
     */
    public int search(int[] nums, int target) {
        int smallestNumIndex = getMinElementIndex(nums);
        int low=0, high =nums.length-1;
        if (nums[high] < target)
            high = smallestNumIndex;
        else
            low = smallestNumIndex;

        while (low<=high){
            int mid = (low+high)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid]<target)
                low = mid+1;
            else
                high = mid -1;
        }
        return -1;
    }

    private int getMinElementIndex(int[] nums){
        int low=0, high = nums.length-1;
        int minIndex = 0;
        int lastElement = nums[nums.length-1];
        while (low <= high){
            int mid = (low+high)/2;
            if (nums[mid] <= lastElement){
                minIndex = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return minIndex;
    }
}
