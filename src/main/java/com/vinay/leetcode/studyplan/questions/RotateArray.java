package com.vinay.leetcode.studyplan.questions;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(new int[]{-1,-100,3,99}, 2);
    }

    //TODO: rotate by block swap
    public void rotate(int[] nums, int k) {

    }

    public void rotateByTempArray(int[] nums, int k) {
        int[] temp = new int[nums.length] ;
        for (int i=0;i< nums.length;i++){
            temp[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int index = (i+k)% nums.length;
            nums[index] = temp[i];
        }

    }

    public int[] rotateByOne(int[] nums){
        int num = nums[0];
        for (int i=1;i< nums.length;i++){
            int newNum = nums[i];
            nums[i] = num;
            num = newNum;
        }
        nums[0] = num;

//        for (int i=0;i<nums.length;i++){
//            System.out.println(nums[i]);
//        }
        return nums;
    }
}
