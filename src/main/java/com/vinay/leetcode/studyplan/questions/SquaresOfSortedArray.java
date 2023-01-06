package com.vinay.leetcode.studyplan.questions;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
        int[] sortedSquares = squaresOfSortedArray.sortedSquares(new int[]{-4, -3, -2, 0, 0, 1, 10});
        for (int d:sortedSquares){
            System.out.println(d);
        }

    }

    public int[] sortedSquares(int[] nums) {
        int zeroIndex = findTheIndexForZero(nums);
        int[] result = new int[nums.length];
        int lowPointer = zeroIndex-1;
        int highIndex =  zeroIndex;
        int index = 0;
        while (index < result.length){
            if (lowPointer<0){
                result[index] = (int) Math.pow(nums[highIndex], 2);
                highIndex++;
            }else if (highIndex>= result.length){
                result[index] = (int) Math.pow(nums[lowPointer], 2);
                lowPointer--;
            }else {
                double lowSquare = Math.pow(nums[lowPointer], 2);
                double highSquare = Math.pow(nums[highIndex], 2);
                if (lowSquare < highSquare){
                    result[index] = (int) lowSquare;
                    lowPointer--;
                }else {
                    result[index] = (int) highSquare ;
                    highIndex++ ;
                }
            }
            index++;
        }
        return result;
    }

    public int findTheIndexForZero(int[] nums){
        int low = 0 ;
        int high = nums.length-1;

        while (low<=high){
            int mid = (low+high)/2 ;
            if (nums[mid] == 0)
                return mid;
            else if (nums[mid] > 0){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return high+1;
    }
}
