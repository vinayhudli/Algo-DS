package com.vinay.leetcode.arrays;

public class JumpGameII {

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(new int[]{1}));
    }

    public int jump(int[] nums) {
        int[] minJump = new int[nums.length];
        for (int i = nums.length-2; i>=0;i--){
            minJumps(nums, i, minJump);
        }
        return minJump[0];
    }

    private int minJumps(int[] nums, int currentPos, int[] minJump){
        if (currentPos == nums.length-1)
            return 0;
        else if (currentPos >= nums.length) {
            return Integer.MAX_VALUE;
        } else if (minJump[currentPos] != 0) {
            return minJump[currentPos];
        }

        int min = Integer.MAX_VALUE;
        for (int i=1;i<=nums[currentPos];i++){
            int jump = minJumps(nums, currentPos+i, minJump);
            min = Math.min(min, jump);
        }

        minJump[currentPos] = min;

        if (min != Integer.MAX_VALUE)
            minJump[currentPos]++;

        return minJump[currentPos];
    }


}
