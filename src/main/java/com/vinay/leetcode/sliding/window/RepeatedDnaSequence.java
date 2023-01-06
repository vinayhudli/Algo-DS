package com.vinay.leetcode.sliding.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDnaSequence {

    public static void main(String[] args) {
        RepeatedDnaSequence repeatedDnaSequence = new RepeatedDnaSequence();
        List<String> repeatedList = repeatedDnaSequence.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String str: repeatedList){
            System.out.println(str);
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i=0;i<s.length()-9;i++){
            String str = s.substring(i, i+10);
            map.compute(str, (key, value)-> value == null? 1:value+1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            if (entry.getValue() > 1){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
