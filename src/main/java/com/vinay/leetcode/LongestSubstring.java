package com.vinay.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {
        LinkedList<Character> list = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();

        char[] chars = s.toCharArray();
        int maxLength = 0;
        for (Character c : chars){
            if (set.contains(c)){
                removePreviousElements(list, set, c);
            }
            list.add(c);
            set.add(c);
            maxLength = maxLength>list.size()?maxLength:list.size();
        }
        return maxLength;
    }

    public void removePreviousElements(LinkedList<Character> list, HashSet<Character> set, Character duplicateChar){
        Iterator<Character> iterator = list.iterator();
        while (iterator.hasNext()){
            Character next = iterator.next();
            if (next.compareTo(duplicateChar) == 0){
                iterator.remove();
                set.remove(duplicateChar);
                return;
            }
            iterator.remove();
            set.remove(next);
        }
    }
}
