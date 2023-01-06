package com.vinay.leetcode.sliding.window;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

    public int longestOnes(int[] nums, int k) {
        if (nums.length <= k)
            return nums.length;
        int leftmostZero = -1;
        int numOfConversions = 0;
        int index = 0;
        int maxLength = 0;
        int currentLength = 0;
        while (index<nums.length){
            if (nums[index] == 1) {
                currentLength++;
                index++;
            }else if(nums[index] == 0 && numOfConversions < k){
                currentLength++;
                numOfConversions++;
                leftmostZero = leftmostZero == -1?index:leftmostZero;
                index++;
            }else {
                maxLength = Math.max(currentLength,maxLength);
                if (index == nums.length-1)
                    break;
                index = leftmostZero == -1?index+1:leftmostZero+1;
                numOfConversions=0;
                currentLength = 0;
                leftmostZero = -1;
            }
        }
        maxLength = Math.max(currentLength,maxLength);
        return maxLength;
    }
}
