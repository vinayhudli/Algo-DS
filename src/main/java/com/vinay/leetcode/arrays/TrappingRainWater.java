package com.vinay.leetcode.arrays;

/**
 * 42. Trapping Rain Water
 * This solution is borrowed from https://www.geeksforgeeks.org/trapping-rain-water/ 2 pointer approach
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int low = 0;
        int high = height.length-1;
        int totalWater = 0;
        while (low<=high){
            if (height[low]<height[high]){
                leftMax = Math.max(leftMax, height[low]);
                totalWater += leftMax-height[low];
                low++;
            }else{
                rightMax = Math.max(rightMax, height[high]);
                totalWater += rightMax-height[high];
                high--;
            }
        }
        return totalWater;
    }


}
