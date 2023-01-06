package com.vinay.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{0});
        for (List<Integer> list:lists){
            for (Integer i:list){
                System.out.println(i);
            }
            System.out.println("next list");
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int lowIndex, preLowIndex, highIndex, preHighIndex = -1 ;

        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i<nums.length-2;i++){
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            lowIndex = i+1;
            highIndex = nums.length-1;
            preHighIndex = -1; preLowIndex = -1;
            while (lowIndex<highIndex){
                if ((preHighIndex!=-1 && nums[preHighIndex]== nums[highIndex])){
                    highIndex--;
                    continue;
                }
                if (preLowIndex != -1 && nums[preLowIndex]==nums[lowIndex] ){
                    lowIndex++;
                    continue;
                }
                int sum = nums[i]+nums[lowIndex]+nums[highIndex];
                if (sum<0){
                    preLowIndex = lowIndex;
                    lowIndex++;
                }else if (sum>0){
                    preHighIndex = highIndex;
                    highIndex--;
                }else{
                    result.add(Arrays.asList(nums[i],nums[lowIndex],nums[highIndex]));
                    preHighIndex=highIndex;
                    preLowIndex=lowIndex;
                    lowIndex++;
                    highIndex--;
                }
            }
        }
        return result;
    }
}
