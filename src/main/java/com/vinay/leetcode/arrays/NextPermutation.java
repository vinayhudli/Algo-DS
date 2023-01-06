package com.vinay.leetcode.arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] test = new int[]{1,5,1};
        nextPermutation.nextPermutation(test);
        for (int i=0;i< test.length;i++){
            System.out.println(test[i]);
        }
    }

    public void nextPermutationMyMethod(int[] nums) {
        if (nums.length == 1)
            return;
        else if (nums.length == 2 &&  nums[0]<nums[1]){
            int temp = nums[1];
            nums[1] = nums[0];
            nums[0] = temp;
            return;
        }

        int maxVal = nums[nums.length-1];
        int index = -1;
        for (int i= nums.length-2;i>=0;i--){
            if (nums[i]<maxVal){
                index = i;
                break;
            }
            maxVal = nums[i];
        }
        if (index == -1){
            Arrays.sort(nums);
            return;
        }
        Arrays.sort(nums, index+1, nums.length);
        int replace = findSmallestLargeIndex(nums, index+1, nums[index]);
        int temp = nums[index];
        nums[index] = nums[replace];
        nums[replace] = temp;
    }

    private int findSmallestLargeIndex(int[] nums, int low, int val){
        int high = nums.length-1;

        while (low<=high){
            int mid = (low+high)/2;
            if (nums[mid]<=val){
                low = mid+1;
            }else
                high = mid-1;
        }
        return high+1;
    }

    /**
     * this is really fast, explanation is here: https://leetcode.com/problems/next-permutation/discuss/2102378/Fully-Explained-easily-understandable-with-comments-and-code
     * increasing subsequence
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        int i = nums.length-2;
        while (i>=0 && nums[i]>=nums[i+1]) i--;
        if (i>=0){
            int j = nums.length-1;
            while (nums[j]<=nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i){
        int j = nums.length-1;
        while (i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
