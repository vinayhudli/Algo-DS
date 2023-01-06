package com.vinay.leetcode.twopointer;

public class SortColors {

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] test = new int[]{0};
        sortColors.sortColors(test);
        for (int i=0;i< test.length;i++)
            System.out.println(test[i]);
    }

    public void sortColorsMySoln(int[] nums) {
        if (nums.length == 1)
            return;
        int numRed = 0;
        int numWhite = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] == 0) {
                numRed++;
            } else if (nums[i] == 1) {
                numWhite++;
            }
        }
        
        for (int i=0;i<nums.length;i++){
            if (numRed > 0) {
                nums[i] = 0;
                numRed--;
            } else if (numWhite > 0) {
                nums[i] = 1;
                numWhite--;
            }else {
                nums[i] = 2;
            }
        }
    }

    public void sortColors(int[] nums){
        if (nums.length == 1)
            return;
        int numsRed = 0, numsWhite = 0, numsBlue = nums.length-1;
        while (numsWhite <= numsBlue){
            if (nums[numsWhite] == 0){
                int temp = nums[numsRed];
                nums[numsRed] = nums[numsWhite];
                nums[numsWhite] = temp;
                numsRed++;
                numsWhite++;
            } else if (nums[numsWhite] == 1) {
                numsWhite++ ;
            }else {
                int temp = nums[numsBlue];
                nums[numsBlue] = nums[numsWhite];
                nums[numsWhite] = temp;
                numsBlue--;
            }
        }
    }
}
