package com.vinay.leetcode.studyplan.questions;

import java.util.*;

public class TwoSumInputArraySorted {

    public static void main(String[] args) {
        TwoSumInputArraySorted twoSumInputArraySorted = new TwoSumInputArraySorted();
        int[] ints = twoSumInputArraySorted.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(ints[0]+" ---- "+ints[1]);
    }

    public int[] twoSumUsingMap(int[] numbers, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            List<Integer> mapOrDefault = map.getOrDefault(numbers[i], new ArrayList<>());
            mapOrDefault.add(i);
            map.put(numbers[i], mapOrDefault);
        }
        for (int i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];
            if (map.containsKey(num)) {
                List<Integer> integers = map.get(num);
                int index = integers.get(0) ;
                if (index == i && integers.size() == 1){
                       continue;
                }else if (index == i){
                    index = integers.get(1);
                }
                return new int[]{i + 1, index+1};
            }
        }
        return new int[]{-1, -1};
    }

    //2 pointer approach
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        while (low<high){
            int sum = numbers[low]+numbers[high];
            if (sum == target){
                return new int[]{low+1, high+1};
            }else if(sum < target){
                low++;
            }else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }

    //this uses less memory but runs slower
    public int getIndexOf(int[] numbers, int num, int start){
        int low = start;
        int high = numbers.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (numbers[mid] == num)
                return mid;
            else if(numbers[mid] < num){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }
}
