package com.vinay.leetcode.studyplan.questions;

import java.util.Map;

public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(new int[]{1},0));
    }

    public int firstAttemptSearchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high){
            int mid = (low+high)/2;
            if (target > nums[mid]){
                if ((mid<nums.length-1 && target<=nums[mid+1]) || mid == nums.length-1)
                    return mid+1;
                low = mid+1 ;
            }else if (target < nums[mid]){
                if (mid>0 && target>nums[mid-1])
                    return mid ;
                else if ((mid>0 && target==nums[mid-1]) || mid == 0)
                    return Math.max(mid-1, 0) ;

                high = mid-1;
            }else{
                return Math.max(mid, 0);
            }
        }
        return -1;
    }

    /**
     This approach is elegant, think of it that it will boil down to either :
     1> target being in the mid or
     2> not finding the target even when low and high are equal
     */
    public int searchInsert(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        return high+1;
    }
}
