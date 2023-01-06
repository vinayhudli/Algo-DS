package com.vinay.leetcode.studyplan.questions;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[]{-1,0,3,5,9,12}, 9));
    }

    public int search(int[] nums, int target){
        int currentIndex = (nums.length-1)/2;
        int low = 0;
        int high = nums.length-1;
        while (currentIndex <= high && currentIndex >= low){
            if (nums[currentIndex] == target)
                return currentIndex;
            else if(nums[currentIndex] < target)
                low = currentIndex+1;
            else
                high = currentIndex-1;

            currentIndex = (low+high)/2;

        }
        return -1;
    }

}
