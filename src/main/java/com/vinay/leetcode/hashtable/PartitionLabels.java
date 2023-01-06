package com.vinay.leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> list = partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
        list.forEach(System.out::println);
    }

    public List<Integer> partitionLabels(String s) {
        int[] charToOccurrenceIndices = new int[26];
        for (int i=0;i<s.length();i++){
            charToOccurrenceIndices[s.charAt(i)-'a'] = i;
        }
        List<Integer> length = new ArrayList<>();
        for (int  i=0;i<s.length();i++){
            int endIndex = getEndIndex(charToOccurrenceIndices, i, s);
            length.add(endIndex-i+1);
            i = endIndex;
        }
        return length;
    }

    private int getEndIndex(int[] charToOccurrenceIndices, int startIndex, String str){
        char c = str.charAt(startIndex);
        int endIndex = charToOccurrenceIndices[c - 'a'];

        while (startIndex <= endIndex){
            char charAt = str.charAt(startIndex);
            endIndex = Math.max(endIndex, charToOccurrenceIndices[charAt-'a']);
            startIndex++;
        }
        return endIndex;
    }
}
