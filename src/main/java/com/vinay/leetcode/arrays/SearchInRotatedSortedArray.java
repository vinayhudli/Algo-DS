package com.vinay.leetcode.arrays;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(new int[]{1}, 1));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1){
            if (nums[0] == target)
                return 0;
            return -1;
        }
        int pivotIndex = getPivotPoint(nums);
        pivotIndex = pivotIndex > -1?pivotIndex:0;
        int low = pivotIndex;
        int high = nums.length-1;
        if (target > nums[high]){
            low = 0;
            high = pivotIndex;
        }
        return binarySearch(nums, low, high, target);
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while (low<=high){
            int mid = (low+high)/2;
            if (nums[mid] ==  target)
                return mid;
            else if (nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }

    private int getPivotPoint(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int pivotIndex = -1;
        while (low <= high){
            int mid = (low+high)/2;
            if (nums[mid] <= nums[nums.length-1]){
                high = mid-1;
                pivotIndex = mid;
            }else {
                low = mid+1;
            }
        }
        return pivotIndex;
    }
}
