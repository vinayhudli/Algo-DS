package com.vinay.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> permute = permutations.permute(new int[]{0});
        for (int i=0;i< permute.size();i++){
            System.out.println("new entry");
            List<Integer> integers = permute.get(i);
            for (int j=0;j< integers.size();j++){
                System.out.println(integers.get(j));
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        iterateAndAdd(nums, new HashSet<>(), new ArrayList<>());
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    private void iterateAndAdd(int[] nums, Set<Integer> set, List<Integer> currentList){
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i=0;i< nums.length;i++){
            if (set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            currentList.add(nums[i]);
            iterateAndAdd(nums, set, currentList);
            currentList.remove(currentList.size()-1);
            set.remove(nums[i]);
        }
    }
}
