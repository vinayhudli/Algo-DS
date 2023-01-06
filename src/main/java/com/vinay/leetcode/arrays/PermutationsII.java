package com.vinay.leetcode.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. Permutations II
 * good explanation here: https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/47_permutations_ii_medium.html
 */
public class PermutationsII {

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        List<List<Integer>> lists = permutationsII.permuteUnique(new int[]{1, 2, 3});
        for (int i =0;i< lists.size();i++){
            System.out.println("new entry");
            List<Integer> integers = lists.get(i);
            for (int j=0;j< integers.size();j++){
                System.out.println(integers.get(j));
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        iterateAndPopulateResult(nums, new LinkedList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void iterateAndPopulateResult(int[] nums, LinkedList<Integer> list, LinkedList<List<Integer>> result, boolean[] visited){
        if (list.size() == nums.length){
            result.add(new LinkedList<>(list));
            return;
        }

        for (int i=0;i< nums.length;i++){
            if (visited[i])
                continue;
            if (i == 0 || nums[i]!=nums[i-1] || (nums[i] == nums[i-1] && visited[i-1])){
                visited[i] = true;
                list.add(nums[i]);
                iterateAndPopulateResult(nums, list, result, visited);
                visited[i] = false;
                list.removeLast();
            }
        }
    }
}
