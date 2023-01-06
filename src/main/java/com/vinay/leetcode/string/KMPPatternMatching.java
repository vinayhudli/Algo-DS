package com.vinay.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class KMPPatternMatching {

    public static void main(String[] args) {
        KMPPatternMatching kmpPatternMatching = new KMPPatternMatching();
        List<Integer> allMatchingIndices = kmpPatternMatching.getAllMatchingIndices("AAAAABAAAAAB".toCharArray(), "AAAA".toCharArray());
        for (Integer index:allMatchingIndices){
            System.out.println(index);
        }
    }

    private List<Integer> getAllMatchingIndices(char[] actualString, char[] search){
        int[] lpsArray = getLPSArray(actualString);
        int j = 0;
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while (i< actualString.length){
            if (j == search.length) {
                result.add(i-j);
                j = lpsArray[j - 1];
            }
            if (actualString[i] == search[j]){
                i++;
                j++;
            }else {
                if (j>0)
                    j = lpsArray[j-1];
                else
                    i++;
            }
        }
        if (j== search.length){
            result.add(i-j);
        }
        return result;
    }

    private int[] getLPSArray(char[] chars){
        int[] lookup = new int[chars.length];
        lookup[0] = 0;
        int t = 0;
        for (int i=1;i< chars.length;i++){
            t = lookup[i-1];
            while (t>0 && chars[t]!=chars[i]){
                t = lookup[t-1];
            }

            if (chars[t] == chars[i])
                t++;
            lookup[i] = t;
        }

        return lookup;
    }
}
