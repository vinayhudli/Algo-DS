package com.vinay.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[-5,-4,-3,-2,-1,0,0,1,2,3,4,5]
public class FourSum {
    //todo: improve this, this is not right solution
    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        List<List<Integer>> lists = fourSum.fourSum(new int[]{-5,-4,-3,-2,-1,0,0,1,2,3,4,5}, 0);
        lists.forEach(innerList->{
            System.out.println("new list");
            innerList.forEach(data-> System.out.println(data));
        });
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length<4)
            return new ArrayList<>();
        Arrays.sort(nums);
        return findKSum(nums, 0, 0, 4, target);
    }

    private List<List<Integer>> findKSum(int[] nums, int start, int sum, int k, int target){
        int pos = start;
        List<List<Integer>> result = new ArrayList<>();
        Integer previous = null;
        while (pos+k-1 <= nums.length-1){
            if (previous != null && nums[pos] == previous) {
                pos++;
                continue;
            }
            if (sum + nums[pos] > target && target >= 0)
                break;
            if (k==2){
                result.addAll(find2Sum(nums, target-sum, pos));
                return result;
            }else{
                List<List<Integer>> kSum = findKSum(nums, pos + 1, sum + nums[pos], k - 1, target);
                int index = pos;
                kSum.forEach(list->list.add(nums[index]));
                result.addAll(kSum);
            }
            previous = nums[pos];
            pos++;
        }

        return result;
    }

    private List<List<Integer>> find2Sum(int[] nums, int target, int start){
        int low = start, high = nums.length-1;
        List<List<Integer>> result = new ArrayList<>();

        while (low < high){
            int sum = nums[low]+nums[high];
            if (sum == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[low]);temp.add(nums[high]);
                result.add(temp);
                int tempLowIndex = getIndexWithDistinctValue(nums, low, 1);
                int tempHighIndex = getIndexWithDistinctValue(nums, high, -1);

                if (tempLowIndex == -1 || tempHighIndex == -1)
                    break;
                low = tempLowIndex;
                high = tempHighIndex;
            }else if(sum < target)
                low++;
            else
                high--;
        }
        return result;
    }

    private int getIndexWithDistinctValue(int[] nums, int index, int adder){
            while (index+adder<nums.length && index+adder>=0){
            if (nums[index] == nums[index+adder]){
                index += adder;
            }else
                return index+adder;
        }
        return -1;
    }

    private int findNumToAdd(int[] nums, int start, int end, int target){
        if (end < start)
            return -1;
        int mid = (start+end)/2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target)
            return findNumToAdd(nums, mid+1, end, target);
        else
            return findNumToAdd(nums, start, mid-1, target);
    }

    private List<List<Integer>> first2Sum(int[] nums, int target, int low, int high){
        if (low>high-3)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int sum = nums[low] + nums[high] ;
        if (sum <= target){
            result.addAll(next2Sum(nums, low, high, target));
            if (nums[low]!=nums[low+1])
                result.addAll(first2Sum(nums, target, low+1, high ));
        }

        if (nums[high]!=nums[high-1])
            result.addAll(first2Sum(nums, target, low, high-1));

        return result;
    }

    private List<List<Integer>> next2Sum(int[] nums, int low, int high, int target){
        int first = low+1, last = high-1;
        int preFirst = -1, preLast = -1;

        boolean preMatch = false;
        List<List<Integer>> result = new ArrayList<>();
        int outerSum = nums[low]+nums[high];

        while (first<last){
            int sum = outerSum+nums[first]+nums[last];
            if (preMatch && nums[preFirst] == nums[first] && nums[preLast] == nums[last]){
                first++;
                last--;
                continue;
            }
            if (sum>target){
                preMatch = false;
                last--;
            }else if(sum<target){
                preMatch = false;
                first++;
            }else {
                result.add(Arrays.asList(nums[low], nums[first], nums[last], nums[high] ));
                preFirst = first;
                preLast = last;
                first++;
                last--;
                preMatch=true;
            }
        }
        return result;
    }

}
