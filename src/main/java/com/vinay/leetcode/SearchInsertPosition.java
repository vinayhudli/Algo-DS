package com.vinay.leetcode;

public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,3,5,6}, 0));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int mid ;
        while (low <= high){
            mid = (low+high)/2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid]) {
                high = mid-1;
            }else
                low = mid+1;
        }

        return high+1;
    }
}
