package com.vinay.leetcode.studyplan.questions;

public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(new int[]{0,1,0,3,12});
    }

    public void moveZeroes(int[] nums) {
        int noOfZeros = 0 ;
        int indexToCopyTo = -1 ;

        for (int i=0;i< nums.length;i++){
            if (nums[i] != 0 && indexToCopyTo != -1){
                nums[indexToCopyTo] = nums[i];
                indexToCopyTo++;
            }else if (nums[i] == 0){
                noOfZeros++;
                if (indexToCopyTo == -1){
                    indexToCopyTo = i;
                }
            }
        }

        int index = nums.length-1;
        for (int i = noOfZeros; i>0;i--){
            nums[index] = 0;
            index--;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
