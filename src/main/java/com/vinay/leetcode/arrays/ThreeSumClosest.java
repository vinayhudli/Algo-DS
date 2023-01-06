package com.vinay.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(new int[]{-100,-98,-2,-1}, -101));
    }

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        List<Integer> closestSum = getClosestSum(3, target, nums, 0);
        return closestSum.get(0);
    }

    private List<Integer> getClosestSum(int noOfOperands, int target, int [] nums, int start){
        if (noOfOperands > 2) {
            int index = start;
            Integer minDiff = null;
            Integer minDiffSum = null;
            Integer prevDiff = null;
            while (index+noOfOperands-1< nums.length){
                if (minDiff != null && nums[index] == nums[index-1]){
                    index++;
                    continue;
                }

                List<Integer> closestSum = getClosestSum(noOfOperands - 1, target - nums[index], nums, index + 1);
                if(minDiff == null) {
                    minDiff = closestSum.get(1);
                    minDiffSum = nums[index]+closestSum.get(0);
                }

                if (minDiff > closestSum.get(1)) {
                    minDiff = closestSum.get(1);
                    minDiffSum = nums[index]+closestSum.get(0);
                }
                index++;
            }
            List<Integer> result = new ArrayList<>();
            result.add(minDiffSum);
            result.add(minDiff);
            return  result;
        }

        return twoPointer(nums, start, nums.length-1, target);
    }

    private List<Integer> twoPointer(int[] nums, int low, int high, int num){
        Integer minDiff = null;
        int sum = 0;
        int start = low, end = high;

        while (start < end){
            int diff = Math.abs(num - nums[start] - nums[end]) ;
            if (minDiff == null){
                minDiff = diff;
                sum = nums[start] + nums[end];
            }

            if (diff < minDiff){
                minDiff = diff;
                sum = nums[start] + nums[end];
            }
            if(num > nums[start]+nums[end]){
                start++;
            }else{
                end--;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(sum);
        result.add(minDiff);
        return result;
    }

    /**
     *
     * @param nums
     * @param low
     * @param high
     * @param num
     * @return list containing index from nums with lowest diff in 0th index and the absolute value of diff itself in 1 index
     */
    private List<Integer> findClosestNum(int[] nums, int low, int high, int num){
        if (low > high)
            return null;

        int mid = (low+high)/2;
        int midDiff = Math.abs(num-nums[mid]);
        List<Integer> result = null ;
        if (num >= nums[high]){
            result = new ArrayList<>() ;
            result.add(nums[high]);
            result.add(Math.abs(num-nums[high]));
        }else if (num <= nums[low]){
            result = new ArrayList<>() ;
            result.add(nums[low]);
            result.add(Math.abs(num-nums[low]));
        }else if (num > nums[mid]){
            result = findClosestNum(nums, mid+1, high, num) ;
        }else if (num<nums[mid]){
            result = findClosestNum(nums, low, mid-1, num) ;
        }

        if (result == null || midDiff < result.get(1)){
            result = new ArrayList<>() ;
            result.add(nums[mid]);
            result.add(midDiff);
        }

        return result;
    }
}
