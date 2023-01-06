package com.vinay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ContainsDuplicate {

    public static void main(String[] args) {
//        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
//        System.out.println(containsDuplicate.containsDuplicate());
        List<Integer> list = Arrays.asList(10, 20, 11, 13);
        List<Integer> result = new ArrayList<>();
        list.stream().map(x->{
            if (x%2==0)
                return x+2;
            return x+3;
        }).collect(Collectors.toList());
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int i=0;i< nums.length;i++){
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}
