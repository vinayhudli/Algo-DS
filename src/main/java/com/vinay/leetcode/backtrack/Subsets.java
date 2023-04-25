package com.vinay.leetcode.backtrack;

/*
https://leetcode.com/problems/subsets/
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(new int[]{1,2,3});
        subsets1.forEach(list->{
            list.forEach(System.out::println);
            System.out.println("new list");
        });
    }

//    backtracking solution
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backtrackingSolution(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrackingSolution(List<List<Integer>> result, List<Integer> currentList, int[] nums, int index){
        for (int i=index;i< nums.length;i++){
            currentList.add(nums[i]);
            result.add(new ArrayList<>(currentList));
            backtrackingSolution(result, currentList, nums, i+1);
            currentList.remove(currentList.size()-1);
        }
    }

//    iterative solution
    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i=0;i< nums.length;i++){
            List<List<Integer>> temp = new ArrayList<>();
            List<Integer> subTemp = new ArrayList<>();
            subTemp.add(nums[i]);
            temp.add(subTemp);
            appendElementToEachList(temp, i+1, nums);
            result.addAll(temp);
        }
        return result;
    }

    private void appendElementToEachList(List<List<Integer>> subset, int index, int[] nums){
        if (index == nums.length)
            return;
        List<List<Integer>> newSubSets = new ArrayList<>();
        for (List<Integer> list:subset){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(nums[index]);
            newSubSets.add(temp);
        }
        subset.addAll(newSubSets);
        appendElementToEachList(subset, index+1, nums);
    }
}
