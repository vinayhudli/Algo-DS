package com.vinay.leetcode.backtrack;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum2(new int[]{2,5,2,1,2},
        5);
        for (List<Integer> list:lists){
            System.out.println("new list");
            for (Integer entry:list){
                System.out.println(entry);
            }
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int i=0;i< candidates.length;i++){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(candidates[i]);
            addCombinationToList(tempList, candidates, i, target, candidates[i]);
        }
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    public void addCombinationToList(List<Integer> currentList, int[] candidates, int startIndex, int target, int sum){
        if (sum == target){
            result.add(currentList);
            return;
        }else if (sum > target)
            return;

        for (int i=startIndex;i<candidates.length;i++){
            int tempSum = sum+candidates[i];
            if (tempSum > target)
                return;
            currentList.add(candidates[i]);
            if (tempSum < target){
                addCombinationToList(currentList, candidates, i, target, tempSum) ;
                currentList.remove(currentList.size()-1);
            }else {
                List<Integer> tempList = new ArrayList<>(currentList);
                result.add(tempList);
                currentList.remove(currentList.size()-1);
                return;
            }
        }
    }

    List<List<Integer>> result2 = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> set = new ArrayList<>();
        for (int candidate : candidates) {
            map.compute(candidate, (key, value) -> value == null ? 1 : value + 1);
        }
        set = new ArrayList<>(map.keySet());
        List<Integer> tempResult = new ArrayList<>();
        addCombinationToList2(map, set, 0, target, tempResult, 0);

        return result2;
    }

    /**
     * This method is interesting, it loops through array with duplicates and considers all the elements to check the sum of result
     * @param map
     * @param set
     * @param startIndex
     * @param target
     * @param tempResult
     * @param currentSum
     */
    public void addCombinationToList2(Map<Integer, Integer> map,
                                      List<Integer> set,
                                      int startIndex,
                                      int target,
                                      List<Integer> tempResult,
                                      int currentSum){
        if (currentSum == target){
            List<Integer> newList = new ArrayList<>(tempResult);
            result2.add(newList);
            return;
        }else if (currentSum > target || startIndex >= set.size())
            return;

        int element = set.get(startIndex);
        if (map.get(element) > 0){
            tempResult.add(element);
            map.compute(element, (key, value)->value-1);
            addCombinationToList2(map, set, startIndex, target, tempResult, currentSum+element);
            map.compute(element, (key, value)->value+1);
            tempResult.remove(tempResult.size()-1);
        }

        addCombinationToList2(map, set, startIndex+1, target, tempResult, currentSum);
    }
}
