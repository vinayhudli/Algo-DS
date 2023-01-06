package com.vinay.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFirstAndLastPosition {

    public static void main(String[] args) {
        FindFirstAndLastPosition findFirstAndLastPosition = new FindFirstAndLastPosition();
        int[] ints = findFirstAndLastPosition.searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3);
        System.out.println(ints[0]+"-"+ints[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        List<Integer> integers = searchInPos(nums, target, 0, nums.length - 1);
        if (integers.isEmpty())
            return new int[]{-1, -1};

        return new int[]{integers.get(0), integers.get(1)};
    }

    private ArrayList<Integer> searchInPos(int[] nums, int target, int low, int high){
        if (low > high)
            return new ArrayList<>(0);;

        if (low == high){
            if (nums[low] == target){
                ArrayList<Integer> result = new ArrayList<>(2);
                result.add(low);
                result.add(low);
                return result;
            }else {
                return new ArrayList<>(0);
            }
        }

        if (nums[low]>target || nums[high]<target)
            return new ArrayList<>(0);

        int mid = (low+high)/2;
        ArrayList<Integer> lower = new ArrayList<>(2);
        ArrayList<Integer> higher = new ArrayList<>(2);
        if (nums[mid] == target){
             lower = searchInPos(nums, target, low, mid-1);
             higher = searchInPos(nums, target, mid+1, high);
             if (lower.isEmpty()){
                 lower.add(mid);
             }
            lower.add(1, mid);

        }else if(nums[mid] > target){
            lower = searchInPos(nums, target, low, mid-1);
        }else {
            higher = searchInPos(nums, target, mid+1, high);
        }
        return merge(lower, higher);
    }

    private ArrayList<Integer> merge(ArrayList<Integer> lower, ArrayList<Integer> higher){
        if (higher.isEmpty())
            return lower;
        else if (lower.isEmpty())
            return higher;
        ArrayList<Integer> result = new ArrayList<>(2);
        result.add(lower.get(0));
        result.add(higher.get(1));
        return result;
    }
}
