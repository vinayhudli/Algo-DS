package com.vinay.leetcode.arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{2,1}));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i=0;i< nums.length;i++){
            int num = nums[i];
            while (num > 0 && num <= nums.length && num!=nums[num-1]){
                int temp = nums[num-1];
                nums[num-1] = num;
                num = temp;
            }
        }

        for (int i =0;i< nums.length;i++){
            if (nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }
}
