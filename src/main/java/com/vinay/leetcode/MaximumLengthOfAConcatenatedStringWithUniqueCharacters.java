package com.vinay.leetcode;

import java.util.*;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    public static void main(String[] args) {
        MaximumLengthOfAConcatenatedStringWithUniqueCharacters maximumLengthOfAConcatenatedStringWithUniqueCharacters = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters();
        System.out.println(maximumLengthOfAConcatenatedStringWithUniqueCharacters.maxLength(Arrays.asList("un","iq","ue")));
    }

    public int maxLength(List<String> arr) {
        List<Set<Character>> list = new ArrayList<>();
        for (String str:arr){
            Set<Character> set = new HashSet<>();
            char[] chars = str.toCharArray();
            for (int i=0;i<chars.length;i++){
                set.add(chars[i]);
            }
            if (set.size() == chars.length)
                list.add(set);
        }
//        System.out.println(list.size());
        iterateEachCombinationWithMemoization(new HashSet<>(), list, 0, new HashSet[list.size()]);
        return maxLength;
    }

    int maxLength ;

    private Set<Character> iterateEachCombinationWithMemoization(Set<Character> currentList,
                                                       List<Set<Character>> originalStringList,
                                                       int index,
                                                       Set<Character>[] maxLengthListAtIndex){

        if (index == originalStringList.size())
            return new HashSet<>();

        if (maxLengthListAtIndex[index] != null){
            Set<Character> set = new HashSet<>(maxLengthListAtIndex[index]);
            for (Character c:currentList){
                if (set.contains(c)) {
                    set.clear();
                    break;
                }
                set.add(c);
            }
            if (maxLengthListAtIndex[index].size() < set.size()) {
                return set;
            }

            return new HashSet<>();
        }

        for (int i=index;i< originalStringList.size();i++){
            Set<Character> characters = originalStringList.get(i);
            HashSet<Character> newList = new HashSet<>(currentList);
            newList.addAll(characters);
            if (newList.size() == characters.size()+ currentList.size()){
                Set<Character> resultSet = iterateEachCombinationWithMemoization(newList, originalStringList, i + 1, maxLengthListAtIndex);
                if (maxLengthListAtIndex[index] == null || maxLengthListAtIndex[index].size() < resultSet.size())
                    maxLengthListAtIndex[index] = resultSet;
            }
            iterateEachCombinationWithMemoization(currentList, originalStringList, i+1, maxLengthListAtIndex);
        }
//        System.out.println(index);
        maxLength = Math.max(maxLengthListAtIndex[index] == null?0:maxLengthListAtIndex[index].size(), maxLength);
        return maxLengthListAtIndex[index];
    }
}
