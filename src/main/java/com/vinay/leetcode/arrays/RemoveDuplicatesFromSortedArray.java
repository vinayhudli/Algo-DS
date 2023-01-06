package com.vinay.leetcode.arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] test = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(test));
        System.out.println("main method");
        for (int i=0;i< test.length;i++){
            System.out.println(test[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
            if (nums.length <= 1 )
                return nums.length;

            int nonRepeatingNumIndex = 1;
            for (int i=1;i<nums.length;i++){
                if (nums[i] == nums[i-1])
                    continue;
                nums[nonRepeatingNumIndex] = nums[i];
                nonRepeatingNumIndex++;
            }

            System.out.println("other method");
            for (int i=0;i< nums.length;i++){
                System.out.println(nums[i]);
            }
            return nonRepeatingNumIndex;
    }
}
